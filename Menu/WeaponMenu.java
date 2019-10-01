
import java.util.Scanner;
public class WeaponMenu {
    public String weapon;


    public String weaponMenu() {
        String weapon_of_choice = "Rough Stones";
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();


        switch (index) {
            case 1:
                weapon_of_choice = "Spade";
                System.out.println("Your weapon is " + weapon_of_choice);
                break;

            case 2:
                weapon_of_choice = "Ax";
                System.out.println("Your weapon is " + weapon_of_choice);
                break;

            default:
                System.out.println("Your weapon is " + weapon_of_choice);
                weapon_of_choice = "Rough Stone";
        }

        return weapon_of_choice;
    }
    public void setWeapon(){
        weapon = weaponMenu();
    }

}