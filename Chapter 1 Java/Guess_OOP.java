
import java.util.Scanner;
import java.lang.Math;


public class Guess_OOP {
    // Enter the variables
    public static boolean play_again = true;
    public static boolean another_game = true;
    public static int max = 10;
    public static  int min = 1;
    public static int range = max - min;
    public static int computer_choice ;



    // Constructor

    // Start method
    static void  Start_game(boolean another_game){
        System.out.println("Do you want to play? Y\\N");
        Scanner scan = new Scanner(System.in);
        String answer = scan.next() ;

        if( answer.equals("y")){

            Guess_OOP game = new Guess_OOP();
            Guess_OOP.computer_choice = (int)(Math.random()*range )+ min;
            game.keep_playing(Guess_OOP.play_again);
        }
        else {
            Guess_OOP.another_game = false;
            Guess_OOP.play_again =true;
            System.out.println("Bye - Bye !");
        }


    }

    static void myTemplate( int my_guess,int  guess){
        System.out.println(" My guess is  "+ my_guess);
        System.out.println("The Computer's guess is "+ guess);
    }

    //Cont Play method
    public static  void keep_playing(boolean play_again){
        boolean another_game = false;

        System.out.println("Enter your guess, an integer between 1 and 10");
        Scanner scan = new Scanner(System.in);
        int my_guess = scan.nextInt();
        if( my_guess == computer_choice){

            myTemplate( my_guess,computer_choice);

            System.out.println("Congrats!!");
            Guess_OOP.Start_game(Guess_OOP.another_game);





        }
        else{

            myTemplate( my_guess,computer_choice);
            System.out.println("Sorry, bayby some other time");

            Guess_OOP.keep_playing(Guess_OOP.play_again);



        }

    }




}
class Test_Game {
     public static void main(String[] args) {
         //initiate Guess_OOP instances
         Guess_OOP gamer = new Guess_OOP();
         gamer.Start_game(Guess_OOP.another_game);



     }
}
