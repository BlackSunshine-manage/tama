package task7.enums;

import lombok.Getter;

@Getter
public enum MaxHungerInAnotherStages {
    STAGE_1_HUNGER_MAX(30),
    STAGE_2_HUNGER_MAX(90),
    STAGE_3_HUNGER_MAX(270);

    private final int hungerMax;

    MaxHungerInAnotherStages(int hungerMax) {
        this.hungerMax = hungerMax;
    }
}
