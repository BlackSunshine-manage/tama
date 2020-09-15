package task7.enums.path;

import lombok.Getter;

@Getter
public enum PathAndNameFiles {
    // ---------- PATH TO FXML, IMAGES AND ICONS---------//
    PATH_TO_FXML("/resources/fxml/"), // path to all fxml
    PATH_TO_MAP("/task7/graphics/maps/"), // path to game map
    PATH_TO_MAP_IN_RESOURCES_FOLDER("/resources/game_maps_image/"), // path to game map

    PATH_TO_DATA_FILE("/data/"), // path to data save and load

    PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER("/resources/sprite_maps/"),// path to sprite map

    PATH_TO_IMAGE("/resources/images/"),// path to images

    PATH_TO_RESOURCES("/resources/"),
    // ---------- FILE NAMES ---------//
    DATA_SAVE_AND_LOAD_FILE_NAME("dataPlayers.txt"),

    ENTERED_WINDOW_FXML_NAME("EnterInTheGame.fxml"),
    GAME_WINDOW_FXML_FILE_NAME("game_map.fxml"), // File name game map
    CREATE_PET_FXML_FILE_NAME("CreateCharacter.fxml"), // File name created pet
    DEAD_PET_FXML_FILE_NAME("deadPet.fxml"), // File name dead pet

    CAGE_IMAGE_CAGE_460x44("cage460x44.png"),
    CAGE_IMAGE_CAGE_60x290("cage60x290.png"),

    UI_DOWN_IMAGE_PATH_TO_FILE("AllUI.png"),

    // ---------- IMAGE NAMES ---------//
    MOOD_MINUS_ONE("minus1mood.png"),

    MOOD_PLUS_ONE("plus1mood.png"),

    HUNGER_MINUS_ONE("minus1hunger.png"),

    HUNGER_PLUS_ONE("plus1hunger.png"),

    MAP_IMAGE_GREEN_1("BigMapHerb.png"), // Green game-map(1)

    FOOD_FISH("fish_to_cat.png"),// food fish to cat
    FOOD_GHOST("ghost_to_nightmare.png"), // food for nightmare
    FOOD_BONE("bone_to_dog.png"),// food for dog
    FOOD_MEAT("meat_to_hellion.png"),//food for hellion
    FOOD_CARROT("carrot_for_rabbit.png"), // food for poring
    FOOD_ROTTENMEAT("rotten_meat_to_zomby.png"), // food for zomby
    // ---------- SPRITE_MAPS NAMES ---------//
    BLACK_CAT_SPRITE_MAP_NAME("BlackCatSprite.png"), // Sprite-map "Black cat"

    HELLION_SPRITE_MAP_NAME("HellionTransparent.png"),//Stage 1"HellionSprite.png"),
    HELLION_SPRITE_MAP_NAME_2("HellionTransparentStage2.png"),//Stage 2"HellionSprite.png"),
    HELLION_SPRITE_MAP_NAME_3("HellionTransparentStage3.png"),//Stage 3"HellionSprite.png"),

    BLACK_CAT_SPRITE_MAP_NAME_1("BlackCatStage1.png"),//Stage 1 Black cat),
    BLACK_CAT_SPRITE_MAP_NAME_2("BlackCatStage2.png"),//Stage 2 Black cat),
    BLACK_CAT_SPRITE_MAP_NAME_3("BlackCatStage3.png"),//Stage 3 Black cat),

    NIGHTMARE_SPRITE_MAP_NAME_1("NightmareStage1.png"),//Stage 1 Nightmare),
    NIGHTMARE_SPRITE_MAP_NAME_2("NightmareStage2.png"),
    NIGHTMARE_SPRITE_MAP_NAME_3("NightmareStage3.png"),

    PORING_SPRITE_MAP_NAME_1("PoringStage1.png"),//Stage 1 Poring),
    PORING_SPRITE_MAP_NAME_2("PoringStage2.png"),
    PORING_SPRITE_MAP_NAME_3("PoringStage3.png");

    private final String path;

    PathAndNameFiles(String path) {
        this.path = path;
    }
}
