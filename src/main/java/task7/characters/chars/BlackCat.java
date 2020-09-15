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
import task7.engine.EngineGameInputKeypad;
import task7.static_vars.StaticImageViews;
import task7.utils.SpriteAnimation;

import static task7.utils.MovingUtils.moveX;
import static task7.utils.MovingUtils.moveY;

public class BlackCat extends CharacterPlayer {
    int count = 3;
    int columns = 3;
    int offsetX = 0;
    int offsetY = 0;
    int width = 32;
    int height = 32;

    public BlackCat(ImageView imageView, int width, int height) {

        super(imageView);
        super.setPetTypeName(TypePetName.BLACK_CAT_TYPE_NAME.getName());
        super.petType.setValue(TypePetName.BLACK_CAT_TYPE_NAME.getName());
        super.description.setValue(PetsDescriptions.BLACK_CAT_PET_DESCRIPTION.getDescription());
        super.setDescriptionValue(PetsDescriptions.BLACK_CAT_PET_DESCRIPTION.getDescription());

        super.count = 3;
        super.columns = 3;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 32;
        super.height = 32;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }

    public BlackCat(ImageView imageView) {

        super(imageView);
        super.setPetTypeName(TypePetName.BLACK_CAT_TYPE_NAME.getName());
        super.petType.setValue(TypePetName.BLACK_CAT_TYPE_NAME.getName());
        super.description.setValue(PetsDescriptions.BLACK_CAT_PET_DESCRIPTION.getDescription());
        super.setDescriptionValue(PetsDescriptions.BLACK_CAT_PET_DESCRIPTION.getDescription());

        super.count = 3;
        super.columns = 3;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 32;
        super.height = 32;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }

    @Override
    public Food getFood() {
        return new Food(new ImageView(new ImageView(StaticImageViews.fishImageView.getImage()).getImage()));
    }

    @Override
    public void setOffsetYByKeyCode(KeyCode keyCode) {
        switch (keyCode) {
            case A:
                getAnimation().setOffsetY(32 * this.getStageGrowth());
                moveX(-1, this);
                break;
            case S:
                getAnimation().setOffsetY(0);
                moveY(1, this);
                break;
            case D:
                getAnimation().setOffsetY(64 * this.getStageGrowth());
                moveX(1, this);
                break;
            case W:
                getAnimation().setOffsetY(96 * this.getStageGrowth());
                moveY(-1, this);
                break;
            default:
                getAnimation().setOffsetY(64 * this.getStageGrowth());
                break;
        }
    }
}
