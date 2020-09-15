package task7.static_vars;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import task7.Main;

import static task7.enums.path.PathAndNameFiles.*;

/**
 * Класс для инициализации всех необходимых изображений в статичном блоке
 */
public class StaticImageViews {
    public static ImageView stage1Hellion = null;//stage1Hellion stage1Hellion
    public static ImageView stage2Hellion = null;
    public static ImageView stage3Hellion = null;

    public static ImageView stage1BlackCat = null;
    public static ImageView stage2BlackCat = null;
    public static ImageView stage3BlackCat = null;

    public static ImageView stage1Nightmare = null;
    public static ImageView stage2Nightmare = null;
    public static ImageView stage3Nightmare = null;

    public static ImageView stage1Poring = null;
    public static ImageView stage2Poring = null;
    public static ImageView stage3Poring = null;

    public static ImageView fishImageView = null; // Для Black cat
    public static ImageView meatImageView = null; // Для Hellion
    public static ImageView boneImageView = null; // Для собачек
    public static ImageView carrotImageView = null;// Для poring
    public static ImageView rottenMeatImageView = null;// Для грифов(или тех кто поедает тухлое мясо)
    public static ImageView ghostMeatImageView = null;// Для кашмаров

    public static ImageView imageUI = null;

    public static ImageView imageCage60x290 = null;
    public static ImageView imageCage460x44 = null;

    public static ImageView moodMinusOne = null;
    public static ImageView moodPlusOne = null;

    public static ImageView hungerPlusOne = null;
    public static ImageView hungerMinusOne = null;

    static {
        hungerMinusOne = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                HUNGER_MINUS_ONE.getPath()))));

        hungerPlusOne = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                HUNGER_PLUS_ONE.getPath()))));

        moodMinusOne = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                MOOD_MINUS_ONE.getPath()))));

        moodPlusOne = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                MOOD_PLUS_ONE.getPath()))));

        imageCage60x290 = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_MAP_IN_RESOURCES_FOLDER.getPath() +
                CAGE_IMAGE_CAGE_60x290.getPath())), 600, 160, false, true));

        imageCage460x44 = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_MAP_IN_RESOURCES_FOLDER.getPath() +
                CAGE_IMAGE_CAGE_460x44.getPath())), 600, 160, false, true));

        imageUI = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                UI_DOWN_IMAGE_PATH_TO_FILE.getPath())), 600, 160, false, true));

//-------------------------food_images----------------------//
        fishImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                FOOD_FISH.getPath()))); // Для Black cat

        ghostMeatImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                FOOD_GHOST.getPath())));// Для nightmare

        meatImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                FOOD_MEAT.getPath()))); // Для Hellion

        boneImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                FOOD_BONE.getPath()))); // Для собачек

        carrotImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                FOOD_CARROT.getPath())));// Для poring

        rottenMeatImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE.getPath() +
                FOOD_ROTTENMEAT.getPath())));// Для грифов(или тех кто поедает тухлое мясо)

        //-------------------------sprite_images----------------------//

        stage1Poring = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                PORING_SPRITE_MAP_NAME_1.getPath())));

        stage2Poring = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                PORING_SPRITE_MAP_NAME_2.getPath())));

        stage3Poring = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                PORING_SPRITE_MAP_NAME_3.getPath())));

        stage1Nightmare = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                NIGHTMARE_SPRITE_MAP_NAME_1.getPath())));

        stage2Nightmare = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                NIGHTMARE_SPRITE_MAP_NAME_2.getPath())));

        stage3Nightmare = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                NIGHTMARE_SPRITE_MAP_NAME_3.getPath())));

        stage1BlackCat = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                BLACK_CAT_SPRITE_MAP_NAME_1.getPath())));

        stage2BlackCat = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                BLACK_CAT_SPRITE_MAP_NAME_2.getPath())));

        stage3BlackCat = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                BLACK_CAT_SPRITE_MAP_NAME_3.getPath())));

        stage1Hellion = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                HELLION_SPRITE_MAP_NAME.getPath())));

        stage2Hellion = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                HELLION_SPRITE_MAP_NAME_2.getPath())));

        stage3Hellion = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                HELLION_SPRITE_MAP_NAME_3.getPath())));
    }
}
