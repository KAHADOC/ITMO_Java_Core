package edu.java.itmo_course.hw08;

public class Train extends TransportVehicle{
    private int numOfCars;
    private boolean hasAC;

    public int getNumOfCars() {
        return numOfCars;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public void setNumOfCars(int numOfCars) {
        this.numOfCars = numOfCars;
    }

    public void switchAC() {
        this.hasAC = !this.hasAC;
    }

    public Train(int numOfCars, boolean hasAC, int maxSpeed, String regNumber) {
        super(regNumber, maxSpeed);
        this.numOfCars = numOfCars;
        this.hasAC = hasAC;
    }
    @Override //annotation
    public void repair() {
        if (numOfCars > 0 && numOfCars < 7 && wearOut >= 2) wearOut -= 2;
        else super.repair();// if (wearout > 0) wearout -=1;
    }
}
