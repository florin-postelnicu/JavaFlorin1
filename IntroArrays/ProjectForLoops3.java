

import java.util.ArrayList;
import  java.util.HashMap;
import java.util.Scanner;

public class ProjectForLoops3 {

    public static class  Employees {
        String ename;
        String euser;
        String epassword;
        public String email;
        int ephone;
        public static ArrayList<Employees> listemp = new ArrayList<>();

        public Employees(String name, String user, String password, int phone){
            this.ename = name;
            this.euser = user;
            this.epassword = password;
            this.ephone = phone;
            listemp.add(this);
            diction.put(this.ename, this );
        }

        public static HashMap<String, Employees> diction = new HashMap<>();

        public String getEname() {
            return ename;
        }

        public String getEpassword() {
            return epassword;
        }
        public String getEuser(){
            return euser;
        }

        public int getEphone() {
            return ephone;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setEpassword(String epassword) {
            this.epassword = epassword;
        }

        public void setEuser(String euser) {
            this.euser = euser;
        }

        public void setEphone(int ephone) {
            this.ephone = ephone;
        }

        public void setEmail(String ename){

            this.email = ename +"@mycompany.com";
        }

        public String getEmail() {
            return email;
        }

        public static void main(String[] args) {
           Employees emp1 = new Employees("Caruso", "RealCaruso", "MayTrai",120634578);

           Employees emp2 = new Employees("Pavarotti", "Tenorro", "LucianoP", 321654789);

           Employees emp3 = new Employees("Silvianus", "SilvaMdres","Silva123*", 456123457);


           emp1.setEmail(emp1.ename);
            System.out.println(emp1.getEmail());
            for( int i = 0; i<listemp.size(); i++){
                System.out.println("Name of emp : " + listemp.get(i).getEname() + "  with password :"+ listemp.get(i).getEpassword());
            }
            for(int j = 0; j< diction.size(); j++){
                String Name = listemp.get(j).ename;
                String Password = diction.get(Name).getEpassword();
                System.out.println("Name of emp from dictionary :" +Name + "  the  password  is" + Password);
            }

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the person's name to hey his Password ");
            String unknown =scan.nextLine();
            boolean spy  = false;
            for( Employees emp : listemp){
            if( unknown.equals(emp.ename) ){
                spy = true;
            }
            }
            if( spy){
                System.out.println("For Name :" + unknown + "  has the  Password " + diction.get(unknown).getEpassword());
            }
            else{
                System.out.println("Our company did not hire this guy!");
            }
        }
    }
}
