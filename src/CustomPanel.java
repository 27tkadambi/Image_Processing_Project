import processing.core.PImage;
public class CustomPanel extends Panel {
    public CustomPanel(int _x, int _y, int _w, int _h) {
        super(_x, _y, _w, _h);
    }

    public void display() {
        Main.app.tint(35, 116, 125);
        PImage img = getImageCopy();
        img.loadPixels();
        for (int x = 0; x < img.width; x++) {
            for (int y = 0; y < img.height; y++) {
                int loc = x + y * img.width;
                float b = Main.app.brightness (img.pixels[loc]);
                if (b > 100) {
                    img.pixels[loc] = Main.app.color(242, 180, 7);
                } else {
                    img.pixels[loc] = Main.app.color(155, 50);
                }
            }
            img.updatePixels();
        }
        Main.app.image(img, getX(), getY(), getW(), getH());
        Main.app.noTint();
        setW(getW() + 1);
        setH(getH() + 1);
        if (getW() <= 0 || getH() >= 200){
            setW(Main.app.width/((Main)Main.app).HorizontalPanelNum);
            setH(Main.app.height/((Main)Main.app).VerticalPanelNum);
        }
    }

}