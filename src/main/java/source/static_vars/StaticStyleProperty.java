package source.static_vars;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

/**
 * Предназначен для инициализации общей стилизации приложения
 */
public class StaticStyleProperty {
    static {
        // Добавить инициализацию иконки
        Button button = new Button();
        DEFAULT_BUTTON_STYLE = button.getStyle();
    }

    /**
     * Иконка для всех окошек
     */
    public static Image iconStages;

    /**
     * Стилизация кнопки при отмене фокуса
     */
    public static String DEFAULT_BUTTON_STYLE;

    /**
     * Стилизация кнопки при наведении
     */
    public static String HOVERED_BUTTON_STYLE = "-fx-background-color: orange; -fx-font-size: 150%; -fx-font-weight: 900";
}
