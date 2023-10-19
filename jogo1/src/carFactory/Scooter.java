package carFactory;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Scooter extends Car {
    private static int scooterSpeed = 5;

    public Scooter(int startPosition) {
        super(CarType.SCOOTER, new Picture(startPosition, -30, CarFactory.chooseScooterPicture()), scooterSpeed);
    }

    public static void increaseYellowSpeed(int speed) {
        System.out.println("passou");
        scooterSpeed += speed;
    }
}
