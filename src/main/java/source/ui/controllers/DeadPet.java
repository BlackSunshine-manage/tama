package source.ui.controllers;

import application_interface.ApplicationInterface;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import source.characters.chars.Player;
import source.path.PathToFiles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DeadPet implements PathToFiles, ApplicationInterface {
    public Button buttonAccept;
    public AnchorPane anchorPane;

    public void initialize() {
        settingHoveringAndExitedButtons(buttonAccept);
    }

    public void buttonAcceptOnAction(ActionEvent actionEvent) throws IOException {

        Player player = CreateCharacter.sharedPlayer;
        player.setTimeToSpawn(10);
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(DATA_SAVE_AND_LOAD_FILE_NAME)));
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
