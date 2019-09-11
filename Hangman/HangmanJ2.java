

import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
public class HangmanJ2 {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = "hangmanGame";

        // String to characters array

        char[] chars = str.toCharArray();


        for (int i = 0; i <= chars.length - 1; i++) {

            chars[i] = '*';
        }


        System.out.println(str);

        System.out.println(chars);
//        System.out.println(Arrays.toString(chars));
//
//
//        System.out.println(Arrays.toString(chars).indexOf("*"));
        boolean isExists = true;
        int count = 0;





        while (isExists) {
//            boolean itExists;
            boolean bull = false;



            // Enter a character
            System.out.println("Enter a new letter : ");

            char guess = scan.next().charAt(0);






            for (int i = 0; i <= chars.length - 1; i++) {

//                char letter = chars1[i];

                if (guess == str.charAt(i)) {
                    chars[i] = guess;
                    bull = true;
                }
            }

            if(!Arrays.toString(chars).contains("*")){
                System.out.println("This is the word! Congrats!");
                System.exit(0);
            }
            if(!bull ){
                count++;
                if(count >= 7){
                    System.out.println("Bad !  Bad1   Bad!");
                   System.exit(0);

                }
            }
//            isExists = bull;



            System.out.println(chars);

        }

        System.exit(0);



    }


}

