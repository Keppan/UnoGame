import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

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
       // Card c = (Card)e.getSource();
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
