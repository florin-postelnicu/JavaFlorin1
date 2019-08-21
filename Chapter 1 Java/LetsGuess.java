
import java.util.Scanner;
import java.lang.Math;

public class LetsGuess {


    public static void main(String[] args) {
        boolean play_again = true;


        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int computer_guess = (int) (Math.random() * range + 1);

        while (play_again) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your guess master :");
            int my_guess = scan.nextInt();
            if (my_guess != computer_guess){
                System.out.println("Too bad Master, you need to guess again!");
            }
            else{
                System.out.println("You are a winner Master, your guess ia as good as the computer's");
                System.out.println("Master's guess: " + my_guess + " computer's guess  :" + computer_guess);
                play_again = false;
            }
        }

    }
}