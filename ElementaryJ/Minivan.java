



public class Minivan extends Cars{
    int seats ;
    int doors;
    int towing = 2 ;

    public Minivan(int theSeats, int theDoors){
        super();
        this.seats = theSeats;
        this.doors = theDoors;}

    public Minivan(int theSeats, int theDoors,int theTowing){
        super();
        this.seats = theSeats;
        this.doors = theDoors;
        this.towing = theTowing;
    }
    public void setTowing(int tow){
        this.towing = tow;
    }
//    public double getTowing(){
//        return  this.towing;
//    }


    @Override
    public void printCarAttributes() {
        System.out.println(" Brand : "+ this.getBrand() + "\nModel  :" + this.getModel() + "\nColor : " + this.getColor() +
                 "\nSeats : " + this.seats + "\nDoors : " + this.doors + "\nTowing Capacity :"+ this.towing);

    }

}
