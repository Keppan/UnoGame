import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class View {
    private JFrame f = new JFrame();
    private ActionListener adapter;
    private Model m;
    private JPanel center = new JPanel();
    private JPanel info = new JPanel();
    private JPanel deck = new JPanel();
    private List<CardsEnum> cards;

    public View(Model m) {
        cards = m.getCards();
        this.m = m;
        f.setLayout(new BorderLayout());
        f.setMinimumSize(new Dimension(1200, 500));
        f.setLocation(200,200);
        f.add(info,BorderLayout.NORTH);
        f.add(center);
        center.setSize(500,500);
        center.setBackground(Color.BLACK);
        Card test = new Card(CardsEnum.Red_0);
        Card test2 = new Card(CardsEnum.Deck);
        center.add(test);
        center.add(test2);
        f.add(deck,BorderLayout.SOUTH);
        initDeck();
        deck.setPreferredSize(new Dimension(0, 200));
        test.repaint();
        f.setVisible(true);
    }
    private void initDeck(){
        List<CardsEnum> temp = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            deck.add(new Card(cards.get(i)));
            temp.add(cards.get(i));
        }
        for (CardsEnum e : temp){
            m.removeDeck(e);
        }
    }
}
