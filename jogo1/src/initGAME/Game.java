package initGAME;

import carFactory.Car;
import carFactory.CarFactory;
import gridFactory.GridBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
Car car;

    private CarFactory[] carFactory;

    static GridBackground grid;


    public static void start (Car car) {

        while (true) {

            // Pause for a while
            CustomSleep.sleep(10);
            car.moveCar();
        }

    }

}
