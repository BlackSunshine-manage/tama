package task7.food;

import javafx.animation.RotateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;

public class Food extends Pane {
        private ImageView imageView;

        private RotateTransition rotateTransition ;

    public Food(ImageView imageView){

        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(0,0,imageView.getImage().getWidth(),imageView.getImage().getHeight()));
        this.rotateTransition = new RotateTransition(Duration.seconds(4),this);
        this.rotateTransition.setFromAngle(0);
        this.rotateTransition.setToAngle(360);
        this.rotateTransition.setCycleCount(50);
        this.rotateTransition.play();
        this.getChildren().addAll(imageView);
    }

    public Food(){}
    }