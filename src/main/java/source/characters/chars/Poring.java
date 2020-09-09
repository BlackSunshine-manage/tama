package source.characters.chars;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import source.utils.SpriteAnimation;

import java.io.Serializable;

public class Poring extends CharacterPlayer implements Serializable {
    public Poring(@Autowired @Qualifier("hellion") ImageView imageView) {

        super(imageView);
        super.petTypeName = "Poring";
        super.petType.setValue("Poring");
        super.description.setValue("Опасный хищник");
        super.descriptionValue = "Опасный хищник";// TODO : Дополнить
        super.count = 5;
        super.columns = 8;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 50;
        super.height = 50;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(1500), count, columns, offsetX, offsetY, width, height);
    }


    public Poring(@Autowired @Qualifier("hellion") ImageView imageView, int width, int height) {

        super(imageView);
        super.petTypeName = "Poring";
        super.petType.setValue("Poring");
        super.description.setValue("Смешная желешка. Кушает морковку.");
        super.descriptionValue = "Смешная желешка. Кушает морковку.";// TODO : Дополнить
        super.count = 5;
        super.columns = 8;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 50;
        super.height = 50;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(1500), count, columns, offsetX, offsetY, width, height);
    }
}
