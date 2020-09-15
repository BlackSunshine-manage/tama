package task7.utils.counter_animation.hunger_counter;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import task7.characters.chars.CharacterPlayer;
import task7.utils.counter_animation.Counter;

public class HungerCounter extends Counter {
    public HungerCounter(ImageView imageView, CharacterPlayer characterPlayer, Pane removeFromThisPane) {
        super(imageView, characterPlayer, removeFromThisPane);
    }
}
