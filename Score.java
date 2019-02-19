/**
  * The player class keeps track of the players' scores in the game.
  * This class will store and properly manipulate players' scores according to the rules of the game.
  */
public class Score {
  private int Score;
  private int result;
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
    * A method that increases/decreases the score of the player.
    * For now, I made it so that "win" is when result equals to 1, "lose" is when result equals 0 and "lose all (reset)" is when result = -1.
    * This method is just temporar. I can add/change all the details once we set all the specific rules of the game.
    */
  public void changeScore(){
    if (result == 1)
    Score += 1;
    System.out.println("You won! Your score is:" + Score);
    if (result == 0)
    Score -= 1;
    System.out.println("You lost! Your score is:" + Score);
    if (result == -1)
    Score = 0;
    System.out.println("You lost everything! Your score will be set to 0.");
  }
}
