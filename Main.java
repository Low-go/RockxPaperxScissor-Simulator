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
        panel.gameInitialize();
    }
}

//inside here that the game should occur, paint components will draw, so this will be added in the frame
class MyPanel extends JPanel{

    static int width, height;
    Timer timer;
    Random rand = new Random();
    //boolean gameEnd = false; //probs need something like this
    Base[] contenders = new Base[30]; // Array where all objects will be stored
    


    public void gameInitialize(){ // gets the dimensions of the frame
        
        width = getWidth();
        height = getHeight();
        int store = 30;
        int i = 0;
        while (i < store){      // instantiate and store 10 of each object in the array
            int buffer = 35;
            int rndX = buffer + rand.nextInt(width - 2 * buffer);
            int rndY = buffer + rand.nextInt(height - 2 * buffer);

            if (i < 10){
                Rock rock = new Rock(rndX, rndY);
                contenders[i] = rock;
                i ++;
            }
            else if(i >= 10 && i < 20){
                Scissor scissor = new Scissor(rndX, rndY);
                contenders[i] = scissor;
                i++;
            }
            else if(i >= 20 && i < 30){
                Paper paper = new Paper(rndX, rndY);
                contenders[i] = paper;
                i++;
            }
        }
        
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for (Base i: contenders){
            g.drawImage(i.image, i.x, i.y, this);
        }
 
        //g.drawImage(rock.image, rock.x, rock.y, this);

    }

    public MyPanel(){
        //after set intervals
        timer = new Timer(100, e-> {

            for (Base i : contenders ){
                i.move();
                i.collide(contenders);
                
            }

            boolean allRock = true;
            boolean allPaper = true;
            boolean allScissor = true;

            for (Base i : contenders){
                if (!(i instanceof Rock)){
                    allRock = false;
                }
                if (!(i instanceof Paper)){
                    allPaper = false;
                }
                if (!(i instanceof Scissor)){
                    allScissor = false;
                }
            }

            if ( allRock || allPaper || allScissor){
                timer.stop();
                System.out.println("Game Over");
            }

             
            repaint();
        });
        timer.start();

    }

}
