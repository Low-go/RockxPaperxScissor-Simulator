

public class Rock extends Base{

    
    public Rock(int x, int y){ // allow the coordinates it spawns in to be passed into it
        super(x, y, "C:\\Users\\lorran\\Documents\\RPS_2_eletric_boogalo\\assets\\rock.png");

    }

    public void handleCollision(Base[] contenders, int i){
        if (contenders[i] instanceof Scissor){ //if what you bumped in is a scissor object
            contenders[i] = new Rock(contenders[i].x, contenders[i].y);
        }
    }

 
}


