import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

class GUI4Pear  implements ActionListener {


     String bearing;
     Game_Pear game_pear = new Game_Pear();

     GUI4Pear() {

         JLabel label1 = new JLabel();
         label1.setText("COMMUNIQUE");
         label1.setBounds(10,10,200,30);

         JFrame frame = new JFrame("Eddie's  Guessing Game ");
         frame.getContentPane().setLayout(new GridLayout(3, 3));
         JTextField textfield1 = new JTextField("", 20);
         textfield1.setBounds(50,250,100,100);

         JButton yes_g = new JButton("YES");
         JButton no_g = new JButton("NO");
         JButton less_g = new JButton("Less");
         JButton greater_g = new JButton("Greater");
         JButton equal_g = new JButton("Equal");

         frame.add(yes_g);
         yes_g.addActionListener(event -> game_pear.Start_game());

         frame.add(no_g);
         no_g.addActionListener(event -> game_pear.Stop_Playing());

         frame.add(less_g);
         less_g.addActionListener(event -> game_pear.choose_less())
         ;
         frame.add(greater_g);
         greater_g.addActionListener(event -> game_pear.choose_greater());

         frame.add(equal_g);
         equal_g.addActionListener(event ->game_pear.choose_equal());

         JButton quit_g = new JButton("Quit");
         frame.add(quit_g);
         quit_g.addActionListener(event -> System.exit(0));


         frame.add(label1);
         frame.add(textfield1, BorderLayout.SOUTH);
         frame.setSize(600, 300);
         frame.pack();
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


         }
         public void actionPerformed(ActionEvent e) {
         throw new UnsupportedOperationException("Not supported yet");
         }
 }
class Test3 {
    public static void main(String[] args) {
        GUI4Pear gamelon = new GUI4Pear();
    }
}
