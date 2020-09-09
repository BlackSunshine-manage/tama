package source.ui.controllers;


import application_interface.ApplicationInterface;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import source.Main;
import source.characters.chars.CharacterPlayer;
import source.characters.chars.Player;
import source.engine.EngineGameInputKeypad;

import java.util.List;

import static source.path.PathToFiles.DEAD_PET_FXML_FILE_NAME;
import static source.path.PathToFiles.PATH_TO_FXML;


public class CreateCharacter implements EngineGameInputKeypad, ApplicationInterface {
    public Button previous;
    public Label petName;
    public Button nextPet;
    public Pane animationPane;
    public Button createPet;

    private static int index = 0;
    private static List<CharacterPlayer> charactersList;
    private static CharacterPlayer characterPlayer;
    public AnchorPane basePane;
    public Label petDescription;
    Player player = Main.player;

    public static Player sharedPlayer;

    public void initialize() {
        charactersList = (List<CharacterPlayer>) Main.applicationContext.getBean("allPetsInCreatePage");
        characterPlayer = charactersList.get(index);
        update(characterPlayer);
        animationPane.getChildren().addAll(characterPlayer);
        petName.textProperty().bind(characterPlayer.petTypeProperty()); // TODO : Доработать привязку
        petDescription.textProperty().bind(characterPlayer.descriptionProperty());
    }

    public void onActionCreatePet(ActionEvent actionEvent) throws Exception {
        player = new Player(charactersList.get(index));
        sharedPlayer = new Player(charactersList.get(index));
        Stage createPet = new Stage();
        createPet.setScene(new Scene(createParentFromFXML(PATH_TO_FXML, DEAD_PET_FXML_FILE_NAME, 250, 300)));
        ((Stage) basePane.getScene().getWindow()).close();
        createPet.show();
    }

    public void onActionNextPet(ActionEvent actionEvent) {
        if (charactersList.size() - 1 > index) {
            index++;
        } else {
            index--;
        }
        animationPane.getChildren().remove(characterPlayer);
        characterPlayer = charactersList.get(index);
        update(characterPlayer);
        animationPane.getChildren().addAll(characterPlayer);
        petName.textProperty().bind(characterPlayer.petTypeProperty());
        petDescription.textProperty().bind(characterPlayer.descriptionProperty());
    }

    public void onActionPrevious(ActionEvent actionEvent) {
        if (0 < index) {
            index--;
        } else {
            index++;
        }
        animationPane.getChildren().remove(characterPlayer);
        characterPlayer = charactersList.get(index);
        animationPane.getChildren().addAll(characterPlayer);
        petName.textProperty().bind(characterPlayer.petTypeProperty());
        petDescription.textProperty().bind(characterPlayer.descriptionProperty());
    }
}
