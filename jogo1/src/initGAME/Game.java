package initGAME;

import carFactory.*;
import gridFactory.Grid;
import music.Music;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

import static gridFactory.Grid.gameOver;

public class Game {
    PlayerCar playerCar;
    CarFactory carFactory = new CarFactory();
    private List<Car> cars = new LinkedList<>();
    private List<Elements> elements = new LinkedList<>();
    private int carSpawnTimer = 100;
    private int carSpawnTimerCounter = 0;
    private int imageAlternateCounter = 0;
    private int imageAlternateTimer = 20;
    private int carSpeed = 0;
    public static int score = 0;
    public static int level = 1;
    private boolean gameOver = false;
    private int coinSpawnTimerCounter = 0;
    private Picture contador;
    private Picture wantedText;
    private Picture star;
    public static Text textScore;
    private int starX = 1075;
    private int starY = 80;

    Music initialMusic = new Music("Musics/testesom.wav");
    Music duringGame = new Music("Musics/duringGameFinal.wav");
    Music policeSong = new Music("Musics/police.wav");

    public Game() {
        this.playerCar = new PlayerCar();
    }

    public void start() {
        initialMusic.play();
        Grid.initgrid();
        spawnNewCar();
        MenuStart.MenuStart();
        playerCar.init();
        while (!playerCar.isEnterKeyPressed()) {
            CustomSleep.sleep(10);
        }
        initialMusic.stop();
        play();
    }

    public void play() {
        initializeScoreAndLevel();
        duringGame.play();
        policeSong.play();

        while (!gameOver) {
            CustomSleep.sleep(15);
            spawnNewCar();
            spawnNewCoin();
            carSpeed++;
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).moveCar(cars, cars.get(i));
                if (carSpeed == 400) {
                    Game.level++;
                    updateLevel();
                    if (PlayerCar.getPlayerSpeed() < 9) {
                        PlayerCar.increasePlayerSpeed(PlayerCar.getPlayerSpeed() + 1);
                    }
                    imageAlternateTimer--;
                    if (Scooter.getScooterSpeed() < 13) {
                        cars.get(i).setCarSpeed(cars.get(i).getCarSpeed() + 2);
                        Scooter.increaseScooterSpeed(1);
                        YellowCar.increaseYellowSpeed(1);
                        GreenCar.increaseGreenSpeed(1);
                        System.out.println(GreenCar.getGreenSpeed() + " " + Scooter.getScooterSpeed());
                    }
                    carSpeed = 0;
                }
            }
            movePlayer();
            alternateImages();
            detectCollision();
            pickCoin();
        }
    }

    public void movePlayer() {
        if (playerCar.isRightPressed()) {
            playerCar.moveRight();
        }
        if (playerCar.isLeftPressed()) {
            playerCar.moveLeft();
        }
        if (playerCar.isUpPressed()) {
            playerCar.moveUp();
        }
        if (playerCar.isDownPressed()) {
            playerCar.moveDown();
        }
    }

    public void spawnNewCar() {
        carSpawnTimerCounter++;
        if (carSpawnTimerCounter == carSpawnTimer) {
            carSpawnTimerCounter = 0;
            cars.add(carFactory.getNewCar());
            if (carSpawnTimer > 15) {
                carSpawnTimer -= 4;
            }
            if (Scooter.getScooterSpeed() < 13) {
                if (carSpawnTimer < 25) {
                    carSpawnTimer = 25;
                }
            } else {
                carSpawnTimer = 15;
            }
        }
    }

    public void spawnNewCoin() {
        coinSpawnTimerCounter++;
        if (coinSpawnTimerCounter == 200) {
            coinSpawnTimerCounter = 0;
            elements.add(Elements.getNewElement());
        }
    }

    public void initializeScoreAndLevel() {
        contador = new Picture(0, 0, "images/contador1.png");
        contador.draw();
        wantedText = new Picture(1070, 40, "images/wantedText.png");
        wantedText.draw();
        star = new Picture(starX, 80, "images/star.png");
        star.draw();
        textScore = new Text(598, 7, "YOUR SCORE: " + Game.score);
        textScore.draw();
        textScore.setColor(Color.GREEN);
        textScore.grow(25, 10);
    }

    public static void updateScore() {
        if (textScore != null) {
            textScore.delete();
        }
        textScore = new Text(598, 7, "YOUR SCORE: " + Game.score);
        textScore.draw();
        textScore.setColor(Color.GREEN);
        textScore.grow(25, 10);
        textScore.draw();
    }
    public void updateLevel() {
        if (Game.level < 6) {
            starX += 18;
            Picture newStar = new Picture(starX, starY, "images/star.png");
            newStar.draw();
        } else {
            if (starY == 80) {
                starX = 1057;
                starY += 18;
            }
            starX += 18;
            Picture newStar = new Picture(starX, starY, "images/star.png");
            newStar.draw();
        }
    }

    public void alternateImages() {
        imageAlternateCounter++;
        if (imageAlternateCounter >= imageAlternateTimer) {
            Grid.alternateImages();
            imageAlternateCounter = 0;
        }
    }

    public void detectCollision() {
        for (int i = 0; i < cars.size(); i++) {
            if (playerCar.isColliding(cars.get(i).getPicture())) {
                cars.get(i).getPicture().delete();
                cars.remove(cars.get(i));
                if (playerCar.getHp() == 0) {
                    Game.textScore.delete();
                    duringGame.stop();
                    policeSong.stop();
                    gameOver = true;
                    gameOver();
                }
            }
        }
    }

    public void pickCoin() {
        for (int i = 0; i < elements.size(); i++) {
            if (playerCar.pickCoin(elements.get(i).getCoin())) {
                elements.get(i).getCoin().delete();
                elements.remove(elements.get(i));
                updateScore();
            }
        }
    }
}
