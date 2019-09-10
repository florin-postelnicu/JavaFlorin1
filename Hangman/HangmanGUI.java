
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.PrintStream;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.JButton;
import javax.swing.text.BadLocationException;

public class HangmanGUI extends JFrame  implements ActionListener {
    // HnagmanGame hg = new HangmanGame;
    public int numButtons = 30;
    Container cp;
    JToggleButton[] buttons;
    BasicOptionPaneUI.ButtonActionListener listener;

    public HangmanGUI() {
        UIManager.put("ToggleButton.Select", new Color(180, 60, 100));
        cp = getContentPane();
        // Create an instance of ActionListener to listen to all buttons

        createButtons();
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setTitle("HANGAMAN");
        setSize(1200, 500);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    public void createButtons() {

        cp.removeAll();
        cp.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
        buttons = new JToggleButton[numButtons]; // Allocate aray
        // Create (numbuttons - 1) "Add " buttons , but minus 1
        buttons[0] = new JToggleButton("A");
        buttons[1] = new JToggleButton("B");
        buttons[2] = new JToggleButton("C");
        buttons[3] = new JToggleButton("D");
        buttons[4] = new JToggleButton("E");
        buttons[5] = new JToggleButton("F");
        buttons[6] = new JToggleButton("G");
        buttons[7] = new JToggleButton("H");
        buttons[8] = new JToggleButton("I");
        buttons[9] = new JToggleButton("J");

        buttons[10] = new JToggleButton("K");
        buttons[11] = new JToggleButton("L");
        buttons[12] = new JToggleButton("M");
        buttons[13] = new JToggleButton("N");
        buttons[14] = new JToggleButton("O");
        buttons[15] = new JToggleButton("P");
        buttons[16] = new JToggleButton("Q");
        buttons[17] = new JToggleButton("R");
        buttons[18] = new JToggleButton("S");
        buttons[19] = new JToggleButton("T");

        buttons[20] = new JToggleButton("U");
        buttons[21] = new JToggleButton("V");
        buttons[22] = new JToggleButton("VV");
        buttons[23] = new JToggleButton("X");
        buttons[24] = new JToggleButton("Y");
        buttons[25] = new JToggleButton("Z");
        buttons[26] = new JToggleButton("START");
        buttons[27] = new JToggleButton("PLAY");
        buttons[28] = new JToggleButton("CLEAR");
        buttons[29] = new JToggleButton("QUIT");

        for (int i = 0; i < 30; i++) {
            cp.add(buttons[i]);

            buttons[i].addActionListener(listener);

        }
        JTextArea textArea = new JTextArea(25, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        cp.add(scroller);
        textArea.setFont(new Font("Serif", Font.BOLD, 24));
        textArea.setForeground(Color.BLUE);


        // The next three lines redirect the console's print to the JTextArea

        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        cp.validate();
        cp.setVisible(true);


//        repaint();

    }


    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    /**
     * The entry main() method
     */
    public static void main(String[] args) {
        // Run GUI codes in the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HangmanGUI();  // Let the constructor do the job
            }
        });
    }
}