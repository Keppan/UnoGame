import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Card extends JPanel {
    private String type;
    private String Color;
    private BufferedImage img;

    public Card(CardsEnum s){
        setMinimumSize(new Dimension(10,10));
        //  setMinimumSize(new Dimension(500,500));
        //   setSize(new Dimension(500,500));
        //   System.out.println(getSize());
        setPreferredSize(new Dimension(120, 200));
        initImg(s.name());
        setVisible(true);
    }
    public Card(String type, String Color){
        this.type = type;
        this.Color = Color;
        setMinimumSize(new Dimension(10,10));
      //  setMinimumSize(new Dimension(500,500));
     //   setSize(new Dimension(500,500));
     //   System.out.println(getSize());
        setPreferredSize(new Dimension(120, 200));
        initImg();
        setVisible(true);
    }

    public String getNumber() {
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
}
