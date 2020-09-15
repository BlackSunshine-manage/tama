package task7.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import task7.blocks.Block;
import task7.characters.chars.CharacterFactory;
import task7.characters.chars.CharacterPlayer;
import task7.characters.chars.CharacterType;
import task7.characters.chars.Player;
import task7.enums.path.PathAndNameFiles;
import task7.food.Food;
import task7.static_vars.StaticStyleProperty;
import task7.ui.controllers.GameMap;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static task7.enums.path.PathAndNameFiles.CREATE_PET_FXML_FILE_NAME;
import static task7.ui.controllers.GameMap.rootInGameMap;

public class ApplicationUtils {
    static final Random random = new Random();
    public static final String APPLICATION_NAME = "Game";

    public static final String DIED_IN_APPLICATION_INTERFACE = "Петомец мёртв и сейчас его везут в вольер";
    public static final String LIVED_IN_APPLICATION_INTERFACE = "Петомец жив и сейчас его везут в вольер";

    public static Parent createParentFromFXML(String pathToFXML, String fileName, double height, double wight) {
        Pane root;
        try {
            root = FXMLLoader.load(ApplicationUtils.class.getResource(pathToFXML + fileName));
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
     * @param buttons Передавать на какие кнопки назначить эвент
     *                Наведение - {@link StaticStyleProperty#HOVERED_BUTTON_STYLE}
     *                Снятие - {@link StaticStyleProperty#DEFAULT_BUTTON_STYLE}
     */
    public static void setButtonEvents(Button... buttons) {
        Arrays.stream(buttons).forEach(button -> {
            button.setOnMouseEntered(e -> button.setStyle(StaticStyleProperty.HOVERED_BUTTON_STYLE));
            button.setOnMouseExited(e -> button.setStyle(StaticStyleProperty.DEFAULT_BUTTON_STYLE));

        });
    }

    public static int randomInRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public static void bonus(List<Food> bonuses, Pane root, Player player, double randomInHeightMin, double randomInHeightMax
            , double randomInWightMin, double randomInWightMax) {
        int x = randomInRange((int) randomInWightMin, (int) randomInWightMax);
        int y = randomInRange((int) randomInHeightMin, (int) randomInHeightMax);
        CharacterPlayer characterPlayer = player.getPlayer();

        Food food = characterPlayer.getFood();
        food.setLayoutX(x);
        food.setLayoutY(y);
        bonuses.add(food);
        root.getChildren().addAll(food);
    }


    /**
     * Метод назначения всех необходимых слушателей
     *
     * @param basedPane      в параметр передаётся игровое поле. Относительно него высчитывается коллизия с объектом
     *                       {@link task7.blocks.UnbreakableBlock} посредством метода
     *                       {@link task7.blocks.Block#isBlock(CharacterPlayer, Pane)}
     * @param player         Передаётся игрок
     * @param growthProgress Передаётся {@link ProgressBar}, который отвечает за стадию роста
     * @param progressHunger Передаётся {@link ProgressBar}, который отвечает за голод
     * @param progressMood   Передаётся {@link ProgressBar}, который отвечает за настроение
     * @return player Возвращает объект {@link Player}, который проинициализирован всеми необходимыми слушателями
     */
    public static Player addListenersAll(Player player, Pane basedPane, ProgressBar growthProgress, ProgressBar progressHunger, ProgressBar progressMood) {

        player.getPlayer().hungryPropertyProperty().addListener((observable, oldValue, newValue) -> {
            progressHunger.setProgress(newValue.doubleValue() / player.getPlayer().getHungerMax());

            if (newValue.intValue() == player.getPlayer().getHungerMax()) {
                int stageGrowth;
                switch (newValue.intValue()) {

                    case 30:
                        stageGrowth = 2;

                        player.getPlayer().growthStagePropertyProperty().setValue(stageGrowth);
                        player.getPlayer().setHungerMax(newValue.intValue() * 3);
                        break;
                    case 90:
                        stageGrowth = 3;

                        player.getPlayer().growthStagePropertyProperty().setValue(stageGrowth);
                        player.getPlayer().setHungerMax(newValue.intValue() * 3);
                        break;
                }
            }
        });


        player.petIsDiedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.booleanValue()) {
                Stage createPet = new Stage();
                createPet.setScene(new Scene(createParentFromFXML(PathAndNameFiles.PATH_TO_FXML.getPath(), CREATE_PET_FXML_FILE_NAME.getPath(), 400, 400)));
                if (((Stage) GameMap.rootInGameMap.getScene().getWindow()) != null) {
                    ((Stage) GameMap.rootInGameMap.getScene().getWindow()).close();
                }
                createPet.show();
            }
        });

        // Add growth property
        player.getPlayer().growthStagePropertyProperty().addListener((observable, oldValue, newValue) -> {

            growthProgress.setProgress(newValue.doubleValue() / player.getPlayer().getGrowthStageMax());

            String type = player.getPlayer().getPetType();
            int stageValue = newValue.intValue();
            rootInGameMap.getChildren().remove(player.getPlayer());

            CharacterType characterType = CharacterType.getCharacterTypeFromString(type, stageValue);
            player.setPlayer(CharacterFactory.createCharacter(characterType));

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
                    createPet.setScene(new Scene(createParentFromFXML(PathAndNameFiles.PATH_TO_FXML.getPath(), CREATE_PET_FXML_FILE_NAME.getPath(), 400, 400)));
                    if (((Stage) GameMap.rootInGameMap.getScene().getWindow()) != null) {
                        ((Stage) GameMap.rootInGameMap.getScene().getWindow()).close();
                    }
                    createPet.show();
                }
            });

            addListenersAll(player, basedPane, growthProgress, progressHunger, progressMood);
            player.getPlayer().setHungerMax(player.getPlayer().getHungerMax() * 2);
            player.getPlayer().hungryPropertyProperty().setValue(0);
            player.getPlayer().setStageGrowth(stageValue);
            rootInGameMap.getChildren().add(player.getPlayer());
        });

        // Mood property
        player.getPlayer().moodPropertyProperty().addListener((observable, oldValue, newValue) -> {
            progressMood.setProgress(newValue.doubleValue() / player.getPlayer().getMoodMax());
        });
        return player;
    }

    public static <T extends Food> T getFood(ImageView imageView) {
        return (T) new Food(new ImageView(imageView.getImage()));
    }
}
