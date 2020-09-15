package task7.ui.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import task7.Main;
import task7.characters.chars.Player;
import task7.enums.path.PathAndNameFiles;

import java.io.ObjectOutputStream;

import static task7.enums.path.PathAndNameFiles.CREATE_PET_FXML_FILE_NAME;
import static task7.enums.path.PathAndNameFiles.GAME_WINDOW_FXML_FILE_NAME;
import static task7.utils.ApplicationUtils.*;


public class EnterInTheGame {
    public Button enteredButton;
    public AnchorPane root;
    public Label petName;
    public Label petHungry;
    public Label petMood;
    public Label petIsDied;
    public Label labelTimeToSpawn;
    public Label timeToSpawn;


    Player player = Main.player;
    public static Scene mainScene;
    Timeline timeline;
    private final int TIMELINE_FINAL = 1;

    public void initialize() {
        timeline = new Timeline(new KeyFrame(
                Duration.seconds(TIMELINE_FINAL),
                ae -> {
                    if (player.timeToSpawnProperty().getValue() > 0) {
                        player.timeToSpawnProperty().setValue(player.timeToSpawnProperty().getValue() - 1);

                    } else if (player.timeToSpawnProperty().getValue() == 0) {
                        player.setTimeToSpawn(0);
                    }
                }
        ));
        timeline.setCycleCount(Integer.MAX_VALUE);
        timeline.play();

        if (player.getPlayer().hungryPropertyProperty().getValue() < (-3)) {
            player.timeToSpawnProperty().setValue(10);
        }

        petName.textProperty().bind(player.getPlayer().petTypeProperty());

        petHungry.textProperty().bind(player.getPlayer().hungryPropertyProperty().asString());
        petMood.textProperty().bind(player.getPlayer().moodPropertyProperty().asString());

        if (player.petIsDiedProperty().getValue()) {
            petIsDied.setText(DIED_IN_APPLICATION_INTERFACE);
            timeToSpawn.setVisible(true);
            timeToSpawn.setDisable(false);

        } else {
            petIsDied.setText(LIVED_IN_APPLICATION_INTERFACE);
        }
        timeToSpawn.textProperty().bind(player.timeToSpawnProperty().asString());


        setButtonEvents(enteredButton);
    }

    public void onActionEnteredButton(ActionEvent actionEvent) {
        System.out.println(player.timeToSpawnProperty().getValue());
        if ((player.timeToSpawnProperty().getValue() <= 0)) {

            if (!player.isDied()) {
                mainScene = Main.scene;

                Pane root = (Pane) createParentFromFXML(PathAndNameFiles.PATH_TO_FXML.getPath(), GAME_WINDOW_FXML_FILE_NAME.getPath(), 600, 450);
                Scene scene = new Scene(root);
                Stage game = new Stage();

                scene.setOnKeyPressed(keyPresetEvent -> {
                    Main.keys.put(keyPresetEvent.getCode(), true);
                });

                scene.setOnKeyReleased(keyReleasedEvent -> {
                    Main.keys.put(keyReleasedEvent.getCode(), false);
                });
                game.setTitle(APPLICATION_NAME);
                game.setScene(scene);

                ((Stage) (root.getScene().getWindow())).close();
                game.show();
            } else {
                Pane pane = (Pane) createParentFromFXML(PathAndNameFiles.PATH_TO_FXML.getPath(), CREATE_PET_FXML_FILE_NAME.getPath(), 430, 300);
                Scene enteredScene = new Scene(pane);
                Stage game = new Stage();
                game.setScene(enteredScene);
                ((Stage) (root.getScene().getWindow())).close();
                game.show();
            }
            ((Stage) root.getScene().getWindow()).close();
        } else {
        }
    }
}