package initGAME;

import carFactory.*;
import gridFactory.Grid;

import java.util.LinkedList;
import java.util.List;

public class Game {
    PlayerCar playerCar;
    CarFactory carFactory = new CarFactory();
    private List<Car> cars = new LinkedList<>();
    private int carSpawnTimer = 200;
    private int carSpawnTimerCounter = 0;
    private int imageAlternateCounter = 0;
    private int imageAlternateTimer = 15;
    private int carSpeed = 0;
    private int carSpeed2 = 0;
    private int carSpeed3 = 0;
    private int carSpeed4 = 0;
    public static int score = 0;


    public Game() {
        this.playerCar = new PlayerCar();
    }

    public void start() {
        Grid.initgrid();
        MenuStart.MenuStart();
        playerCar.init();
        while (!playerCar.isEnterKeyPressed()) {
            CustomSleep.sleep(10

            );
        }
        play();
    }

    public void play() {
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
                if (carSpeed == 500) {
                    //PlayerCar.increasePlayerSpeed(PlayerCar.getPlayerSpeed() + 10);
                    imageAlternateTimer = 5;
                    Scooter.increaseYellowSpeed(7);
                    YellowCar.increaseYellowSpeed(7);
                    GreenCar.increaseGreenSpeed(7);
                }
            }
            movePlayer();
            imageAlternateCounter++;
            if (imageAlternateCounter == imageAlternateTimer) {
                Grid.alternateImages();
                imageAlternateCounter = 0;
            }
            //Timer
            //TimerTask
            for (int i = 0; i < cars.size(); i++) {
                if (playerCar.isColliding(cars.get(i).getPicture())) {
                    gameOver = true;
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
            carSpawnTimer -= 40;
        }
        if (carSpawnTimer < 20) {
            carSpawnTimer = 10;
        }
    }
}
