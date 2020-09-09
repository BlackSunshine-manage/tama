package source.classes.blocks;

import javafx.scene.image.ImageView;
import org.springframework.stereotype.Component;

@Component
public class BreakableBlock extends Block {
    public double getMaxLife() {
        return maxLife;
    }

    public double getLife() {
        return life;
    }

    public BreakableBlock(ImageView imageView, double life, double maxLife) {
        super.getChildren().add(imageView);
        this.life = life;
        this.maxLife = maxLife;
    }

    private double maxLife = 0.0;
    private double life = 0.0;
}
