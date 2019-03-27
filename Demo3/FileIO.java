import java.io.*;

public class FileIO{
    private String  fileName = "gameData.txt";
    
  /*  private static FileWriter fwriter = new FileWriter("gameData.txt");
    private static BufferedWriter  bwriter = new BufferedWriter(fwriter);
    private static FileReader freader = new FileReader("gameData.txt");
    private static BufferedReader breader = new BufferedReader(freader);
    */
    /*
    public static String readScore(){
        String line = " ";
        try {
            FileReader freader = new FileReader("gameData.txt");
            BufferedReader breader = new BufferedReader(freader);
            line = breader.readLine();
        
        }
        catch(IOException ioe) {
            System.out.println("Exception : " + ioe);
        }
        return line;
    }
    public static void writeScore(int score){
        String line1="High Score: "+ score;
        //String line2="Second line";
        try {
            FileWriter fwriter = new FileWriter("gameData.txt");
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            
            bwriter.write(line1);
            bwriter.newLine();
            bwriter.close();
        }
        catch (IOException ioe) {
            System.out.println("IO EXCEPTION");
        }
    }
    public static void writeName(String name){
        String line2="Name: "+ name;
        //String line2="Second line";
        try {
            FileWriter fwriter = new FileWriter("gameData.txt");
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            
            bwriter.write(line2);
            
            bwriter.close();
        }
        catch (IOException ioe) {
            System.out.println("IO EXCEPTION");
        }
    }*/
    public static void write(String name, int score, int spins){
        String line1= name;
        String line2= Integer.toString(score);
        String line3 = Integer.toString(spins);
        //String line2="Second line";
        try {
            FileWriter fwriter = new FileWriter("gameData.txt");
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            bwriter.write(line1);
            bwriter.newLine();
            bwriter.write(line2);
            bwriter.newLine();
            bwriter.write(line3);
            bwriter.close();
        }
        catch (IOException ioe) {
            System.out.println("IO EXCEPTION");
        }
    }
    public static String readScore(){
        String line = " ";
        try {
            FileReader freader = new FileReader("gameData.txt");
            BufferedReader breader = new BufferedReader(freader);
            breader.readLine();
            line = breader.readLine();
        
        }
        catch(IOException ioe) {
            System.out.println("Exception : " + ioe);
        }
        return line;
    }
    public static String readName(){
        String line = " ";
        try {
            FileReader freader = new FileReader("gameData.txt");
            BufferedReader breader = new BufferedReader(freader);
            //breader.readLine();
            line = breader.readLine();    
        }
        catch(IOException ioe) {
            System.out.println("Exception : " + ioe);
        }
        return line;
    }
    public static String readSpins(){
        String line = " ";
        try {
            FileReader freader = new FileReader("gameData.txt");
            BufferedReader breader = new BufferedReader(freader);
            breader.readLine();
            breader.readLine();
            line = breader.readLine();
        
        }
        catch(IOException ioe) {
            System.out.println("Exception : " + ioe);
        }
        return line;
    }

    public static void main(String args[]){
        //FileIO file = new FileIO();
        write("Firoz", 50,20);
        System.out.println(readName());
    }
}