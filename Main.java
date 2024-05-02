import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

public class Main{

    public static void main(String[] args){
        JFrame frame = new JFrame("Window");
        frame.setSize(750, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //do not let size adjust
        frame.setVisible(true);

        MyPanel panel = new MyPanel(); 
        frame.add(panel);

        frame.setVisible(true);
        panel.updateDimensions();
    }
}

//inside here that the game should occur, paint components will draw, so this will be added in the frame
class MyPanel extends JPanel{
    int width; 
    int height;
    Timer timer;
    Random rand = new Random();
    boolean gameEnd = false; //probs need something like this

    Rock rock; //just for test purposes for now, remove later

    public MyPanel(){
        //after set intervals
        timer = new Timer(100, e-> {
            
            rock.move();
            repaint();
        });

    }

    public void updateDimensions(){ // gets the dimensions of the frame
        
        width = getWidth();
        height = getHeight();
        int rndX = rand.nextInt(width);
        int rndY = rand.nextInt(height);
        rock = new Rock(rndX, rndY);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(rock.image, rock.x, rock.y, this);

    }

}