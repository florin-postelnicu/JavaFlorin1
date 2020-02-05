

import java.util.ArrayList;
import  java.util.HashMap;
import java.util.Scanner;
import java.io.*;


public class EmployeeProject1 {
    public boolean condition;

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
        public void CheckforEntry(boolean condition) throws Exception{
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Enter the Password :");
            String password =scan2.nextLine();
            boolean aspy = false;
            Employees emppa = new Employees();
            for(Employees emp: listemp){

                if(condition){

                    emppa = emp;
                    System.out.println(emppa.getEname());
                    aspy = true;
                }

            }
            if( aspy){
                System.out.println("Say Yeey!");
                System.out.println("The Employee :" + emppa.getEname() + "  has the  Password: " + diction.get(emppa.getEname()).getEpassword());
                System.out.println("The Employee :" + emppa.getEname() + "  has the  Username:   " + diction.get(emppa.getEname()).getEuser());
                System.out.println("The Employee :" + emppa.getEname() + "  has the  Phone number:  " + diction.get(emppa.getEname()).getEphone());
                System.out.println("The Employee :" + emppa.getEname() + "  has the  Email:   " + diction.get(emppa.getEname()).getEmail());
            }
            else{
                System.out.println("Not such a password");
            }

        }
        public static void CheckListOfEmployees() throws Exception {
            listemp = Employees.Listofemployeesfile();
            System.out.println(listemp.size());
            for( int en = 0; en <listemp.size(); en++){
            System.out.println(listemp.get(en).getEname());}
            Scanner scano = new Scanner(System.in);
            System.out.println("Choose one of the options bellow :");
            System.out.println("Press 1 for  name ");
            System.out.println("Press 2 for password ");
            System.out.println("Press 3 for phone number");
            System.out.println("Press 4 for  user name");
            int trythis = scano.nextInt();

            switch (trythis){
                case 1 :{
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
                    else {
                        System.out.println("Our company did not hire this guy!");
                        System.out.println("\n Would you like to set an account him/her? Press y/n");
                        char yesno = scan.next().charAt(0);
                        if (yesno == 'y') {
                            Employees empy = new Employees();
                            empy.setEname(unknown);
                            Scanner scan1 = new Scanner(System.in);
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

                        } else {
                            System.out.println("Ok! I will see you next time! \n Have a nice day!");
                        }
                    }
                }
                case 2:
                {


                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Enter the Password :");
                    String password =scan2.nextLine();
                    boolean aspy = false;
                    Employees emppa = new Employees();
                    for(Employees emp: listemp){
                        if(emp.epassword.equals(password)){

                            emppa = emp;
                            System.out.println(emppa.getEname());
                            aspy = true;
                        }

                    }
                    if( aspy){
                        System.out.println("Say Yeey!");
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Password: " + diction.get(emppa.getEname()).getEpassword());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Username:   " + diction.get(emppa.getEname()).getEuser());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Phone number:  " + diction.get(emppa.getEname()).getEphone());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Email:   " + diction.get(emppa.getEname()).getEmail());
                    }
                    else{
                        System.out.println("Not such a password");
                    }

                }
                case 3:{
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Enter the User Name :");
                    String userp =scan2.nextLine();
                    boolean aspy = false;
                    Employees emppa = new Employees();
                    for(Employees emp: listemp){
                        if(emp.euser.equals(userp)){

                            emppa = emp;
                            System.out.println(emppa.getEname());
                            aspy = true;
                        }

                    }
                    if( aspy){
                        System.out.println("Say Yeey!");
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Password: " + diction.get(emppa.getEname()).getEpassword());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Username:   " + diction.get(emppa.getEname()).getEuser());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Phone number:  " + diction.get(emppa.getEname()).getEphone());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Email:   " + diction.get(emppa.getEname()).getEmail());
                    }
                    else{
                        System.out.println("Not such a password");
                    }

                }
                case 4:
                {
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Enter the Phone Number :");
                    String phonep =scan2.nextLine();
                    boolean aspy = false;
                    Employees emppa = new Employees();
                    for(Employees emp: listemp){
                        if(emp.ephone.equals(phonep)){

                            emppa = emp;
                            System.out.println(emppa.getEname());
                            aspy = true;
                        }

                    }
                    if( aspy){
                        System.out.println("Say Yeey!");
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Password: " + diction.get(emppa.getEname()).getEpassword());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Username:   " + diction.get(emppa.getEname()).getEuser());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Phone number:  " + diction.get(emppa.getEname()).getEphone());
                        System.out.println("The Employee :" + emppa.getEname() + "  has the  Email:   " + diction.get(emppa.getEname()).getEmail());
                    }
                    else{
                        System.out.println("Not such a password");
                    }

                }
                }

            }

        }



        public static void main(String[] args) throws Exception {
            Employees.CheckListOfEmployees();



        }}




