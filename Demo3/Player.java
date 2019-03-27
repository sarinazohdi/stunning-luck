import java.util.ArrayList;

public class Player{
    private String name;
    private int numOfSpins;
    private int score;
    private int strikes;
    private int miniGameCount = 0;
    private ArrayList<Square> awards = new ArrayList<Square>();
    //setter constrcutor that allows you to set all the iunstacne variables in the new object
    public Player(String setName, int setSpins, int setScore, int setStrikes){
        this.name = setName;
        this.numOfSpins = setSpins;
        this.score = setScore;
        this.strikes = setStrikes;
        this.awards = new ArrayList<Square>();
    }
    //Default constructor that allows you to set the name and gives the other instance variables their default values
    public Player(String setName){
        this.name = setName;
        this.numOfSpins = 0;
        this.score = 0;
        this.strikes = 0;
        this.awards = new ArrayList<Square>();
    }
    //Copy Constructor
    public Player(Player p){
        this.name = p.name;
        this.numOfSpins = p.numOfSpins;
        this.score = p.score;
        this.strikes = p.strikes;
        this.awards = p.awards;
    }

    public String getName(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.name;
    }

    public int getSpins(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.numOfSpins;
    }

    public int getScore(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.score;
    }

    public int getStrikes(){
        Player getterPlayer = new Player(this.name, this.numOfSpins, this.score, this.strikes);
        return getterPlayer.strikes;
    }

    public int getMiniGameCount(){
        return this.miniGameCount;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSpins(int newSpins){
        this.numOfSpins = newSpins;
    }

    public void addSpins(int addedSpins){
        this.numOfSpins += addedSpins;
    }

    public void setScore(int newScore){
        this.score = newScore;
    }

    public void setStrikes(int newStrikes){
        this.strikes = newStrikes;
    }

    public void setMiniGameCount(int nMiniGameCount){
        this.miniGameCount = nMiniGameCount;
    }

    public void addMiniGameCount(int i){
        this.miniGameCount += i;
    }

    public void addAward(Square newAward){
        this.awards.add(newAward);
    }

    public ArrayList<Square> getAwards(){
        ArrayList<Square> getterAwards = new ArrayList<Square>();
        for (Square a : this.awards){
            getterAwards.add(a);
        }

        return getterAwards;
    }
}
