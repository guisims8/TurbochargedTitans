package initGAME;

import carFactory.CarFactory;
import gridFactory.GridBackground;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) {

       /* CarFactory carFactory = new CarFactory();
        carFactory.getCars(); */


        GridBackground grid1 = new GridBackground();
        grid1.initgrid();



        Picture background = new Picture(13,13, "images/pista1.png");
        background.draw();



        Picture car = new Picture(460,515, "images/carblue.png");
        car.draw();



        EventHandler eventHandler = new EventHandler(car);
        eventHandler.init();









    }

}

