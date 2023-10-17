package gridFactory;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Grid {
    public static final int PADDINGY = 120;
    public static final int PADDINGX = 220;
    public static final int cols = 810;
    public static final int rows = 600;
    private Picture roadImage;


    public void initgrid() {
        this.roadImage = new Picture(13, 13, "images/final.png");
        roadImage.draw();
        Rectangle rectangle = new Rectangle(PADDINGX,PADDINGY,cols,rows);
        rectangle.draw();

    }

    public static int getCols() {
        return cols;
    }

    public static int getRows() {
        return rows;
    }
}
