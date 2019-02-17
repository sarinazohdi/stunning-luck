public class Player{
    private String name;
    private int numOfSpins;
    private int score;
    private int strikes;
    //setter constrcutor that allows you to set all the iunstacne variables in the new object
    public Player(String setName, int setSpins, int setScore, int setStrikes){
        this.name = setName;
        this.numOfSpins = setSpins;
        this.score = setScore;
        this.strikes = setStrikes;
    }
    //Default constructor that allows you to set the name and gives the other instance variables their default values
    public Player(String setName){
        this.name = setName;
        this.numOfSpins = 0;
        this.score = 0;
        this.strikes = 0;
    }
    //Copy Constructor
    public Player(Player p){
        this.name = p.name;
        this.numOfSpins = p.numOfSpins;
        this.score = p.score;
        this.strikes = p.strikes;
    }

    public String getName(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.name;
    }

    public Int getSpins(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.numOfSpins;
    }

    public Int getScore(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.score;
    }
    
    public Int getStrikes(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.strikes;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSpins(Int newSpins){
        this.numOfSpins = newSpins;
    }
    
    public void setScore(Int newScore){
        this.score = newScore;
    }

    public void setStrikes(Int newStrikes){
        this.strikes = newStrikes;
    }
}