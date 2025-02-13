import processing.core.PApplet;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends PApplet {

    Panel guardian;
    public final int HorizontalPanelNum = 5;
    public final int VerticalPanelNum = 5;
    private ArrayList<Panel> panels;
   // private Panel[] panels = new Panel[HorizontalPanelNum * VerticalPanelNum];
    public static PApplet app;
    private boolean press;

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        PApplet.main("Main");
        }
    public Main(){
        super();
        app = this;
    }

    public void settings(){ size(600,600);}

    public void setup() {
        size(600, 600);
        int w = width/HorizontalPanelNum;
        int h = height/VerticalPanelNum;
        int inCount = 0;
        panels = new ArrayList<Panel>();
        for (int j = 0; j < HorizontalPanelNum; j++){
            int y = j*w + 65;
            for (int i = 0; i < VerticalPanelNum; i++){
                int x = i*h + 60;
                if (j % VerticalPanelNum == 0) {
                    guardian = new Panel(x, y, w, h);
                }else if (j % VerticalPanelNum == 1){
                    guardian = new CustomPanel(x, y, w, h);
                }else if (j % VerticalPanelNum == 2){
                    guardian = new TintedPanel(x, y, w, h);
                }else if (j % VerticalPanelNum == 3){
                    guardian = new RotatingPanel(x, y, w, h);
                }else{
                    guardian = new ContrastPanel(x, y, w, h);
                    inCount++;
                }
                guardian.setupImage("Guardian.png");
                panels.add(guardian);
            }
        }
        imageMode(CENTER);
    }

    public void draw(){
        fancyBackground();
        for (Panel panel: panels){
            panel.display();
        }
    }

    public void mouseClicked(){
        for (Panel panel: panels) {
            if (panel instanceof RotatingPanel) {
                panel.handleMouseClicked(mouseX, mouseY);
            }
        }
    }

    private void fancyBackground(){
        loadPixels();
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int loc = x + y * width;
                if (x % 3 == 0) {
                    pixels[loc] = color(255);
                } else if (x % 3 == 1) {
                    pixels[loc] = color(156, 247, 229);
                } else {
                    pixels[loc] = color(220, 166, 237);
                }
            }
        }
        updatePixels();
    }

    public void keyPressed(){
        if (key =='s'){ //switch x and y as well
            Panel first;
            Panel last;
            first = panels.getLast(); // first of new is last of old
            last = panels.getFirst();// last of new is first of old

            int tempX = first.getX();
            int tempY = first.getY();

            first.setX(last.getX());
            first.setY(last.getY());

            last.setX(tempX);
            last.setY(tempY);

            panels.remove(0);
            panels.remove(panels.get(panels.size()-1));
            panels.add(0,first);
            panels.add(last);
        }
        if (key == 'r'){
            int randomIndex = (int)(Math.random()*25);
            Panel replace;
            int x = panels.get(randomIndex).getX();
            int y = panels.get(randomIndex).getY();
            int w = panels.get(randomIndex).getOrgW();
            int h = panels.get(randomIndex).getOrgH();
            if (panels.get(randomIndex) instanceof CustomPanel){
                replace = new RotatingPanel(x, y, w, h);
                replace.setupImage("Guardian.png");
                panels.set(randomIndex, replace);
            }else if(panels.get(randomIndex) instanceof TintedPanel){
                replace = new ContrastPanel(x, y, w, h);
                replace.setupImage("Guardian.png");
                panels.set(randomIndex, replace);
            }else if(panels.get(randomIndex) instanceof RotatingPanel) {
                replace = new Panel(x, y, w, h);
                replace.setupImage("Guardian.png");
                panels.set(randomIndex, replace);
            }else if(panels.get(randomIndex) instanceof ContrastPanel) {
                replace = new CustomPanel(x, y, w, h);
                replace.setupImage("Guardian.png");
                panels.set(randomIndex, replace);
            }else{
                replace = new TintedPanel(x, y, w, h);
                replace.setupImage("Guardian.png");
                panels.set(randomIndex, replace);
            }
        }
    }
}