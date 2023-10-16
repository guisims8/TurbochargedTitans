package gridFactory;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class GridBackground {

    private final int cols = 495;
    private final int rows = 655;



    public void initgrid(){
        int PADDINGY = 10;
        int PADDINGX = 185;
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
