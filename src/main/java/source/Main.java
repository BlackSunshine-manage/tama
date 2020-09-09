package source;

import application_interface.ApplicationInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import source.characters.chars.CharacterPlayer;
import source.characters.chars.Player;
import source.classes.food.Food;
import source.engine.EngineGameInputKeypad;
import source.path.IdentifyInFXML;
import source.path.PathToFiles;
import spring_cfg.SpringApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main extends Application implements PathToFiles, IdentifyInFXML, EngineGameInputKeypad, ApplicationInterface {
    public static Map<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>(100);
    public static List<Food> foods = new CopyOnWriteArrayList<>();
    public static Scene scene;
    public static Player player = new Player();
    public static CharacterPlayer character;
    public static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringApplicationContext.class);

    public static Pane root = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(DATA_SAVE_AND_LOAD_FILE_NAME)));
            player = player.readObject(ois);
            character = player.getPlayer();
            if (player.petIsDiedProperty().getValue()) {
                root = (Pane) createParentFromFXML(PATH_TO_FXML, CREATE_PET_FXML_FILE_NAME, 300, 430);
            } else {
                root = (Pane) createParentFromFXML(PATH_TO_FXML, ENTERED_WINDOW_FXML_NAME, 300, 430);
            }
            scene = new Scene(root);
        } catch (Exception e) {
            root = (Pane) createParentFromFXML(PATH_TO_FXML, CREATE_PET_FXML_FILE_NAME, 300, 430);
            scene = new Scene(root);
        } finally {
            if (ois != null) {
                ois.close();
            }
        }

        scene.setOnKeyPressed(keyPressetEvent -> {
            keys.put(keyPressetEvent.getCode(), true);
        });

        scene.setOnKeyReleased(keyReleasedEvent -> {
            keys.put(keyReleasedEvent.getCode(), false);
        });

        primaryStage.setTitle(APPLICATION_NAME);
        primaryStage.setScene(root.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
