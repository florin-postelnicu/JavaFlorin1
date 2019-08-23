
import java.util.Scanner;
import java.lang.Math;


class Guess_OOP {
    // Enter the variables

    private static int max = 10;
    private static  int min = 1;
    private static int range = max - min;
    private static int computer_choice ;

    // Start method
    static void  Start_game(){
        System.out.println("Do you want to play? Y\\N");
        Scanner scan = new Scanner(System.in);
        String answer = scan.next() ;

        if( answer.equals("y")){
//            Guess_OOP game = new Guess_OOP();
            Guess_OOP.computer_choice = (int)(Math.random()*range )+ min;
            Guess_OOP.keep_playing();
        }
        else {
            System.out.println("Bye - Bye !");
        }
    }
    // Display message method
    private static void myTemplate(int my_guess, int guess){
        System.out.println(" My guess is  "+ my_guess);
        System.out.println("The Computer's guess is "+ guess);
    }
    //Continue  Play method
    private static  void keep_playing(){

        System.out.println("Enter your guess, an integer between 1 and 10");
        Scanner scan = new Scanner(System.in);
        int my_guess = scan.nextInt();
        if( my_guess == computer_choice){
            myTemplate( my_guess,computer_choice);
            System.out.println("Congrats!!");
            Guess_OOP.Start_game();
        }
        else{

            System.out.println("Sorry, baby, maybe  next time! Keep trying!");
            Guess_OOP.keep_playing();
        }
    }
}
class Test_Game {
    public static void main(String[] args) {
        Guess_OOP.Start_game();
    }
}
