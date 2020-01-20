public class Card {
  private Suit suit;
  private Number number;

  public Card( Suit suit, Number number){
    this.suit = suit;
    this.number = number;
  }

  public String toString(){
    String output = "";
    output += number;
    output += ": ";
    output += suit;
    return output;
  }

  public static void main(String[] args){
    int cardNumber = 0;
    Card[] deck = new Card[52];
      for(Suit suit : Suit.values()){
        for (Number number : Number.values()){
          deck[cardNumber] = new Card(suit,number);
          cardNumber++;
        }
      }
      for(int i = 0; i < cardNumber; i++){
        System.out.println(deck[i].toString());
      }
  }
}
