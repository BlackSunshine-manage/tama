package source.classes.food.foods;

import javafx.scene.image.ImageView;
import source.classes.food.Food;

public class Ghost extends Food {
    public Ghost(ImageView imageView,int x, int y) {
        super(imageView, x, y);
    }

    public Ghost(ImageView imageView) {
        super(imageView);
    }

    public Ghost() {
    }
}
