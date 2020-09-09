package source.ui.controllers;

import application_interface.ApplicationInterface;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import source.Main;
import source.static_vars.StaticImageViews;

import static source.ui.controllers.GameMap.player;
import static source.ui.controllers.GameMap.rootInGameMap;

public class GUI implements ApplicationInterface {
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
        settingHoveringAndExitedButtons(hungerUp, moodUp);
    }

    public void onActionHungerUp(ActionEvent actionEvent) {
        for (int i = 0; i < 50; i++) {
            ApplicationInterface.bonus(Main.foods, rootInGameMap, GameMap.player, 40, 410, 40, 560);
        }
    }

    public void onActionMoodUp(ActionEvent actionEvent) {
        GameMap.player.getPlayer().moodPropertyProperty().setValue(GameMap.player.getPlayer().moodPropertyProperty().get() + 1);
    }
}
