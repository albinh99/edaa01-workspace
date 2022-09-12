package Game;

public abstract class Player {

    protected String userId;
    private int n;

    protected Player(String name){
        this.userId = name;
    }

    public String getUserId() {
        return userId;
    }

    public void takePins(Board bräda, int n){
        bräda.takePins(n);

    }



}
