package initGAME;

import carFactory.*;
import gridFactory.Grid;
import music.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

import static gridFactory.Grid.gameOver;

public class Game {
    PlayerCar playerCar;

    CarFactory carFactory = new CarFactory();
    private List<Car> cars = new LinkedList<>();
    private int carSpawnTimer = 100;
    private int carSpawnTimerCounter = 0;
    private int imageAlternateCounter = 0;
    private int imageAlternateTimer = 20;
    private int carSpeed = 0;
    public static int score = 0;
    public static int level = 1;


    Music initialMusic = new Music("Musics/testesom.wav");


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
        Music duringGame = new Music("Musics/duringGameFinal.wav");
        duringGame.play();

        Music policeSong = new Music("Musics/police.wav");
        policeSong.play();

        boolean gameOver = false;
        while (!gameOver) {
            CustomSleep.sleep(15);
            carSpawnTimerCounter++;
            if (carSpawnTimerCounter == carSpawnTimer) {
                spawnNewCar();
            }
            carSpeed++;
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).moveCar(cars, cars.get(i));
                if (carSpeed == 400) {
                    if (PlayerCar.getPlayerSpeed() < 8) {
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
            imageAlternateCounter++;
            if (imageAlternateCounter >= imageAlternateTimer) {
                Grid.alternateImages();
                imageAlternateCounter = 0;
            }
            for (int i = 0; i < cars.size(); i++) {
                if (playerCar.isColliding(cars.get(i).getPicture())) {
                    Car.textScore.delete();
                    duringGame.stop();
                    policeSong.stop();
                    gameOver = true;
                    gameOver();
                }
            }
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

    // carSpawnTimerCounter é incrementado uma vez a cada 10 ms quando é
    // igual ao carSpawnTimer chama-se este método que da spawn
    // a um carro, dá reset ao counter e diminui o próximo carSpawnTimer.
    // Assim os carros começam a aparecer cada vez mais rápido
    public void spawnNewCar() {
        cars.add(carFactory.getNewCar());
        carSpawnTimerCounter = 0;
        if (carSpawnTimer > 20) {
            carSpawnTimer -= 4;
        }
        if (Scooter.getScooterSpeed() <13) {
            if (carSpawnTimer < 25) {
                carSpawnTimer = 25;
            }
        }else{
            carSpawnTimer=15;
        }
    }
}
