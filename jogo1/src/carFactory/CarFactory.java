package carFactory;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CarFactory {











    EnemyCars[] randomCars = new EnemyCars[100];

    public void getCars() {

        for(int i = 0; i < randomCars.length; i++){
            int random = (int) (Math.random() * EnemyCars.values().length);
            randomCars[i] = EnemyCars.values()[random];
        }

        System.out.println(randomCars[6]);
        System.out.println(randomCars[3]);
        System.out.println(randomCars[99]);



    }


}
