

public class CheckPalindrome {

    int number;

    public int ZPalindrome(int Znumber){
        this.number = Znumber;

    String st = String.valueOf(this.number);
    char[] list = st.toCharArray();

    return CheckPoly(list);
    }
    public int CheckPoly (char[] newList1) {
        int santinel = 0;

        for (int i = 0; i <= newList1.length / 2; i++) {
            if (newList1[i] != newList1[newList1.length - 1 - i]) {
                santinel = 1;
                break;
            }
        }
        return santinel;
    }
}
