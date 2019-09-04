


import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;

class GamePearGUI  implements ActionListener {

    Game_Pear1 game_pear = new Game_Pear1();


    GamePearGUI() {
        JFrame frame = new JFrame("Eddie's  Guessing Game ");
        JPanel panel = new JPanel();
        frame.getContentPane().setLayout(new FlowLayout());


        JLabel label1 = new JLabel();
        label1.setText("COMMUNIQUE");
//        label1.setBounds(10,10,10,10);


        JButton yes_g = new JButton("PLAY");
//        yes_g.setBounds(10,10,20,10);
        JButton no_g = new JButton("CLEAR ");
//        no_g.setBounds(31,10,20,10);
        JButton less_g = new JButton("LOWER");
//        less_g.setBounds(52,10,20,10);
        JButton greater_g = new JButton("GREATER");
//        greater_g.setBounds(52, 21,20,10);
        JButton equal_g = new JButton("EQUAL");
//        equal_g.setBounds(52, 32, 20, 10);
        JButton quit_g = new JButton("Quit");
//        quit_g.setBounds(10,21,60,10);

        JTextArea textArea = new JTextArea(25,60);

        // This is the scrolling feature of the textArea
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroller);
        textArea.setFont(new Font("Serif", Font.BOLD,  24));


        PrintStream standardOut = System.out;

        frame.add(yes_g);
        yes_g.addActionListener(event -> game_pear.Start_game());

        frame.add(no_g);

        // This is the CLEAR Button
        no_g.addActionListener(evt -> {
            // clears the text area
            try {
                textArea.getDocument().remove(0,
                        textArea.getDocument().getLength());
                standardOut.println("Text area cleared");
                game_pear.Start_game();

            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        } );
// End of the CLEAR procedure
        frame.add(less_g);
        less_g.addActionListener(event -> game_pear.choose_less());

        frame.add(greater_g);
        greater_g.addActionListener(event -> game_pear.choose_greater());

        frame.add(equal_g);
        equal_g.addActionListener(event ->game_pear.choose_equal());


        frame.add(quit_g);

        quit_g.addActionListener(event -> System.exit(0));

        // The next three lines redirect the console's print to the JTextArea
        
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream);
// ******
        frame.getContentPane().add(scroller);
        frame.add(panel);
        frame.add(label1);
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
