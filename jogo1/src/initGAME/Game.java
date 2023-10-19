package initGAME;

import carFactory.Car;
import carFactory.CarFactory;
import carFactory.PlayerCar;
import gridFactory.Grid;

import java.util.LinkedList;
import java.util.List;

public class Game {
    PlayerCar playerCar;
    private List<Car> cars = new LinkedList<>();
    private int carSpawnTimer = 200;
    private int carSpawnTimerCounter = 0;
    private int imageAlternateTimer = 0;
    private int carSpeed=0;


    public Game() {
        this.playerCar = new PlayerCar();
    }

    public void start() {
        Grid.initgrid();
        MenuStart.MenuStart();
        playerCar.init();
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
            /*carSpeed++;
            if(carSpeed==200){
                Car.setSpeed(Car.getSpeed()+5);
            }*/
            movePlayer();
            Car.moveCars(cars);
            imageAlternateTimer++;
            if (imageAlternateTimer == 15) {
                Grid.alternateImages();
                imageAlternateTimer=0;
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
        cars.add(CarFactory.getNewCar());
        carSpawnTimerCounter = 0;
        if (carSpawnTimer > 40) {
            carSpawnTimer -= 20;
        }
        if (carSpawnTimer < 40) {
            carSpawnTimer = 35;
        }
    }
}
