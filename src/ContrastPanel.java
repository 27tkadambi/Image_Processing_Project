import processing.core.PImage;
public class ContrastPanel extends Panel {
    public ContrastPanel(int _x, int _y, int _w, int _h) {
        super(_x, _y, _w, _h);
    }

    public void display() {
        PImage img = getImageCopy();
        img.loadPixels();
        for (int x = 0; x < img.width; x++) {
            for (int y = 0; y < img.height; y++) {
                int loc = x + y * img.width;
                float b = Main.app.brightness(img.pixels[loc]);
                if (b > 100) {
                    img.pixels[loc] = Main.app.color(0);
                } else {
                    img.pixels[loc] = Main.app.color(250, 0);
                }
            }
            img.updatePixels();
        }
        Main.app.image(img, getX(), getY(), getW(), getH());
    }
}