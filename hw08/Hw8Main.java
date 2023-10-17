package edu.java.itmo_course.hw08;

public class Hw8Main {
    public static void main(String[] args) {
        Bicycle ural = new Bicycle("ekb15", 37);
        ural.increaseWearout(3);
        ural.repair();

        Train sapsan = new Train(9, true, 250, "Чщлз32");
        sapsan.increaseWearout(5);
        sapsan.repair();
    }
}
