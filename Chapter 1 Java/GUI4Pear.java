import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

 class GUI4Pear {

     String bearing;

     G_OOPear3 gamer = new G_OOPear3();
     GUI4Pear() {
         JFrame frame = new JFrame("Eddie's  Guessing Game ");

         JButton start_g = new JButton("Start_game");
         JButton play_g = new JButton("Keep_Playing");
         JButton decide_g = new JButton("Choose l-h-e");
         frame.add(start_g, BorderLayout.WEST);
         frame.add(play_g,BorderLayout.CENTER);
         frame.add(decide_g, BorderLayout.EAST);
         frame.setLayout(new FlowLayout());
         frame.setSize(600, 300);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }



    class ButtonStart extends JButton {
        JButton button_start = new JButton("Start_Game");
        public void actionPerformed (ActionListener event) {
            gamer.Start_game();

        }
    }

    class ButtonKeepPlaying extends JButton{
        JButton button_keep_playing = new JButton("Keep_Playing");

        public void actionPerformed(ActionListener event){
            gamer.Keep_Playing();

        }

    }

    class ButtonDecide extends JButton {
        public void actionPerformed (ActionListener event){
            JButton button_decide = new JButton("Choose :l-h-e");
            gamer.Your_guess_is(bearing);

        }
    }

}
class Test3 {
    public static void main(String[] args) {
        GUI4Pear gamelon = new GUI4Pear();
    }
}
