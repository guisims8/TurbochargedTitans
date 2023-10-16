package initGAME;

import carFactory.Car;
import carFactory.CarFactory;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {
Car car;

    private CarFactory[] carFactory;

    public static void start (Car car) {

        while (true) {

            // Pause for a while
            CustomSleep.sleep(10);
            car.moveCar();
        }

    }

}
