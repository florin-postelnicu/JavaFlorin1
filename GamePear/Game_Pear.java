/*
The computer would guess your number.
Choose an integer between min and max - 1
 */



class Game_Pear {
    public String msg = "Press Yes to play";

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
        String msg = "Do you want to play? ";
        Display("Press YES to play");
        Game_Pear start = new Game_Pear();// using constructor to instantiate a new game
        start.Keep_Playing();
        }


    void Stop_Playing(){
        Display("Thank you ! Bye - Bye!");
        System.exit(0);

    }

    void choose_less(){

        Display("Your choice was higher");
        setMax(computer_guess);
        Keep_Playing();
    }
    void choose_greater() {

        Display("Your choice was lower");
        setMin(computer_guess);
        Keep_Playing();
    }
    void choose_equal(){
        Display("Congrats this is the number " + computer_guess);
        Start_game();

    }
    String Display(String msg){
        System.out.println(msg);
        return msg;
    }


    // Keep playing Method

    void Keep_Playing() {

        computer_guess = Computer_Guess(getMin(), getMax());
        Display("Is your choice LOWER, HIGHER , or EQUAL to the computer's guess  : " + computer_guess + " ?");
    }


}


