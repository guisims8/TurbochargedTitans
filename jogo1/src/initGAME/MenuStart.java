package initGAME;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuStart {

    private static Picture picture;


    public static void MenuStart(){

        picture = new Picture(13,13,"images/menufinal.png");
        picture.draw();

    }


    public static void DeleteMenu(){
        picture.delete();
    }

}
