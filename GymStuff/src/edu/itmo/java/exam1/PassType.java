package edu.itmo.java.exam1;

import java.time.LocalDate;
import java.time.LocalTime;

public enum PassType {
    SINGLE, DAYTIME, FULL;

    public static boolean validPass(Pass memberCard) {
        try { return ((!memberCard.getStartDate().isAfter(LocalDate.now()))
                && (!memberCard.getExpiryDate().isBefore(LocalDate.now()))); }
        catch (NullPointerException oops) {
            System.out.println("Invalid Pass"); return false;
        }
    }

    public static boolean validTime(Pass memberCard) {
        boolean result = false;
        if ((memberCard.getType() == PassType.SINGLE || memberCard.getType() == PassType.FULL)
                && LocalTime.now().isAfter(LocalTime.of(8, 00))
                && LocalTime.now().isBefore(LocalTime.of(22, 00)))
            result = true;
        if (memberCard.getType() == PassType.DAYTIME
                && LocalTime.now().isAfter(LocalTime.of(8, 00))
                && LocalTime.now().isBefore(LocalTime.of(16, 00)))
            result = true;
        return result;
    }
}


