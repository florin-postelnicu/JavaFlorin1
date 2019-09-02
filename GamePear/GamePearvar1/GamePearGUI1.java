

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
;
import javax.swing.JButton;
import javax.swing.JFrame;

class GamePearGUI  implements ActionListener {

    Game_Pear game_pear = new Game_Pear();


    GamePearGUI() {
        JFrame frame = new JFrame("Eddie's  Guessing Game ");
        frame.getContentPane().setLayout(new GridLayout(3, 3));


        JLabel label1 = new JLabel();
        label1.setText("COMMUNIQUE");
        label1.setBounds(10,10,10,10);


        JButton yes_g = new JButton("PLAY");
        JButton no_g = new JButton("NO");
        JButton less_g = new JButton("LOWER");
        JButton greater_g = new JButton("GREATER");
        JButton equal_g = new JButton("EQUAL");

        frame.add(yes_g);
        yes_g.addActionListener(event -> game_pear.Start_game());

        frame.add(no_g);
        no_g.addActionListener(event -> game_pear.Stop_Playing());

        frame.add(less_g);
        less_g.addActionListener(event -> game_pear.choose_less());

        frame.add(greater_g);
        greater_g.addActionListener(event -> game_pear.choose_greater());

        frame.add(equal_g);
        equal_g.addActionListener(event ->game_pear.choose_equal());

        JButton quit_g = new JButton("Quit");
        frame.add(quit_g);

        quit_g.addActionListener(event -> System.exit(0));

        JTextArea textArea = new JTextArea(50,50);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream);

        frame.add(textArea);
        frame.setSize(600, 300);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet");
    }



    }











class Test4 {
    public static void main(String[] args) {
       new GamePearGUI();

    }
}