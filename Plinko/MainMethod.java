public class MainMethod{
    public static void main(String[] args){
        Player player = new Player("john doe");
        String[] starter = new String[] {"1","2","3"};
        PlinkoGui.main(starter);
        player.setSpins(PlinkoGui.getSpinsFromPlinko());
    }
}
