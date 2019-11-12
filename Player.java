import java.util.LinkedList;

public class Player{
    private Hand hand;
    private String name;
    
    public Player(String name){
        this.name = name;
        hand = new Hand();
    }
    
    public String getName(){
        return name;
    }
    
    public Card draw(){
        return hand.draw();
    }
    
    public void add(Card card){
        hand.add(card);
    }
    
    public void add(LinkedList<Card> cards){
        hand.add(cards);
    }
    
    public LinkedList<Card> getCards(){
        return hand.getCards();
    }
    
    public void fold(){
        hand.clear();
    }
    
    public int size(){
        return hand.size();
    }
    
    public String toString(){
        return name + " has " + hand.size() + " cards";
    }
}