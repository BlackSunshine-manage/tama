package source.characters.chars;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import source.utils.SpriteAnimation;

import java.io.Serializable;


public class Hellion extends CharacterPlayer implements Serializable {
    public Hellion(@Autowired @Qualifier("hellion") ImageView imageView) {
        super(imageView);
        super.petTypeName = "Hellion";
        super.petType.setValue("Hellion");
        super.description.setValue("Опасный хищник");
        super.descriptionValue = "Опасный хищник";// TODO : Дополнить
        super.count = 5;
        super.columns = 6;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 100;
        super.height = 100;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }


    public Hellion(@Autowired @Qualifier("hellion") ImageView imageView, int width, int height) {

        super(imageView);
        super.petTypeName = "Hellion";
        super.petType.setValue("Hellion");
        super.description.setValue("Опасный хищник. Большие лапки.");
        super.descriptionValue = "Опасный хищник. Большие лапки.";// TODO : Дополнить
        super.count = 5;
        super.columns = 6;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 100;
        super.height = 100;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }
}
