import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class View implements PropertyChangeListener {
    private JFrame f = new JFrame();
    private MouseListener adapter;
    private Model m;
    private JPanel center = new JPanel();
    private JPanel info = new JPanel();
    private JPanel deck = new JPanel();
    private Card activeCard;
    private List<CardsEnum> cards;

    public View(Model m) {
        cards = m.getCards();
        m.addPropertyChangeListener(this);
        this.m = m;
        f.setLayout(new BorderLayout());
        f.setMinimumSize(new Dimension(1200, 500));
        f.setLocation(200,200);
        f.add(info,BorderLayout.NORTH);
        f.add(center);

        center.setSize(500,500);
        center.setBackground(Color.BLACK);
        f.add(deck,BorderLayout.SOUTH);
        deck.setPreferredSize(new Dimension(0, 200));
    }

    private void initDeck(){
        activeCard = m.getActiveCard();
        Card cardPile = new Card(CardsEnum.Deck);
        activeCard.addMouseListener(adapter);
        cardPile.addMouseListener(adapter);
        m.removeDeck(CardsEnum.Deck);
        center.add(cardPile);
        center.add(activeCard);

        List<CardsEnum> temp = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            Card c = new Card(cards.get(i));
            c.addMouseListener(adapter);
            deck.add(c);
            temp.add(cards.get(i));
        }
        for (CardsEnum e : temp){
            m.removeDeck(e);
        }
    }
    public void setAdapter(MouseListener adapter){
        this.adapter = adapter;
        initDeck();
        f.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        deck.remove((Card)evt.getNewValue());
        center.remove(activeCard);
        activeCard = m.getActiveCard();
        activeCard.addMouseListener(adapter);
        center.add(activeCard);
        deck.repaint();
        center.repaint();
        System.out.println("TESTESTSTS");
        f.repaint();
        f.validate();
    }
}
