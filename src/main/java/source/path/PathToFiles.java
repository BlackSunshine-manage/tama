package source.path;

/**
 * Интерфейс для хранения переменных, которые связанны с путями к файлам и названиями файлов
 */
public interface PathToFiles {
    // ---------- PATH TO FXML, IMAGES AND ICONS---------//
    String PATH_TO_FXML = "/source/ui/fxml/"; // path to all fxml
    String PATH_TO_MAP = "/source/graphics/maps/"; // path to game map
    String PATH_TO_MAP_IN_RESOURCES_FOLDER = "/game_maps_image/"; // path to game map

    String PATH_TO_DATA_FILE = "/data/"; // path to data save and load

    String PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER = "/sprite_maps/";//"/source/graphics/sprite_maps/"; // path to sprite maps(images)

    String PATH_TO_IMAGE = "/images/";
    // ---------- FILE NAMES ---------//
    String DATA_SAVE_AND_LOAD_FILE_NAME = "dataPlayers.txt";

    String ENTERED_WINDOW_FXML_NAME = "EnterInTheGame.fxml";
    String GAME_WINDOW_FXML_FILE_NAME = "game_map.fxml"; // File name game map
    String CREATE_PET_FXML_FILE_NAME = "CreateCharacter.fxml"; // File name created pet
    String DEAD_PET_FXML_FILE_NAME = "deadPet.fxml"; // File name dead pet

    String CAGE_IMAGE_CAGE_460x44 = "cage460x44.png";
    String CAGE_IMAGE_CAGE_60x290 = "cage60x290.png";

    String UI_DOWN_IMAGE_PATH_TO_FILE = "AllUI.png";

    // ---------- IMAGE NAMES ---------//
    String MAP_IMAGE_GREEN_1 = "BigMapHerb.png"; // Green game-map(1)

    String FOOD_FISH = "fish_to_cat.png";// food fish to cat
    String FOOD_GHOST = "ghost_to_nightmare.png"; // food for nightmare
    String FOOD_BONE = "bone_to_dog.png";// food for dog
    String FOOD_MEAT = "meat_to_hellion.png";//food for hellion
    String FOOD_CARROT = "carrot_for_rabbit.png"; // food for poring
    String FOOD_ROTTENMEAT = "rotten_meat_to_zomby.png"; // food for zomby
    // ---------- SPRITE_MAPS NAMES ---------//
    String BLACK_CAT_SPRITE_MAP_NAME = "BlackCatSprite.png"; // Sprite-map "Black cat"

    String HELLION_SPRITE_MAP_NAME = "HellionTransparent.png";//Stage 1"HellionSprite.png";
    String HELLION_SPRITE_MAP_NAME_2 = "HellionTransparentStage2.png";//Stage 2"HellionSprite.png";
    String HELLION_SPRITE_MAP_NAME_3 = "HellionTransparentStage3.png";//Stage 3"HellionSprite.png";

    String BLACK_CAT_SPRITE_MAP_NAME_1 = "BlackCatStage1.png";//Stage 1 Black cat;
    String BLACK_CAT_SPRITE_MAP_NAME_2 = "BlackCatStage2.png";//Stage 2 Black cat;
    String BLACK_CAT_SPRITE_MAP_NAME_3 = "BlackCatStage3.png";//Stage 3 Black cat;

    String NIGHTMARE_SPRITE_MAP_NAME_1 = "NightmareStage1.png";//Stage 1 Nightmare;
    String NIGHTMARE_SPRITE_MAP_NAME_2 = "NightmareStage2.png";
    String NIGHTMARE_SPRITE_MAP_NAME_3 = "NightmareStage3.png";

    String PORING_SPRITE_MAP_NAME_1 = "PoringStage1.png";//Stage 1 Poring;
    String PORING_SPRITE_MAP_NAME_2 = "PoringStage2.png";
    String PORING_SPRITE_MAP_NAME_3 = "PoringStage3.png";
}
