package Homework4;

// Code by Alex Mariano
// CS 1400
// Professor David Johannsen


public class Stats {

    private int strength; // 1 - 12
    private int intelligence; // 1 - 12
    private int stamina; // 1 - 12

    public Stats(int strength, int intelligence, int stamina) throws Exception {
        this.strength = strength;
        this.intelligence = intelligence;
        this.stamina = stamina;
        checkValidity();
    }

    public Stats(Stats statsObject){
        if (statsObject == null){
            throw new NullPointerException();
        }
        strength = statsObject.strength;
        intelligence = statsObject.intelligence;
        stamina = statsObject.stamina;
    }

    public void moveStrengthToIntelligence(int amount) throws Exception {
        intelligence += amount;
        strength -= amount;
        checkValidity();
    }

    public void moveIntelligenceToStamina(int amount) throws Exception {
        intelligence -= amount;
        stamina += amount;
        checkValidity();
    }

    public void moveStaminaToStrength(int amount) throws Exception {
        stamina -= amount;
        strength += amount;
        checkValidity();
    }

    private void checkValidity() throws Exception {
        boolean valid = true;
        if (strength <= 0 || strength >= 13){
            valid = false;
        }
        if (intelligence <= 0 || intelligence >= 13){
            valid = false;
        }
        if (stamina <= 0 || stamina >= 13){
            valid = false;
        }
        if (strength + intelligence + stamina != 20){
            valid = false;
        }
        if (!valid){ // valid = false
            throw new IllegalArgumentException("Values out of range");
        }

    }

    public int getStrength(){return strength;}
    public int getIntelligence(){return intelligence;}
    public int getStamina(){return stamina;}

    @Override
    public boolean equals(Object other){
        if (other == null || Stats.class != other.getClass()){
            return false;
        } else {
            if (strength == ((Stats) other).getStrength() && intelligence == ((Stats) other).getIntelligence() && stamina == ((Stats) other).getStamina()){
                return true;
            }
            return false;
        }
    }

    @Override
    public String toString(){
        return "Strength:" + strength + ", Intelligence:" + intelligence + ", Stamina:"  + stamina;
    }
}
