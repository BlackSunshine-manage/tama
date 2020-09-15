package task7.characters.chars;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.springframework.stereotype.Component;
import task7.enums.MaxHungerInAnotherStages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;


@Component
public class Player implements Serializable {

    /**
     * Дата последнего визита в игру
     */
    private Date lastVisit; // Дата последнего визита

    /**
     * Дата входа в игру
     */
    private Date secondVisit; // Дата входа

    /**
     * То, сколько проведено времени в игре
     */
    private Date timeInGame;// Время в игре

    private int hungryIntValue = 10;

    private int moodIntValue = 10;

    private int howLongSecondAfk = 0;

    private boolean isDied = false;

    /**
     * Свойство - умер ли петомец
     */
    SimpleBooleanProperty petIsDied; // pet is died?

    /**
     * Время до спавна
     */
    private int timeForRespawn; // time to respawn pet

    /**
     * Свойство - Время до спавна
     */
    private SimpleIntegerProperty timeToSpawn;

    /**
     * Свойство - Времени в оффлайне
     */
    private SimpleIntegerProperty afkTime; // Сколько игрок отсутствовал

    /**
     * Свойство - голода персонажа
     */
    private SimpleIntegerProperty hungry; // Голод

    /**
     * Свойство - настроения персонажа
     */
    private SimpleIntegerProperty mood; // В каком настроении был питомец

    /**
     * Персонаж игрока {@link CharacterPlayer}
     */
    private CharacterPlayer player;

    private long timeInGameMills = 0;

    public Player(CharacterPlayer player) {
        this.lastVisit = new Date();
        this.secondVisit = new Date();
        this.petIsDied = new SimpleBooleanProperty(isDied);
        this.timeToSpawn = new SimpleIntegerProperty(timeForRespawn);
        this.afkTime = new SimpleIntegerProperty(howLongSecondAfk);
        this.player = player;
        this.timeInGameMills = timeInGameMills;

        if (timeInGame != null) {
        } else {
            timeInGame = new Date();
        }
    }

    public Player() {
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Date getSecondVisit() {
        return secondVisit;
    }

    public void setSecondVisit(Date secondVisit) {
        this.secondVisit = secondVisit;
    }

    public Date getTimeInGame() {
        return timeInGame;
    }

    public void setTimeInGame(Date timeInGame) {
        this.timeInGame = timeInGame;
    }

    public int getHungryIntValue() {
        return hungryIntValue;
    }

    public void setHungryIntValue(int hungryIntValue) {
        this.hungryIntValue = hungryIntValue;
    }

    public int getMoodIntValue() {
        return moodIntValue;
    }

    public void setMoodIntValue(int moodIntValue) {
        this.moodIntValue = moodIntValue;
    }

    public int getHowLongSecondAfk() {
        return howLongSecondAfk;
    }

    public void setHowLongSecondAfk(int howLongSecondAfk) {
        this.howLongSecondAfk = howLongSecondAfk;
    }

    public boolean isDied() {
        return isDied;
    }

    public void setDied(boolean died) {
        isDied = died;
    }

    public boolean isPetIsDied() {
        return petIsDied.get();
    }

    public SimpleBooleanProperty petIsDiedProperty() {
        return petIsDied;
    }

    public void setPetIsDied(boolean petIsDied) {
        this.petIsDied.set(petIsDied);
    }

    public int getTimeForRespawn() {
        return timeForRespawn;
    }

    public void setTimeForRespawn(int timeForRespawn) {
        this.timeForRespawn = timeForRespawn;
    }

    public int getTimeToSpawn() {
        return timeToSpawn.get();
    }

    public SimpleIntegerProperty timeToSpawnProperty() {
        return timeToSpawn;
    }

    public void setTimeToSpawn(int timeToSpawn) {
        this.timeToSpawn.set(timeToSpawn);
    }

    public long getTimeInGameMills() {
        return timeInGameMills;
    }

    public void setTimeInGameMills(long timeInGameMills) {
        this.timeInGameMills = timeInGameMills;
    }

    public int getAfkTime() {
        return afkTime.get();
    }

    public SimpleIntegerProperty afkTimeProperty() {
        return afkTime;
    }

    public void setAfkTime(int afkTime) {
        this.afkTime.set(afkTime);
    }

    public int getHungry() {
        return hungry.get();
    }

    public SimpleIntegerProperty hungryProperty() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry.set(hungry);
    }

    public int getMood() {
        return mood.get();
    }

    public SimpleIntegerProperty moodProperty() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood.set(mood);
    }

    public CharacterPlayer getPlayer() {
        return player;
    }

    public void setPlayer(CharacterPlayer player) {
        this.player = player;
    }

    /**
     * Записывает объект класса {@link task7.characters.chars.Player#Player(CharacterPlayer)} в файл по пути {@link task7.enums.path.PathAndNameFiles#DATA_SAVE_AND_LOAD_FILE_NAME}
     *
     * @param objectOutputStream - в параметр передавать поток записи файлов. В частности по пути {@link task7.enums.path.PathAndNameFiles#DATA_SAVE_AND_LOAD_FILE_NAME}
     * @throws IOException В случаях когда произошла общая ошибка чтения объекта.
     */
    public void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(player);
        objectOutputStream.writeObject(player.hungryProperty.getValue());
        objectOutputStream.writeObject(player.moodProperty.getValue());
        objectOutputStream.writeObject(new Date());// last visit
        objectOutputStream.writeObject(timeInGame.getTime() + (lastVisit.getTime() - new Date().getTime()));
        objectOutputStream.writeObject(petIsDiedProperty().getValue());
        objectOutputStream.writeObject(player.getStageGrowth());
        System.out.println(player.getStageGrowth() + " WRITE ON GROWTH PROPERTY");
        objectOutputStream.writeObject(this.timeToSpawn.getValue());
    }

    /**
     * @param objectInputStream - в параметр передавать поток чтения файлов. В частности по пути {@link task7.enums.path.PathAndNameFiles#DATA_SAVE_AND_LOAD_FILE_NAME}
     * @return Возвращает проинициализированный объект класса {@link task7.characters.chars.Player#Player(CharacterPlayer)}, который был сохранён методом
     * {@link task7.characters.chars.Player#writeObject(ObjectOutputStream)} автосохранением в {@link task7.ui.controllers.GameMap#timeline}.
     * @throws IOException            В случаях когда произошла общая ошибка чтения объекта.
     * @throws ClassNotFoundException В случаях когда файл по пути {@link task7.enums.path.PathAndNameFiles#DATA_SAVE_AND_LOAD_FILE_NAME} не найден.
     */
    public Player readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        final int OFFLINE_TIME_IN_DEAD = 144;// In seconds
        int multiple;
        CharacterPlayer characterPlayer = null;
        player = (CharacterPlayer) objectInputStream.readObject();
        int hungry = (int) objectInputStream.readObject();
        int mood = (int) objectInputStream.readObject();
        lastVisit = (Date) objectInputStream.readObject();
        secondVisit = new Date();
        timeInGame = new Date((long) objectInputStream.readObject());
        boolean isDead = (boolean) objectInputStream.readObject();
        int growthStage = (int) objectInputStream.readObject();
        petIsDied = new SimpleBooleanProperty(isDead);
        int timeToSpawning = (int) objectInputStream.readObject();
        int maxHunger = 0;
        howLongSecondAfk = (int) (((int) (secondVisit.getTime() - lastVisit.getTime())) / 1000); //
        CharacterType characterType = CharacterType.getCharacterTypeFromString(player.getPetTypeName(), growthStage);
        characterPlayer = CharacterFactory.createCharacter(characterType);

        if (0 > mood) { // Если mood (настроение) отрицательное то множитель голода ускоряется в 3 раза
            multiple = (int) (howLongSecondAfk / (characterPlayer.hungryMultipleOffline.get() / 3));
        } else {
            multiple = (int) (howLongSecondAfk / characterPlayer.hungryMultipleOffline.get());
        }
        switch (growthStage) {
            case 1:
                maxHunger = MaxHungerInAnotherStages.STAGE_1_HUNGER_MAX.getHungerMax();
                break;
            case 2:
                maxHunger = MaxHungerInAnotherStages.STAGE_2_HUNGER_MAX.getHungerMax();
                break;
            case 3:
                maxHunger = MaxHungerInAnotherStages.STAGE_3_HUNGER_MAX.getHungerMax();
                break;
        }

        hungry -= multiple;
        mood -= multiple;
        characterPlayer.setStageGrowth(growthStage);
        characterPlayer.growthStageProperty = new SimpleIntegerProperty(growthStage);
        characterPlayer.hungryPropertyMax = new SimpleIntegerProperty(maxHunger);
        characterPlayer.setHungerMax(maxHunger);
        characterPlayer.hungryProperty = new SimpleIntegerProperty(hungry);
        characterPlayer.moodProperty = new SimpleIntegerProperty(mood);
        characterPlayer.setHunger(hungry);
        characterPlayer.setMood(mood);

        Player player = new Player(characterPlayer);
        player.timeToSpawn = new SimpleIntegerProperty(timeToSpawning);
        if ((hungry < 0) && howLongSecondAfk > OFFLINE_TIME_IN_DEAD) {
            System.out.println("Is dead");
            player.petIsDied = new SimpleBooleanProperty(true);
            player.isDied = true;
        } else {
            player.petIsDied = new SimpleBooleanProperty(isDead);
        }
        return player;
    }
}