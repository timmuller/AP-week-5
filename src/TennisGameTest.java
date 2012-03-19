
import junit.framework.TestCase;

public class TennisGameTest extends TestCase{
	
	private TennisGame t;
	
	protected void setUp() throws Exception{
		t = new TennisGame();
	}
	
	public void testLoveSet(){
		int serves = 24;
		boolean wonAllServes = false;
		this.playServes(serves, wonAllServes);
		int score = t.getWonGames();
		assertEquals(0, score);
	}
	
	public void testWonSet(){
		int serves = 24;
		boolean wonAllGames = true;
		this.playServes(serves, wonAllGames);
		int score = t.getWonGames();
		assertEquals(6, score);
	}
	
	public void testCurrentGameScoreLostAll(){
		this.playServes(4, false);
		int score = t.getCurrentGameScore();
		assertEquals(0, score);
	}
	
	public void testCurrentGameScoreWinAll(){
		this.playServes(4, true);
		int score = t.getCurrentGameScore();
		assertEquals(4, score);
	}
	
	
	public void playServes(int total, boolean result){
		for(int i = 0; i < total; i++){
			t.wonGame(result);
		}
	}
	
}
