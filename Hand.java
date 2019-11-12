import java.util.LinkedList;

public class Hand{
    private LinkedList<Card> cards;

    public Hand(){
        cards = new LinkedList<Card>();
    }

    public LinkedList<Card> getCards()
    {
        return cards;
    }

    public void add(Card card){
        cards.add(card);
    }

    public void add(LinkedList<Card> hand){
        cards.addAll(hand);
    }

    public Card draw(){
        return cards.removeFirst();
    }

    public void clear(){
        cards.clear();
    }

    public int size(){
        return cards.size();
    }

    public String toString(){
        return "";
    }
}