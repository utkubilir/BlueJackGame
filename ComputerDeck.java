

import java.util.Random;

public class ComputerDeck {
    Random r = new Random();
    private Cards[] computerDeck;
    private Cards[] computerHand;
	public Cards [] last5cards;
	private GameDeck gameDeck; 
	private Cards DOUBLE;
	private Cards flip;
	private SignDeck signDeck;
	public int randomValue;
	

    public ComputerDeck() {
        gameDeck = new GameDeck();
		randomValue = r.nextInt(100);
        signDeck = new SignDeck();
        computerDeck = new Cards[10];
        computerHand = new Cards[4];
        last5cards = gameDeck.drawLast5Cards();
        fillComputerDeck(last5cards);
		fillComputerHand();
    }
	public void synchronizeWithGameDeck(GameDeck gameDeck) {
        last5cards = gameDeck.drawLast5Cards();
        fillComputerDeck(last5cards);
    }
	public Cards[] fillComputerDeck(Cards[] last5cards) {

        for (int i = 0; i < 5; i++) {
            computerDeck[i] = last5cards[i];
        }

        for (int i = 5; i < 8; i++) {
            computerDeck[i] = signDeck.getSignCard();
        }

        

        if (randomValue > 20) {
            computerDeck[8] = signDeck.getSignCard();
            computerDeck[9] = signDeck.getSignCard();
        } else if (randomValue < 4) {
            computerDeck[8] = signDeck.getFlip();
            computerDeck[9] = signDeck.getDouble();
        } else if (randomValue >= 4 && randomValue <= 20) {
            computerDeck[8] = signDeck.getFlipOrDouble();
            computerDeck[9] = signDeck.getSignCard();
        }
		return computerDeck;
    }

	public Cards[] printComputerDeck() {
        System.out.print("Computer Deck: ");
        for (int i = 0; i < computerDeck.length; i++) {
            System.out.print(computerDeck[i].toString() + " ");
        }
        System.out.println();
		return computerDeck;
    }

	public Cards[] fillComputerHand(){
		Cards [] computerDeckCopy = new Cards[10];
		for(int i = 0 ; i < computerDeckCopy.length ; i++){
			computerDeckCopy[i] = computerDeck[i];
			
		}
		Random r = new Random();
		int randomValue = r.nextInt(computerDeckCopy.length) + 1 ;
       for (int i = computerDeckCopy.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);

            Cards temp = computerDeckCopy[i];
            computerDeckCopy[i] = computerDeckCopy[j];
            computerDeckCopy[j] = temp;
        }

        for (int i = 0; i < computerHand.length; i++) {
            computerHand[i] = computerDeckCopy[i];
        }
	   return computerHand;
	}
	
	 public Cards[] printComputerHand() {
		System.out.print("Computer Hand:");
		System.out.print("[");
        for (int i = 0; i < computerHand.length; i++) {
            System.out.print(computerHand[i].toString());
            if (i < computerHand.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
		return computerHand;
    }
	
    
	public Cards[] getComputerHand(){
		return computerHand;
	}
	
	
}






