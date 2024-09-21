import javax.swing.*;

public class GameFrame {

    private JFrame frame;
    private GamePanel gamePanel;

    GameFrame(){
        this.frame = new JFrame();
        this.gamePanel = new GamePanel();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(500, 300);


        frame.add(gamePanel);

        frame.setVisible(true);
    }
}
