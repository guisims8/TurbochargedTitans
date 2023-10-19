package carFactory;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CarFactory {
    private static int firstLane = 302;
    private static int secondLane = 482;
    private static int thirdLane = 680;
    private static int fourthLane = 860;
    private static int lastStartPosition = 0;


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

    // Decide em que lane o carro dá spawn.
    // O valor que retorna é usado para decidir o x inicial dos nossos carros
    // nos respetivos construtores.
    // O lastStartPosition guarda a lane em que o último carro deu spawn e isso
    // mais o while impedem que dois carros seguidos spawnem na mesma lane
    public static int startPosition() {
        int randomLane = lastStartPosition;
        while (randomLane == lastStartPosition) {
            randomLane = (int) Math.floor(Math.random() * 4);
        }
        int startPosition = switch (randomLane) {
            case 0 -> firstLane;
            case 1 -> secondLane;
            case 2 -> thirdLane;
            case 3 -> fourthLane;
            default -> 0;
        };
        lastStartPosition = randomLane;
        return startPosition;
    }
}
