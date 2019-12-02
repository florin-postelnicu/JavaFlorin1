
import java.util.Scanner;
public class Cars {
    public String  brand;
    public String model;
    public String color;
    public double gas = 0;
    public double currency = 25;
    public double bankacount;

//    public double mon;


    public Cars(String theBrand, String theModel, String theColor){
        this.brand = theBrand;
        this.model = theModel;
        this.color = theColor;
        this.gas =0;
    }
    public Cars(String theBrand, String theModel){
        this.brand = theBrand;
        this.model = theModel;
        this.color = "I Don't Care";
    }

    public Cars(){
        this.brand = "Lemon";
        this.model = "Stegosaur";
        this.color = "Greenish";
        this.gas = 0;



    }
    public void setBrand(String newBrand){
        this.brand = newBrand;
    }
    public void setModel( String newModel){
        this.model = newModel;
    }
    public void setColor(String newColor){
        this.color = newColor;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    public String getColor(){
        return this.color;
    }

    public void printCarAttributes(){
        System.out.println("Brand  : "+ this .getBrand() +"\nModel :  " + this.getModel() +"\nColor :  " + this.getColor());
    }
    public void filltank( double mon){
        if(this.currency<= 0){
            this.currency = -(Math.abs(this.currency) - mon);}
        else{
            this.currency = Math.abs(this.currency) - mon;
        }
       this.gas = mon*(1/3.05);
        System.out.println("Your currency is : " + this.getCurrency() + " and you have "+ this.getGas() +" gallons of gas");

    }
    public double getGas(){
        return  this.gas;
    }
    public double setCurrency(double borrow){
        this.currency = this.currency - borrow;
        return this.currency;
    }

    public double getCurrency() {
        return currency;
    }
    public double runtheCar(){
        if(this.gas == 0){
            System.out.println("You have an empty tank! \nHow much money are you filling off?\n");
            Scanner scan = new Scanner(System.in);
            double money = scan.nextDouble();
            if(this.currency - money >= 0){
            this.filltank(money);
            return this.gas;}
            else{
                System.out.println("Sorry you do not have that much money!You have only :" +this.getCurrency());
                System.out.println("Would you like to borrow something? The interest is 10% ?");
                double moneyB = scan.nextDouble();
                System.out.println("Old currency :"+ this.getCurrency());

                this.currency = this.currency + moneyB;
                this.filltank(money);
                this.currency = this.currency - moneyB*1.1;
                System.out.println("Your currency is : " + this.getCurrency() + " and you have "+ this.getGas() +" gallons of gas");
                return this.currency;
            }
        }
        return this.gas;
    }
}
