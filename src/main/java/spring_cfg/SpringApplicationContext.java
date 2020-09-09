package spring_cfg;

import application_interface.ApplicationInterface;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import source.Main;
import source.characters.chars.*;
import source.path.PathToFiles;
import source.static_vars.StaticImageViews;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan

public class SpringApplicationContext implements PathToFiles, ApplicationInterface {
    private final StaticImageViews images = new StaticImageViews();

    @Bean
    @Scope
    @Qualifier("blackcat")
    public ImageView getBlackCatImageView() {
        Image image = null;
        try {
            image = new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER + BLACK_CAT_SPRITE_MAP_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ImageView(image);
    }

    @Bean
    @Scope("singleton")
    @Qualifier("hellion")
    public ImageView getHellionImageView() {
        Image image = null;
        try {
            image = new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                    HELLION_SPRITE_MAP_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ImageView(image);
    }

    @Bean
    @Scope()
    public Hellion getHellion() {
        return new Hellion(getHellionImageView());
    }

    @Bean
    @Scope()
    public BlackCat getPlayerBlackCat() {
        return new BlackCat(getBlackCatImageView());
    }

    @Bean
    @Scope("singleton")
    @Qualifier("nightmare")
    public ImageView getNightmareImageView() {
        Image image = null;
        try {
            image = new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                    NIGHTMARE_SPRITE_MAP_NAME_1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ImageView(image);
    }

    @Bean
    @Scope("singleton")
    @Qualifier("nightmare")
    public ImageView getPoringImageView() {
        Image image = null;
        try {
            image = new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                    PORING_SPRITE_MAP_NAME_1));
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ImageView(image);
    }

    @Bean
    @Scope("prototype")
    public Player getPlayerInputFile() throws IOException, ClassNotFoundException {
        Player player = new Player();
        player = player.readObject(new ObjectInputStream(new FileInputStream(DATA_SAVE_AND_LOAD_FILE_NAME)));
        return player;
    }

    // TODO FOD ADDONS(3). Дополнить блок ArrayList (методом add) когда добавляем нового CharacterPlayer - дочернего класса
    @Bean
    public List<CharacterPlayer> allPetsInCreatePage() {
        ArrayList<CharacterPlayer> characterPlayers = new ArrayList<CharacterPlayer>();
        characterPlayers.add(0, new BlackCat(new ImageView(getBlackCatImageView().getImage()), 32, 32));//getHellion());
        characterPlayers.add(1, new Hellion(new ImageView(getHellionImageView().getImage()), 100, 100));//getPlayerBlackCat());
        characterPlayers.add(2, new Nightmare(new ImageView(getNightmareImageView().getImage()), 100, 100));
        characterPlayers.add(3, new Poring(new ImageView(getPoringImageView().getImage()), 50, 50));
        return (List<CharacterPlayer>) characterPlayers.clone();
    }
}

