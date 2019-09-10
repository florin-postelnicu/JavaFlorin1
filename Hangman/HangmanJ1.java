

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
        System.out.println(new_word.toString());


        System.out.println(new_word.toString().indexOf("*"));
        boolean isExists = true;
        int count = 0;



        while (isExists) {
//            boolean itExists;



            // Enter a character
            System.out.println("Enter a new letter : ");

            char guess = scan.next().charAt(0);





            for (int i = 0; i <= chars.length - 1; i++) {

//                char letter = chars1[i];

                if (guess == str.charAt(i)) {
                    new_word[i] = guess;

                }
                if('*' == new_word [i]){
                    isExists = true;
                    continue;
                }else{
                    isExists = false;}
//

            }


            System.out.println(new_word);

        }

        System.exit(0);



    }


}


