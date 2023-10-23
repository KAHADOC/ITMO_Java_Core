package edu.java.itmo_course.hw11;

public enum EndoPlanet {
    Mercury (3.303e+23, 2.4397e+6),
    Venus   (4.869e+24, 6.0518e+6),
    Earth   (5.976e+24, 6.37814e+6),
    Mars    (6.421e+23, 3.3972e+6),
    Jupiter (1.9e+27,   7.1492e+7),
    Saturn  (5.688e+26, 6.0268e+7),
    Uranus  (8.686e+25, 2.5559e+7),
    Neptune (1.024e+26, 2.4746e+7);

    private final double planetMass;   // in kilograms
    private final double planetRadius; // in meters
    EndoPlanet(double mass, double radius) {
        planetMass = mass;
        planetRadius = radius;
    }
    private double getMass() { return planetMass; }
    private double getRadius() { return planetRadius; }

    public static final double G = 6.67300e-11;

    double surfaceGravity() {
        return G * planetMass / (planetRadius * planetRadius);
    }
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}
