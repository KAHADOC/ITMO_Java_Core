package edu.java.itmo_course.hw08;

public class Car extends TransportVehicle {
    private String colour = "off-white";
    protected int maxSpeed = 240;

    public void changeColour(String color) {
        colour = color;
    }

    public Car(String regNumber) {
        super(regNumber);
    }

    public Car(String regNumber, String colour) {
        super(regNumber);
        this.colour = colour;
    }
//    @Override
//    public void repair() {
//        if (this.wearout > 0) this.wearout -= -1;
//    }
}
