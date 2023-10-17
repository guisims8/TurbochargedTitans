package carFactory;

import gridFactory.Grid;
import initGAME.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {
    Picture picture;

    public Car() {
        this.picture = new Picture(Grid.PADDINGX, Grid.PADDINGY, "images/boat2.png");
        picture.draw();
    }

    public void moveCar() {
        this.getPicture().translate(0, 3);
        if (this.getPicture().getMaxY() > Grid.PADDINGY + Grid.rows - 30) {
            this.getPicture().delete();
        }
    }

    public Picture getPicture() {
        return picture;
    }
}
