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

    public Car(CarType carType, Picture picture) {
        this.carType = carType;
        this.picture = picture;
        picture.draw();
    }

    // Recebe a lista de carros, itera sobre ela e move os carros
    // fazendo-os desaparecer quando chegam ao fundo
    public static void moveCars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).getPicture().translate(0, speed);
            if (cars.get(i).getPicture().getMaxY() > Grid.PADDINGY + Grid.rows - 30) {
                cars.get(i).getPicture().delete();
                cars.remove(cars.get(i));
            }
        }
    }


    // speed é uma propriedade static de todos os carros que uso
    // no método moveCars para os mexer
    // Com este método posso aumentar/diminuir a velocidade dos carros
    public static void increaseAllCarsSpeed(int speed) {
        speed += speed;
    }

    public Picture getPicture() {
        return picture;
    }
}
