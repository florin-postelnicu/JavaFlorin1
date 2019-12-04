import java.util.ArrayList;

public class TestforCars {
    public static void main(String[] args) {

        ArrayList<Cars> CarsList = new ArrayList<>();

        for (int i = 1; i<=5; i++){

           CarsList.add(new Cars("Car" +i));

        }
        for(Cars car : CarsList){
            int speed = 400*((int)(5*Math.random()+ 1 ));
            int gas = ((int)(6*Math.random() + 1));
            car.speed = speed;
            car.gas = gas;
            car.Distance();

            car.thread.start();

        }
}
}
