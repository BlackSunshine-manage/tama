package task7.characters.chars;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import task7.enums.PetsDescriptions;
import task7.enums.TypePetName;
import task7.food.Food;
import task7.static_vars.StaticImageViews;
import task7.utils.SpriteAnimation;

import static task7.utils.MovingUtils.moveX;
import static task7.utils.MovingUtils.moveY;

public class Nightmare extends CharacterPlayer {
    public Nightmare(ImageView imageView) {

        super(imageView);
        super.setPetTypeName(TypePetName.NIGHTMARE_TYPE_NAME.getName());
        super.petType.setValue( TypePetName.NIGHTMARE_TYPE_NAME.getName());
        super.description.setValue(PetsDescriptions.NIGHTMARE_PET_DESCRIPTION.getDescription());
        super.setDescriptionValue(PetsDescriptions.NIGHTMARE_PET_DESCRIPTION.getDescription());
        super.count = 5;
        super.columns = 6;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 100;
        super.height = 100;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }

    public Nightmare(ImageView imageView, int width, int height) {
        super(imageView);
        super.setPetTypeName(TypePetName.NIGHTMARE_TYPE_NAME.getName());
        super.petType.setValue( TypePetName.NIGHTMARE_TYPE_NAME.getName());
        super.description.setValue(PetsDescriptions.NIGHTMARE_PET_DESCRIPTION.getDescription());
        super.setDescriptionValue(PetsDescriptions.NIGHTMARE_PET_DESCRIPTION.getDescription());
        super.count = 5;
        super.columns = 6;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 100;
        super.height = 100;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }

    @Override
    public Food getFood() {
        return new Food(new ImageView(new ImageView(StaticImageViews.ghostMeatImageView.getImage()).getImage()));
    }

    @Override
    public void setOffsetYByKeyCode(KeyCode keyCode) {
        switch (keyCode) {
            case A:
                getAnimation().setOffsetY(100 *  this.getStageGrowth());
                moveX(-1, this);
                break;
            case S:
                getAnimation().setOffsetY(300 *  this.getStageGrowth());
                moveY(1, this);
                break;
            case D:
                getAnimation().setOffsetY(300 *  this.getStageGrowth());
                moveX(1, this);
                break;
            case W:
                getAnimation().setOffsetY(200 *  this.getStageGrowth());
                moveY(-1, this);
                break;
            default:
                getAnimation().setOffsetY(0);
                break;
        }
    }
}
