public class TestforCars {
    public static void main(String[] args) {


        System.out.println("Minivan");
        Minivan familyCar = new Minivan(7, 5);
        familyCar.printCarAttributes();

        System.out.println("After setting the attributes");
        familyCar.setBrand("Ford");
        familyCar.setModel(" Windstar");
        familyCar.setColor(" Blue");
        familyCar.filltank(121);
        familyCar.runtheCar();
        familyCar.printCarAttributes();

        Cars tonyC = new Cars();
        tonyC.printCarAttributes();
        familyCar.runtheCar();
        System.out.println(familyCar.getGas());
        System.out.println(tonyC.gas);
        System.out.println(tonyC.currency);
        System.out.println(tonyC.brand);
        tonyC.runtheCar();

    }

}
