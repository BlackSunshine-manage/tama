package source.classes.food.foods;

import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import source.classes.food.Food;

public class Meat extends Food {

    public Meat(ImageView imageView) {
        super(imageView);
    }

    public Meat() {}

    public Meat(ImageView imageView, int x, int y) {
        super(imageView,x,y);
    }
}
