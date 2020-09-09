package application_interface;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import source.characters.chars.*;
import source.classes.blocks.Block;
import source.classes.food.Food;
import source.classes.food.foods.Carrot;
import source.classes.food.foods.Fish;
import source.classes.food.foods.Ghost;
import source.classes.food.foods.Meat;
import source.static_vars.StaticImageViews;
import source.static_vars.StaticStyleProperty;
import source.ui.controllers.GameMap;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static source.path.PathToFiles.CREATE_PET_FXML_FILE_NAME;
import static source.path.PathToFiles.PATH_TO_FXML;
import static source.ui.controllers.GameMap.rootInGameMap;

public interface ApplicationInterface {
    static final Random random = new Random();
    String APPLICATION_NAME = "Game";

    String DIED_IN_APPLICATION_INTERFACE = "Петомец мёртв и сейчас его везут в вольер";
    String LIVED_IN_APPLICATION_INTERFACE = "Петомец жив и сейчас его везут в вольер";

    default Parent createParentFromFXML(String pathToFXML, String fileName, double height, double wight) {
        Pane root;
        try {
            root = FXMLLoader.load(getClass().getResource(pathToFXML + fileName));
        } catch (IOException e) {
            root = new Pane();
            e.printStackTrace();
        }
        root.setPrefSize(wight, height);
        return root;
    }

    /**
     * Метод назначения эвентов на кнопки, которые меняют стили при наведении фокуса и снятии фокуса:
     *
     * @param button1 Передавать на какие кнопки назначить эвент
     *                Наведение - {@link StaticStyleProperty#HOVERED_BUTTON_STYLE}
     *                Снятие - {@link StaticStyleProperty#DEFAULT_BUTTON_STYLE}
     */
    default void settingHoveringAndExitedButtons(Button... button1) {
        for (int i = 0; i < button1.length; i++) {
            Button butt = button1[i];
            butt.setOnMouseEntered(e -> butt.setStyle(StaticStyleProperty.HOVERED_BUTTON_STYLE));
            butt.setOnMouseExited(e -> butt.setStyle(StaticStyleProperty.DEFAULT_BUTTON_STYLE));
        }
    }

    static int randomInRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    static void bonus(List<Food> bonuses, Pane root, Player player, double randomInHeightMin, double randomInHeightMax
            , double randomInWightMin, double randomInWightMax) {
        int x = randomInRange((int) randomInWightMin, (int) randomInWightMax);
        int y = randomInRange((int) randomInHeightMin, (int) randomInHeightMax);
        CharacterPlayer characterPlayer = player.getPlayer();

        Food food = null;
        // TODO FOR ADDONS(4). Дополнить блок if/else когда добавляем нового CharacterPlayer - дочернего класса
        if (characterPlayer instanceof Hellion) {
            food = getFood(new Meat(), new ImageView(StaticImageViews.meatImageView.getImage()));
        } else if (characterPlayer instanceof BlackCat) {
            food = getFood(new Fish(), new ImageView(StaticImageViews.fishImageView.getImage()));
        } else if (characterPlayer instanceof Nightmare) {
            food = getFood(new Ghost(), new ImageView(StaticImageViews.ghostMeatImageView.getImage()));
        } else if (characterPlayer instanceof Poring) {
            food = getFood(new Carrot(), new ImageView(StaticImageViews.carrotImageView.getImage()));
        }
        food.setLayoutX(x);
        food.setLayoutY(y);
        bonuses.add(food);
        root.getChildren().addAll(food);
    }


    /**
     * Метод назначения всех необходимых слушателей
     *
     * @param basedPane      в параметр передаётся игровое поле. Относительно него высчитывается коллизия с объектом
     *                       {@link source.classes.blocks.UnbreakableBlock} посредством метода
     *                       {@link source.classes.blocks.Block#isBlock(CharacterPlayer, Pane)}
     * @param player         Передаётся игрок
     * @param growthProgress Передаётся {@link ProgressBar}, который отвечает за стадию роста
     * @param progressHunger Передаётся {@link ProgressBar}, который отвечает за голод
     * @param progressMood   Передаётся {@link ProgressBar}, который отвечает за настроение
     * @return player Возвращает объект {@link Player}, который проинициализирован всеми необходимыми слушателями
     */
    default Player addListenersAll(Player player, Pane basedPane, ProgressBar growthProgress, ProgressBar progressHunger, ProgressBar progressMood) {


        player.getPlayer().hungryPropertyProperty().addListener((observable, oldValue, newValue) -> {
            progressHunger.setProgress(newValue.doubleValue() / player.getPlayer().getHungerMax());

            if (newValue.intValue() == player.getPlayer().getHungerMax()) {
                int stageGrowth;
                switch (newValue.intValue()) {

                    case 30:
                        stageGrowth = 2;

                        player.getPlayer().growthStagePropertyProperty().setValue(stageGrowth);
                        player.getPlayer().setGrowthStage(stageGrowth);
                        player.getPlayer().setHungerMax(newValue.intValue() * 3);
                        System.out.println(player.getPlayer().getHungerMax() + "  HUNGER MAX");
                        break;
                    case 90:
                        stageGrowth = 3;

                        player.getPlayer().growthStagePropertyProperty().setValue(stageGrowth);
                        player.getPlayer().setGrowthStage(stageGrowth);
                        player.getPlayer().setHungerMax(newValue.intValue() * 3);
                        System.out.println(player.getPlayer().getHungerMax() + "  HUNGER MAX");
                        break;
                }
            }
        });


        player.petIsDiedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("pet is dead property add" + newValue + "property" + "   " + player.isPetIsDied());
            if (newValue.booleanValue()) {
                Stage createPet = new Stage();
                createPet.setScene(new Scene(createParentFromFXML(PATH_TO_FXML, CREATE_PET_FXML_FILE_NAME, 400, 400)));
                if (((Stage) GameMap.rootInGameMap.getScene().getWindow()) != null) {
                    ((Stage) GameMap.rootInGameMap.getScene().getWindow()).close();
                }
//                player.setPetIsDied(false);
//                player.petIsDiedProperty().setValue(false);
                createPet.show();
            }
        });

        // Add growth property
        player.getPlayer().growthStagePropertyProperty().addListener((observable, oldValue, newValue) -> {

            growthProgress.setProgress(newValue.doubleValue() / player.getPlayer().getGrowthStageMax());

            String type = player.getPlayer().getPetType();
            int stageValue = newValue.intValue();
            rootInGameMap.getChildren().remove(player.getPlayer());
            switch (type) {


                // TODO: Добавить (6) при добавлении классов и стадий
                case "Hellion":
                    if (stageValue == 2) {
                        player.setPlayer(new Hellion(new ImageView(StaticImageViews.stage2Hellion.getImage()), 200, 200));
                    } else if (stageValue == 3) {
                        player.setPlayer(new Hellion(new ImageView(StaticImageViews.stage3Hellion.getImage()), 300, 300));
                    }
                    break;
                case "Black cat":
                    if (stageValue == 2) {
                        player.setPlayer(new BlackCat(new ImageView(StaticImageViews.stage2BlackCat.getImage()), 64, 64));
                    } else if (stageValue == 3) {
                        player.setPlayer(new BlackCat(new ImageView(StaticImageViews.stage3BlackCat.getImage()), 96, 96));
                    }
                    break;

                case "Nightmare":
                    if (stageValue == 2) {
                        player.setPlayer(new Nightmare(new ImageView(StaticImageViews.stage2Nightmare.getImage()), 200, 200));
                    } else if (stageValue == 3) {
                        player.setPlayer(new Nightmare(new ImageView(StaticImageViews.stage3Nightmare.getImage()), 300, 300));
                    }
                    break;

                case "Poring":
                    if (stageValue == 2) {
                        player.setPlayer(new Poring(new ImageView(StaticImageViews.stage2Poring.getImage()), 100, 100));
                    } else if (stageValue == 3) {
                        player.setPlayer(new Poring(new ImageView(StaticImageViews.stage3Poring.getImage()), 150, 150));
                    }
                    break;
            }
            player.getPlayer().setTranslateX(player.getPlayer().getTranslateX() + 220);
            player.getPlayer().setTranslateY(player.getPlayer().getTranslateY() + 100);

            player.getPlayer().translateXProperty().addListener((observableValue, oldV, newV) -> {
                if (Block.isBlock(player.getPlayer(), basedPane)) {
                    player.getPlayer().translateXProperty().set((Double) oldV);
                } else {
                    player.getPlayer().translateXProperty().set((Double) newV);
                }
            });

            player.getPlayer().translateYProperty().addListener((observableValue, oldV, newV) -> {
                if (Block.isBlock(player.getPlayer(), basedPane)) {
                    player.getPlayer().translateYProperty().set((Double) oldV);
                } else {
                    player.getPlayer().translateYProperty().set((Double) newV);
                }
            });

            player.petIsDiedProperty().addListener((observableValue, oldV, newV) -> {
                if (newV.booleanValue()) {
                    Stage createPet = new Stage();
                    createPet.setScene(new Scene(createParentFromFXML(PATH_TO_FXML, CREATE_PET_FXML_FILE_NAME, 400, 400)));
                    if (((Stage) GameMap.rootInGameMap.getScene().getWindow()) != null) {
                        ((Stage) GameMap.rootInGameMap.getScene().getWindow()).close();
                    }
                    createPet.show();
                }
            });

            addListenersAll(player, basedPane, growthProgress, progressHunger, progressMood);
            player.getPlayer().setHungerMax(player.getPlayer().getHungerMax() * 2);
            player.getPlayer().hungryPropertyProperty().setValue(0);
            //player.getPlayer().growthStagePropertyProperty().setValue(player.getPlayer().growthStagePropertyProperty().getValue()+1);
            player.getPlayer().setGrowthStage(stageValue);
            rootInGameMap.getChildren().add(player.getPlayer());
        });

        // Mood property
        player.getPlayer().moodPropertyProperty().addListener((observable, oldValue, newValue) -> {
            progressMood.setProgress(newValue.doubleValue() / player.getPlayer().getMoodMax());
        });
        return player;
    }

    static <T extends Food> T getFood(T food, ImageView imageView) {
        return (T) new Food(new ImageView(imageView.getImage()));
    }
}
