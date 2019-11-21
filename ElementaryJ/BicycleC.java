
/*
A class contains constructors that are invoked to create objects from the class blueprint.
Constructor declarations look like method declarations—except that
they use the name of the class and have no return type.
Both constructors could have been declared in Bicycle because they have different argument lists.
 As with methods, the Java platform differentiates constructors on the basis of the number of arguments in the list
  and their types. You cannot write two constructors that have the same number and type of arguments for the same class,
   because the platform would not be able to tell them apart. Doing so causes a compile-time error.

You don't have to provide any constructors for your class, but you must be careful when doing this.
The compiler automatically provides a no-argument, default constructor for any class without constructors.
This default constructor will call the no-argument constructor of the superclass. In this situation,
 the compiler will complain if the superclass doesn't have a no-argument constructor so you must verify that it does.
 If your class has no explicit superclass, then it has an implicit superclass of Object,
 which does have a no-argument constructor.

You can use a superclass constructor yourself. The MountainBike class at the beginning of this lesson did just that.
 This will be discussed later, in the lesson on interfaces and inheritance.

You can use access modifiers in a constructor's declaration to control which other classes can call the constructor.

Note: If another class cannot call a MyClass constructor, it cannot directly create MyClass objects.
 */


public class BicycleC {
    int gear, speed, cadence;

    public BicycleC(int startCadence, int startGear, int startSpeed ){
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;

    }
    public BicycleC(){
        gear = 1;
        cadence = 8;
        speed = 0;


    }
    public BicycleC(int startGear, int startSpeed){
        gear = startGear;
        speed = startSpeed;
        cadence = 10;

    }


    public static void main(String[] args) {
       BicycleC  myBike = new BicycleC(30, 0, 8) ;
        System.out.println("Characteristics of myBike : Cadence: "
                + myBike.cadence +" ,Gear: " + myBike.gear + " ,Speed: "+ myBike.speed);

        BicycleC aBike = new  BicycleC();
        System.out.println("Characteristics of aBike : Cadence: "
                + aBike.cadence +" ,Gear: " + aBike.gear + ", Speed: "+ aBike.speed);
        BicycleC kindBike = new BicycleC(3, 5);
        System.out.println("Characteristics of kindBike : Cadence :  "
                + kindBike.cadence +" ,Gear: " + kindBike.gear + ", Speed: "+ kindBike.speed);

    }

}
