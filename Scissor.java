public class Scissor extends Base{
    
    public Scissor(int x, int y){
        super(x, y, "C:\\Users\\lorran\\Documents\\RPS_2_eletric_boogalo\\assets\\scissor.png" );
    }

    public void handleCollision(Base[] contenders, int i){
        if (contenders[i] instanceof Paper){ //if what you bumped in is a scissor object
            contenders[i] = new Scissor(contenders[i].x, contenders[i].y);
        }
    }
}
