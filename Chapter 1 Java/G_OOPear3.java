/*
The computer would guess your number.
Choose an integer between 1 and 1000
 */


import org.jetbrains.annotations.Contract;

import java.util.Scanner;

 class G_OOPear3 {


     private int min ;
     private int max ;
     private int computer_guess;
     private int count ;


     // constructor for initial values
     G_OOPear3(){
         initGAME();
     }

     private void initGAME() {
         min = 1;
         max = 1025;
         count = 0;
         computer_guess= Computer_Guess(getMin(), getMax());
     }

    // Setters

    private void setMax(int a) {
        this.max = a;
    }
    private void setMin(int b) {
        this.min = b;
    }

    // Getters

    @Contract(pure = true)
    private int getMax() {
        return max;
    }
    @Contract(pure = true)
    private int getMin() {
        return min;
    }
    @Contract(pure = true)
    private int Computer_Guess(int low, int high) {
        return low + (high - low) / 2;
    }

    void Start_game() {
        System.out.println("Do you want to play? Y\\N");
        Scanner scan = new Scanner(System.in);
        String answer = scan.next();
        if (answer.equals("y")) {
            G_OOPear3 start = new G_OOPear3();// using constructor to instantiate a new game
            start.Keep_Playing();
        } else {

            System.out.println("Bye - Bye !");
        }
    }

    private void Keep_Playing() {

        computer_guess = Computer_Guess(getMin(), getMax());
        System.out.println(computer_guess);
        System.out.println("Is your choice lower(l), higher(h), or equal(e) to the computer's guess  : "
                + computer_guess + "   Enter the answer between () ");
        count++;
        Scanner scan = new Scanner(System.in);
        String my_guess = scan.next();
        if (my_guess.equals("e")) {
            System.out.println("This is your number :" + computer_guess);
            System.out.println("Congrats!!");
            Start_game();
        } else {
            if (my_guess.equals("h")) {
                Your_guess_is("low");
                setMin(computer_guess);

            } else {
                if (my_guess.equals("l")) {
                    Your_guess_is("high");
                    setMax(computer_guess);

                } else {
                    System.out.println("You enter a wrong sign. Please try again");
                }
            }
            Keep_Playing();
            }
        }

    private void Your_guess_is(String bearing) {
        System.out.println("Sorry Master, maybe  next time! Keep trying!It seems that Eddie's guess was " + bearing +"\n\tEddie has guessed :" + count + "\ttime(s)");
    }
}

class Test_Game2 {

    public static void main(String[] args) {
        G_OOPear3 game = new G_OOPear3();
        game.Start_game();


    }
}


