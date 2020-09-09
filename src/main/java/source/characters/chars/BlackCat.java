package source.characters.chars;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import source.engine.EngineGameInputKeypad;
import source.utils.SpriteAnimation;

public class BlackCat extends CharacterPlayer implements EngineGameInputKeypad {
    int count = 3;
    int columns = 3;
    int offsetX = 0;
    int offsetY = 0;
    int width = 32;
    int height = 32;

    public BlackCat(@Autowired @Qualifier("blackcat") ImageView imageView, int width, int height) {

        super(imageView);
        super.petTypeName = "Black cat";
        super.petType.setValue("Black cat");
        super.description.setValue("Опасный хищник. Не такой как хеллион, но всёже. Имеются маленькие лапки, из-за чего не столь опасен");
        super.descriptionValue = "Опасный хищник. Не такой как хеллион, но всёже. Имеются маленькие лапки, из-за чего не столь опасен";// TODO : Дополнить
        super.count = 3;
        super.columns = 3;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 32;
        super.height = 32;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }

    public BlackCat(@Autowired @Qualifier("blackcat") ImageView imageView) {

        super(imageView);
        super.petTypeName = "Black cat";
        super.petType.setValue("Black cat");
        super.description.setValue("Опасный хищник");
        super.descriptionValue = "Опасный хищник";// TODO : Дополнить

        super.count = 3;
        super.columns = 3;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 32;
        super.height = 32;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }
}
