package task7.engine;

import javafx.scene.input.KeyCode;
import task7.Main;
import task7.characters.chars.CharacterPlayer;

/**
 * @author shapkin eduard. Шапкин Эдуард
 * Основной движок для управления персонажем и начисления бонусов за съеденную еду.
 */
public interface EngineGameInputKeypad {
    double MOVEMENT_RATE = 0.5;

    /**
     * Метод вызывается для действия персонажа в ответ на нажатие клавиши.
     *
     * @param <T>             Требование: наследование от класса {@link CharacterPlayer}. Принимает на вход объект персонажа которым будет управляться
     * @param playerCharacter Принимает на вход объект персонажа которым будет управляться.
     */
    default <T extends CharacterPlayer> void update(T playerCharacter) {
        KeyCode keyCode = Main.getPressedKeyCode();
        playerCharacter.playAnimation();
        playerCharacter.setOffsetYByKeyCode(keyCode);
    }
}


