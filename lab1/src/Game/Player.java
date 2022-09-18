package Game;

public abstract class Player {

    protected String userId;

    protected Player(String name){
        this.userId = name;
    }

    public String getUserId() {
        return userId;
    }

    public abstract int takePins(Board bräda);

    }




