package Homework4;

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
        intelligence += amount;
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

    @Override
    public boolean equals(Object other){
        if (other == null || getClass() != other.getClass()){
            return false;
        } else {
            if (strength == ((Stats) other).strength && intelligence == ((Stats) other).intelligence && stamina == ((Stats) other).stamina){
                return true;
            }
            return false;
        }
    }

    @Override
    public String toString(){
        return "strength:" + strength + " intelligence:" + intelligence + " stamina:"  + stamina;
    }
}
