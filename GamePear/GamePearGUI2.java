

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;

class GamePearGUI  implements ActionListener {

    Game_Pear1 game_pear = new Game_Pear1();


    GamePearGUI() {
        UIManager.put("ToggleButton.select", new Color(52, 190, 126));
        JFrame frame = new JFrame("Eddie's  Guessing Game ");
        JPanel panel = new JPanel();
        frame.getContentPane().setLayout(new FlowLayout());


        JLabel label1 = new JLabel();
        label1.setText("COMMUNIQUE");
//        label1.setBounds(10,10,10,10);

        ButtonGroup buttonGroup = new ButtonGroup();


        JToggleButton yes_g = new JToggleButton("PLAY");
        yes_g.setBounds(10,10,20,10);
       JToggleButton no_g = new JToggleButton("CLEAR ");
        no_g.setBounds(31,10,20,10);
        JToggleButton less_g = new JToggleButton("LOWER");
        less_g.setBounds(52,10,20,10);
        JToggleButton greater_g = new JToggleButton("GREATER");
        greater_g.setBounds(52, 21,20,10);
        JToggleButton equal_g = new JToggleButton("EQUAL");
        equal_g.setBounds(52, 32, 20, 10);
        JToggleButton quit_g = new JToggleButton("Quit");
        quit_g.setBounds(10,21,60,10);

        JTextArea textArea = new JTextArea(26,50);
        textArea.setBounds(10, 50, 200, 200);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Serif", Font.BOLD, 20));
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroller);

//


//        frame.add(yes_g);
        yes_g.addActionListener(event -> game_pear.Start_game());
//
//        frame.add(no_g);
        PrintStream standardOut = System.out;
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

//        frame.add(less_g);
        less_g.addActionListener(event -> game_pear.choose_less());

//        frame.add(greater_g);
        greater_g.addActionListener(event -> game_pear.choose_greater());

//         frame.add(equal_g);
        equal_g.addActionListener(event ->game_pear.choose_equal());


//        frame.add(quit_g);

        quit_g.addActionListener(event -> System.exit(0));



        buttonGroup.add(yes_g);
        buttonGroup.add(less_g);
        buttonGroup.add(greater_g);
        buttonGroup.add(equal_g);
        buttonGroup.add(no_g);
        buttonGroup.add(quit_g);



        panel.add(yes_g);
        panel.add(less_g);
        panel.add(greater_g);
        panel.add(equal_g);
        panel.add(no_g);
        panel.add(quit_g);

        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));

        System.setOut(printStream);
        System.setErr(printStream);

        frame.getContentPane().add(scroller);

        frame.add(panel, BorderLayout.NORTH);


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
        UIManager.put("ToggleButton.select", new Color(42, 91, 190));
       new GamePearGUI();

    }
}