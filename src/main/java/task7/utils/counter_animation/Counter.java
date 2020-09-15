package task7.utils.counter_animation;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;
import task7.characters.chars.CharacterPlayer;

@Setter
@Getter
public abstract class Counter extends Pane {
    private TranslateTransition translateTransition;
    private FadeTransition fadeTransition;
    private ImageView imageView;
    public Counter(ImageView imageView, CharacterPlayer characterPlayer,Pane removeFromThisPane) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(0,0,imageView.getImage().getWidth(),imageView.getImage().getHeight()));
        this.translateTransition = new TranslateTransition(Duration.seconds(3),this);
        this.fadeTransition = new FadeTransition(Duration.seconds(3),this);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        translateTransition.setByX(characterPlayer.translateXProperty().getValue());
        translateTransition.setFromX(characterPlayer.translateXProperty().getValue());
        translateTransition.setFromY(characterPlayer.translateYProperty().getValue()-20);
        translateTransition.setToY(characterPlayer.translateYProperty().getValue()-120);
        translateTransition.play();
        fadeTransition.play();
        removeFromThisPane.getChildren().addAll(this);
        translateTransition.statusProperty().addListener((observer,oldValue,newValue)->{
            if(newValue.toString().equals("STOPPED")){
                removeFromThisPane.getChildren().remove(this);
            }
        });
        this.imageView = imageView;
        this.getChildren().addAll(imageView);
    }
}
