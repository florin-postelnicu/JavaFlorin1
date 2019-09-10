

import java.util.Scanner;
import java.lang.*;
public class HangmanJ1 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = "hangmanGame";

        // String to characters array

        char[] chars = str.toCharArray();
        System.out.println(chars.length);

        char[] new_word = chars;

        for (int i = 0; i <= chars.length - 1; i++) {

            new_word[i] = '*';
        }


        System.out.println(str);

        System.out.println(new_word);

        boolean isExists = new_word.toString().indexOf("*")!= 0;

        while (isExists){

            // Enter a character
            System.out.println("Enter a new letter : ");

            char guess = scan.next().charAt(0);

            char[] chars1 = str.toCharArray();


            for (int i = 0; i <= chars.length - 1; i++) {

                char letter = chars1[i];

                if (guess == letter) {
                    new_word[i] = guess;

                } else {
                    continue;
                }
            }


            System.out.println(new_word);


//
        }
    }
}
