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
    private int carSpawnTimer = 0;

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
            if (carSpawnTimer == 100) {
                Car car1 = new Car();
                cars.add(car1);
                carSpawnTimer = 0;
            }

            if (playerCar.isRightPressed()) {
                playerCar.moveRight();
            }

            if(playerCar.isLeftPressed()){
                playerCar.moveLeft();
            }
            if (1 == 1) {
            }

            Car.moveCars(cars);
            carSpawnTimer++;
            for(int i=0; i<cars.size();i++){
                playerCar.isColliding(cars.get(i).getPicture());

            }

            //PlayerCar.collisionDetector(car.getPicture());
        }

    }

}
