package edu.java.itmo_course.hw11;
import edu.java.itmo_course.hw11.EndoPlanet;

public class HW11 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earthWeight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EndoPlanet.Earth.surfaceGravity();
        for (EndoPlanet p : EndoPlanet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }
}
