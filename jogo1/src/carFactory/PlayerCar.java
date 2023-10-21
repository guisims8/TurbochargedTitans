package carFactory;

import gridFactory.Grid;
import initGAME.Game;
import initGAME.MenuStart;
import music.Music;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static gridFactory.Grid.PADDINGX;
import static gridFactory.Grid.PADDINGY;


public class PlayerCar implements KeyboardHandler {

    private final Picture playerCarPicture;
    private boolean rightPressed = false;
    private boolean leftPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private static int playerSpeed = 4;
    private int hp = 3;
    private boolean hasCollided = false;
    private boolean enterKeyPressed = false;

    public PlayerCar() {
        this.playerCarPicture = new Picture(368, 430, "images/carblue.png");
    }

    public void init() {
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
        int maxCarX = playerCarPicture.getMaxX();
        if (maxCarX < Grid.getCols() + PADDINGX) {
            playerCarPicture.translate(playerSpeed, 0);
        }
    }

    public void moveUp() {
        int minCarY = playerCarPicture.getY();
        if (minCarY > PADDINGY) {
            playerCarPicture.translate(0, -playerSpeed);
        }
    }

    public void moveDown() {
        int maxCarY = playerCarPicture.getMaxY();
        if (maxCarY < Grid.getRows() + PADDINGY) {
            playerCarPicture.translate(0, playerSpeed);
        }
    }

    public void moveLeft() {
        int minCarX = playerCarPicture.getX();
        if (minCarX > PADDINGX) {
            playerCarPicture.translate(-playerSpeed, 0);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                setRightPressed(true);
                break;
            case KeyboardEvent.KEY_LEFT:
                setLeftPressed(true);
                break;
            case KeyboardEvent.KEY_UP:
                setUpPressed(true);
                break;
            case KeyboardEvent.KEY_DOWN:
                setDownPressed(true);
                break;
            case KeyboardEvent.KEY_SPACE:
                playerCarPicture.translate(0, -40);
                break;
            case KeyboardEvent.KEY_ENTER:
                enterKeyPressed = true;
                MenuStart.DeleteMenu();
                this.playerCarPicture.draw();
                break;
        }
    }

    public boolean isColliding(Picture other) {
        if (playerCarPicture.getX() < other.getX() + other.getWidth() &&
                playerCarPicture.getX() + playerCarPicture.getWidth() > other.getX() &&
                playerCarPicture.getY() < other.getY() + other.getHeight() &&
                playerCarPicture.getY() + playerCarPicture.getHeight() > other.getY()) {
            if (!hasCollided) {
                Music crashSound = new Music("Musics/crashsong.wav");
                crashSound.play();
                other.delete();
                hp--;
                System.out.println("HP : " + hp);
                return true;
            }
            if (hp == 0) {
                hasCollided = true;
                Music crashSound = new Music("Musics/crashsong.wav");
                crashSound.play();
                System.out.println("HP : " + hp);
                System.out.println("Game Over");
                return true;
            }
        }
        return false;
        /*boolean collision = playerCarPicture.getX() < other.getX() + other.getWidth() &&
                playerCarPicture.getX() + playerCarPicture.getWidth() > other.getX() &&
                playerCarPicture.getY() < other.getY() + other.getHeight() &&
                playerCarPicture.getY() + playerCarPicture.getHeight() > other.getY();
        if (collision) {
           Music crashSound = new Music("Musics/crashsong.wav");
           crashSound.play();
        }
        return collision;*/
    }

    public boolean pickCoin(Picture coin) {
        boolean coinPick = playerCarPicture.getX() < coin.getX() + coin.getWidth() &&
                playerCarPicture.getX() + playerCarPicture.getWidth() > coin.getX() &&
                playerCarPicture.getY() < coin.getY() + coin.getHeight() &&
                playerCarPicture.getY() + playerCarPicture.getHeight() > coin.getY();
        if (coinPick) {
            Game.score += 4;
            System.out.println("Ganda COIN_a");
        }
        return coinPick;
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

    public static int getPlayerSpeed() {
        return playerSpeed;
    }

    public static void increasePlayerSpeed(int playerSpeed) {
        PlayerCar.playerSpeed = playerSpeed;
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

    public int getHp() {
        return hp;
    }
}