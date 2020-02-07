
import java.util.ArrayList;
import  java.util.HashMap;
import java.util.Scanner;
import java.io.*;


public class Employees4 {


    public static class  Employees {
        String ename;
        String euser;
        String epassword;
        public String email;
        String ephone;

        public static ArrayList<Employees> listemp = new ArrayList<>();
        public static String[] keywords = {"name", "user", "password","phone" };
        public static HashMap<String, Employees> diction = new HashMap<>();
        public Employees(){

        }
        public Employees(String name, String user, String password, String phone){
            this.ename = name;
            this.euser = user;
            this.epassword = password;
            this.ephone = phone;
        }

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

        public String getEmail() {
            this.email = ename +"@mycompany.com";
            return email;
        }

        public static ArrayList<Employees>Listofemployeesfile() throws Exception {
            FileReader fileReader = new FileReader("C://Users//postelnicu//IdeaProjects//MoreVectorsLists//src//ListEmployees.txt");
            Scanner scanner = new Scanner(new BufferedReader(fileReader));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" {3}");
                Employees personnel = new Employees(line[0], line[1], line[2], line[3]);
                Employees.listemp.add(personnel);
                Employees.diction.put(line[0], personnel);
            }
            return listemp;
        }
        public static void FileWriteEmps(Employees employee) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C://Users//postelnicu//IdeaProjects//MoreVectorsLists//src//ListEmployees.txt"),true));
            bufferedWriter.newLine();
            String stringBuilder = employee.ename +
                    "   " +
                    employee.euser +
                    "   " +
                    employee.epassword +
                    "   " +
                    employee.ephone;
            bufferedWriter.write(stringBuilder);
            bufferedWriter.close();
        }

        public static void DisplayData(Employees e){
            System.out.println("The Employee :" + e.ename + "  has the  Password: " + e.getEpassword());
            System.out.println("The Employee :" + e.ename + "  has the  Username:   " + e.getEuser());
            System.out.println("The Employee :" + e.ename + "  has the  Phone number:  " + e.getEphone());
            System.out.println("The Employee :" + e.ename + "  has the  Email:   " + e.getEmail());

        }

        public static void Continue() throws IOException {
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Our company did not have the person registered!");
            System.out.println("\n Would you like to set an account  for him/her? Press y/n");
            char yesno = scan2.next().charAt(0);
            if (yesno == 'y') {
                EnterEmployee();
            } else {
                System.out.println("Ok! I will see you next time! \n Have a nice day!");
            }
        }

        public static String EnterData(int i){
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Enter the  " + keywords[i]);
            return scan2.nextLine();
        }

        public static void EnterEmployee() throws IOException {
            String unknown;
            Employees empy = new Employees();
            System.out.println("Enter Employee's name");
            Scanner scan1 = new Scanner(System.in);
            unknown = scan1.nextLine();
            empy.setEname(unknown);

            System.out.println("Enter user name for " + unknown);
            String useremp = scan1.nextLine();
            empy.setEuser(useremp);

            System.out.println("Enter Password for " + unknown);
            String pass = scan1.nextLine();
            empy.setEpassword(pass);
            System.out.println("Enter Phone Number  for " + unknown);

            String phon = scan1.nextLine();
            empy.setEphone(phon);

            listemp.add(empy);
            diction.put(unknown, empy);
            empy.setEname(unknown);
            System.out.println("The email for  " + unknown + "is  " + empy.getEmail());
            Employees.FileWriteEmps(empy);


        }
        public static void CheckListOfEmployees() throws Exception {

            listemp = Employees.Listofemployeesfile();
            Scanner scano = new Scanner(System.in);
            System.out.println("Choose one of the options bellow :");
            System.out.println("Press 1 for  name ");
            System.out.println("Press 2 for user name ");
            System.out.println("Press 3 for password");
            System.out.println("Press 4 for  phone");

            int trythis = scano.nextInt();

            switch (trythis){
                case 1 :
                {
                    String name = EnterData(0);
                    boolean spy  = false;
                    Employees  emppa = new Employees();
                    for( Employees emp : listemp){
                        if( name.equals(emp.getEname()) ){
                            spy = true;
                            emppa = emp;
                        }
                    }
                    if( spy) {
                        Employees.DisplayData(emppa);
                    }
                    else {
                        Continue();
                    }
                    break;
                }
                case 2:
                {
                    String user = EnterData(1);

                    boolean spy  = false;
                    Employees emppa = new Employees();
                    for( Employees emp : listemp){
                        if( user.equals(emp.getEuser()) ){
                            spy = true;
                            emppa = emp;
                        }
                    }
                    if( spy) {
                        Employees.DisplayData(emppa);
                    }
                    else {
                        Continue();
                    }
                    break;
                }
                case 3:{
                    String password = EnterData(2);
                    boolean spy  = false;
                    Employees emppa = new Employees();
                    for( Employees emp : listemp){
                        if( password.equals(emp.getEpassword()) ){
                            spy = true;
                            emppa = emp;
                        }
                    }
                    if( spy) {
                        Employees.DisplayData(emppa);
                    }
                    else {
                        Continue();
                    }
                    break;
                }
                case 4: {
                    String phone = EnterData(3);
                    boolean spy  = false;
                    Employees emppa = new Employees();
                    for( Employees emp : listemp){
                        if( phone.equals(emp.getEphone()) ){
                            spy = true;
                            emppa = emp;
                        }
                    }
                    if( spy) {
                        DisplayData(emppa);
                    }
                    else {
                        Continue();
                    }
                    break;
                }
                default:
                {
                    System.out.println("You should use on of the numbers in the list : 1, 2, 3, 4 ");
                }
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Employees.CheckListOfEmployees();
    }}




