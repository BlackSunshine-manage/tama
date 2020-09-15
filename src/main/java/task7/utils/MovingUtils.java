package task7.utils;

import task7.Main;
import task7.characters.chars.CharacterPlayer;
import task7.enums.StatsValue;
import task7.enums.StatusType;
import task7.food.Food;
import task7.ui.controllers.GameMap;
import task7.utils.counter_animation.factory.CounterFactory;

import static task7.engine.EngineGameInputKeypad.MOVEMENT_RATE;

public class MovingUtils {
    /**
     * Метод передвижения персонажа
     *
     * @param player Принимает на вход объект персонажа которым будет управляться.
     * @param x      Кратность выполнения передвижения
     */
    public static void moveX(double x, CharacterPlayer player) {

        x = x * 5;
        boolean right = x > 0 ? true : false;
        for (int i = 0; i < Math.abs(x); i++) {
            if (right) {
                player.setTranslateX(player.getTranslateX() + MOVEMENT_RATE);

            } else {
                player.setTranslateX(player.getTranslateX() - MOVEMENT_RATE);
            }
        }
        isEat(player);
    }

    /**
     * Метод передвижения персонажа
     *
     * @param player Принимает на вход объект персонажа которым будет управляться.
     * @param y      Кратность выполнения передвижения
     */
    public static void moveY(double y, CharacterPlayer player) {
        y = y * 5;
        boolean down = y > 0 ? true : false;
        for (int i = 0; i < Math.abs(y); i++) {
            if (down) {
                player.setTranslateY(player.getTranslateY() + MOVEMENT_RATE);
            } else {
                player.setTranslateY(player.getTranslateY() - MOVEMENT_RATE);
            }
        }
        isEat(player);
    }

    /**
     * Метод проверки "наступил" ли персонаж на еду, если да, то персонажу засчитывается одно очко еды, и убирается с
     * игрового поля и удаляется из листа {@link Main#foods}
     *
     * @param player Принимает на вход объект, координаты которого сравниваются с координатами "еды" на игровом поле
     */
    public static void isEat(CharacterPlayer player) {
        final Food[] removeElement = new Food[1];
        Main.foods.forEach((food) -> {
            if ((player).getBoundsInParent().intersects(food.getBoundsInParent())) {
                removeElement[0] = (Food) food;
                Main.foods.remove(removeElement[0]);
                GameMap.rootInGameMap.getChildren().remove(removeElement[0]);
                player.hungryPropertyProperty().setValue(player.hungryPropertyProperty().get() + 1);
                player.setHunger(player.getHunger() + 1);
                CounterFactory.createCounter(StatusType.getStatusTypeFromStatusNameAndStatusValue(StatsValue.HUNGRY.getValueName(), +1));
            }
        });
    }
}
