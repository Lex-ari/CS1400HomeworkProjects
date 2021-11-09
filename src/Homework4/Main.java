package Homework4;

public class Main {

    public static void main(String[] args) throws Exception {
        // for reference, Stats(int strength, int intelligence, int stamina) each 1-12 totals 20
        // for reference, Status(int hitPoints (0-25), int hunger (0-15), int sleepiness(0-15))
        // for reference, Player(String name, int experience (0-1000), Stats stats, Status status)

        Stats stats = new Stats(5, 10, 5);
        Status status = new Status(0, 0, 0);
        Player kazuma = new Player("Kazuma Sato", 500, stats, status);

        stats = new Stats(5, 3, 12);
        Player aqua = new Player("Aqua", 0, stats, status);

        status.setHunger(15);
        Player darkness = new Player("Darkness Lalatina", 0, aqua.getStats(), status);

        status.setHunger(0);
        stats.moveStaminaToStrength(8);
        Player megumin = new Player("Megumin", 700, stats, status);

        System.out.println("Listing party members...");
        System.out.println(kazuma);
        System.out.println(aqua);
        System.out.println(darkness);
        System.out.println(megumin);
        System.out.println();

        System.out.println("Megumin casts EXUSPLOSION!");
        megumin.setStatus(new Status(1, 0, 15));
        System.out.println("Megumin used up all her mana and can no longer fight.");
        System.out.println("Updated Megumin:");
        System.out.println(megumin);
        System.out.println();
    }
}
