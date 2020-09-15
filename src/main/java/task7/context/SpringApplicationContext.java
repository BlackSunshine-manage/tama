package task7.context;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import task7.Main;
import task7.characters.chars.*;

import java.util.ArrayList;
import java.util.List;

import static task7.enums.path.PathAndNameFiles.*;

@Configuration
@ComponentScan

public class SpringApplicationContext {
    @Bean
    @Scope
    @Qualifier("blackcat")
    public ImageView getBlackCatImageView() {
        Image image = null;
        try {
            image = new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                    BLACK_CAT_SPRITE_MAP_NAME.getPath()));
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
            image = new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                    HELLION_SPRITE_MAP_NAME.getPath()));
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
            image = new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +
                    NIGHTMARE_SPRITE_MAP_NAME_1.getPath()));
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
            image = new Image(Main.class.getResourceAsStream(PATH_TO_SPRITE_MAPS_IN_RESOURCES_FOLDER.getPath() +//PATH_TO_MAP_IN_RESOURCES_FOLDER +
                    PORING_SPRITE_MAP_NAME_1.getPath()));
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ImageView(image);
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

