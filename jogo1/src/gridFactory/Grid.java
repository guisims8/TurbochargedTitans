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
    private static Picture roadImage1;
    private static Picture roadImage2;
    private static Picture roadImage3;
    private static Picture roadImage4;
    private static Picture roadImage5;
    private static int whichRoad = 0;
    List<Picture> roadPictures = new LinkedList<>();


    public static void initgrid() {
        roadImage1 = new Picture(10, 0, "images/final.png");
        roadImage1.draw();
        roadImage2 = new Picture(10, 0, "images/road10.png");
        roadImage3 = new Picture(10, 0, "images/road11.png");
        roadImage4 = new Picture(10,0,"images/road12.png");
        Rectangle rectangle = new Rectangle(PADDINGX, PADDINGY, cols, rows);
        rectangle.draw();

    }

    public static void drawRoad(Picture picture) {
        picture.draw();
    }

    public static void alternateImages() {
        switch (whichRoad) {
            case 0:
                drawRoad(roadImage2);
                deleteRoad(roadImage1);
                whichRoad++;
                break;
            case 1:
                drawRoad(roadImage3);
                deleteRoad(roadImage2);
                whichRoad++;
            case 2:
                drawRoad(roadImage4);
                deleteRoad(roadImage3);
                whichRoad++;
                break;
            case 3:
                drawRoad(roadImage1);
                deleteRoad(roadImage4);
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
        roadImage1.translate(0, 0);
    }

    public static Picture getRoadImage() {
        return roadImage1;
    }

    public static void setRoadImage(Picture roadImage) {
        Grid.roadImage1 = roadImage;
    }
}
