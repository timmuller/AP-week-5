
import junit.framework.TestCase;

public class TennisGameTest extends TestCase{
	public void testLoveSet(){
		TennisGame t = new TennisGame();
		for (int i = 0; i < 24; i++){
			t.wonGame(false);
		}
		int score = t.getWonGames();
		assertEquals(0, score);
	}
	
	public void testWonSet(){
		TennisGame t = new TennisGame();
		for(int i = 0; i < 24; i++){
			t.wonGame(true);
		}
		int score = t.getWonGames();
		assertEquals(24, score);
	}
	
}
