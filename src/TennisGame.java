
public class TennisGame {

	private int wonGames = 0;
	
	public void wonGame(boolean gameWon){
		if( gameWon == true) {
			this.wonGames++;
		}
	}
	
	public int getWonGames(){
		return this.wonGames / 4;
	}
	
	public int getCurrentGameScore(){
		return 0;
	}
	
}