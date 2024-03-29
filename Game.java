import java.util.LinkedList;
import java.util.Scanner;

public class Game{
    private Scanner sc;
    private LinkedList<Player> players;
    private Deck deck;
    private boolean flag;

    private final int MAX = 52;

    public Game(){
        sc = new Scanner(System.in);
        players = new LinkedList<Player>();
        deck = new Deck();
        flag = true;

        players.add(new Player("Computer"));
        System.out.println("Please enter the player name");
        players.add(new Player(sc.nextLine()));

        fillDeck();

        while(flag){
            menu();
        }
    }

    public void menu(){
        System.out.print("Please enter your choice (D, T, S, X):  ");
        char menu = sc.next().charAt(0);

        switch(menu){
            case 'D':
            case 'd':
            deal();
            break;

            case 'T':
            case 't':
            turn();
            break;

            case 'S':
            case 's':
            summary();
            break;

            case 'X':
            case 'x':
            flag = false;
            System.out.println("Goodbye!");
            break;

            default:
            System.out.println("Please enter a valid value");
        }
    }

    public void deal(){
        deck.shuffle();

        while(!deck.empty()){
            for(Player player : players){
                player.add(deck.draw());
            }
        }

        System.out.println("Cards have been dealt");
    }

    public void fold(){
        for(Player player : players){
            player.fold();
        }

        deck.clear();
        fillDeck();
    }

    public void turn(){
        if(deck.size() == MAX){
            System.out.println("Please deal first");
            return;
        }

        for(Player player : players){
            Card card = player.draw();
            System.out.println(player.getName() + " drew " + card.toString());
            deck.add(card);

            if(deck.snap()){
                System.out.println("Snap!");
                player.add(deck.getCards());
                deck.clear();
                System.out.println(player.getName() + " snapped");
            }

            if(player.size() == 0){
                flag = false;
                result(player);
                break;
            }
        }
    }

    public void summary(){
        for(Player player : players){
            System.out.println(player.toString());
        }

        deck.show();
    }

    public void fillDeck(){
        for(Rank rank : Rank.values()){
            for(Suit suit : Suit.values()){
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
    }

    public void result(Player loser){
        for(Player player : players){
            if(player.equals(loser)){
                System.out.println(player.getName() + " lose");
            }
            else{
                System.out.println(player.getName() + " win");
            }
        }
    }

    public String toString(){
        return "";
    }
}