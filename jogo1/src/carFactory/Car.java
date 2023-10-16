package carFactory;

import gridFactory.GridBackground;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {
    Picture picture;

    public Car() {
        this.picture = new Picture(GridBackground.PADDINGX, GridBackground.PADDINGY, "images/boat2.png");
        picture.draw();
    }


    public void moveCar() {
        this.getPicture().translate(0, 3);
    }


    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
