package controller;

import gameclasses.Card;
import view.View;
import model.Model;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener {
    private Model m;
    private View v;
    public Controller(Model m, View v){
        this.m = m;
        this.v = v;
        v.setAdapter(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       // Gameclasses.Card c = (Gameclasses.Card)e.getSource();
       // m.seeCard(c);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Card c = (Card)e.getSource();
        m.seeCard(c);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
