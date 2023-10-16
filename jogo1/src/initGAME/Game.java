package initGAME;

import carFactory.Car;
import carFactory.CarFactory;
import gridFactory.GridBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private final GridBackground grid = new GridBackground();


    public Game() {

    }

    public void start() {
        grid.initgrid();
        Picture car = new Picture(460, 515, "images/porsche.png");
        car.draw();
        PlayerCar eventHandler = new PlayerCar(car);

        play();
    }

    public void play() {

        while (true) {
            // Pause for a while
            CustomSleep.sleep(10);
        }

    }

}
