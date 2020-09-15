package task7.ui.controllers;

import javafx.scene.image.Image;
import task7.characters.chars.CharacterFactory;
import task7.characters.chars.CharacterType;
import task7.enums.StatsValue;
import task7.enums.StatusType;
import task7.utils.ApplicationUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import task7.Main;
import task7.static_vars.StaticImageViews;
import task7.utils.counter_animation.Counter;
import task7.utils.counter_animation.factory.CounterFactory;

import static task7.ui.controllers.GameMap.player;
import static task7.ui.controllers.GameMap.rootInGameMap;

public class GUI {
    public AnchorPane pane;
    public ImageView imageView;
    public Button hungerUp;
    public Button moodUp;
    public ProgressBar progressHunger;
    public ProgressBar progressMood;
    public ProgressBar growthProgress;

    public void initialize() {
        imageView = StaticImageViews.imageUI;
        growthProgress.setProgress((double) player.getPlayer().growthStagePropertyProperty().getValue() / player.getPlayer().getGrowthStageMax());
        progressMood.setProgress((double) player.getPlayer().moodPropertyProperty().getValue() / player.getPlayer().getMoodMax());
        progressHunger.setProgress((double) player.getPlayer().hungryPropertyProperty().getValue() / player.getPlayer().getHungerMax());
        ApplicationUtils.setButtonEvents(hungerUp, moodUp);
    }

    public void onActionHungerUp(ActionEvent actionEvent) {
        for (int i = 0; i < 1; i++) {
            ApplicationUtils.bonus(Main.foods, rootInGameMap, GameMap.player, 40, 410, 40, 560);
        }
    }

    public void onActionMoodUp(ActionEvent actionEvent) {
        CounterFactory.createCounter(StatusType.getStatusTypeFromStatusNameAndStatusValue(StatsValue.MOOD.getValueName(), 1));
        GameMap.player.getPlayer().moodPropertyProperty().setValue(GameMap.player.getPlayer().moodPropertyProperty().get() + 1);
    }
}
