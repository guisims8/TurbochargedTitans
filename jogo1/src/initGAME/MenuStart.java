package initGAME;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class MenuStart {

  Picture picture;


    public void MenuStart(){

        picture = new Picture(13,13,"images/testefundo.png");
        picture.draw();

    }


    public void DeleteMenu(){
        this.picture.delete();
    }






}
