/*
* The Square class contains information regarding each square on the main gamboard including its title
* the number of bonus spins it grants if any, the prize value and the name of the assosiated image file
*/

public class Square {

    protected int spins;
    protected int value;
    protected String title;
    protected String image;

    /*
    * Constructor to create Square without image
    */

    public Square() {
        this.title = "";
        this.value = 0;
        this.spins = 0;
        this.image = "none"; 
    }

    public Square(String title, int value, int spins) {
        this.title = title;
        this.value = value;
        this.spins = spins;
        this.image = "none";
    }

    /*
    * Constructor to create Square with image
    */

    public Square(String title, int value, int spins, String image) {
        this.title = title;
        this.value = value;
        this.spins = spins;
        this.image = image;
    }
    
    /** 
    * Copy Constructor
    */
    public Square(Square sqr){
        this.title = sqr.title;
        this.value = sqr.value;
        this.spins = sqr.spins;
        this.image = sqr.image;
    }

    /*
    * @param title is assigned to the Square title
    */
    public void setTitle(String title){
        String newtitle = title;
        this.title = newtitle;
    }

    /*
    * @param value is assigned to the Square value
    */    
    public void setValue(int value){
        int newValue = value;
        this.value = newValue;
    }

    /*
    * @param spins is assigned to the Square spins
    */    
    public void setSpins(int spins){
        int newSpins = spins;
        this.spins = newSpins;
    }

    /*
    * @return the square title
    */
    public String getTitle(){
        Square copySquare = new Square(this.title, this.value, this.spins, this.image);
        return copySquare.title;
    }

        /*
    * @return the square title
    */
    public String getImage(){
        Square copySquare = new Square(this.title, this.value, this.spins, this.image);
        return copySquare.image;
    }

    /*
    * @return the square bonus spins
    */
    public int getSpins(){
        Square copySquare = new Square(this.title, this.value, this.spins, this.image);
        return copySquare.spins;
    }

    /*
    * @return the square value
    */
    public int getValue(){
        Square copySquare = new Square(this.title, this.value, this.spins, this.image);
        return copySquare.value;
    }

}
