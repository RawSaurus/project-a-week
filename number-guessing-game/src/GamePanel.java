import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class GamePanel extends JPanel{

    JLabel label1;
    JTextField input;
    GamePanel(){

        label1 = new JLabel("Test");
        input = new JTextField("Take your guess");

//        label1.setBounds(40,40, 100, 15);

        input.setBounds(40,40, 410, 100);


        //TODO another idea - make your own graphics planner, that will show you position of x, y, so I don't have to guess all the time

        this.setSize(450, 250);
        this.setLayout(null);


//        this.add(label1);
        this.add(input);


        this.setVisible(true);
    }

}

