package task7.ui.controllers;


import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import task7.Main;
import task7.characters.chars.CharacterPlayer;
import task7.characters.chars.Player;
import task7.engine.EngineGameInputKeypad;
import task7.enums.path.PathAndNameFiles;

import java.util.List;

import static task7.enums.path.PathAndNameFiles.DEAD_PET_FXML_FILE_NAME;
import static task7.utils.ApplicationUtils.createParentFromFXML;


public class CreateCharacter implements EngineGameInputKeypad {
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
        petName.textProperty().bind(characterPlayer.petTypeProperty());
        petDescription.textProperty().bind(characterPlayer.descriptionProperty());
    }

    public void onActionCreatePet(ActionEvent actionEvent) {
        player = new Player(charactersList.get(index));
        sharedPlayer = new Player(charactersList.get(index));
        Stage createPet = new Stage();
        createPet.setScene(new Scene(createParentFromFXML(PathAndNameFiles.PATH_TO_FXML.getPath(), DEAD_PET_FXML_FILE_NAME.getPath(), 250, 300)));
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
