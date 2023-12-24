import java.util.Random;

public class ComputerAI {
    private Random random = new Random();
ComputerDeck computerdeck = new ComputerDeck();
GameController gameController = new GameController();
    public ComputerAI() {
    }

    
	private void makeChoiceStand(){	
			System.out.println("Computer chooses to end its turn.");
            gameController.inputFromComputer = "e";
			
		}
		private void makeChoiceUseHand(int theElementOfComputerHand){
			gameController.inputFromComputer = "h";
			gameController.inputFromComputerHand = Integer.toString(theElementOfComputerHand);
		}
		private void makeChoiceEndTurn(){
			gameController.inputFromComputer = "e";
			
		}
	public void computerUseFlipOrDouble(){
		for(int i = 0; i < computerdeck.getComputerHand().length ; i++){
			if(computerdeck.getComputerHand()[i].color.equals("FLIP +/-")){
				for(int j = 0 ; j < computerdeck.getComputerHand().length; j++){
				if(computerdeck.getComputerHand()[j].sign.equals("+")){
					if(gameController.getComputerBoardToplam() - computerdeck.getComputerHand()[j].value == 20){
						makeChoiceUseHand(j + 1);
						makeChoiceUseHand(i + 1);
					}
				}
				if(computerdeck.getComputerHand()[i].sign.equals("-")){
					if(gameController.getComputerBoardToplam() + computerdeck.getComputerHand()[j].value == 20){
						makeChoiceUseHand(j + 1);
						makeChoiceUseHand(i + 1);
					}
				}
				}
			}
			if(computerdeck.getComputerHand()[i].color.equals("DOUBLE")){
				for(int j = 0 ; j < computerdeck.getComputerHand().length; j++){
					if(computerdeck.getComputerHand()[j].sign.equals("+")){
					if(gameController.getComputerBoardToplam() + computerdeck.getComputerHand()[j].value * 2 == 20){
						makeChoiceUseHand(j + 1);
						makeChoiceUseHand(i + 1);
					}
					}
					if(computerdeck.getComputerHand()[j].sign.equals("-")){
					if(gameController.getComputerBoardToplam() - computerdeck.getComputerHand()[j].value * 2 == 20){
						makeChoiceUseHand(j + 1);
						makeChoiceUseHand(i + 1);
					}	
				}	
			}
		}
	}
}
	public void computerMake20(){
		for(int i = 0; i < computerdeck.getComputerHand().length ; i++){
			if(computerdeck.getComputerHand()[i].sign.equals("+")){
			if(gameController.getComputerBoardToplam() + computerdeck.getComputerHand()[i].value == 20){
			makeChoiceUseHand(i + 1);
			makeChoiceStand();
		}	
		}else if(computerdeck.getComputerHand()[i].sign.equals("-")){
				if(gameController.getComputerBoardToplam() - computerdeck.getComputerHand()[i].value == 20){
					makeChoiceUseHand(i + 1);
					makeChoiceStand();
			}
		}
	}
}
private void computerEndTurn(){
	if(gameController.getComputerBoardToplam() <= 12){
		makeChoiceEndTurn();
		}
	else if(gameController.getComputerBoardToplam() == 20){
		makeChoiceEndTurn();
		}
	}
}


