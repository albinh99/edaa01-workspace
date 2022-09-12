package Game;

public class Board {
    private int noPins;
    public Board(int noPins) {
        this.noPins = noPins;
    }

    public void setUp(int pinnarStart){
        noPins = pinnarStart;

    }

    public void takePins(int taPinnar){
        noPins -= taPinnar;

    }

    public void getNoPins(){
        System.out.println(noPins);
    }


}
