package task7.ui.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import task7.characters.chars.Player;
import task7.single_instance.FileSaveAndLoadPlayer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static task7.utils.ApplicationUtils.setButtonEvents;

public class DeadPet {
    public Button buttonAccept;
    public AnchorPane anchorPane;

    public void initialize() {
        setButtonEvents(buttonAccept);
    }

    public void buttonAcceptOnAction(ActionEvent actionEvent) throws IOException {

        Player player = CreateCharacter.sharedPlayer;
        player.setTimeToSpawn(10);
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FileSaveAndLoadPlayer.getInstance()));
            player.writeObject(objectOutputStream);
            System.out.println("Write complited");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
        }
        ((Stage) anchorPane.getScene().getWindow()).close();
    }
}