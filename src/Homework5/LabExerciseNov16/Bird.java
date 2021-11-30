package Homework5.LabExerciseNov16;

public class Bird extends Pet{

    public void speak(){
        System.out.println("chirp");
    }

    @Override
    public void move(){
        System.out.println(getName() + " flies across the room");
    }
}
