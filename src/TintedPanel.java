public class TintedPanel extends Panel{

    //subclass constructor
    //invokes the Panel constructor by calling super
    //passes all the information Panel needs to super
    public TintedPanel(int _x, int _y, int _w, int _h){
        super(_x, _y, _w, _h);
    }

    //to give Panel objects a red tint
    //override the Panel's display method
    public void display(){
        Main.app.tint(255, 0, 0, 200); //turns tint on - like fill function
        super.display();
        Main.app.noTint(); // turns tint off
    }
}