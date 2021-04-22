import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Card extends JPanel {
    private int type;
    private String Color;
    private BufferedImage img;

    public Card(CardsEnum s){
        setMinimumSize(new Dimension(10,10));
        setPreferredSize(new Dimension(120, 200));
        initImg(s.name());
        setVisible(true);
        if(!s.name().equals("Deck")){
            type = Integer.parseInt(s.name().substring(s.name().indexOf("_")+1));
            Color = s.name().substring(0,s.name().indexOf("_"));
        }
        System.out.println(type +" and "+ Color);
    }

    public int getNumber() {
        return type;
    }

    public String getColor() {
        return Color;
    }

    private void initImg(String s ) {
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Assets/" +s+".png")));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void initImg() {
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Assets/" + Color + "_" + type + ".png")));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0, getWidth(), getHeight(), null);

    }
    public String toString(){
        return Color + " " + type;
    }
}
