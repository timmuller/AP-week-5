
import junit.framework.TestCase;

public class TennisGameTest extends TestCase{
	
	private TennisGame t;
	
	protected void setUp() throws Exception{
		t = new TennisGame();
	}
	
	public void testLoveSet(){
		int games = 24;
		boolean wonAllGames = false;
		this.playGames(games, wonAllGames);
		int score = t.getWonGames();
		assertEquals(0, score);
	}
	
	public void testWonSet(){
		int games = 24;
		boolean wonAllGames = true;
		this.playGames(games, wonAllGames);
		int score = t.getWonGames();
		assertEquals(24, score);
	}
	
	public void playGames(int total, boolean result){
		for(int i = 0; i < total; i++){
			t.wonGame(result);
		}
	}
	
}
