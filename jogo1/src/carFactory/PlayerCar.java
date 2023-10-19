package carFactory;

import gridFactory.Grid;
import initGAME.MenuStart;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static gridFactory.Grid.PADDINGX;
import static gridFactory.Grid.PADDINGY;


public class PlayerCar implements KeyboardHandler {
    private final Picture car;
    private boolean rightPressed = false;
    private boolean leftPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;

    private boolean enterKeyPressed = false;

    public PlayerCar() {
        this.car = new Picture(368, 430, "images/carblue.png");
    }


    public void init() {
        car.draw();
        Keyboard kb = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent upReleased = new KeyboardEvent();
        upReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upReleased.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent downReleased = new KeyboardEvent();
        downReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        downReleased.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        enter.setKey(KeyboardEvent.KEY_ENTER);


        kb.addEventListener(enter);
        kb.addEventListener(down);
        kb.addEventListener(downReleased);
        kb.addEventListener(up);
        kb.addEventListener(upReleased);
        kb.addEventListener(rightPressed);
        kb.addEventListener(rightReleased);
        kb.addEventListener(left);
        kb.addEventListener(leftReleased);
        kb.addEventListener(space);
    }

    public void moveRight() {
        int maxCarX = car.getMaxX();
        if (maxCarX < Grid.getCols() + PADDINGX) {
            car.translate(8, 0);
        }
    }

    public void moveUp() {
        int minCarY = car.getY();
        if (minCarY > PADDINGY) {
            car.translate(0, -8);
        }
    }

    public void moveDown() {
        int maxCarY = car.getMaxY();
        if (maxCarY < Grid.getRows() + PADDINGY) {
            car.translate(0, 8);
        }
    }

    public void moveLeft() {
        int minCarX = car.getX();
        if (minCarX > PADDINGX) {
            car.translate(-8, 0);
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                    //moveRight();
                    setRightPressed(true);
                break;

            case KeyboardEvent.KEY_LEFT:
                    setLeftPressed(true);
                    //moveLeft();
                break;

            case KeyboardEvent.KEY_UP:
                setUpPressed(true);
                break;

            case KeyboardEvent.KEY_DOWN:
                setDownPressed(true);
                break;

            case KeyboardEvent.KEY_SPACE:
                car.translate(0, -40);
                break;

            case KeyboardEvent.KEY_ENTER:
                enterKeyPressed = true;
                MenuStart.DeleteMenu();
                break;
        }
    }

    public boolean isColliding(Picture other) {
        boolean collision = car.getX() < other.getX() + other.getWidth() &&
                car.getX() + car.getWidth() > other.getX() &&
                car.getY() < other.getY() + other.getHeight() &&
                car.getY() + car.getHeight() > other.getY();
        if (collision) {
            System.out.println("Game Over");
        }
        return collision;
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            setRightPressed(false);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            setLeftPressed(false);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            setUpPressed(false);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            setDownPressed(false);
        }

    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public boolean isEnterKeyPressed() {
        return enterKeyPressed;
    }

    public void setEnterKeyPressed(boolean enterKeyPressed) {
        this.enterKeyPressed = enterKeyPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }
}