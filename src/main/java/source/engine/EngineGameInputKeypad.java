package source.engine;

import javafx.scene.input.KeyCode;
import source.Main;
import source.characters.chars.*;
import source.classes.food.Food;
import source.ui.controllers.GameMap;

/**
 * @author shapkin eduard. Шапкин Эдуард
 * Основной движок для управления персонажем и начисления бонусов за съеденную еду.
 */
public interface EngineGameInputKeypad {

    /**
     * Определяет нажата ли одна из кнопок на клавиатуре, извлекая результат нажатия из {@link Main#keys} в результате
     * отсутствия элементов в {@link Main#keys} извлечёт false, а конкретно "A", "S", "W", "D" в методе
     * {@link EngineGameInputKeypad#update(CharacterPlayer)} описана реализация тех или иных действий.
     *
     * @param key Принимает на вход одно из перечислений класса {@link KeyCode}, определяя есть ли в {@link Main#keys}
     *            данное значение (нажата ли кнопка)
     * @return boolean Возвращает результат выполнения проверки нажатия клавиш
     */
    default boolean isPressed(KeyCode key) {
        return Main.keys.getOrDefault(key, false);
    }

    public static final double MOVEMENT_RATE = 0.5;

    // TODO: FOR ADDONS(2). Дополнить метод update в блоках if/else когда добавляем нового CharacterPlayer - дочернего класса

    /**
     * Метод вызывается для действия персонажа в ответ на нажатие клавиши. При расширении колличества классов, наследующих
     * {@link CharacterPlayer} необходимо дополнить метод
     *
     * @param <T>             Требование: наследование от класса {@link CharacterPlayer}. Принимает на вход объект персонажа которым будет управляться
     * @param playerCharacter Принимает на вход объект персонажа которым будет управляться.
     */
    default <T extends CharacterPlayer> void update(T playerCharacter) {
        int w, a, s, d, always; // переменные для начала
        int stageGrowth = playerCharacter.getGrowthStage();
        if (isPressed(KeyCode.W)) {
            playerCharacter.animation.play();
            if (playerCharacter instanceof Hellion) {
                w = 200;
                System.out.println(w + " W" + " Стадия роста " + stageGrowth);
                playerCharacter.animation.setOffsetY(w * stageGrowth);
            } else if (playerCharacter instanceof BlackCat) {
                w = 96;
                playerCharacter.animation.setOffsetY(w * stageGrowth);
            } else if (playerCharacter instanceof Nightmare) {
                w = 200;
                playerCharacter.animation.setOffsetY(w * stageGrowth);
            } else if (playerCharacter instanceof Poring) {
                w = 150;
                playerCharacter.animation.setOffsetY(w * stageGrowth);
            }
            moveY(-1, playerCharacter);
        } else if (isPressed(KeyCode.S)) {
            playerCharacter.animation.play();
            if (playerCharacter instanceof Hellion) {
                s = 0;
                System.out.println(s + " S" + " Стадия роста " + stageGrowth);
                playerCharacter.animation.setOffsetY(s);
            } else if (playerCharacter instanceof BlackCat) {
                s = 0;
                playerCharacter.animation.setOffsetY(s * stageGrowth);
            } else if (playerCharacter instanceof Nightmare) {
                s = 300;
                playerCharacter.animation.setOffsetY(s * stageGrowth);
            } else if (playerCharacter instanceof Poring) {
                w = 50;
                playerCharacter.animation.setOffsetY(w * stageGrowth);
            }
            moveY(1, playerCharacter);
        } else if (isPressed(KeyCode.D)) {
            playerCharacter.animation.play();
            if (playerCharacter instanceof Hellion) {
                d = 100 * stageGrowth;
                playerCharacter.animation.setOffsetY(d);
            } else if (playerCharacter instanceof BlackCat) {
                d = 64 * stageGrowth;
                playerCharacter.animation.setOffsetY(d);
            } else if (playerCharacter instanceof Nightmare) {
                d = 300;
                playerCharacter.animation.setOffsetY(d * stageGrowth);
            } else if (playerCharacter instanceof Poring) {
                d = 100;
                playerCharacter.animation.setOffsetY(d * stageGrowth);
            }
            moveX(1, playerCharacter);
        } else if (isPressed(KeyCode.A)) {
            playerCharacter.animation.play();
            if (playerCharacter instanceof Hellion) {
                a = 0;
                System.out.println(a + " A" + " Стадия роста " + stageGrowth);
                playerCharacter.animation.setOffsetY(a * stageGrowth);
            } else if (playerCharacter instanceof BlackCat) {
                a = 32;
                playerCharacter.animation.setOffsetY(a * stageGrowth);
            } else if (playerCharacter instanceof Nightmare) {
                a = 100;
                playerCharacter.animation.setOffsetY(a * stageGrowth);
            } else if (playerCharacter instanceof Poring) {
                a = 50;
                playerCharacter.animation.setOffsetY(a * stageGrowth);
            }
            moveX(-1, playerCharacter);
        } else {
            playerCharacter.animation.play();
            if (playerCharacter instanceof Hellion) {
                always = 300;
                playerCharacter.animation.setOffsetY(always * stageGrowth);
            } else if (playerCharacter instanceof BlackCat) {
                always = 64;
                playerCharacter.animation.setOffsetY(always * stageGrowth);//* stageGrowth);
            } else if (playerCharacter instanceof Nightmare) {
                always = 0;
                playerCharacter.animation.setOffsetY(always * stageGrowth);
            } else if (playerCharacter instanceof Poring) {
                always = 0;
                playerCharacter.animation.setOffsetY(always * stageGrowth);
            }
        }
    }

    /**
     * Метод передвижения персонажа
     *
     * @param <T>    Требование: наследование от класса {@link CharacterPlayer}. Принимает на вход объект персонажа которым будет управляться
     * @param player Принимает на вход объект персонажа которым будет управляться.
     * @param x      Кратность выполнения передвижения
     */
    default <T extends CharacterPlayer> void moveX(double x, T player) {

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
     * @param <T>    Требование: наследование от класса {@link CharacterPlayer}.
     * @param y      Кратность выполнения передвижения
     */
    default <T extends CharacterPlayer> void moveY(double y, T player) {
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
    default void isEat(CharacterPlayer player) {
        final Food[] removeElement = new Food[1];
        Main.foods.forEach((food) -> {
            if ((player).getBoundsInParent().intersects(food.getBoundsInParent())) {
                removeElement[0] = (Food) food;
                Main.foods.remove(removeElement[0]);
                GameMap.rootInGameMap.getChildren().remove(removeElement[0]);
                player.hungryPropertyProperty().setValue(player.hungryPropertyProperty().get() + 1);
                player.setHunger(player.getHunger() + 1);
            }
        });
    }
}


