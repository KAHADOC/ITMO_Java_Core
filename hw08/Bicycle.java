package edu.java.itmo_course.hw08;

public class Bicycle extends TransportVehicle {
    private int wheels = 2;
    private String type = "City-bike";

    public String getType() {
        return type;
    }

    public Bicycle(String regNumber, int wheels, String type) {
        super(regNumber);
        this.wheels = wheels;
        this.type = type;
    }

    public Bicycle(String regNumber, int maxSpeed) {
        super(regNumber, maxSpeed);
    }

    public int getWheels() {
        return wheels;
    }


}
