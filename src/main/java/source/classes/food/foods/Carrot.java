package source.classes.food.foods;

import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import source.classes.food.Food;

public class Carrot extends Food {
    public Carrot(ImageView imageView) {
        super(imageView);
    }

    public Carrot() {
    }

    public Carrot(ImageView imageView, int x, int y) {
        super(imageView, x, y);
    }
}
