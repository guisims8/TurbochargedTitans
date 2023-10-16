package gridFactory;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class GridBackground {
    public static final int PADDINGY = 10;
    public static final int PADDINGX = 185;
    private final int cols = 495;
    private final int rows = 655;



    public void initgrid(){
        Rectangle rectangle = new Rectangle(PADDINGX, PADDINGY, cols, rows);
        rectangle.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows(){
        return rows;
    }
}
