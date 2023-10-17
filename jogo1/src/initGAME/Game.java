package initGAME;

import carFactory.Car;
import gridFactory.Grid;

public class Game {
    private final Grid grid;
    PlayerCar playerCar;
    Car car;


    public Game() {
        this.grid = new Grid();
        this.playerCar = new PlayerCar();
    }

    public void start() {
        grid.initgrid();
        playerCar.init();
        car = new Car();
        play();
    }

    public void play() {

        while (true) {
            // Pause for a while
            CustomSleep.sleep(10);
            car.moveCar();

            PlayerCar.collisionDetector(car.getPicture());
        }

    }

}
