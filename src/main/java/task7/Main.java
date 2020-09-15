package task7;

import com.google.common.collect.Maps;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task7.characters.chars.CharacterPlayer;
import task7.characters.chars.Player;
import task7.context.SpringApplicationContext;
import task7.engine.EngineGameInputKeypad;
import task7.enums.path.PathAndNameFiles;
import task7.food.Food;
import task7.single_instance.FileSaveAndLoadPlayer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import static task7.enums.path.PathAndNameFiles.*;
import static task7.utils.ApplicationUtils.APPLICATION_NAME;
import static task7.utils.ApplicationUtils.createParentFromFXML;

public class Main extends Application implements EngineGameInputKeypad {
    public static Map<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>(100);
    public static List<Food> foods = new CopyOnWriteArrayList<>();
    public static Scene scene;
    public static Player player = new Player();
    public static CharacterPlayer character;
    public static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringApplicationContext.class);

    public static Pane root = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Temp.FULL_PATH_TO_FILE.setValue(getPathToDirSave());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FileSaveAndLoadPlayer.getInstance()));
            player = player.readObject(ois);
            character = player.getPlayer();

            if (player.petIsDiedProperty().getValue()) {
                System.out.println("HERE");
                root = (Pane) createParentFromFXML(PathAndNameFiles.PATH_TO_FXML.getPath(), CREATE_PET_FXML_FILE_NAME.getPath(), 300, 430);
            } else {
                root = (Pane) createParentFromFXML(PathAndNameFiles.PATH_TO_FXML.getPath(), ENTERED_WINDOW_FXML_NAME.getPath(), 300, 430);
            }
            scene = new Scene(root);
        } catch (Exception e) {
            root = (Pane) createParentFromFXML(PathAndNameFiles.PATH_TO_FXML.getPath(), CREATE_PET_FXML_FILE_NAME.getPath(), 300, 430);
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

    public static KeyCode getPressedKeyCode() {
        return keys.entrySet().stream()
                .filter(Map.Entry::getValue)
                .findFirst()
                .orElse(Maps.immutableEntry(KeyCode.ACCEPT, false)).getKey();
    }

//    public static File findOrCreateFileSaveAndLoad() throws IOException {
//        Temp tempDirectory = Temp.USER_DIR_TO_SAVE_AND_LOAD;
//        String sumPath = tempDirectory.getValue() + DATA_SAVE_AND_LOAD_FILE_NAME.getPath();
//        File saveAndLoad = new File(sumPath);
//        if (!saveAndLoad.exists()) {
//        } else {
//            System.out.println("Not existed");
//            System.out.println(sumPath);
//        }
//        return saveAndLoad;
//    }


}

