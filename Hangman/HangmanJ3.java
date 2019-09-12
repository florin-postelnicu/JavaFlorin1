



import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
public class HangmanJ3 {

    private String word;

     HangmanJ3(){
        word = "hangamanGame";
    }
    private  void  setWord( String w) {
       this.word = w;
    }

    private  String getWord (){
        return word;}


    public  void  Hange() {
        HangmanJ3 hang = new HangmanJ3();

        Scanner scan = new Scanner(System.in);
        String str = hang.getWord();
        char[] chars = str.toCharArray();


        // String to characters array


        char[] memoryLane = new char[chars.length + 8];
        int index_memory = 0;


        for (int i = 0; i <= chars.length - 1; i++) {

            chars[i] = '*';
        }


        System.out.println(str);

        System.out.println(chars);
        int count = 0;

        while (true) {

            boolean bull = false;

            // Enter a character
            System.out.println("Enter a new letter : ");

            char guess = scan.next().charAt(0);

            for (int i = 0; i <= chars.length - 1; i++) {

                if (guess == str.charAt(i)) {
                    chars[i] = guess;
                    bull = true;

                }
            }

            if(!Arrays.toString(chars).contains("*")){
                System.out.println("This is the word! Congrats!");
                System.exit(0);
            }
            if (!bull | Memory_Repeat(guess, memoryLane) ) {

                count++;
                System.out.println("You made Soooooo many mistakes   :" + count);
                if(count >= 7){
                    System.out.println("Bad !  Bad!   Bad!");
                    System.exit(0);
                }
            }
            memoryLane[index_memory] = guess;
            System.out.println("Your memory's bellow !");
            System.out.println( memoryLane);
            index_memory++;
            System.out.println("That's the status of your work on the secret word :");
            System.out.println(chars);
        }
    }

    private static boolean Memory_Repeat(char guesst, char[] aRRay) {
        HangmanJ3 hango = new HangmanJ3();
        for(int i = 0; i <= hango.getWord().length() + 7; i++ ){
            if ( aRRay[i] == guesst ){
                return true;

            }
        }


        return false;
    }
}
class TestHangaman {
    public static void main(String[] args) {


    HangmanJ3 hangman_game = new HangmanJ3();
    hangman_game.Hange();
}}