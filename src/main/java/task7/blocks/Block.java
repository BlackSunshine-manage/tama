package task7.blocks;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.springframework.stereotype.Component;
import task7.characters.chars.CharacterPlayer;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class Block extends Pane {
    ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Block(ImageView imageView) {
        this.imageView = imageView;
        this.setBackground(
                new Background(new BackgroundImage(
                        imageView.getImage(),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
    }

    public static boolean isBlock(CharacterPlayer player, Pane root) {
        AtomicBoolean collision = new AtomicBoolean(false);
        root.getChildren().stream().forEach(node -> {
            boolean intersects = player.getBoundsInParent().intersects(node.getBoundsInParent());
            if (intersects) {
                if (node instanceof UnbreakableBlock) {
                    collision.set(true);
                }
            }
        });
        return collision.get();
    }
}
