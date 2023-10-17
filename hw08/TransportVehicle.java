package edu.java.itmo_course.hw08;

public class TransportVehicle {
    protected String regNumber;
    protected int wearOut;
    protected int maxSpeed = 120;

    public TransportVehicle(String regNumber, int maxSpeed) {
        this(regNumber);
        //this.regNumber = regNumber;
        this.maxSpeed = maxSpeed;
    }

    public TransportVehicle(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void increaseWearout(int wear) {
        if (wear > 0) this.wearOut += wear;
    }
    public void repair() {
        if (this.wearOut > 0) this.wearOut -= 1;
    }
    public int getWearout() {
        return wearOut;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
