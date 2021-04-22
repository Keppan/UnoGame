import java.beans.PropertyChangeSupport;
import java.util.*;

public class Model extends PropertyChangeSupport {
    private List<CardsEnum> cards;
    private Card activeCard;
    private Card markedCard;

    public Model(){
        super("böna");
        cards = new LinkedList<>(Arrays.asList(CardsEnum.values()));
        int r = new Random().nextInt(39);
        activeCard = new Card(cards.get(r));
        cards.remove(r);
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
    public void seeCard(Card c){
        System.out.println(c.getColor()+ " " + c.getNumber());
        if (markedCard == null)
        markedCard = c;
        else if (c == activeCard) {
            if(!markedCard.getColor().equals("Black")){
                if(!markedCard.getColor().equals(activeCard.getColor())){
                    return;
                }
                removeDeck(activeCard.getIdentifier());
                activeCard = markedCard;
                removeDeck(markedCard.getIdentifier());
                firePropertyChange("updateCard",null,activeCard);
            }
            markedCard = null;
        }
    }

    public Card getActiveCard() {
        return activeCard;
    }
}
