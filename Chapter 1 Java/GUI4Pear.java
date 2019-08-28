import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

class GUI4Pear  implements ActionListener {


     String bearing;

     G_OOPear3 gamer = new G_OOPear3();

     GUI4Pear() {
         JFrame frame = new JFrame("Eddie's  Guessing Game ");

         JButton start_g = new JButton("Start_game");
         JButton play_g = new JButton("Keep_Playing");
         JButton decide_g = new JButton("Choose l-h-e");
         frame.add(start_g, BorderLayout.WEST);
         start_g.addActionListener(event -> gamer.Start_game());
         frame.add(play_g, BorderLayout.CENTER);
         play_g.addActionListener((event -> gamer.Keep_Playing()));
         frame.add(decide_g, BorderLayout.EAST);
         decide_g.addActionListener(event -> gamer.Your_guess_is(bearing));
         frame.setLayout(new FlowLayout());
         frame.setSize(600, 300);
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
