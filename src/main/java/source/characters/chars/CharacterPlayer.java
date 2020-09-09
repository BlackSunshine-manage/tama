package source.characters.chars;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.Main;
import source.utils.SpriteAnimation;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Component
public abstract class CharacterPlayer extends Pane implements Serializable {
    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getDescriptionValue() {
        return descriptionValue;
    }

    public void setDescriptionValue(String descriptionValue) {
        this.descriptionValue = descriptionValue;
    }

    //@Autowired
    transient ImageView imageView;

    transient SimpleStringProperty description;

    transient SimpleStringProperty petType;

    transient SimpleDoubleProperty movementSpeedProperty;

    transient SimpleIntegerProperty hungryMultipleOffline;

    transient SimpleIntegerProperty hungryMultipleOnline;

    transient SimpleIntegerProperty moodMultipleOffline;

    transient SimpleIntegerProperty moodMultipleOnline;

    transient SimpleIntegerProperty moodProperty;

    transient SimpleIntegerProperty hungryProperty;

    transient SimpleIntegerProperty moodPropertyMax;

    transient SimpleIntegerProperty hungryPropertyMax;

    transient SimpleIntegerProperty growthStageProperty;

    transient SimpleIntegerProperty foodEatenProperty;

    int growthStage = 1;

    int foodEaten = 0;

    double movementSpeed = 5;
    transient public SpriteAnimation animation;

    int hunger = 1;

    int mood = 10;

    int hungerMax = 30;

    int moodMax = 30;

    String petTypeName = "character";

    int count = 3;
    int columns = 3;
    int offsetX = 0;
    int offsetY = 0;
    int width = 32;
    int height = 32;

    int hungryMultipleOfflineIntValue = 360; // TODO FOR CHANGE (1) для реальной работы 1ед. еды должны истикатSь в 3600 секунды(число в секундах)

    int hungryMultipleOnlineIntValue;

    int moodMultipleOfflineIntValue = 360;// TODO FOR CHANGE (2) для реальной работы 1ед. настроения должны истикать в 3600 секунды(число в секундах)

    int moodMultipleOnlineIntValue;

    String descriptionValue;

    Player player;

    int growthStageMax = 3; // TODO FOR ADDONS GROWTH STAGE(Если делать больше стадий роста). изменить на число стадий

    public CharacterPlayer(ImageView imageView) {
        this.player = player;


        this.description = new SimpleStringProperty(descriptionValue);

        this.moodProperty = new SimpleIntegerProperty(mood);

        this.hungryProperty = new SimpleIntegerProperty(hunger);

        this.foodEatenProperty = new SimpleIntegerProperty(foodEaten);

        this.growthStageProperty = new SimpleIntegerProperty(growthStage);

        this.hungryMultipleOffline = new SimpleIntegerProperty(hungryMultipleOfflineIntValue);

        this.hungryMultipleOnline = new SimpleIntegerProperty(hungryMultipleOnlineIntValue);

        this.moodMultipleOffline = new SimpleIntegerProperty(moodMultipleOfflineIntValue);

        this.moodMultipleOnline = new SimpleIntegerProperty(moodMultipleOnlineIntValue);
        this.petType = new SimpleStringProperty(petTypeName);

        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        animation = new SpriteAnimation(this.imageView, Duration.millis(200), count, columns, offsetX, offsetY, width, height);
        getChildren().addAll(imageView);
        this.movementSpeedProperty = new SimpleDoubleProperty(movementSpeed);
    }


    public CharacterPlayer(ImageView imageView, int wighte, int height) {


        this.description = new SimpleStringProperty(descriptionValue);

        this.hungryPropertyMax = new SimpleIntegerProperty(hungerMax);

        this.moodPropertyMax = new SimpleIntegerProperty(moodMax);

        this.moodProperty = new SimpleIntegerProperty(mood);

        this.hungryProperty = new SimpleIntegerProperty(hunger);

        this.foodEatenProperty = new SimpleIntegerProperty(foodEaten);

        this.growthStageProperty = new SimpleIntegerProperty(growthStage);

        this.hungryMultipleOffline = new SimpleIntegerProperty(hungryMultipleOfflineIntValue);

        this.hungryMultipleOnline = new SimpleIntegerProperty(hungryMultipleOnlineIntValue);

        this.moodMultipleOffline = new SimpleIntegerProperty(moodMultipleOfflineIntValue);

        this.moodMultipleOnline = new SimpleIntegerProperty(moodMultipleOnlineIntValue);
        this.petType = new SimpleStringProperty(petTypeName);

        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, wighte, height));
        animation = new SpriteAnimation(this.imageView, Duration.millis(200), count, columns, offsetX, offsetY, wighte, height);
        getChildren().addAll(imageView);
        this.movementSpeedProperty = new SimpleDoubleProperty(movementSpeed);
    }

    public double getMovementSpeedProperty() {
        return movementSpeedProperty.get();
    }

    public SimpleDoubleProperty movementSpeedPropertyProperty() {
        return movementSpeedProperty;
    }

    public void setMovementSpeedProperty(double movementSpeedProperty) {
        this.movementSpeedProperty.set(movementSpeedProperty);
    }


    public int getMoodPropertyMax() {
        return moodPropertyMax.get();
    }

    public SimpleIntegerProperty moodPropertyMaxProperty() {
        return moodPropertyMax;
    }

    public void setMoodPropertyMax(int moodPropertyMax) {
        this.moodPropertyMax.set(moodPropertyMax);
    }

    public int getHungryPropertyMax() {
        return hungryPropertyMax.get();
    }

    public SimpleIntegerProperty hungryPropertyMaxProperty() {
        return hungryPropertyMax;
    }

    public void setHungryPropertyMax(int hungryPropertyMax) {
        this.hungryPropertyMax.set(hungryPropertyMax);
    }

    public int getHungerMax() {
        return hungerMax;
    }

    public void setHungerMax(int hungerMax) {
        this.hungerMax = hungerMax;
    }

    public int getMoodMax() {
        return moodMax;
    }

    public void setMoodMax(int moodMax) {
        this.moodMax = moodMax;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getPetType() {
        return petType.get();
    }


    public SimpleStringProperty petTypeProperty() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType.set(petType);
    }

    public int getHungryMultipleOffline() {
        return hungryMultipleOffline.get();
    }

    public SimpleIntegerProperty hungryMultipleOfflineProperty() {
        return hungryMultipleOffline;
    }

    public void setHungryMultipleOffline(int hungryMultipleOffline) {
        this.hungryMultipleOffline.set(hungryMultipleOffline);
    }

    public int getHungryMultipleOnline() {
        return hungryMultipleOnline.get();
    }

    public SimpleIntegerProperty hungryMultipleOnlineProperty() {
        return hungryMultipleOnline;
    }

    public void setHungryMultipleOnline(int hungryMultipleOnline) {
        this.hungryMultipleOnline.set(hungryMultipleOnline);
    }

    public int getMoodMultipleOffline() {
        return moodMultipleOffline.get();
    }

    public SimpleIntegerProperty moodMultipleOfflineProperty() {
        return moodMultipleOffline;
    }

    public void setMoodMultipleOffline(int moodMultipleOffline) {
        this.moodMultipleOffline.set(moodMultipleOffline);
    }

    public int getMoodMultipleOnline() {
        return moodMultipleOnline.get();
    }

    public SimpleIntegerProperty moodMultipleOnlineProperty() {
        return moodMultipleOnline;
    }

    public void setMoodMultipleOnline(int moodMultipleOnline) {
        this.moodMultipleOnline.set(moodMultipleOnline);
    }

    public SpriteAnimation getAnimation() {
        return animation;
    }

    public void setAnimation(SpriteAnimation animation) {
        this.animation = animation;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public String getPetTypeName() {
        return petTypeName;
    }

    public void setPetTypeName(String petTypeName) {
        this.petTypeName = petTypeName;
    }

    public int getHungryMultipleOfflineIntValue() {
        return hungryMultipleOfflineIntValue;
    }

    public void setHungryMultipleOfflineIntValue(int hungryMultipleOfflineIntValue) {
        this.hungryMultipleOfflineIntValue = hungryMultipleOfflineIntValue;
    }

    public int getHungryMultipleOnlineIntValue() {
        return hungryMultipleOnlineIntValue;
    }

    public void setHungryMultipleOnlineIntValue(int hungryMultipleOnlineIntValue) {
        this.hungryMultipleOnlineIntValue = hungryMultipleOnlineIntValue;
    }

    public int getGrowthStageMax() {
        return growthStageMax;
    }

    public void setGrowthStageMax(int growthStageMax) {
        this.growthStageMax = growthStageMax;
    }

    public int getMoodMultipleOfflineIntValue() {
        return moodMultipleOfflineIntValue;
    }

    public void setMoodMultipleOfflineIntValue(int moodMultipleOfflineIntValue) {
        this.moodMultipleOfflineIntValue = moodMultipleOfflineIntValue;
    }

    public int getMoodMultipleOnlineIntValue() {
        return moodMultipleOnlineIntValue;
    }

    public void setMoodMultipleOnlineIntValue(int moodMultipleOnlineIntValue) {
        this.moodMultipleOnlineIntValue = moodMultipleOnlineIntValue;
    }

    public int getMoodProperty() {
        return moodProperty.get();
    }

    public SimpleIntegerProperty moodPropertyProperty() {
        return moodProperty;
    }

    public void setMoodProperty(int moodProperty) {
        this.moodProperty.set(moodProperty);
    }

    public int getHungryProperty() {
        return hungryProperty.get();
    }

    public SimpleIntegerProperty hungryPropertyProperty() {
        return hungryProperty;
    }

    public void setHungryProperty(int hungryProperty) {
        this.hungryProperty.set(hungryProperty);
    }

    public int getGrowthStageProperty() {
        return growthStageProperty.get();
    }

    public SimpleIntegerProperty growthStagePropertyProperty() {
        return growthStageProperty;
    }

    public void setGrowthStageProperty(int growthStageProperty) {
        this.growthStageProperty.set(growthStageProperty);
    }

    public int getFoodEatenProperty() {
        return foodEatenProperty.get();
    }

    public SimpleIntegerProperty foodEatenPropertyProperty() {
        return foodEatenProperty;
    }

    public void setFoodEatenProperty(int foodEatenProperty) {
        this.foodEatenProperty.set(foodEatenProperty);
    }

    public int getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(int growthStage) {
        this.growthStage = growthStage;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public void setImageView(@Autowired ImageView imageView) {
        this.imageView = imageView;
    }


    public void writeObject(ObjectOutputStream out) throws Exception {
        out.writeObject(petType.getValue());
        out.writeObject(movementSpeedProperty.getValue());
        out.writeObject(hungryProperty.getValue());
        out.writeObject(moodProperty.getValue());
        out.writeObject(growthStageProperty.getValue());
        out.writeObject(foodEatenProperty.getValue());
    }

    public Object readObject(ObjectInputStream in) throws Exception {
        petType = new SimpleStringProperty((String) in.readObject());
        movementSpeedProperty = new SimpleDoubleProperty((Double) in.readObject());
        hungryProperty = new SimpleIntegerProperty((int) in.readObject());
        moodProperty = new SimpleIntegerProperty((int) in.readObject());
        growthStageProperty = new SimpleIntegerProperty((int) in.readObject());
        foodEatenProperty = new SimpleIntegerProperty((int) in.readObject());
        CharacterPlayer characterPlayer;
        switch (petType.getValue()) {
            case "Hellion":
                characterPlayer = (CharacterPlayer) Main.applicationContext.getBean("getHellion");
                break;
            case "Black cat":
                characterPlayer = (CharacterPlayer) Main.applicationContext.getBean("getBlackCat");
                break;

            default:
                characterPlayer = null;
        }

        return characterPlayer;
    }
}
