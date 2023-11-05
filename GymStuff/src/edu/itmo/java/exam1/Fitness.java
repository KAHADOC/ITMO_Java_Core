package edu.itmo.java.exam1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Fitness {
    private static Pass[] swimPool = new Pass[20];
    private static Pass[] gymZone = new Pass[20];
    private static Pass[] groupClass = new Pass[20];
    public static boolean validPass(Pass memberCard) {
        try { return ((!memberCard.getStartDate().isAfter(LocalDate.now()))
                && (!memberCard.getExpiryDate().isBefore(LocalDate.now()))); }
        catch (NullPointerException oops) {
            System.out.println("Invalid Pass"); return false;
        }
    }
    public static boolean validZone(Pass memberCard, TrainingArea zone) {
        boolean result = false;
        if (memberCard.getType() == PassType.single && (zone == TrainingArea.gymZone
                || zone == TrainingArea.swimPool)) result = true;
        if (memberCard.getType() == PassType.daytime && (zone == TrainingArea.gymZone
                || zone == TrainingArea.groupClass)) result = true;
        if (memberCard.getType() == PassType.full) result = true;
        return result;
    }
    public static boolean validTime(Pass memberCard) {
        boolean result = false;
        if ((memberCard.getType() == PassType.single || memberCard.getType() == PassType.full)
                && LocalTime.now().isAfter(LocalTime.of(8, 00))
                && LocalTime.now().isBefore(LocalTime.of(22, 00)))
            result = true;
        if (memberCard.getType() == PassType.daytime
                && LocalTime.now().isAfter(LocalTime.of(8, 00))
                && LocalTime.now().isBefore(LocalTime.of(16, 00)))
            result = true;
        return result;
    }
    public static boolean zoneFull(TrainingArea zone) {
        boolean result = switch (zone) {
            case gymZone -> checkZone(gymZone);
            case swimPool -> checkZone(swimPool);
            case groupClass -> checkZone(groupClass);
            default -> true;
        };
        return  result;
    }
    public static boolean checkZone(Pass[] zoneArray) {
        boolean result = false;
        int i = 0;
        while (i < 20 && zoneArray[i] != null) i++;
        if (i == 20) result = true;
        return result;
    }
    public static boolean registerMember(TrainingArea where, Pass who) {
        if (!validPass(who)) return false;
        if (who.getRegZone() != null) {
            System.out.println("This member is already registered in " + who.getRegZone());
            return false;
        }
        if (!validZone(who, where)) {
            System.out.println("This pass is not appropriate for Zone " + where);
            return false;
        }
        if (!validTime(who)) {
            System.out.println("Inappropriate time for registration");
            return false;
        }
        if (zoneFull(where)) {
            System.out.println("The preferred zone is now full");
            return false;
        }
        addToArray(who, where);
        return true;
    }
    public static void verboseRegistration(TrainingArea where, Pass who) {
        boolean check = registerMember(where, who);
        if (check) {
            System.out.println("Verbose:");
            System.out.println(who.getOwner().getMemberName() + "  " + where + "date: " + LocalDate.now() + "time: " + LocalTime.now());
        }
    }
    public static void addToArray(Pass memberCard, TrainingArea zone) {
        switch (zone) {
            case gymZone -> zoneAdd(gymZone, memberCard);
            case swimPool -> zoneAdd(swimPool, memberCard);
            case groupClass -> zoneAdd(groupClass, memberCard);
        }
        memberCard.setRegZone(zone);
    }
    public static void zoneAdd(Pass[] zone, Pass memberCard) {
        for (int n = 0; n < zone.length; n++)
            if (zone[n] == null) { zone[n] = memberCard; break;}
    }
    public static void printStatus() {
        System.out.println(Arrays.toString(gymZone));
        System.out.println(Arrays.toString(swimPool));
        System.out.println(Arrays.toString(groupClass));
    }
}
