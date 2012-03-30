import junit.framework.TestCase;

/**
 * Tests for the tennis game
 * @author Dennis van den Waardenburg
 * @author Tim Muller
 *
 */
public class TennisGameTest extends TestCase {
	/**
	 * Initial game between Rafael Nadal & Novak Dokovic
	 */
	TennisGameTDD game = new TennisGameTDD("Rafael Nadal" , "Novak Dokovic");
	
	public void testStartGameWithNoScore()
	{
		String score = game.getScore();

		assertEquals("Love beide", score);
	}

	public void testPlayerOneScoresFirstPoint()
	{
		game.spelerEenScoort();
		String score = game.getScore();
		
		assertEquals("Vijftien,Love", score);		
	}

	public void testBothPlayersScoreOnePoint(){
		game.spelerEenScoort();
		game.spelerTweeScoort();
		String score = game.getScore();
		
		assertEquals("Vijftien beide", score);
	}

	public void testPlayerTwoScoresTwoTimesInARow() {
		createScore(0, 2);
		String score = game.getScore();
		
		assertEquals("Love,Dertig", score);
	}

	public void testPlayerOneScoresThreeTimesInARow(){
		createScore(3, 0);
		String score = game.getScore();
		
		assertEquals("Veertig,Love", score);
	}

	public void TestBothPlayersPlayUntilDeuce() {
		createScore(3, 3);
		String score = game.getScore();
		
		assertEquals("Deuce", score);		
	}

	public void testPlayerOnePlayesALoveGame(){
		createScore(4, 0);
		String score = game.getScore();
		
		assertEquals("Rafael Nadal wint", score);
	}

	public void testPlayerTwoWinsAGame(){
		createScore(1,4);
		String score = game.getScore();
		
		assertEquals("Novak Dokovic wint", score);
	}

	public void testBothPlayersScore4Times() {
		createScore(4, 4);
		String score = game.getScore();
		
		assertEquals("Deuce", score);		
	}

	public void testPlayerTwoIsInAdvantage(){
		createScore(4, 5);
		String score = game.getScore();
		
		assertEquals("Voordeel Novak Dokovic", score);
	}

	public void testPlayerOneAdvantage(){
		createScore(5, 4);
		String score = game.getScore();
		
		assertEquals("Voordeel Rafael Nadal", score);
	}

	public void testPlayerTwoWinsAGameAgain(){
		createScore(2, 4);
		String score = game.getScore();
		
		assertEquals("Novak Dokovic wint", score);
	}

	public void testPlayerTwoWinsAfterAdvantage() {
		createScore(6, 8);
		String score = game.getScore();
		
		assertEquals("Novak Dokovic wint", score);
	}

	public void testPlayerOneWinsAfterAdvantage() {
		createScore(8, 6);
		String score = game.getScore();
		
		assertEquals("Rafael Nadal wint", score);
	}

	/**
	 * Methode om een score aan te maken. Wordt gebruikt door (bijna) alle tests.
	 * @param playerOneBalls
	 * @param playerTwoBalls
	 * @return void
	 */
	private void createScore(int playerOneBalls, int playerTwoBalls ) {
		for (int i = 0; i < playerOneBalls; i++) {
			game.spelerEenScoort();
		}
		for (int i = 0; i < playerTwoBalls; i++) {
			game.spelerTweeScoort();
		}
	}
}
