package gameclasses;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class Card extends JPanel implements Serializable {
    private int type;
    private String Color;
    private final CardsEnum enumIdentifier;
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
         //   img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Assets/" +enumIdentifier+".png")));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            g.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResource("/assets/" +enumIdentifier+".png")))
                        ,x,y, getWidth(), getHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
