public class Paper extends Base{
    
    public Paper(int x, int y){
        super(x, y, "C:\\Users\\lorran\\Documents\\RPS_2_eletric_boogalo\\assets\\paper.png");
    }

    public void handleCollision(Base[] contenders, int i){
        if (contenders[i] instanceof Rock){ //if what you bumped in is a scissor object
            contenders[i] = new Paper(contenders[i].x, contenders[i].y);
        }
    }
}
