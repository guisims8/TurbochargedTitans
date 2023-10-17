package carFactory;

import gridFactory.Grid;
import initGAME.Game;
import initGAME.Main;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Car {
    Picture picture;
    int firstLane = 302;
    int secondLane = 482;
    int thirdLane = 680;
    int fourthLane = 860;


    public Car() {
        int randomLane = (int) Math.floor(Math.random() * 4);
        int startPosition = switch (randomLane) {
            case 0 -> firstLane;
            case 1 -> secondLane;
            case 2 -> thirdLane;
            case 3 -> fourthLane;
            default -> 0;
        };
        int randomCar = (int) Math.floor(Math.random() * 2);
        if (randomCar == 0) {
            this.picture = new Picture(startPosition, -30, "images/cargreen.png");
        } else {
            this.picture = new Picture(startPosition, -30, "images/caryellow.png");
        }
        picture.draw();
    }

    public static void moveCars(List<Car> cars) {
        /*for (Car car : cars) {
            car.getPicture().translate(0, 3);
            if (car.getPicture().getMaxY() > Grid.PADDINGY + Grid.rows - 30) {
                car.getPicture().delete();
                cars.remove(car);
            }

        }*/
        for(int i=0; i<cars.size();i++){
            cars.get(i).getPicture().translate(0,3);
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
