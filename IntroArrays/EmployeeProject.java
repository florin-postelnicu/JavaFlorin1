

import java.util.ArrayList;
import  java.util.HashMap;
import java.util.Scanner;
import java.io.*;


public class EmployeeProject {

    public static class  Employees {
        String ename;
        String euser;
        String epassword;
        public String email;
        String ephone;
        public static ArrayList<Employees> listemp = new ArrayList<>();
        public Employees(){



        }

        public Employees(String name, String user, String password, String phone){
            this.ename = name;
            this.euser = user;
            this.epassword = password;
            this.ephone = phone;
            listemp.add(this);
            diction.put(this.ename, this );
        }
        public void setList() throws Exception {
            for( Employees emps : Listofemployeesfile()){
                this.ename = emps.getEname();
                this.euser = emps.getEuser();
                this.epassword = emps.getEpassword();
                this.ephone = emps.getEphone();
                listemp.add(this) ;
                diction.put(this.ename, this)  ;

            }
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

        public String getEphone() {
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

        public void setEphone(String ephone) {
            this.ephone = ephone;
        }

        public void setEmail(String ename){

            this.email = ename +"@mycompany.com";
        }

        public String getEmail() {
            this.email = ename +"@mycompany.com";
            return email;
        }


        public static ArrayList<Employees>Listofemployeesfile() throws Exception {
            FileReader fileReader = new FileReader("C://Users//postelnicu//IdeaProjects//MoreVectorsLists//src//ListEmployees.txt");
            Scanner scanner = new Scanner(new BufferedReader(fileReader));


            while (scanner.hasNextLine()) {

                String[] line = scanner.nextLine().split("   ");

                Employees personnel = new Employees(line[0], line[1], line[2], line[3]);
                Employees.listemp.add(personnel);
                Employees.diction.put(line[0], personnel);

            }
            return listemp;
        }
        public static void FileWriteEmps(Employees employee) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C://Users//postelnicu//IdeaProjects//MoreVectorsLists//src//ListEmployees.txt"),true));
            bufferedWriter.newLine();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(employee.ename);
            stringBuilder.append("   ");
            stringBuilder.append(employee.euser);
            stringBuilder.append("   ");
            stringBuilder.append(employee.epassword);
            stringBuilder.append("   ");
            stringBuilder.append(employee.ephone);
            bufferedWriter.write(stringBuilder.toString());

            bufferedWriter.close();

        }



        public static void main(String[] args) throws Exception {
            listemp = Employees.Listofemployeesfile()  ;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the person's name to get his Password ");
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
                System.out.println("This is not our employee!");
                System.out.println("\n Would you like to set an account for this person? Press y/n");
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
                    String phon = scan1.nextLine();
                    empy.setEphone(phon);

                    listemp.add(empy) ;
                    diction.put(unknown, empy)  ;
//                     empy.setEname(unknown);
                    System.out.println("The email for  "+ unknown +  "is  "+ empy.getEmail());
                    Employees.FileWriteEmps(empy);

                }
                else{
                    System.out.println("Ok! I will see you next time! \n\t Have a nice day!");
                }
            }
        }
    }
}



