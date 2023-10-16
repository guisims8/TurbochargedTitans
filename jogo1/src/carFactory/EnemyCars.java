package carFactory;

public enum EnemyCars {

    CAR1(CarColor.GREEN),

    CAR2(CarColor.RED);

    private CarColor color;

    EnemyCars(CarColor color){
        this.color = color;
    }

}
