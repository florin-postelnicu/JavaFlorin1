

public class ProjectArray3 {

    public static void main(String[] args) {
        char[] aword = {'d','e','c','a','f','f', 'e','i','n','a','t','e','d'};
        char[] newword = new char[2];

        System.arraycopy(aword, 4, newword, 0, 2);
        System.out.println(new String(newword));

        String[] students = {"Leonardo", "Michelangelo", "Ruben", "Picasso", "Matisse"};
        for(int index = 0; index < students.length; index ++){
            System.out.println(students[index]+"@myCompanyEmail" +"   Come quickly to the Expo with 10 pieces!");
        }
    }
}
