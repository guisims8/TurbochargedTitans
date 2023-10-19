package gridFactory;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;


public class Grid {
    public static final int PADDINGY = 120;
    public static final int PADDINGX = 220;
    public static final int cols = 810;
    public static final int rows = 600;
    private static Picture roadImage;
    private static int whichRoad = 0;
    List<Picture> roadPictures = new LinkedList<>();


    public static void initgrid() {
        roadImage = new Picture(10, 0, "images/final.png");
        roadImage.draw();
        Rectangle rectangle = new Rectangle(PADDINGX, PADDINGY, cols, rows);
        rectangle.draw();
    }
    public static void alternateImages() {
        switch (whichRoad) {
            case 0:
                roadImage.load("images/road10.png");
                whichRoad++;
                break;
            case 1:
                roadImage.load("images/road11.png");
                whichRoad++;
            case 2:
                roadImage.load("images/road12.png");
                whichRoad++;
                break;
            case 3:
                roadImage.load("images/final.png");
                whichRoad = 0;
                break;
        }
    }

    public static void deleteRoad(Picture picture) {
        picture.delete();
    }

    public static int getCols() {
        return cols;
    }

    public static int getRows() {
        return rows;
    }

    public static void moveBackground() {
        roadImage.translate(0, 0);
    }

    public static Picture getRoadImage() {
        return roadImage;
    }

    public static void setRoadImage(Picture roadImage) {
        Grid.roadImage = roadImage;
    }
}
