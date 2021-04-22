import javax.swing.border.EtchedBorder;
import java.beans.PropertyChangeSupport;
import java.util.*;

public class Model extends PropertyChangeSupport {
    private List<CardsEnum> cards;
    private Card activeCard;
    private Card markedCard;
    private Card[] deckCard;

    public Model(){
        super("böna");
        deckCard = new Card[7];
        cards = new LinkedList<>(Arrays.asList(CardsEnum.values()));
        int r = new Random().nextInt(39);
        activeCard = new Card(cards.get(r));
        cards.remove(r);
        Collections.shuffle(cards);
        for(int i = 0; i < 7; i++){
            Card c = new Card(cards.get(i));
            deckCard[i] = c;
            cards.remove(c.getIdentifier());
        }

    }

    public List<CardsEnum> getCards() {
        return cards;
    }
    public void removeDeck(CardsEnum e){
        cards.remove(e);
    }


    public void seeCard(Card c){
        if (markedCard == null && c != activeCard){
            markedCard = c;
            markedCard.setBorder(new EtchedBorder());
            return;
        }
        else if (c == activeCard && markedCard != activeCard && markedCard != null) {
            if(!markedCard.getColor().equals("Black")){
                if(!markedCard.getColor().equals(activeCard.getColor()) && markedCard.getNumber()!=activeCard.getNumber()){
                    markedCard.setBorder(null);
                    markedCard = null;
                    return;
                }
               // removeDeck(activeCard.getIdentifier());
                activeCard = markedCard;
                activeCard.setBorder(null);
               // removeDeck(markedCard.getIdentifier());
                firePropertyChange("updateCard",null,activeCard);
            }
        }
        assert markedCard != null;
        markedCard.setBorder(null);
        markedCard = null;
        c.setBorder(null);
    }

    public Card getActiveCard() {
        return activeCard;
    }
    public Card[] getDeckCard(){
        return deckCard;
    }
}
