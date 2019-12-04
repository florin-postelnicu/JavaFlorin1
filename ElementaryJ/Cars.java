



import java.util.Scanner;
public class Cars implements Runnable{
    public String name;
    public String  brand;
    public String model;
    public String color;
    public double gas = 100;
    public double currency = 25;
    public double bankacount;
    public boolean running = true;
    public int speed = 0;
    public Thread thread = new Thread(this::run);


    long  Old_time = System.currentTimeMillis();


    public Cars(String theBrand, String theModel, String theColor, String theName){
        this.brand = theBrand;
        this.model = theModel;
        this.color = theColor;
        this.name = theName;
        this.gas =0;
    }
    public Cars(String theBrand, String theModel, String theName){
        this.brand = theBrand;
        this.model = theModel;
        this.name = theName;
        this.color = "I Don't Care";

    }

    public Cars(String theName){
        this.name = theName;
        this.brand = "Lemon";
        this.model = "Stegosaur";
        this.color = "Greenish";
        this.gas = 10;

    }

    public Cars() {
        this.name = "Lola";
        this.brand = "Normie";
        this.model = "RunOver";
        this.color = "Hazy";
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
        this.currency = this.currency -mon;
        this.gas = mon*(1/3.05);
        System.out.println("Your currency is : " + this.getCurrency() +
                " and you have "+ this.getGas() +" gallons of gas");
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
        if(this.gas <= 0){
            System.out.println("You have an empty tank! \nHow much money are you filling off?\n");
            Scanner scan = new Scanner(System.in);
            double money = scan.nextDouble();
            if(money <= 0){
                this.StopZcar();
            }
            else {if(this.currency - money >= 0){
                this.filltank(money);
                return this.gas;}
            else{
                System.out.println("Sorry you do not have that much money!You have only :" +this.getCurrency());
                System.out.println("Would you like to borrow something? The interest is 10% ?");
                double moneyB = scan.nextDouble();
                System.out.println("Old currency :"+ this.getCurrency());

                this.currency = this.currency + moneyB;
                this.filltank(moneyB);
                this.currency = this.currency - moneyB*1.1;
                System.out.println("Your currency is : " + this.getCurrency() + " and you have "+
                        this.getGas() +" gallons of gas");
                return this.currency;
            }
            }
        }
        return this.gas;
    }


    public double GasConsumption(int speed) {
        while( running){
            try{
                long New_time = System.currentTimeMillis();
                if(New_time - Old_time > speed){

                    this.gas = this.getGas() - 0.5;
                    Old_time = New_time;
                    if(this.gas<= 0){

//                        this.runtheCar();
                        this.StopZcar();
                    }
                    System.out.println("The "+ this.name+ " consumption is  : " + this.gas + " Speed :"+ speed);
                }
            }catch(Exception e){
                System.out.println("Got an exception! \n");
            }
        }return this.gas;
    }

    private void StopZcar() {
        running = false;
    }
    public void run(){
        try{
        doDBProcessing();
        this.GasConsumption(this.speed);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    private void doDBProcessing() throws InterruptedException{
       this.thread.sleep(this.speed);
    }
}