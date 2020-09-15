package task7.enums;

import lombok.Getter;

@Getter
public enum StatsValue { // Пока-что содержит только голод и настроение
    HUNGRY("голод"),
    MOOD("настроение");

    private final String valueName;

    StatsValue(String valueName) {
        this.valueName = valueName;
    }
}
