package carFactory;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GreenCar extends Car{
    public GreenCar(int startPosition) {
        super(CarType.GREEN,new Picture(startPosition,-30,"images/cargreen.png"));
    }
}
