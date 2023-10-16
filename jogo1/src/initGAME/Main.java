package initGAME;

import carFactory.Car;
import carFactory.CarFactory;
import carFactory.EnemyCars;
import gridFactory.GridBackground;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        MenuStart menu = new MenuStart();

        GridBackground grid1 = new GridBackground();
        grid1.initgrid();


       Picture background = new Picture(13, 13, "images/pista1.png");
        background.draw();


        Picture car = new Picture(460, 515, "images/carblue.png");
        car.draw();

        Car enemyCar = new Car();

        EventHandler eventHandler = new EventHandler(car);
        eventHandler.init();


        Game.start(enemyCar);
        //menu.MenuStart();

    }

}

