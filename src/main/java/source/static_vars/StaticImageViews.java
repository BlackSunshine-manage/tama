package source.static_vars;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import source.Main;
import source.path.PathToFiles;

/**
 * Класс для инициализации всех необходимых изображений в статичном блоке
 */
public class StaticImageViews implements PathToFiles {
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

    static {
        imageCage60x290 = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_MAP_IN_RESOURCES_FOLDER + CAGE_IMAGE_CAGE_60x290)), 600, 160, false, true));

        imageCage460x44 = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_MAP_IN_RESOURCES_FOLDER + CAGE_IMAGE_CAGE_460x44)), 600, 160, false, true));

        imageUI = new ImageView(new Image((Main.class.getResourceAsStream(PATH_TO_IMAGE + UI_DOWN_IMAGE_PATH_TO_FILE)), 600, 160, false, true));

//-------------------------food_images----------------------//
        fishImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                FOOD_FISH))); // Для Black cat
        ghostMeatImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                FOOD_GHOST)));// Для nightmare
        meatImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                FOOD_MEAT))); // Для Hellion
        boneImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                FOOD_BONE))); // Для собачек
        carrotImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                FOOD_CARROT)));// Для poring

        rottenMeatImageView = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_IMAGE +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                FOOD_ROTTENMEAT)));// Для грифов(или тех кто поедает тухлое мясо)

        //-------------------------sprite_images----------------------//

        stage1Poring = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                PORING_SPRITE_MAP_NAME_1)));

        stage2Poring = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                PORING_SPRITE_MAP_NAME_2)));

        stage3Poring = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                PORING_SPRITE_MAP_NAME_3)));

        stage1Nightmare = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                NIGHTMARE_SPRITE_MAP_NAME_1)));

        stage2Nightmare = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                NIGHTMARE_SPRITE_MAP_NAME_2)));

        stage3Nightmare = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                NIGHTMARE_SPRITE_MAP_NAME_3)));

        stage1BlackCat = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                BLACK_CAT_SPRITE_MAP_NAME_1)));

        stage2BlackCat = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                BLACK_CAT_SPRITE_MAP_NAME_2)));

        stage3BlackCat = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                BLACK_CAT_SPRITE_MAP_NAME_3)));

        stage1Hellion = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                HELLION_SPRITE_MAP_NAME)));

        stage2Hellion = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                HELLION_SPRITE_MAP_NAME_2)));

        stage3Hellion = new ImageView(new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                HELLION_SPRITE_MAP_NAME_3)));
    }
}
