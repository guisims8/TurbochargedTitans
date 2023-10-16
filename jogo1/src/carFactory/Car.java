package carFactory;

import gridFactory.GridBackground;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {
    Picture picture;
    GridBackground grid = new GridBackground();

    public Car() {
        this.picture = new Picture(GridBackground.PADDINGX + 25, GridBackground.PADDINGY, "images/cargreen.png");
        picture.draw();

    }

    public void moveCar() {
        this.getPicture().translate(0, 3);

        // apaga o carro quando bate no fim da grid
        if (picture.getY() + 125  > grid.getRows()) {
            picture.delete();
        }
    }


    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
