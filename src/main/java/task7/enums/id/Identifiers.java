package task7.enums.id;

import lombok.Getter;

/**
 * Хранит значения ID(идентификаторов) в FXML-файлах
 */
@Getter
public enum Identifiers {

    ID_IN_GAME_WINDOW_TO_THE_GROWTH_PROGRESS_BAR("#growthProgress"),

    ID_IN_GAME_WINDOW_TO_THE_HUNGER_PROGRESS_BAR("#progressHunger"),

    ID_IN_GAME_WINDOW_TO_THE_MOOD_PROGRESS_BAR("#progressMood");

    private final String name;

    Identifiers(String name) {
        this.name = name;
    }
}
