public class Card{
    private Rank rank;
    private Suit suit;
    
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    public boolean matchedRank(Card card){
        return this.rank.equals(card.rank());
    }
    
    public Rank rank(){
        return rank;
    }
    
    public String toString(){
        return "" + rank + " of " + suit;
    }
}