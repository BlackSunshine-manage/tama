package source.ui.controllers;


import application_interface.ApplicationInterface;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import source.Main;
import source.characters.chars.Player;
import source.classes.blocks.Block;
import source.classes.blocks.UnbreakableBlock;
import source.engine.EngineGameInputKeypad;
import source.path.PathToFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static source.path.IdentifyInFXML.*;
import static source.static_vars.StaticImageViews.imageCage460x44;
import static source.static_vars.StaticImageViews.imageCage60x290;

public class GameMap implements EngineGameInputKeypad, PathToFiles, ApplicationInterface {
    public Button hungerUp;
    public Button moodUp;
    public AnchorPane includingPane;
    public AnchorPane basedPane;

    public static Pane rootInGameMap;

    public Pane block60x290cagePane;
    public Pane block460x44cagePane;
    public Pane block60x290cagePane1;
    public Pane block460x44cagePane1;
    public static Timeline timeline;
    public static Player player = Main.player;

    public void initialize() {
        BackgroundImage backgroundImage = new BackgroundImage(new Image(getClass().getResourceAsStream(PATH_TO_MAP_IN_RESOURCES_FOLDER + MAP_IMAGE_GREEN_1), 2000, 2000, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        basedPane.setBackground(new Background(backgroundImage));

        /**
         * Таймлайн для постепенного снижения голода и настроения у питомца(по 1 ед.) каждые 5 секунд. В случае если голод
         * равен 0 и прошло 75 секунд петомец умирает.
         * Процедура автосохранения инициализируется каждые 30 секунд
         * */
        final int TIMELINE_FINAL = 5;
        int timeToDead[] = new int[]{1};
        int time[] = new int[]{1};
        int timeToSave[] = new int[]{1};
        try {
            player = (Player) Main.applicationContext.getBean("getPlayerInputFile");
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.petIsDiedProperty().setValue(false);
        player.timeToSpawnProperty().setValue(0);
        timeline = new Timeline(new KeyFrame(
                Duration.seconds(TIMELINE_FINAL),
                ae -> {
                    time[0] = time[0] + TIMELINE_FINAL;
                    if (time[0] > 5) {
                        if (player.getPlayer().getHungryProperty() < 0) {
                            timeToDead[0] = timeToDead[0] + TIMELINE_FINAL;
                        }
                        if (timeToDead[0] > 15) {// время в онлайне без пищи
                            player.petIsDiedProperty().setValue(true);
                            player.setPetIsDied(true);
                        }
                        player.getPlayer().hungryPropertyProperty().setValue(player.getPlayer().hungryPropertyProperty().getValue() - 1);//setHungryProperty(player.getPlayer().getHungryProperty() - 1);
                        player.getPlayer().moodPropertyProperty().setValue(player.getPlayer().moodPropertyProperty().getValue() - 1);//player.getPlayer().//setMoodProperty(player.getPlayer().getMoodProperty() - 1);
                    }
                    timeToSave[0] = timeToSave[0] + 1;
                    if (timeToSave[0] > 5) { // TODO : АВТОСЕЙВ
                        ObjectOutputStream objectOutputStream = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(DATA_SAVE_AND_LOAD_FILE_NAME)));
                            player.writeObject(objectOutputStream);
                            System.out.println("Write is WELL DONE");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        timeToSave[0] = 0;
                    }
                }));
        player.getPlayer().setTranslateX(player.getPlayer().getTranslateX() + 230);
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

        timeline.setCycleCount(Integer.MAX_VALUE);
        timeline.play();
        rootInGameMap = basedPane;

        player = addListenersAll(player, basedPane, (ProgressBar) includingPane.lookup(ID_IN_GAME_WINDOW_TO_THE_GROWTH_PROGRESS_BAR),
                (ProgressBar) includingPane.lookup(ID_IN_GAME_WINDOW_TO_THE_HUNGER_PROGRESS_BAR),
                (ProgressBar) includingPane.lookup(ID_IN_GAME_WINDOW_TO_THE_MOOD_PROGRESS_BAR));
        Block up = new UnbreakableBlock(imageCage60x290, 40, 640, 0, 0);
        Block left = new UnbreakableBlock(imageCage460x44, 450, 40, 0, 20);
        Block down = new UnbreakableBlock(new ImageView(imageCage60x290.getImage()), 40, 640, 0, 430);
        Block right = new UnbreakableBlock(new ImageView(imageCage460x44.getImage()), 450, 40, 600, 0);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(player.getPlayer());
            }
        };
        timer.start();

        basedPane.getChildren().addAll(player.getPlayer(), up, left, right, down);//        basedPane.getChildren().addAll(Main.player.getPlayer(),clip);
    }
}
