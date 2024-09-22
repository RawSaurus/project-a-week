import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel{

    private JLabel label1;
    private JTextField input;
    private JButton startEnd;
    private JButton guess;
    private MouseListener mouseListener;
    private Random random;
    private int guessInt;
    private int tries = 5;
    private boolean isGameOn;


    GamePanel(){

        label1 = new JLabel("Tries: " + tries);
        input = new JTextField();
        startEnd = new JButton("Start");
        guess = new JButton("Guess");
        mouseListener = new ML();
        random = new Random();


        label1.setBounds(280,160, 170, 40);

        input.setBounds(40,40, 410, 100);
        input.addMouseListener(mouseListener);
        input.setEnabled(false);
        input.setFocusable(false);

        startEnd.setBounds(40, 160, 100, 40);
        startEnd.addMouseListener(mouseListener);
        startEnd.setFocusable(false);

        guess.setBounds(160, 160, 100, 40);
        guess.addMouseListener(mouseListener);
        guess.setFocusable(false);
        guess.setVisible(false);



        //TODO another idea - make your own graphics planner, that will show you position of x, y, so I don't have to guess all the time

        this.setSize(450, 250);
        this.setLayout(null);


        this.add(label1);
        this.add(input);
        this.add(startEnd);
        this.add(guess);


        this.setVisible(true);
    }

    private void startEnd(){
        if(!isGameOn){
            startEnd.setText("End");
            input.setEnabled(true);
            input.setText("Take your guess");
            input.setFocusable(true);

            isGameOn=true;
            guess.setVisible(true);
            guessInt = random.nextInt(100);
        } else{
            startEnd.setText("Start");
            input.setFocusable(false);
            isGameOn=false;
            guess.setVisible(false);
        }
    }

    private void guess(String s) {
        if (isNumerical(s)){
            if (Integer.parseInt(s) == guessInt) {
                label1.setText("You won");
            }else{
                tries--;
                label1.setText("Tries: " + tries);
            }
            if(tries==0){
                label1.setText("Game over. Number was: " + guessInt);
                input.setFocusable(false);
            }
        }else{
            label1.setText("Not a number");
        }
    }

    private boolean isNumerical(String s){
        if(s.isEmpty()){
            return false;
        }
        for(char c : s.toCharArray()){
            if(c < '0' || (int)c > '9'){
                return false;
            }
        }
        return true;
    }

    private class ML implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource().equals(startEnd)){
                startEnd();
            }
            if(e.getSource().equals(input)){
                input.setText("");
            }
            if(e.getSource().equals(guess)){
                guess(input.getText());
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}

