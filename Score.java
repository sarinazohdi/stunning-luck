/**
  * The player class keeps track of the players' scores in the game.
  * This class will store and properly manipulate players' scores according to the rules of the game.
  */
public class Score {
  private int Score;
/**
  /* A constructor that sets the initial score in new objects.
  * @param initialScore is assigned to the score.
  */
  public Score(int initialScore){
    Score = initialScore;
  }
/**
  * A default constructor that sets the initial score of the player to zero.
  */
  public Score(){
    Score = 0;
  }
  /**
    * A getter method that returns the score of the player.
    */
  public int getScore(){
    Score s = new Score (Score);
    return s.Score;
  }
  /**
    * A setter method that sets the score of the player.
    * @param nScore is assigned to the score only if nScore is greater than or equal to zero.
    */
  public void setScore(int nScore){
    if (nScore >= 0)
    Score = nScore;
  }
 /**
    * A method that increases the score of the player by the points gained.
    * @param addedScore is the numerical value of the points won.
    */
  public void addScore(int addedScore){
    Score += addedScore;
  }
  /**
    * A method that decreases the score of the player by the points lost.
    * @param subtractScore is the numerical value of the points lost.
    */
  public void subtractScore(int subtractedScore){
    Score -= subtractedScore;
  }
}
