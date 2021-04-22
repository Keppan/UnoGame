import java.util.*;

public class Model {
    private List<CardsEnum> cards;
    private Card activeCard;

    public Model(){
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
    }

    public Card getActiveCard() {
        return activeCard;
    }
}
