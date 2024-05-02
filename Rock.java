import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;


public class Rock {
    Image image;
    Rectangle hitbox;
    int x, y;
    int dx, dy;
    Random rand;
    
    public Rock(int x, int y){ // allow the coordinates it spawns in to be passed into it
        ImageIcon icon = new ImageIcon("C:\\Users\\lorran\\Documents\\RPS_eletric_boogalo\\assets\\rock.png");
        image = icon.getImage();
        hitbox = new Rectangle(x, y, 32, 32);
        rand = new Random();
        this.x = x;
        this.y = y;

    }

    public void move(){
        x += dx;
        y += dy;

        hitbox.x = x;
        hitbox.y = y;

        //allow some randomized movment
        if (rand.nextInt(100) < 10){ //10 percent chance of random mov
            dx = rand.nextInt(10) -5;
            dy = rand.nextInt(10) - 5;
        }

        //not really sure yet? probably a collide method soon
    }
}
