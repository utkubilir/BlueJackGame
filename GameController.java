import java.util.Scanner;

public class GameController {
    private Scanner scanner = new Scanner(System.in);
    private PlayerDeck playerDeck = new PlayerDeck();
    private ComputerDeck computerDeck = new ComputerDeck();
    private GameDeck gameDeck = new GameDeck();

    private Cards[] playerBoardCards = new Cards[9];
    private Cards[] computerBoardCards = new Cards[9];
	String inputFromPlayer;	
	String inputFromPlayer2;	
    private int playerBoardCardCount = 0;
    private int computerBoardCardCount = 0;
	private Cards withdrawncard;  
    private int k = 0;
    private int l = 0;
    private int playersetpointtoplam = 0;
    private int computersetpointtoplam = 0;
    private int pboardtoplam = 0;
    private int cboardtoplam = 0;
    private int pboardcardnumber = 0;
    private int cboardcardnumber = 0;


    public GameController() {
    }

    public void runGame() {
        System.out.println("WELCOME TO BLUEJACK GAME");
        System.out.println();
        computerDeck.synchronizeWithGameDeck(Game.gameDeck);
        playerDeck.synchronizeWithGameDeck(Game.gameDeck);
        playerDeck.printPlayerDeck();
        computerDeck.printComputerDeck();
        computerDeck.printComputerHand();
        System.out.println("Computer Board:");
        System.out.println("Player Board  :");
        playerDeck.printPlayerHand();
        System.out.println();
        System.out.println();
        gameTable(1);
    }



	 private void gameTable(int turnNumber) {
    if (turnNumber == 1) {
        System.out.println("Computer Hand : X X X X ");
        System.out.print("Computer Board:");
        printComputerBoardCards();
		System.out.println();
        System.out.print("Player Board  :");
        printPlayerBoardCards();
		drawCardForPlayerBoard();
        playerDeck.printPlayerHand();
        System.out.println("Press s to STAND, press e to end your turn, or press h to use your hand");
        inputFromPlayer = scanner.nextLine();
        inputController();
    } else if (turnNumber == 2) {
        System.out.println("Computer Hand : X X X X ");
        System.out.print("Computer Board:");
        printComputerBoardCards();
        drawCardForComputerBoard();
        System.out.print("Player Board  :");
        printPlayerBoardCards();
		System.out.println();
        playerDeck.printPlayerHand();
        System.out.println("Press s to STAND, press e to end your turn, or press h to use your hand");
		inputFromPlayer2 = scanner.nextLine();
        inputController2();
    }
}
private void gameTableWithoutDrawingACard(int turnNumber) {
    if (turnNumber == 1) {
        System.out.println("Computer Hand : X X X X ");
        System.out.print("Computer Board:");
        printComputerBoardCards();
		System.out.println();
        System.out.print("Player Board  :");
        printPlayerBoardCards();
		System.out.println();
        playerDeck.printPlayerHand();
        System.out.println("Press s to STAND, press e to end your turn, or press h to use your hand");
        inputFromPlayer = scanner.nextLine();
        inputController();
    } else if (turnNumber == 2) {
        System.out.println("Computer Hand : X X X X ");
        System.out.print("Computer Board:");
        printComputerBoardCards();
        System.out.print("Player Board  :");
        printPlayerBoardCards();
		System.out.println();
        playerDeck.printPlayerHand();
        System.out.println("Press s to STAND, press e to end your turn, or press h to use your hand");
		inputFromPlayer2 = scanner.nextLine();
        inputController2();
    }
}


	private void inputController() {
        if (inputFromPlayer.equals("h")) {
            playerDeck.printPlayerHandWithNumber();
            System.out.println("Choose the card you want to play:");
            String inputFromPlayerHand = scanner.nextLine();
            int cardNumber = Integer.parseInt(inputFromPlayerHand);
            
			if(cardNumber == 1){
			playerBoardCards(throwedCardFromPlayerHand(1));
			playerDeck.setPlayerHand(cardNumber);
			gameTableWithoutDrawingACard(1);
			}else if(cardNumber == 2){
			playerBoardCards(throwedCardFromPlayerHand(2));
			playerDeck.setPlayerHand(cardNumber);
			gameTableWithoutDrawingACard(1);
			}else if(cardNumber == 3){
			playerBoardCards(throwedCardFromPlayerHand(3));
			playerDeck.setPlayerHand(cardNumber);			
			gameTableWithoutDrawingACard(1);
			}else if(cardNumber == 4){
			playerBoardCards(throwedCardFromPlayerHand(4));	
			playerDeck.setPlayerHand(cardNumber);
			gameTableWithoutDrawingACard(1);
			}
			
        } else if (inputFromPlayer.equals("s")) {
			
        } else if (inputFromPlayer.equals("e")) {
            System.out.println("Turn passed to the computer");
            gameTable(2);
        }
        }
    private void inputController2() {
        if (inputFromPlayer2.equals("h")) {
            playerDeck.printPlayerHandWithNumber();
            System.out.println("Choose the card you want to play:");
            String inputFromPlayerHand = scanner.nextLine();
            int cardNumber = Integer.parseInt(inputFromPlayerHand);
            playerDeck.setPlayerHand(cardNumber);
        } else if (inputFromPlayer2.equals("s")) {
        } else if (inputFromPlayer2.equals("e")) {
            System.out.println("Turn passed to the player");
            gameTable(1);
        }
    }
	
	public void printComputerBoardCards() {
    for (int i = 0; i < computerBoardCards.length; i++) {
        if (computerBoardCards[i] != null) {
            System.out.print(computerBoardCards[i].toString());
            if (i < computerBoardCards.length - 1) {
                System.out.print(", ");
            }
        }
    }
}

	public void printPlayerBoardCards() {
    for (int i = 0; i < playerBoardCards.length; i++) {
        if (playerBoardCards[i] != null) {
            System.out.print(playerBoardCards[i].toString());
            if (i < playerBoardCards.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
	private Cards throwedCardFromPlayerHand(int thenumberofthrowedcard){
		return playerDeck.getPlayerHand()[thenumberofthrowedcard - 1];
	}
	

	public Cards drawCardForComputerBoard(){
		withdrawncard = Game.gameDeck.getDrawCard();// gamedeck teki en üstteki kart
		computerBoardCards(withdrawncard);
		System.out.println(withdrawncard);
		return withdrawncard;
		}
	public Cards drawCardForPlayerBoard(){
		withdrawncard = Game.gameDeck.getDrawCard();// gamedeck teki en üstteki kart
		System.out.println(withdrawncard);
		playerBoardCards(withdrawncard);
		return withdrawncard;
		}
	public Cards[] playerBoardCards(Cards withdrawncard){
		
			playerBoardCards[k] = withdrawncard;
			k += 1 ;
			return playerBoardCards;
		}
	public void computerBoardCards(Cards withdrawncard){
			computerBoardCards[l] = withdrawncard;
			l += 1 ;
			

	}

		
		
	
	
	/*while(!setFinished){
		System.out.print("Computer Hand :");
		System.out.print("Computer Board: ");
		System.out.print("Player Board  :");
		System.out.print("Player Hand   :");
	setFinished = 	
	}*/

	
	
	
	/*public boolean finishGameŞart(){
			if(getPlayerSetPointToplam() == 3  || getComputerSetPointToplam()  == 3 ){
				return true;	
			}
			return false;
		}
public void gameFinish(){
	while(!gameFinished){
		if(computerWinsSet()){
			setComputerWinsSet();
		}if(playerWinsSet()){
			setPlayerWinsSet();
			
		}
		gameFinished = finishGameŞart();
	}
	
	finishGame();
}

private void startTurn(){
	if(finishSet()){
	turnRestart();
	}
}
private void turnRestart(){
	runGame();
}

private boolean finishSet(){
	if(getPlayerBoardToplam() > 20 && getComputerBoardToplam() <= 20){// player busts
		computerWinsSet();
		return true;
	}else if(getPlayerBoardToplam() <= 20 && getComputerBoardToplam() > 20){//computer busts
	playerWinsSet();
	return true;
	}
	if(getPlayerBoardToplam() < 20 && getComputerBoardToplam() < 20){// 20 nin altındaki kazanç durumu
		if(getPlayerBoardToplam() < getComputerBoardToplam()){
		computerWinsSet();
			return true;
		}else if (getPlayerBoardToplam() > getComputerBoardToplam()){
			playerWinsSet();
			return true;
		}
		else{ // 20 nin altındaki berabere durumu
			computersetpoint = computersetpoint;
			playersetpoint = playersetpoint;
			turnRestart();
		}
	}
	if(getPlayerBoardToplam() == 20 && getComputerBoardToplam() == 20){// iki oyuncunun da 20 de turu bitirmesi durumu
		computersetpoint = computersetpoint;
		playersetpoint = playersetpoint;
		
		turnRestart();
	}
	if(getPlayerBoardToplam() > 20 && getComputerBoardToplam() > 20){// player and computer busts
		 computersetpoint = computersetpoint;
		 playersetpoint = playersetpoint;
		 
		 turnRestart();
	}
	if(pboardcardnumber== 9 && getPlayerBoardToplam() <= 20 ){// player boardda 9 kart olması ve kartların toplamının 20 den az olması durumu
		playerWinsSet();
		return true;
	}else if (cboardcardnumber == 9 && getComputerBoardToplam() <= 20){// computer boardda 9 kart olması ve kartların toplamının 20 den az olması durumu
		computerWinsSet();
		return true;
		}return false;
	
}
private void setPlayerBoardToplam(String sign , int value){
	if(sign == "+"){
		pboardtoplam += value;
	}else pboardtoplam -= value;
}
private void setComputerBoardToplam(String sign , int value){
	if(sign == "+"){
		cboardtoplam += value;
	}else cboardtoplam -= value;
}
private int getPlayerBoardToplam(){
	return pboardtoplam;
}

private int getComputerBoardToplam(){
	return cboardtoplam;
}
private boolean computerWinsSet(){
	return true;
}
private boolean playerWinsSet(){
	return true;
}
private int setPlayerWinsSet(){
	return playersetpointtoplam += 1;
}
private int setComputerWinsSet(){
	return computersetpointtoplam += 1;
}
private int getPlayerSetPointToplam(){
	return playersetpointtoplam;
}
private int getComputerSetPointToplam(){
	return computersetpointtoplam;
}
private static void finishGame(){
	System.out.println("Oyun Bitmiştir");
}*/

}



