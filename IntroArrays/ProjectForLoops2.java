



import java.util.ArrayList;
import java.util.HashMap;

public class ProjectForLoops2 {
    public static class Personnel {
        String Pname;
        int Page;
        int Pphone;
        String pswrd;
        public Personnel(String name, int age, int phone, String password){
            this.Pname= name;
            this.Page = age;
            this.Pphone = phone;
            this.pswrd = password;

        }

    }


    public static ArrayList<Personnel> listofemployes = new ArrayList<>();
    /* This is how to declare HashMap , or Dictionary in Java*/
    public static HashMap<String, Personnel> hmap = new HashMap<>();



    public static void main(String[] args) {
        Personnel employes1 = new Personnel("Strat", 27, 22206, "Spheres03#.");

        Personnel employes2 = new Personnel("Calisto", 35, 33291, "untilthen*.!");
        Personnel employes3 = new Personnel("Artas", 33, 40412, "remember!3");
        listofemployes.add(employes1);
        listofemployes.add(employes2);
        listofemployes.add(employes3);

        // this is how to build a hashmap with Pname as key and the corresponding employe as value
        for( int i = 0; i < listofemployes.size(); i++){
            hmap.put(listofemployes.get(i).Pname, listofemployes.get(i));



            for(int j= 0; j< listofemployes.size(); j++ ){
                try{
                    System.out.println(listofemployes.get(j).Pname + "    "+ listofemployes.get(j).Page);
                }
                catch(Exception e){
                    System.out.println(e.fillInStackTrace());
                }
                if(listofemployes.get(j).Pname.equals("Calisto")){
                    System.out.println("Calisto's password is :" + listofemployes.get(j).pswrd);
                    System.out.println(" and I will change it to Krusk!");
                    listofemployes.get(j).pswrd = "Krusk!";

                }
            }

            System.out.println("The Proof");

        }

        System.out.println("New password for Calisto  :" + hmap.get("Calisto").pswrd);

    }}