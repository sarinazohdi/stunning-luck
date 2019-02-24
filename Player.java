/*
* The Player class keeps track of the player's status throughout the game
* This class can modify and access the player name, number of spins, score and the number of strikes
*/
public class Player{
    private String name;
    private int numOfSpins;
    private int score;
    private int strikes;
    private ArrayList<Square> awards = new ArrayList<Square>();
    /* setter constructor that allows you to set all the instance variables in the new object
    * @param setName gets assigned to the player name
    * @param setSpins gets assigned to the number of spins 
    * @param setScore gets assigned to the player score
    * @param setStrikes gets assigned to the number of strikes
    */
    public Player(String setName, int setSpins, int setScore, int setStrikes){
        this.name = setName;
        this.numOfSpins = setSpins;
        this.score = setScore;
        this.strikes = setStrikes;
        this.awards = new ArrayList<Square>();
    }
    /*Default constructor that allows you to set the name and gives the other instance variables their default values
    * @param setName gets assigned to the player name
    */
    public Player(String setName){
        this.name = setName;
        this.numOfSpins = 0;
        this.score = 0;
        this.strikes = 0;
        this.awards = new ArrayList<Square>();
    }
    /*Copy Constructor
    * @param p of type Player who's instance variables get copied and reassigned to this object
    */
    public Player(Player p){
        this.name = p.name;
        this.numOfSpins = p.numOfSpins;
        this.score = p.score;
        this.strikes = p.strikes;
        this.awards = p.awards;
    }
    /*
    * @return the name of the player
    */
    public String getName(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.name;
    }
    /*
    * @return the number of spins the player has accumulated
    */
    public int getSpins(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.numOfSpins;
    }
    
    /*
    * @return the player score
    */
    public int getScore(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.score;
    }
    
    /*
    * @return the number of strikes
    */
    public int getStrikes(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.strikes;
    }
    
    /*
    * @param newName is assigned to the player name
    */
    public void setName(String newName){
        this.name = newName;
    }
    
    /*
    * @param newSpins is assigned to the numOfSpins instance variable
    */
   
    public void setSpins(int newSpins){
        this.numOfSpins = newSpins;
    }
    
    /**
    *@param addedSpins is added to the already existing number of spins
    */
    public void addSpins(int addedSpins){
        this.numOfSpins += addedSpins;
    }
    /*
    * @param newScore is assigned to the score instance variable
    */
   
    public void setScore(int newScore){
        this.score = newScore;
    }
    
    /*
    * @param newStrikes is assigned to the strikes instance variable
    */
   
    public void setStrikes(int newStrikes){
        this.strikes = newStrikes;
    }
    
    public void addAward(Square newAward){
        this.awards.add(newAward);
    }
}
