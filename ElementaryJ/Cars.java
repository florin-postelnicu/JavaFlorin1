

public class Cars {
    public String  brand;
    public String model;
    public String color;


    public Cars(String theBrand, String theModel, String theColor){
        this.brand = theBrand;
        this.model = theModel;
        this.color = theColor;
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


    }
    public void  setBrand(String newBrand){
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

    public void printCarCahracters(){
        System.out.println("Brand  : "+ this .getBrand() +"\nModel :  " + this.getModel() +"\nColor :  " + this.getColor());
    }

}
