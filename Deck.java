import java.util.Collections;

public class Deck extends Hand{
    public void shuffle(){
        Collections.shuffle(super.getCards());
    }

    public boolean snap(){
        if(super.getCards().size() > 2)
            return super.getCards().getLast().matchedRank(super.getCards().get(super.getCards().size()-2));
        else
            return false;
    }

    public boolean empty(){
        return super.getCards().size() == 0;
    }

    public void show(){
        System.out.println("Deck has " + super.size() + " cards");
    }
}