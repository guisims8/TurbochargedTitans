package carFactory;

import gridFactory.Grid;
import initGAME.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Car {
    private final Picture picture;
    private final CarType carType;
    private int carsSpeed;
    public static Text textScore;
    public static Text textLevel;

    public Car(CarType carType, Picture picture, int speed) {
        this.carType = carType;
        this.picture = picture;
        this.carsSpeed = speed;
        picture.draw();

        if (textScore != null) {
            textScore.delete();
        }

        textScore = new Text(600, 690, "YOUR SCORE: " + Game.score);
        textScore.setColor(Color.GREEN);
        textScore.grow(25, 10);
        textScore.draw();

        textLevel = new Text(1100, 130, "LEVEL: " + Game.level);
        textLevel.setColor(Color.BLUE);
        textLevel.grow(25,10);
        textLevel.draw();


    }

    // Recebe a lista de carros, itera sobre ela e move os carros
    // fazendo-os desaparecer quando chegam ao fundo
    public void moveCar(List cars, Car car) {


        car.getPicture().translate(0, car.carsSpeed);
        if (car.getPicture().getMaxY() > Grid.PADDINGY + Grid.rows - 30) {
            car.getPicture().delete();
            cars.remove(car);
            Game.score += 1;
        }
    }

    // speed é uma propriedade static de todos os carros que uso
    // no método moveCars para os mexer
    // Com este método posso aumentar/diminuir a velocidade dos carros
    public Picture getPicture() {
        return picture;
    }

    public int getCarSpeed() {
        return carsSpeed;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarSpeed(int carsSpeed) {
        this.carsSpeed = carsSpeed;
    }
}
