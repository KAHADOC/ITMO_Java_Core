package edu.itmo.java.exam1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static edu.itmo.java.exam1.PassType.validPass;
import static edu.itmo.java.exam1.PassType.validTime;
import static edu.itmo.java.exam1.TrainingArea.validZone;

public class Fitness {
    private Pass[] swimPool = new Pass[20];
    private Pass[] gymZone = new Pass[20];
    private Pass[] groupClass = new Pass[20];

    private static Fitness fitnessInstance;
    private Fitness() {}
    public static Fitness createFitness() {
        if (fitnessInstance == null) fitnessInstance = new Fitness();
        return fitnessInstance;
    }


    public boolean zoneFull(TrainingArea zone) {
        boolean result = switch (zone) {
            case GYM_ZONE -> checkZone(gymZone);
            case SWIM_POOL -> checkZone(swimPool);
            case GROUP_CLASS -> checkZone(groupClass);
            default -> true;
        };
        return  result;
    }
    public boolean checkZone(Pass[] zoneArray) {
        boolean result = false;
        int i = 0;
        while (i < 20 && zoneArray[i] != null) i++;
        if (i == 20) result = true;
        return result;
    }
    public boolean registerMember(TrainingArea where, Pass who) {
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
    public void verboseRegistration(TrainingArea where, Pass who) {
        boolean check = registerMember(where, who);
        if (check) {
            System.out.println("Verbose:");
            System.out.println(who.getOwner().getMemberName() + "  " + where + "date: " + LocalDate.now() + "time: " + LocalTime.now());
        }
    }
    public void addToArray(Pass memberCard, TrainingArea zone) {
        switch (zone) {
            case GYM_ZONE -> zoneAdd(gymZone, memberCard);
            case SWIM_POOL -> zoneAdd(swimPool, memberCard);
            case GROUP_CLASS -> zoneAdd(groupClass, memberCard);
        }
        memberCard.setRegZone(zone);
    }
    public void zoneAdd(Pass[] zone, Pass memberCard) {
        for (int n = 0; n < zone.length; n++)
            if (zone[n] == null) { zone[n] = memberCard; break;}
    }
    public void printStatus() {
        System.out.println(Arrays.toString(gymZone));
        System.out.println(Arrays.toString(swimPool));
        System.out.println(Arrays.toString(groupClass));
    }
}
