import processing.core.PImage;
public class Panel{ //panel is the name of the class/type
    // instance variables: stores data for type/class
    private PImage img; //looks like a variable declaration (private is the visibility)
    private int x; //x point of image
    private int y; //y point of image
    private int w; //width of image
    private int h; //height of image
    private int orgW;
    private int orgH;

    // constructor initializes data for the class (constructor always has the same name as the class)
    public Panel(int _x, int _y, int _w, int _h){
        x = _x;
        y = _y;
        w = _w;
        h = _h;
        orgW = _w;
        orgH = _h;
    }

    public Panel(){
    }

    // instance methods: behavior for type/class (how it reacts to things and what it does/what can be done)
    public void display(){
        Main.app.image(img,x,y,w,h); //displays something - like the rect function
    }

    public void handleMouseClicked(int mX, int mY){
    }

//Getters (accessors) and setters(mutators) methods

    //Getters give access to data with private visibility
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }

    public int getOrgW(){
        return orgW;
    }

    public int getOrgH(){
        return orgH;
    }

    public void setX(int _x){
        x = _x;
    }

    public void setY(int _y){
        y = _y;
    }

    public void setW(int _w){
        w = _w;
    }

    public void setH(int _h){
        h = _h;
    }

    public void setupImage(String imageName){
        img = Main.app.loadImage(imageName);
    }

    public PImage getImageCopy(){
        return img.copy();
    }
}