package task7.enums;

import lombok.Getter;

@Getter
public enum PetsDescriptions {
    HELLION_PET_DESCRIPTION("Опасный хищник. Большие лапки."),
    BLACK_CAT_PET_DESCRIPTION("Опасный хищник. Не такой как хеллион, но всёже. Имеются маленькие лапки, из-за чего не столь опасен"),
    NIGHTMARE_PET_DESCRIPTION("Кошмар. Большой. И страшный."),
    PORING_PET_DESCRIPTION("Смешная желешка. Кушает морковку.");

    private final String description;

    PetsDescriptions(String description) {
        this.description = description;
    }
}
