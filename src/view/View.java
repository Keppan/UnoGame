package view;

import gameclasses.Card;
import gameclasses.CardsEnum;
import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class View implements PropertyChangeListener {
    private JFrame f = new JFrame();
    private MouseListener adapter;
    private Model m;
    private JPanel center = new JPanel();
    private JPanel info = new JPanel();
    private JPanel deck = new JPanel();
    private Card activeCard;
    private Card[] cards;

    public View(Model m) {
        cards = m.getDeckCard();
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

        for (Card c : cards){
            c.addMouseListener(adapter);
            deck.add(c);
        }
    }
    public void setAdapter(MouseListener adapter){
        this.adapter = adapter;
        initDeck();
        f.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        center.remove(activeCard);
      //  deck.remove((Gameclasses.Card)evt.getNewValue());
        center.add((Card)evt.getNewValue());
        activeCard = (Card)evt.getNewValue();

       // activeCard.addMouseListener(adapter); HÄR VAR FELET!!!!!
       // deck.repaint();
       // center.repaint();
        f.repaint();
        f.validate();
        System.out.println(Arrays.toString(center.getComponents()));
    }
}
