package gridFactory;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class GridBackground {
    public static final int PADDINGY = 10;
    public static final int PADDINGX = 185;
    private static final int cols = 495;
    private static final int rows = 655;
    private Rectangle field;
    private Picture road;


    public void initgrid() {
        this.field = new Rectangle(PADDINGX, PADDINGY, cols, rows);
        field.draw();
        road = new Picture(13, 13, "images/pista1.png");
        road.draw();

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
