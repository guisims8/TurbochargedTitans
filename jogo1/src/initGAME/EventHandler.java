package initGAME;

import gridFactory.GridBackground;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EventHandler implements KeyboardHandler {

    private Picture car;
    GridBackground grid1 = new GridBackground();

    public EventHandler(Picture car) {
       this.car = car;
    }

    public void init() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);


        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);


        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);


        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);

        kb.addEventListener(down);
        kb.addEventListener(up);
        kb.addEventListener(right);
        kb.addEventListener(left);
        kb.addEventListener(space);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
       // GridBackground grid1 = new GridBackground();
       // grid1.initgrid();


        int carX = car.getX();
        //System.out.println(car.getX());
        int carY = car.getY();
        //System.out.println(car.getY());


        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                if (carX - 110 <= grid1.getCols()) {
                    //grid1.getCols() >= -100 + carX) WTFFF ISS THATT
                    car.translate(15, 0);
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (carX + 303 > grid1.getCols()) {
                    car.translate(-15, 0);
                }
                break;

            case KeyboardEvent.KEY_UP:
                if(carY + 615 > grid1.getRows()){
                    car.translate(0, -15);
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (carY + 140 < grid1.getRows()) {
                    car.translate(0, 20);
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                car.translate(0, -40);
                break;


        }


    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


    }
}