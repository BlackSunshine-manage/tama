package task7.utils.counter_animation.factory;

import task7.enums.StatusType;
import task7.static_vars.StaticImageViews;
import task7.ui.controllers.GameMap;
import task7.utils.counter_animation.Counter;
import task7.utils.counter_animation.hunger_counter.HungerCounter;
import task7.utils.counter_animation.mood_counter.MoodCounter;

public class CounterFactory {
    public static Counter createCounter(StatusType statusType) {
        switch (statusType) {
            case MOOD_DECREMENT_TO_ONE:
                return new MoodCounter(StaticImageViews.moodMinusOne, GameMap.player.getPlayer(), GameMap.rootInGameMap);
            case MOOD_INCREMENT_TO_ONE:
                return new HungerCounter(StaticImageViews.moodPlusOne, GameMap.player.getPlayer(), GameMap.rootInGameMap);
            case HUNGER_INCREMENT_TO_ONE:
                return new MoodCounter(StaticImageViews.hungerPlusOne, GameMap.player.getPlayer(), GameMap.rootInGameMap);
            case HUNGER_DECREMENT_TO_ONE:
                return new HungerCounter(StaticImageViews.hungerMinusOne, GameMap.player.getPlayer(), GameMap.rootInGameMap);
            default:
                throw new UnsupportedOperationException("Not supported operation for" + statusType.getStatusName());
        }
    }
}
