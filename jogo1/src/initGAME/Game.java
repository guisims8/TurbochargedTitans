package initGAME;

import carFactory.Car;
import gridFactory.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import java.util.LinkedList;
import java.util.List;

public class Game {
    PlayerCar playerCar;
    List<Car> cars = new LinkedList<>();
    private int carSpawnTimer = 200;
    private int carSpawnTimerCounter = 0;


    MenuStart menu = new MenuStart();

    public Game() {
        this.playerCar = new PlayerCar();
    }

    public void start() {
        Grid.initgrid();
        playerCar.init();
        Car car = new Car();
        cars.add(car);
        play();
        /*while(!playerCar.isEnterKeyPressed()) {
            //playerCar.init();
            menu.MenuStart();
        }
        if(playerCar.isEnterKeyPressed()){
            menu.DeleteMenu();
            Grid.initgrid();
            playerCar.init();
            Car car = new Car();
            cars.add(car);
            play();
        }*/
    }

    public void play() {

        while (true) {
            // Pause for a while
            CustomSleep.sleep(10);
            spawnNewCar();
            movePlayer();
            Car.moveCars(cars);
            for (int i = 0; i < cars.size(); i++) {
                playerCar.isColliding(cars.get(i).getPicture());
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

    public void spawnNewCar() {
        System.out.println(carSpawnTimer);
        carSpawnTimerCounter++;
        if (carSpawnTimerCounter == carSpawnTimer) {
            Car car1 = new Car();
            cars.add(car1);
            carSpawnTimerCounter = 0;
            if (carSpawnTimer > 12) {
                carSpawnTimer -= 20;
            }
            if (carSpawnTimer < 10) {
                carSpawnTimer = 11;
            }
        }
    }
}
