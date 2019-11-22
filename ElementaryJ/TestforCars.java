public class TestforCars {
    public static void main(String[] args) {
        Cars BillyCar = new Cars("Ford", "Mustang", "Red");
        System.out.println("Billy's car is a : "+ BillyCar.brand +
                "- "+BillyCar.model +" and its color is :"+BillyCar.color);
        Cars myCar = new Cars("Toyota","Prius","Silver");
        System.out.println("My Car's brand is :" + myCar.brand);
        System.out.println("My Car's model is :" + myCar.model);
        System.out.println("My Car's color is :" + myCar.color);

        Cars Biak = new Cars("Buagatti", "236ZXL");
        System.out.println("Biak's brnd is :" + Biak.brand);
        System.out.println("Biak's model is :" + Biak.model);
        System.out.println("Biak's color is :" + Biak.color);
        Biak.setBrand("Fiat");
        System.out.println(Biak.getBrand());

        Cars rabla = new Cars();
        System.out.println(rabla.brand);
        System.out.println(rabla.model);
        System.out.println(rabla.color);


    }

}
