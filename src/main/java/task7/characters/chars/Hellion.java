package task7.characters.chars;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import task7.enums.PetsDescriptions;
import task7.enums.TypePetName;
import task7.food.Food;
import task7.static_vars.StaticImageViews;
import task7.utils.SpriteAnimation;

import static task7.utils.MovingUtils.moveX;
import static task7.utils.MovingUtils.moveY;


public class Hellion extends CharacterPlayer {
    public Hellion(ImageView imageView) {
        super(imageView);
        super.setPetTypeName(TypePetName.HELLION_TYPE_NAME.getName());
        super.petType.setValue(TypePetName.HELLION_TYPE_NAME.getName());
        super.description.setValue(PetsDescriptions.HELLION_PET_DESCRIPTION.getDescription());
        super.setDescriptionValue(PetsDescriptions.HELLION_PET_DESCRIPTION.getDescription());
        super.count = 5;
        super.columns = 6;
        super.offsetX = 0;
        super.offsetY = 0;
        super.width = 100;
        super.height = 100;
        super.getImageView().setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        this.animation = new SpriteAnimation(super.getImageView(), Duration.millis(500), count, columns, offsetX, offsetY, width, height);
    }


    public Hellion(ImageView imageView, int width, int height) {

        super(imageView);
        super.setPetTypeName(TypePetName.HELLION_TYPE_NAME.getName());
        super.petType.setValue(TypePetName.HELLION_TYPE_NAME.getName());
        super.description.setValue(PetsDescriptions.HELLION_PET_DESCRIPTION.getDescription());
        super.setDescriptionValue(PetsDescriptions.HELLION_PET_DESCRIPTION.getDescription());
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
        return new Food(new ImageView(new ImageView(StaticImageViews.meatImageView.getImage()).getImage()));
    }

    @Override
    public void setOffsetYByKeyCode(KeyCode keyCode) {
        switch (keyCode) {
            case A:
                getAnimation().setOffsetY(0);
                moveX(-1, this);
                break;
            case S:
                getAnimation().setOffsetY(0);
                moveY(1, this);
                break;
            case D:
                getAnimation().setOffsetY(100 * this.getStageGrowth());
                moveX(1, this);
                break;
            case W:
                getAnimation().setOffsetY(200 * this.getStageGrowth());
                moveY(-1, this);
                break;
            default:
                getAnimation().setOffsetY(300 * this.getStageGrowth());
                break;
        }
    }
}
