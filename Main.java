import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Timer;

public class Main{

    public static void main(String[] args){
        JFrame frame = new JFrame("Window");
        frame.setSize(750, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

//inside here that the game should occur, paint components will draw, so this will be added in the frame
class MyPanel extends JPanel{
    
}