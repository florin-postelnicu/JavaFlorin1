
/*
The computer would guess your number.
Choose an integer between min and max - 1
 */



class Game_Pear {
    public String msg = "Press Yes to play";

   private int min ;
   private int max ;
    public int computer_guess;
    public int count ;

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

    public int getMax() {
        return max;
    }
   public int getMin() {
        return min;
    }
   public int Computer_Guess(int low, int high) {
        return low + (high - low) / 2;
    }

    // Start the game method

    void Start_game() {

        msg = "Press YES to play";
        Display();
        Game_Pear start = new Game_Pear();// using constructor to instantiate a new game
        start.Keep_Playing();
    }


    void Stop_Playing(){
        msg = "Thank you ! Bye - Bye!";
        Display();
        System.exit(0);

    }

    void choose_less(){
        count++;

        msg = "Your choice was higher";
        Display();
        setMax(computer_guess);
        Keep_Playing();
    }
    void choose_greater() {

        count++;
        msg = "Your choice was lower";
        Display();
        setMin(computer_guess);
        Keep_Playing();
    }
    void choose_equal(){
        count++;
        msg = "Congrats this is the number " + computer_guess;
        Display();
        Start_game();

    }
    void  Display(){
        System.out.println(msg);

    }


    // Keep playing Method

    void Keep_Playing() {

        computer_guess = Computer_Guess(getMin(), getMax());
        msg = "Is your choice LOWER, HIGHER , or EQUAL to the computer's guess  : " + computer_guess + " there are "+ count +" questions";
        Display();
    }


}


