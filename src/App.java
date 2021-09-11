import controller.Controller;
import model.Model;
import view.View;

public class App {
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View(m);
        new Controller(m,v);

    }
}
