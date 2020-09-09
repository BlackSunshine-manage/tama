package source.classes.blocks;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.springframework.stereotype.Component;

@Component
public class UnbreakableBlock extends Block {

    public UnbreakableBlock(ImageView imageView) {

        super.getChildren().add(imageView);
        this.setBackground(
                new Background(new BackgroundImage(
                        imageView.getImage(),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
    }

    public UnbreakableBlock(ImageView imageView, double fixHeight, double fixWight, double layoutX, double layoutY) {
        imageView.setFitWidth(fixWight);
        imageView.setFitHeight(fixHeight);
        super.getChildren().add(imageView);
        this.setBackground(
                new Background(new BackgroundImage(
                        imageView.getImage(),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT)));
        this.setLayoutY(layoutY);
        this.setLayoutX(layoutX);
    }

    public UnbreakableBlock() {
    }

    private UnbreakableBlock getUnbreakableBlock() {
        return this;
    }
}
