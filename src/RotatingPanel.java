public class RotatingPanel extends Panel{

    private float degrees;
    private boolean rotating;

    public RotatingPanel(int _x, int _y, int _w, int _h){
        super(_x, _y, _w, _h);
        degrees = 10;
        rotating = false;
    }

    public void handleMouseClicked(int mX, int mY){
        if (mX > getX() && mX < getX()+getW() && mY > getY() && mY < getY() + getH()) {
            rotating = !rotating;
        }
    }

    public void display(){
        Main.app.imageMode(Main.app.CENTER);
        if (!rotating){
            Main.app.tint(255, 162, 56, 1000);
            super.display();
            Main.app.noTint();
        }else{
            Main.app.push();
            Main.app.imageMode(Main.app.CENTER);
            Main.app.tint(255, 162, 56, 1000);
            int x = getX();
            int y = getY();
            Main.app.translate(x,y);
            Main.app.rotate(Main.app.radians(degrees));
            degrees++;
            setX(0);
            setY(0);
            super.display();
            setX(x);
            setY(y);
            Main.app.noTint();
            Main.app.imageMode(Main.app.CORNER);
            Main.app.pop();
        }
    }
}