package task7.enums;

import lombok.Getter;

@Getter
public enum TypePetName {
    HELLION_TYPE_NAME("Hellion"),
    BLACK_CAT_TYPE_NAME("Black cat"),
    NIGHTMARE_TYPE_NAME("Nightmare"),
    PORING_TYPE_NAME("Poring");

    private final String name;

    TypePetName(String name) {
        this.name = name;
    }
}
