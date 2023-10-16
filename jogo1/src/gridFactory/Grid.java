package gridFactory;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Grid {
    public static final int PADDINGY = 100;
    public static final int PADDINGX = 185;
    public static final int cols = 495;
    public static final int rows = 600;
    private Picture roadImage;


    public void initgrid() {
        this.roadImage = new Picture(13, 13, "images/pista1.png");
        roadImage.draw();

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
