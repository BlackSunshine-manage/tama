package source.ui.controllers;

import application_interface.ApplicationInterface;
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
import source.Main;
import source.characters.chars.Player;
import source.path.PathToFiles;

import java.io.ObjectOutputStream;


public class EnterInTheGame implements ApplicationInterface, PathToFiles {
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
    ObjectOutputStream objectOutputStream = null;

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
            player.timeToSpawnProperty().setValue(40);
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


        settingHoveringAndExitedButtons(enteredButton);
    }

    public void onActionEnteredButton(ActionEvent actionEvent) {
        System.out.println(player.timeToSpawnProperty().getValue());
        if ((player.timeToSpawnProperty().getValue() <= 0)) {

            if (!player.isDied()) {
                mainScene = Main.scene;

                Pane root = (Pane) createParentFromFXML(PATH_TO_FXML, GAME_WINDOW_FXML_FILE_NAME, 600, 450);
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
                Pane pane = (Pane) createParentFromFXML(PATH_TO_FXML, CREATE_PET_FXML_FILE_NAME, 430, 300);
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