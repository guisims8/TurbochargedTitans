package initGAME;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuStart {

    Picture picture;


    public void MenuStart(){

        picture = new Picture(13,13,"images/menufinal.png");
        picture.draw();

    }


    public void DeleteMenu(){
        this.picture.delete();
    }

}
