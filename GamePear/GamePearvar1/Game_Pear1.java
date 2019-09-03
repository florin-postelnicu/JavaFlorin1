
/*
The computer would guess your number.
Choose an integer between min and max - 1
 */



class Game_Pear {
    public String msg ="Guess a number between 1 and 1000. PLAY";

   private int min ;
   private int max ;
   private int computer_guess;
    public int count ;

    // constructor for initial values

    public Game_Pear(){
        initGAME();
    }

    //Method for initial attributes

    private void initGAME() {
        min = 1;
        max = 1025;
        count = 1;
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

        msg = "Good Luck guessing the computer's choice, an integer between 1 and 1000";
        Display();
        min = 1;
        max = 1025;
        count = 1;
        computer_guess= Computer_Guess(getMin(), getMax());
        Keep_Playing();
    }


    void Stop_Playing(){
        msg = "Thank you ! Bye - Bye!";
        Display();
        System.exit(0);

    }

    void choose_less(){
        count++;

        msg = "You chose LOWER than :" + computer_guess;
        Display();
        setMax(computer_guess);
        Keep_Playing();
    }
    void choose_greater() {

        count++;
        msg = "You chose GREATER than :" + computer_guess;
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
//
        System.out.println(msg);;

    }

    // Keep playing Method

    private void Keep_Playing() {

        computer_guess = Computer_Guess(getMin(), getMax());
        msg = "Is your choice LOWER, HIGHER , or EQUAL to the computer's guess  : " + computer_guess + "? "+ count +" questions ";
        Display();
    }


}


