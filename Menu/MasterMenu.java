import java.util.Scanner;


public class MasterMenu {
    public static void main(String[] args) {
        MasterMenu.display_things();


        while (true) {

            Scanner scan = new Scanner(System.in);
            boolean keepatit = true;
            int decision = scan.nextInt();
            switch (decision) {
                case 1:
                    WeaponMenu wm = new WeaponMenu();
                    System.out.println("Weapons available :");
                    System.out.println(" 1  Spade");
                    System.out.println(" 2  Ax");
                    System.out.println(" Stones");
                    System.out.println("Your weapon_of_choice Is:");
                    wm.weaponMenu();
                    System.out.println("Thank you ");
                    MasterMenu.display_things();

                    break;
                case 2:
                    System.out.println("Game Over!");
                    System.exit(0);
                    break;
                case 3:
                    System.out.println("Maybe other time y/ n if you want to play more");
                    char kai = scan.next().charAt(0);
                    if (kai != 'y'){
                        keepatit = false;
                    }
                    MasterMenu.display_things();

                    break;

                default:
                    System.out.println("You should make a valid choice 1-2-3");


            }
        }


    }
    public static void display_things(){
        System.out.println("This is the Master Menu");
        System.out.println("Press 1 for Weapons");
        System.out.println("Press 2 for Quit");
        System.out.println("Press 3 for something");
    }

}