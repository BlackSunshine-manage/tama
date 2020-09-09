package source.classes.food.foods;

import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import source.classes.food.Food;

public class Fish extends Food {
    public Fish(ImageView imageView) {
        super(imageView);
    }

    public Fish() { }

    public Fish(ImageView imageView, int x, int y) {
        super(imageView,x,y);
    }
}
