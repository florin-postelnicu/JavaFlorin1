/*
The computer would guess your number.
Choose an integer between min and max - 1
 */



class Game_Pear {

    private int min ;
    private int max ;
    private int computer_guess;
    private int count ;

    // constructor for initial values

    Game_Pear(){
        initGAME();
    }

    //Method for initial attributes

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

    private int getMax() {
        return max;
    }
    private int getMin() {
        return min;
    }
    private int Computer_Guess(int low, int high) {
        return low + (high - low) / 2;
    }

    // Start the game method

    void Start_game() {
        System.out.println("Do you want to play? ");
        Game_Pear start = new Game_Pear();// using constructor to instantiate a new game
        start.Keep_Playing();
        }


    void Stop_Playing(){
        System.out.println("Bye Bye!");
        System.exit(0);
    }

    void choose_less(){
        Your_guess_is("high");
        setMax(computer_guess);
        Keep_Playing();
    }
    void choose_greater() {
        Your_guess_is("low");
        setMin(computer_guess);
        Keep_Playing();
    }
    void choose_equal(){
        System.out.println("This is your number :" + computer_guess);
        System.out.println("Congrats!!");
        Start_game();

    }


    // Keep playing Method

    void Keep_Playing() {

        computer_guess = Computer_Guess(getMin(), getMax());
        System.out.println(computer_guess);
        System.out.println("Is your choice lower(l), higher(h), or equal(e) to the computer's guess  : " + computer_guess + "   Enter the answer between () ");
        count++;
    }

    void Your_guess_is(String bearing) {
        System.out.println("Sorry Master, maybe  next time! Keep trying!It seems that Eddie's guess was " + bearing +"\n\tEddie has guessed :" + count + "\ttime(s)");
    }
}


