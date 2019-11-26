public class TestforCars {
    public static void main(String[] args) {


        System.out.println("Minivan");
        Minivan familyCar = new Minivan(7, 5);
        familyCar.printCarCahracters();

        System.out.println("After setting the attributes");
        familyCar.setBrand("Ford");
        familyCar.setModel(" Windstar");
        familyCar.setColor(" Blue");
        familyCar.printCarCahracters();




    }

}
