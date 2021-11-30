package Homework5.LabExerciseNov16;

public class Main {

    public static void main(String[] args){
        Dog dog = new Dog();
        dog.setName("dawg");

        Cat cat = new Cat();
        cat.setName("tom");

        Bird bird = new Bird();
        bird.setName("鶏カツ");

        dog.speak();
        cat.speak();
        bird.speak();

        dog.move();
        cat.move();
        bird.move();
    }

}
