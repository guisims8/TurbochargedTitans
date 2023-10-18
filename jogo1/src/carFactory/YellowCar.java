package carFactory;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class YellowCar extends Car{
    public YellowCar(int startPosition) {
        super(CarType.YELLOW, new Picture(startPosition, -30, "images/caryellow.png"));
    }
}
