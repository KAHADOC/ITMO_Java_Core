package edu.java.itmo_course.hw08;

import java.util.Arrays;
import java.util.Random;

public class ServiceStation {
    //private TransportVehicle[] trains;
    private TransportVehicle[] vehicles = new TransportVehicle[5];
    private int arrSize = 0;


    public void addToVehicles(TransportVehicle vehicle){
        if (arrSize == vehicles.length)
            vehicles = Arrays.copyOf(vehicles, vehicles.length + 5);
        vehicles[arrSize++] = vehicle;
    }
    private String[] colors = {"red", "yellow", "orange", "black"};

    public void repairAll() {
        for (TransportVehicle vehicle : vehicles) {
           if (vehicle != null) {
               vehicle.repair();
               if (vehicle instanceof Train train)
                    ((Train) vehicle).switchAC();
               if (vehicle instanceof Car car) {
                   int randomIndex = new Random().nextInt(colors.length);
                   car.changeColour(colors[randomIndex]);
                   vehicle = null;
               }
           }
        }
    }
}
