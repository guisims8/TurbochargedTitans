package initGAME;

import gridFactory.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static gridFactory.Grid.PADDINGX;
import static gridFactory.Grid.PADDINGY;


public class PlayerCar implements KeyboardHandler {

    private final Picture car;
    Grid grid1 = new Grid();

    MenuStart menu = new MenuStart();

    public PlayerCar() {
        this.car = new Picture(368, 430, "images/carblue.png");
        //menu.MenuStart();
    }


    public void init() {
        car.draw();
        menu.MenuStart();
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

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        enter.setKey(KeyboardEvent.KEY_ENTER);


        kb.addEventListener(enter);
        kb.addEventListener(down);
        kb.addEventListener(up);
        kb.addEventListener(right);
        kb.addEventListener(left);
        kb.addEventListener(space);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int minCarX = car.getX();
        int minCarY = car.getY();
        int maxCarX = car.getMaxX();
        int maxCarY = car.getMaxY();


        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                if (maxCarX < grid1.getCols() + PADDINGX) {
                    car.translate(15, 0);
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (minCarX > PADDINGX) {
                    car.translate(-15, 0);
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (minCarY > PADDINGY) {
                    car.translate(0, -15);
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (maxCarY < grid1.getRows() + PADDINGY) {
                    car.translate(0, 20);
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                car.translate(0, -40);
                break;


            case KeyboardEvent.KEY_ENTER:
                menu.DeleteMenu();
                break;


        }


    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


    }
}