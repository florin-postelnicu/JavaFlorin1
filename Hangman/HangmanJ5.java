

import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;

 class HangmanJ5 {
     Scanner scan = new Scanner(System.in);

     public char Invite_play() {
         System.out.println("Do you want to play one more game y\\n");

         char invite = scan.next().charAt(0);
         return invite;
     }


 }


class TestH5{
    public static void main(String[] args) {
        HangmanJ5 play = new HangmanJ5();
        if(play.Invite_play()=='y'){
            HangmanJ4 hangman_game = new HangmanJ4();
            hangman_game.Hange();
        }
        else{
            System.exit(0);
        }



    }}


