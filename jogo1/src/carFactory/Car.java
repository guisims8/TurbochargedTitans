package carFactory;

import gridFactory.Grid;
import initGAME.Game;
import initGAME.Main;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Car {
    private final Picture picture;
    private final CarType carType;
    private static int speed = 3;
    private static int firstLane = 302;
    private static int secondLane = 482;
    private static int thirdLane = 680;
    private static int fourthLane = 860;


    public Car(CarType carType, Picture picture) {
        this.carType = carType;
        this.picture = picture;
        picture.draw();
    }


    public static void moveCars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).getPicture().translate(0, speed);
            if (cars.get(i).getPicture().getMaxY() > Grid.PADDINGY + Grid.rows - 30) {
                cars.get(i).getPicture().delete();
                cars.remove(cars.get(i));
            }
        }

    }

    public Picture getPicture() {
        return picture;
    }
}
