package task7.ui.controllers;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import task7.Main;
import task7.blocks.Block;
import task7.blocks.UnbreakableBlock;
import task7.characters.chars.Player;
import task7.engine.EngineGameInputKeypad;
import task7.enums.StatsValue;
import task7.enums.StatusType;
import task7.single_instance.FileSaveAndLoadPlayer;
import task7.utils.ApplicationUtils;
import task7.utils.counter_animation.factory.CounterFactory;

import java.io.*;

import static task7.enums.id.Identifiers.*;
import static task7.enums.path.PathAndNameFiles.MAP_IMAGE_GREEN_1;
import static task7.enums.path.PathAndNameFiles.PATH_TO_MAP_IN_RESOURCES_FOLDER;
import static task7.static_vars.StaticImageViews.imageCage460x44;
import static task7.static_vars.StaticImageViews.imageCage60x290;

public class GameMap implements EngineGameInputKeypad {
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
        BackgroundImage backgroundImage = new BackgroundImage(new Image(getClass().getResourceAsStream(PATH_TO_MAP_IN_RESOURCES_FOLDER.getPath() + MAP_IMAGE_GREEN_1.getPath()), 2000, 2000, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        basedPane.setBackground(new Background(backgroundImage));

        /**
         * Таймлайн для постепенного снижения голода и настроения у питомца(по 1 ед.) каждые 3 секунды и 4 секунды соответственно. В случае если голод
         * равен 0 и прошло 15 секунд петомец умирает.
         * Процедура автосохранения инициализируется каждые 15 секунд
         * */
        final int TIMELINE_FINAL = 1;

        int[] time = new int[]{1};
        final int[] result = new int[1];
        try {
            player = player.readObject(new ObjectInputStream(new FileInputStream(FileSaveAndLoadPlayer.getInstance())));//(Player) Main.applicationContext.getBean("getPlayerInputFile");
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.petIsDiedProperty().setValue(false);
        player.timeToSpawnProperty().setValue(0);
        timeline = new Timeline(new KeyFrame(Duration.seconds(TIMELINE_FINAL),
                ae -> {
                    boolean flagDead = true;
                    time[0] = time[0] + TIMELINE_FINAL;
                    if (neededHungry(player)) {
                        player.petIsDiedProperty().setValue(true);
                    }

                    result[0] = time[0] % 3;
                    if (result[0] == 0) {
                        CounterFactory.createCounter(StatusType.getStatusTypeFromStatusNameAndStatusValue(StatsValue.MOOD.getValueName(), -1));
                        player.getPlayer().moodPropertyProperty().setValue(player.getPlayer().moodPropertyProperty().getValue() - 1);
                    }

                    result[0] = time[0] % 4;
                    if (result[0] == 0) {
                        CounterFactory.createCounter(StatusType.getStatusTypeFromStatusNameAndStatusValue(StatsValue.HUNGRY.getValueName(), -1));
                        player.getPlayer().hungryPropertyProperty().setValue(player.getPlayer().hungryPropertyProperty().getValue() - 1);
                    }
                    result[0] = time[0] % 15;
                    if (result[0] == 0) {
                        ObjectOutputStream objectOutputStream = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FileSaveAndLoadPlayer.getInstance()));
                            player.writeObject(objectOutputStream);
                            System.out.println("Write is WELL DONE");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if (time[0] > 15) {
                        time[0] = 0;
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

        player = ApplicationUtils.addListenersAll(player, basedPane, (ProgressBar) includingPane.lookup(ID_IN_GAME_WINDOW_TO_THE_GROWTH_PROGRESS_BAR.getName()),
                (ProgressBar) includingPane.lookup(ID_IN_GAME_WINDOW_TO_THE_HUNGER_PROGRESS_BAR.getName()),
                (ProgressBar) includingPane.lookup(ID_IN_GAME_WINDOW_TO_THE_MOOD_PROGRESS_BAR.getName()));
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

        basedPane.getChildren().addAll(player.getPlayer(), up, left, right, down);
    }

    private static boolean neededHungry(Player player) {
        return (player.getPlayer().hungryPropertyProperty().getValue() < -3);
    }
}
