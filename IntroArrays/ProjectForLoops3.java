

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
        public Employees(){

        }

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
            this.email = ename +"@mycompany.com";
            return email;
        }

        public static void main(String[] args) {
           Employees emp1 = new Employees("Caruso", "RealCaruso", "MayTrai",120634578);

           Employees emp2 = new Employees("Pavarotti", "Tenorro_DelMundo", "LucianoP", 321654789);

           Employees emp3 = new Employees("Silvia", "Silvia_Morriorty","Silva123*", 456123457);


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
                System.out.println("The Employee :" + unknown + "  has the  Password: " + diction.get(unknown).getEpassword());
                System.out.println("The Employee :" + unknown + "  has the  Username:   " + diction.get(unknown).getEuser());
                System.out.println("The Employee :" + unknown + "  has the  Phone number:  " + diction.get(unknown).getEphone());
                System.out.println("The Employee :" + unknown + "  has the  Email:   " + diction.get(unknown).getEmail());
            }
            else{
                System.out.println("Our company did not hire this guy!");
                System.out.println("\n Would you like to set an account him/her? Press y/n");
                char yesno = scan.next().charAt(0) ;
                if(yesno=='y')   {
                    Employees empy = new Employees();
                    empy.setEname(unknown);
                    Scanner scan1 = new Scanner(System.in)  ;
                    System.out.println("Enter user name for " + unknown);
                    String useremp = scan1.nextLine();
                    empy.setEuser(useremp);
                    
                    System.out.println("Enter Password for " + unknown);
                    String pass = scan1.nextLine();
                    empy.setEpassword(pass);
                    System.out.println("Enter Phone Number  for " + unknown);
                    int phon = scan1.nextInt();
                    empy.setEphone(phon);

                    listemp.add(empy) ;
                    diction.put(unknown, empy)  ;
                    empy.setEname(unknown);
                    System.out.println("The email for  "+ unknown +  "is  "+ empy.getEmail());
                }
                else{
                    System.out.println("Ok! I will see you next time! \n Have a nice day!");
                }

            }
        }
    }
}
