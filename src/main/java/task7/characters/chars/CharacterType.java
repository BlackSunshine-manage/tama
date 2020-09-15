package task7.characters.chars;

import javafx.scene.image.ImageView;
import lombok.Getter;
import task7.enums.TypePetName;
import task7.static_vars.StaticImageViews;

import java.util.Arrays;

@Getter
public enum CharacterType {
    HELLION_SMALL(TypePetName.HELLION_TYPE_NAME.getName(), StaticImageViews.stage1Hellion, 1, 100, 100),
    HELLION_MEDIUM(TypePetName.HELLION_TYPE_NAME.getName(), StaticImageViews.stage2Hellion, 2, 200, 200),
    HELLION_LARGE(TypePetName.HELLION_TYPE_NAME.getName(), StaticImageViews.stage3Hellion, 3, 300, 300),

    BLACK_CAT_SMALL(TypePetName.BLACK_CAT_TYPE_NAME.getName(), StaticImageViews.stage1BlackCat, 1, 32, 32),
    BLACK_CAT_MEDIUM(TypePetName.BLACK_CAT_TYPE_NAME.getName(), StaticImageViews.stage2BlackCat, 2, 64, 64),
    BLACK_CAT_LARGE(TypePetName.BLACK_CAT_TYPE_NAME.getName(), StaticImageViews.stage3BlackCat, 3, 96, 96),

    NIGHTMARE_SMALL(TypePetName.NIGHTMARE_TYPE_NAME.getName(), StaticImageViews.stage1Nightmare, 1, 100, 100),
    NIGHTMARE_MEDIUM(TypePetName.NIGHTMARE_TYPE_NAME.getName(), StaticImageViews.stage2Nightmare, 2, 200, 200),
    NIGHTMARE_LARGE(TypePetName.NIGHTMARE_TYPE_NAME.getName(), StaticImageViews.stage3Nightmare, 3, 300, 300),

    PORING_SMALL(TypePetName.PORING_TYPE_NAME.getName(), StaticImageViews.stage1Poring, 1, 50, 50),
    PORING_MEDIUM(TypePetName.PORING_TYPE_NAME.getName(), StaticImageViews.stage2Poring, 2, 100, 100),
    PORING_LARGE(TypePetName.PORING_TYPE_NAME.getName(), StaticImageViews.stage3Poring, 3, 150, 150);

    private final String name;
    private final ImageView imageView;
    private final int stage;
    private final int width;
    private final int height;

    CharacterType(String name, ImageView imageView, int stage, int width, int height) {
        this.name = name;
        this.imageView = imageView;
        this.stage = stage;
        this.width = width;
        this.height = height;
    }

    public static CharacterType getCharacterTypeFromString(String value, int stage) {
        return Arrays.stream(CharacterType.values()).filter(t -> t.getName().equals(value) && t.stage == stage).findFirst()//getName
                .orElseThrow(() -> new UnsupportedOperationException("Name: " + value + " not supported"));
    }
}
