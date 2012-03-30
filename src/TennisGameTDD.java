/**
 * Tennisgame class
 * @author Dennis vd Waardenburg <dennis@vdwaardenburg.nl>
 * @author Tim Muller
 *
 */
public class TennisGameTDD {

	/**
	 * Score van speler een
	 */
	private int playerOneScore = 0;
	/**
	 * Score van speler twee
	 */
	private int playerTwoScore = 0;
	/**
	 * De naam van speler twee
	 */
	private String playerTwoName;
	/**
	 * De naam van speler een
	 */
	private String playerOneName;

	/**
	 * Set up the TennisGame
	 * @param namePlayerOne
	 * @param namePlayerTwo
	 * @return void
	 */
	public TennisGameTDD(String namePlayerOne, String namePlayerTwo) {
		this.playerOneName = namePlayerOne;
		this.playerTwoName = namePlayerTwo;
	}

	/**
	 * Display the score
	 * @return
	 */
	public String getScore() {
		if (this.hasWinner() == true) {
			return this.playerWithHighestScore() + " wint";
		}
		
		if (this.hasAdvantage() == true) {
			return "Voordeel " + this.playerWithHighestScore();
		}
		
		if (this.isDeuce() == true) {
			return "Deuce";
		}

		if (this.playerOneScore == this.playerTwoScore) {
			return translateScore(this.playerOneScore) + " beide";
		}

		return translateScore(this.playerOneScore) + "," + translateScore(this.playerTwoScore);
	}

	/**
	 * Return is the game is deuce (gelijkspel)
	 * @return
	 */
	private boolean isDeuce() {
		return this.playerOneScore >= 3 && this.playerTwoScore == this.playerOneScore;
	}

	/**
	 * Who has the highest score?
	 * @return
	 */
	private String playerWithHighestScore() {
		if (this.playerOneScore > this.playerTwoScore) {
			return this.playerOneName;
		} else {
			return this.playerTwoName;
		}
	}

	/**
	 * Who is the winner of the game?
	 * @return
	 */
	private boolean hasWinner() {
		if(this.playerTwoScore >= 4 && this.playerTwoScore >= this.playerOneScore + 2) {
			return true;
		}
		if(this.playerOneScore >= 4 && this.playerOneScore >= this.playerTwoScore + 2) {
			return true;
		}
		return false;
	}

	/**
	 * Is there advantage?
	 * @return
	 */
	private boolean hasAdvantage() {
		if (this.playerTwoScore >= 4 && this.playerTwoScore == this.playerOneScore + 1) {
			return true;
		}
		if (this.playerOneScore >= 4 && this.playerOneScore == this.playerTwoScore + 1) {
			return true;
		}

		return false;

	}

	/**
	 * Speler een scoort
	 */
	public void spelerEenScoort() {
		this.playerOneScore++;
	}

	/**
	 * Speler twee scoort
	 */
	public void spelerTweeScoort() {
		this.playerTwoScore++;
	}

	/**
	 * Vertalen van een score naar string
	 * @param score
	 * @return string
	 * @throws IllegalArgumentException
	 */
	private String translateScore(int score) {
		switch (score)
		{
			case 3:
				return "Veertig";
			case 2:
				return "Dertig";
			case 1: 
				return "Vijftien";
			case 0:
				return "Love";
		}
		throw new IllegalArgumentException("Foutieve score: " + score);
	}
}