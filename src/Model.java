import java.util.*;

public class Model {
    private List<CardsEnum> cards;

    public Model(){
        cards = new LinkedList<>(Arrays.asList(CardsEnum.values()));
        Collections.shuffle(cards);
        for (CardsEnum msg : cards) {
            System.out.println(msg);
        }
    }

    public List<CardsEnum> getCards() {
        return cards;
    }
    public void removeDeck(CardsEnum e){
        cards.remove(e);
    }
}
