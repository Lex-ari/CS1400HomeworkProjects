package Homework4;

// Code by Alex Mariano
// CS 1400
// Professor David Johannsen

public class Main {

    public static void main(String[] args) throws Exception {
        // for reference, Stats(int strength, int intelligence, int stamina) each 1-12 totals 20
        // for reference, Status(int hitPoints (0-25), int hunger (0-15), int sleepiness(0-15))
        // for reference, Player(String name, int experience (0-1000), Stats stats, Status status)

        System.out.println();
        System.out.println("/// START OF PROGRAM ///");
        System.out.println();
        Stats stats;
        Status status;
        System.out.println("(TEST1): Attempting to set a Stats object's parameters out of bounds... > 12");
        try {
            stats = new Stats(100, 100, 100);
            System.out.println("Values successfully set out of range"); // this should not happen.
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
            System.out.println("(TEST1): Exception appropriately caught.");
            stats = new Stats(5, 10, 5);
        }

        Player kazuma;
        try {
            status = new Status(0, 0, 0);
            kazuma = new Player("Kazuma Sato", 500, stats, status);
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
            stats = new Stats(7, 6, 7);
            status = new Status(0, 0, 0);
            kazuma = new Player("Kazuma Sato", 0, stats, status);
        }

        Player aqua;
        System.out.println("(TEST2): Attempting to copy a Stats object from null");
        try {
            stats = new Stats(null);
            aqua = new Player("Aqua", 0, stats, status); // this shouldn't happen
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
            System.out.println("(TEST2): Exception appropriately caught");
            stats = new Stats(5, 3, 12);
            status = new Status(0, 0, 0);
            aqua = new Player("Aqua", 0, stats, status);
        }

        Player darkness ;
        try {
            status.setHunger(15);
            darkness = new Player("Darkness Lalatina", 0, aqua.getStats(), status);
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
            stats = new Stats(7, 6, 7);
            status = new Status(0, 0, 0);
            darkness = new Player("Darkness Lalatina", 0, stats, status);
        }

        Player megumin;
        try {
            status.setHunger(0);
            stats.moveStaminaToStrength(7);
            stats.moveStrengthToIntelligence(7);
            megumin = new Player("Megumin", 700, stats, status);
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
            stats = new Stats(7, 6, 7);
            status = new Status(0, 0, 0);
            megumin = new Player("Megumin", 0, stats, status);
        }

        System.out.println("Listing party members...");
        System.out.println("There are currently " + Player.getNumberOfPlayers() + " players in this party");
        System.out.println();
        System.out.println(kazuma);
        System.out.println(aqua);
        System.out.println(darkness);
        System.out.println(megumin);
        System.out.println();

        System.out.println("Megumin casts EXUSPLOSION!!!");
        try {
            Status meguminUpdatedStatus = new Status(1, 0, megumin.getStatus().getSleepiness() + 15);
            meguminUpdatedStatus.addHunger(5);
            megumin.setStatus(meguminUpdatedStatus);
            System.out.println("Megumin used up all her mana and can no longer fight.");
            megumin.addExperience(10);
            System.out.println("Updated Megumin:");
            System.out.println(megumin);
            System.out.println();
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
            System.out.println(megumin.getName() + "'s stats and status did not receive any changes.");
        }

        System.out.println("Oh no! Vanir approaches and takes the same form as Darkness!");
        Player vanir;
        System.out.println("(TEST3): Attempting to copy a player with a Stats object passed in");
        try {
            vanir = new Player(darkness.getStats());
            System.out.println("Successfully copied darkness's stats to vanir character"); // this shouldn't happen
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
            System.out.println("(TEST3): Exception appropriately caught");
        }
        try {
            vanir = new Player(darkness);
            System.out.println("Successfully created new Player: " + vanir.getName() + " with the same stats as " + darkness.getName());
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
            vanir = new Player("Vanir", 0, stats, status); //initializing vanir with basic variables. This part of code shouldn't run however.
        }

        System.out.println();
        System.out.println("Is Vanir the same player as Darkness?");
        try {
            if (vanir.equals(darkness)){
                System.out.println("He is! Oh no!");
                System.out.println("Change his name!");
                vanir.setName("Vanir");
                System.out.println("Now we have a Vanir and a Darkness!");
            } else {
                System.out.println("No he isn't. We are safe!");
            }
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
        }
        System.out.println();

        System.out.println("Kazuma slays Vanir with Chunchunmaru");
        try {
            Status updatedVanirStats = vanir.getStatus();
            updatedVanirStats.addHitPoints(10000000);
            vanir.setStatus(updatedVanirStats);
        } catch (Exception e){
            System.out.println("Something went wrong: '" + e + "'");
        }
        System.out.println();
        System.out.println("Final Character Info, Stats, and Status!");
        System.out.println("There are currently " + Player.getNumberOfPlayers() + " players in this party");
        System.out.println();
        System.out.println(kazuma);
        System.out.println(aqua);
        System.out.println(darkness);
        System.out.println(megumin);
        System.out.println(vanir);
    }
}