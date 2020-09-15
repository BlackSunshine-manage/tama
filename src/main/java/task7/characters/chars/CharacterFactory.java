package task7.characters.chars;

public class CharacterFactory {

    public static CharacterPlayer createCharacter(CharacterType type) {
        assert type == null : "Type should not be null";
        switch (type) {
            case HELLION_LARGE:
            case HELLION_SMALL:
            case HELLION_MEDIUM:
                return new Hellion(type.getImageView(), type.getWidth(), type.getHeight());
            case BLACK_CAT_LARGE:
            case BLACK_CAT_SMALL:
            case BLACK_CAT_MEDIUM:
                return new BlackCat(type.getImageView(), type.getWidth(), type.getHeight());
            case NIGHTMARE_LARGE:
            case NIGHTMARE_SMALL:
            case NIGHTMARE_MEDIUM:
                return new Nightmare(type.getImageView(), type.getWidth(), type.getHeight());
            case PORING_LARGE:
            case PORING_SMALL:
            case PORING_MEDIUM:
                return new Poring(type.getImageView(), type.getWidth(), type.getHeight());
            default:
                throw new UnsupportedOperationException("CharacterType: " + type.getName() + " not supported");
        }
    }
}
