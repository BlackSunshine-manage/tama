package task7.enums;

import javafx.scene.image.ImageView;
import lombok.Getter;
import task7.static_vars.StaticImageViews;

import java.util.Arrays;

@Getter
public enum StatusType {

    HUNGER_INCREMENT_TO_ONE(StatsValue.HUNGRY.getValueName(), 1, new ImageView(StaticImageViews.hungerPlusOne.getImage())),

    MOOD_INCREMENT_TO_ONE(StatsValue.MOOD.getValueName(), 1, new ImageView(StaticImageViews.moodPlusOne.getImage())),

    HUNGER_DECREMENT_TO_ONE(StatsValue.HUNGRY.getValueName(), -1, new ImageView(StaticImageViews.hungerMinusOne.getImage())),

    MOOD_DECREMENT_TO_ONE(StatsValue.MOOD.getValueName(), -1, new ImageView(StaticImageViews.moodMinusOne.getImage()));

    private final String statusName;

    private final int statusValue;

    private final ImageView imageView;

    StatusType(String statusName, int statusValue, ImageView imageView) {
        this.statusName = statusName;
        this.statusValue = statusValue;
        this.imageView = imageView;
    }

    public static StatusType getStatusTypeFromStatusNameAndStatusValue(String statusName, int statusValue) {
        return Arrays.stream(StatusType.values()).filter(t -> t.statusName.equals(statusName) && t.statusValue == statusValue).findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Name: " + statusName + " and " + statusValue + "not supported"));
    }
}
