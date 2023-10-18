package carFactory;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CarFactory {
    private static int firstLane = 302;
    private static int secondLane = 482;
    private static int thirdLane = 680;
    private static int fourthLane = 860;
    public static Car getNewCar() {
        Car car;
        int randomCar = (int) Math.floor(Math.random() * 2);
        if (randomCar == 0) {
            car = new GreenCar(CarFactory.startPosition());
        } else {
            car = new YellowCar(CarFactory.startPosition());
        }
        return car;
    }

    public static int startPosition() {
        int randomLane = (int) Math.floor(Math.random() * 4);
        int startPosition = switch (randomLane) {
            case 0 -> firstLane;
            case 1 -> secondLane;
            case 2 -> thirdLane;
            case 3 -> fourthLane;
            default -> 0;
        };
        return startPosition;
    }
}
