package Homework4;

// Code by Alex Mariano
// CS 1400
// Professor David Johannsen


public class Status {

    private int hitPoints; // 0 - 25
    private int hunger; // 0 - 15
    private int sleepiness; // 0 -15

    public Status(int hitPoints, int hunger, int sleepiness){
        this.hitPoints = hitPoints;
        this.hunger = hunger;
        this.sleepiness = sleepiness;
        ensureValidity();
    }

    public Status(Status statusObject){
        if (statusObject == null){
            throw new NullPointerException();
        }
        hitPoints = statusObject.hitPoints;
        hunger = statusObject.hunger;
        sleepiness = statusObject.sleepiness;
    }

    public void setHitPoints(int value){
        hitPoints = value;
        ensureValidity();
    }

    public void setHunger(int value){
        hunger = value;
        ensureValidity();
    }

    public void setSleepiness(int value){
        sleepiness = value;
        ensureValidity();
    }

    public int getHitPoints(){return hitPoints;}
    public int getHunger(){return hunger;}
    public int getSleepiness(){return sleepiness;}

    public void addHitPoints(int delta){
        hitPoints += delta;
        ensureValidity();
    }

    public void addHunger(int delta){
        hunger += delta;
        ensureValidity();
    }

    public void addSleepiness(int delta){
        sleepiness += delta;
        ensureValidity();
    }

    @Override
    public String toString(){
        return "HitPoints:" + hitPoints + ", Hunger:" + hunger + ", Sleepiness:" + sleepiness;
    }

    @Override
    public boolean equals(Object other){
        if (other == null || Status.class != other.getClass()){
            return false;
        } else {
            if (hitPoints == ((Status) other).getHitPoints() && hunger == ((Status) other).getHunger() && sleepiness == ((Status) other).getSleepiness()){
                return true;
            }
            return false;
        }
    }

    private void ensureValidity(){
        if (hitPoints > 25){
            hitPoints = 25;
        }
        if (hitPoints < 0){
            hitPoints = 0;
        }
        if (hunger > 15){
            hunger = 15;
        }
        if (hunger < 0){
            hunger = 0;
        }
        if (sleepiness > 15){
            sleepiness = 15;
        }
        if (sleepiness < 0){
            sleepiness = 0;
        }
    }
}
