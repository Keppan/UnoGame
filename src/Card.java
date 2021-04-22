import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Card extends JPanel {
    private int type;
    private String Color;
    private BufferedImage img;
    private CardsEnum enumIdentifier;
    private int x;
    private int y;
    public Card(CardsEnum s){
        enumIdentifier = s;
        setMinimumSize(new Dimension(10,10));
        setPreferredSize(new Dimension(120, 200));
        initImg();
        setVisible(true);
        if(!s.name().equals("Deck")){
            type = Integer.parseInt(s.name().substring(s.name().indexOf("_")+1));
            Color = s.name().substring(0,s.name().indexOf("_"));
        }
    }

    public int getNumber() {
        return type;
    }

    public String getColor() {
        return Color;
    }

    private void initImg() {
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Assets/" +enumIdentifier+".png")));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,x,y, getWidth(), getHeight(), null);

    }
    public void move(){
        x++;
        y++;
        repaint();
    }
    public String toString(){
        return Color + " " + type;
    }

    public CardsEnum getIdentifier() {
        return enumIdentifier;
    }
}
