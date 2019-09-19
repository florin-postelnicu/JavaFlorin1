
/*
HangmanJ4 ,ConvertArrayList, listofwords.csv and SelectWord are the engine for HangmanJ6- the play machine
*/
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
class HangmanJ4 {

    private String word;
    Scanner scan = new Scanner(System.in);

    HangmanJ4() {
        SelectWord neword = new SelectWord();
        word = neword.get_a_new_Word();}

    private String getWord () {
        return word;
    }

    void Hange () {
        HangmanJ4 hang = new HangmanJ4();
//
//        Scanner scan = new Scanner(System.in);
        String str = hang.getWord();
        char[] chars = str.toCharArray();

        // String to characters array

        char[] memoryLane = new char[chars.length + 8];
        int index_memory = 0;

        for (int i = 0; i <= chars.length - 1; i++) {

            chars[i] = '*';
        }
//             System.out.println(str);

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
            if (!Arrays.toString(chars).contains("*")) {
                System.out.println("This is the word!");
                System.out.println(chars);
                System.out.println("Congrats!");
                new HangmanJ6();
            }
            if (!bull | Memory_Repeat(guess, memoryLane)) {

                count++;

                if (count >= 7) {
                    System.out.println("Bad !  Bad!   Bad!");
                    System.out.println(str);
                    new HangmanJ6();
                }
            }
            memoryLane[index_memory] = guess;
            index_memory++;

            System.out.println("You made Soooooo many mistakes   :" + count);

            System.out.println("Your memory's bellow !");

            System.out.println(memoryLane);

            System.out.println("That's the status of your work on the secret word :");
            System.out.println(chars);
        }
    }

    private static boolean Memory_Repeat ( char guesst, char[] aRRay){
        new HangmanJ4();
        for (int i = 0; i <= aRRay.length -1; i++) {
            if (aRRay[i] == guesst) {
                return true;
            }
        }
        return false;
    }
}
