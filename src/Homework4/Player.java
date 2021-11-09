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

    public Player(Object playerObject) throws Exception { // copy constructor
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

    public void setExperience(int experience){
        this.experience = experience;
    }

    public int getExperience(){
        return experience;
    }

    public void setStats(Stats stats){
        if (stats == null){
            throw new NullPointerException();
        }
        this.stats = new Stats(stats);
    }

    public Stats getStats(){
      return new Stats(stats);
    }

    public void setStatus(Status status){
        if (status == null){
            throw new NullPointerException();
        }
        this.status = new Status(status);
    }

    public Status getStatus(){
        return new Status(status);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public void setId(int a){
        id = a;
        if (id >= 10000){
            id = 9999;
        }
        if (id < 0){
            id = 0;
        }
    }

    public void addExperience(int newExperience){
        experience += newExperience;
        if (experience > 1000){
            experience = 1000;
        }
    }

    public static int getNumberOfPlayers(){
        return count;
    }



    @Override
    public String toString(){
        return "Name:" + name + "\nExperience:" + experience + "\nSTATS\n" + stats.toString() + "\nSTATUS\n" + status.toString() + "\nId:" + id + "\n";
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
