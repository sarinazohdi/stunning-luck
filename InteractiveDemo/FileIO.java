import java.io.*;

public class FileIO{
    private String  fileName = "gameData.txt";
    
    public static void write(String name, int score, int spins, int miniGames){
        String line1= name;
        String line2= Integer.toString(score);
        String line3 = Integer.toString(spins);
        String line4 = Integer.toString(miniGames);
        //String line2="Second line";
        try {
            FileWriter fwriter = new FileWriter("gameData.txt");
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            bwriter.write(line1);
            bwriter.newLine();
            bwriter.write(line2);
            bwriter.newLine();
            bwriter.write(line3);
            bwriter.newLine();
            bwriter.write(line4);
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
            breader.close();   
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
            breader.close();
        
        }
        catch(IOException ioe) {
            System.out.println("Exception : " + ioe);
        }
        return line;
    }
    public static String readMiniGameCount(){
        String line = " ";
        try {
            FileReader freader = new FileReader("gameData.txt");
            BufferedReader breader = new BufferedReader(freader);
            breader.readLine();
            breader.readLine();
            breader.readLine();
            line = breader.readLine();
            breader.close();
        }
        catch(IOException ioe) {
            System.out.println("Exception : " + ioe);
        }
        return line;
    }

    public static void main(String args[]){
        //FileIO file = new FileIO();
        write("Firoz", 50,20,30);
        System.out.println(readName());
    }
}