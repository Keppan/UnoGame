import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Model m;
    private View v;
    public Controller(Model m, View v){
        this.m = m;
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
