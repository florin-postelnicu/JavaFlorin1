/*hangmanJ4 and SelectWord are the main ingredients for HangmanJ6-the play machine
 */
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;

class HangmanJ6 {
    Scanner scan = new Scanner(System.in);

    public char Invite_play() {
        System.out.println("Do you want to play one more game y\\n");

        char invite = scan.next().charAt(0);
        return invite;
    }
    public HangmanJ6() {
        if(Invite_play()!='y'){
            System.out.println("Thank you for playing HangmanJ  !")
            System.exit(0);
        }
        else{
            HangmanJ4 hangman_game = new HangmanJ4();
            hangman_game.Hange();
        }
    }
}

class PlayDaGame{
    public static void main(String[] args) {
        new HangmanJ6();
    }}

