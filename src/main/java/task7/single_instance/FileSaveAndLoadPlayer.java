package task7.single_instance;

import task7.enums.path.PathAndNameFiles;

import java.io.File;
import java.io.IOException;

public class FileSaveAndLoadPlayer extends File {
    private static FileSaveAndLoadPlayer instance;

    public FileSaveAndLoadPlayer(String pathname) {
        super(pathname);
    }

    public static FileSaveAndLoadPlayer getInstance() {
        if (instance == null) {
            instance = new FileSaveAndLoadPlayer(getPathToDirSave());
        }
        return instance;
    }

    private static String getPathToDirSave() {
        StringBuilder stringBuilder = new StringBuilder();
        String paths[] = null;
        try {
            paths = File.createTempFile("text", ".txt").getAbsolutePath().split("\\" + File.separator);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        for (int i = 0; i < paths.length - 1; i++) {
            stringBuilder.append(paths[i]);
            stringBuilder.append(File.separator);
        }
        if (!new File(stringBuilder.toString() + "tamagotcha").exists()) {
            new File(stringBuilder.toString() + "tamagotcha").mkdir();
        }
        stringBuilder.append("tamagotcha");
        stringBuilder.append(File.separator);
        stringBuilder.append(PathAndNameFiles.DATA_SAVE_AND_LOAD_FILE_NAME.getPath());
        return stringBuilder.toString();
    }
}
