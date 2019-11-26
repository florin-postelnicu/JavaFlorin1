



public class Minivan extends Cars{
    int seats ;
    int doors;
    public Minivan(int theSetas, int theDoors){
        super();
        this.seats = theSetas;
        this.doors = theDoors;
    }

    @Override
    public void printCarCahracters() {
        System.out.println(" Brand : "+ this.getBrand() + "\nModel  :" + this.getModel() + "\nColor : " + this.getColor() +
                 "\nSeats : " + this.seats + "\nDoors : " + this.doors);

    }
}
