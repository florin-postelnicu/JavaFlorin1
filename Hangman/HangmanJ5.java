

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

//    private String word;
//     private String getWord() {
//         return word;
//     }
//
//
//
//
//
//
//    HangmanJ5() {
//
//
//        void Hange()
//        {
//
//
//            if (Invite_play() == 'y') {
//                HangmanJ5 hang = new HangmanJ5();
//
//                SelectWord neword = new SelectWord();
//                word = neword.get_a_new_Word();
//                String str = hang.getWord();
//                char[] chars = str.toCharArray();
//                char[] memoryLane = new char[chars.length + 8];
//                int index_memory = 0;
//                for (int i = 0; i <= chars.length - 1; i++) {
//
//                    chars[i] = '*';
//                }
////             System.out.println(str);
//
//                System.out.println(chars);
//                int count = 0;
//
//                while (true) {
//
//                    boolean bull = false;
//
//                    // Enter a character
//                    System.out.println("Enter a new letter : ");
//
//                    char guess = scan.next().charAt(0);
//                    for (int i = 0; i <= chars.length - 1; i++) {
//
//                        if (guess == str.charAt(i)) {
//                            chars[i] = guess;
//                            bull = true;
//
//                        }
//                    }
//
//                    if (!Arrays.toString(chars).contains("*")) {
//                        System.out.println("This is the word!");
//                        System.out.println(chars);
//                        System.out.println("Congrats!");
//                        System.exit(0);
//
//                    }
//                    if (!bull | Memory_Repeat(guess, memoryLane)) {
//
//                        count++;
//
//                        if (count >= 7) {
//                            System.out.println("Bad !  Bad!   Bad!");
//                            System.out.println(str);
//                            System.exit(0);
//                        }
//                    }
//                    memoryLane[index_memory] = guess;
//                    index_memory++;
//
//                    System.out.println("You made Soooooo many mistakes   :" + count);
//
//                    System.out.println("Your memory's bellow !");
//
//                    System.out.println(memoryLane);
//
//                    System.out.println("That's the status of your work on the secret word :");
//                    System.out.println(chars);
//                }
//            }
//            else{
//                System.out.println("Game Over!");
//                System.exit(0);
//            }
//
//        }
//
//
//    }
//    public char Invite_play() {
//
//        char invite = scan.next().charAt(0);
//        return invite;
//    }
//
//
//
//    private static boolean Memory_Repeat(char guesst, char[] aRRay) {
//
//        for (int i = 0; i <= aRRay.length - 1; i++) {
//            if (aRRay[i] == guesst) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}
//
//
//
//
//
//

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


