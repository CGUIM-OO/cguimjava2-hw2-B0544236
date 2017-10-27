import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student b0544236 and name here
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int n=1; n<=nDeck; n++){//先看總共給副牌(最外圍)決定我下面雙迴圈(加入每個(花色,數字))要做幾次
		    for(int i=1; i<=4; i++){//花色for迴圈包在數字外圍 因為我想先把每個花色都填完 再填下一個花色
			    for(int j=1; j<=13; j++){//外圍i=1時,填完梅花 和數字1~13的卡片  以此類推
				  Card card=new Card(i,j);//instance method 要用必須先new出來，然後填入花色和數字
				  cards.add(card);//將new出的物件 卡片 加近牌組裡ArrayList cards裡
			    }
		    }
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
        int Size= cards.size();
        for(int i=0; i<Size; i++){//此時要注意 java index第一個為0而非1
        	cards.get(i).printCard();//Card c= cards.get(i); c=printCard();
        	
        }
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
        if (suit ==1&&rank>=1&&rank<=13){//先判斷花色1是梅花數字是否為1~13
        	if(rank==1){
        		System.out.print("Clubs Ace, ");//如果數字=1印Ace
        	}
        	else	
        	System.out.print("Clubs "+rank+", ");//其餘的數字就照數字印出 ex:rank=2
        }
        if (suit ==2&&rank>=1&&rank<=13){//先判斷花色1是鑽石數字是否為1~13
        	if(rank==1){
        		System.out.print("Diamonds Ace, ");
        	}
        	else	
        	System.out.print("Diamonds "+rank+", ");
        }
        if (suit ==3&&rank>=1&&rank<=13){//先判斷花色1是紅心數字是否為1~13
        	if(rank==1){
        		System.out.print("Hearts Ace, ");
        	}
        	else	
        	System.out.print("Hearts "+rank+", ");
        }
        if (suit ==4&&rank>=1&&rank<=13){//先判斷花色4是黑桃數字是否為1~13
        	if(rank==1){
        		System.out.print("Spades Ace, ");
        	}
        	else	
        	System.out.print("Spades "+rank+", ");
        }	
        
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
