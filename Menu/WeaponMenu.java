
import java.util.Scanner;
public class WeaponMenu {
    public String weapon1;


    public String weaponMenu() {
        String weapon_of_choice = "Rough Stones";
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();


        switch (index) {
            case 1:
                weapon_of_choice = "Spade";
                System.out.println("Your weapon is " + weapon_of_choice);
                setWeapon(weapon_of_choice);
                break;

            case 2:
                weapon_of_choice = "Ax";
                System.out.println("Your weapon is " + weapon_of_choice);
                setWeapon(weapon_of_choice);
                break;
            case 3:
                weapon_of_choice = "Spear";
                System.out.println("Your weapon is " + weapon_of_choice);
                setWeapon(weapon_of_choice);
                break;
            case 4:
                weapon_of_choice = "Bow and Arrows";
                System.out.println("Your weapon is " + weapon_of_choice);
                setWeapon(weapon_of_choice);
                break;
            case 5 :
                weapon_of_choice = "Fire of Hell";
                System.out.println("Your weapon is " + weapon_of_choice);
                setWeapon(weapon_of_choice);
                break;
            case 6:
                weapon_of_choice = "Jumanhajil Balhal";
                System.out.println("Your weapon is " + weapon_of_choice);
                setWeapon(weapon_of_choice);
                break;



            default:
                System.out.println("Your weapon is " + weapon_of_choice);
                weapon_of_choice = "Rough Stone";
                setWeapon("A bunch of rough stones");
        }

        return weapon_of_choice;
    }
    public void setWeapon(String weapon){
        weapon1 = weapon;
    }
    public String getWeapon(){
        return weapon1;
    }
    public void display_weapons(){
        System.out.println("Weapons available :");
        System.out.println(" 1  Spade");
        System.out.println(" 2  Axe");
        System.out.println(" 3  Spear");
        System.out.println(" 4  Bow and  Arrows  ");
        System.out.println(" 5  Fire of Hell");
        System.out.println(" 6 Jumanhajil Balhal");
        System.out.println(" Stones  - If you do not know numbers!");
        System.out.println("Your weapon_of_choice Is:");
    }

}