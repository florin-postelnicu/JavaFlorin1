/*
Guess computer's number with recursive functions
Note:
All private attributes can be used only by the class where they are created,
G_OOPvar2
Start_game() can not be private, since it is used by class Test_Game1.
A non static method can be used in a static environment if it is generated
an instance of the class containing the method 
In class Test_Game1 the Start_game() method of G_OOPvar2 is invoked by instancieting 

G_OOPvar2 game = new G_OOPvar2();

The invokation:

game.Start_game();
*/

import java.util.Scanner ;
import java.lang.Math;


class G_OOPvar2 {
    // Enter the variables

    private  int max = 1000;
    private   int min = 1;
    private  int range = max - min;
    private  int computer_choice ;
    private int count = 0;

    // Start method

    void  Start_game(){

        System.out.println("Do you want to play? Y\\N");
        Scanner scan = new Scanner(System.in);
        String answer = scan.next() ;

        if( answer.equals("y")){
            computer_choice = (int)(Math.random()*range )+ min;
            Keep_Playing();
        }
        else {
            System.out.println("Bye - Bye !");
        }
    }
    // Display message method
    private void Display_message(int my_guess, int guess){

        System.out.println("My guess is  "+ my_guess);
        System.out.println("The Computer's guess is "+ guess);

    }
    private void Your_guess_is(String bearing ){
        System.out.println("Sorry, baby, maybe  next time! Keep trying! Your guess is too "
                + bearing + "\n\tyou have asked :" + count + "\tquestions");

    }
    //Continue  Play method

    private  void Keep_Playing(){

        System.out.println("Enter your guess, an integer between 1 and 1000");
        count++;
        Scanner scan = new Scanner(System.in);
        int my_guess = scan.nextInt();
        if( my_guess == computer_choice){
            Display_message( my_guess,computer_choice);
            System.out.println("Congrats!!");
            Start_game();
        }
        else{
            if(my_guess< computer_choice){
                Your_guess_is("low");
            Keep_Playing();}
            else{
                Your_guess_is("high");
                Keep_Playing();}
            }
        }
    }
class Test_Game1 {

    public static void main(String[] args) {
        G_OOPvar2 game = new G_OOPvar2();
        game.Start_game();
    }
}


