package Homework4;

public class Player {

    private String name;
    private int experience; //0 - 1000
    private Stats stats;
    private Status status;
    private int id;
    private static int count = 0;

    public Player(String name, int experience, Stats stats, Status status){
        this.name = name;
        this.experience = experience;
        this.stats = new Stats(stats);
        this.status = new Status(status);
        count++;
        id = (int)Math.random()*10000; // random id number from 0 to 9999
    }

    public Player(Object playerObject) throws Exception {
        if (playerObject == null || playerObject.getClass() != this.getClass()){
            throw new Exception("Object in player copy constructor is not a player object");
        }
        name = ((Player) playerObject).name;
        experience = ((Player) playerObject).experience;
        stats = new Stats(((Player) playerObject).stats);
        status = new Status(((Player) playerObject).status);
        id = ((Player) playerObject).id;
        count++;
    }

    @Override
    public String toString(){
        return "name:" + name + " experience:" + experience + " stats:(" + stats.toString() + ") status:(" + status.toString() + ") id:" + id;
    }

    @Override
    public boolean equals(Object other){
        if (other == null || getClass() != other.getClass()){
            return false;
        } else {
            if (name == ((Player) other).name && experience == ((Player) other).experience && stats.equals(stats) && status.equals(status) && id == ((Player) other).id){
                return true;
            }
            return false;
        }
    }
}
