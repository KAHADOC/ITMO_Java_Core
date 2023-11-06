package edu.itmo.java.exam1;

import java.time.LocalDate;
import java.time.Month;

import edu.itmo.java.exam1.TrainingArea;

public class GymApp {



    public static void main(String[] args) {
        Member baby = new Member("Sabrina Juana Lopez", LocalDate.now().plusMonths(3), Sex.FEMALE);
        Member swimmerDude = new Member("Michael Fred Phelps II", LocalDate.of(1985, Month.JUNE, 30), Sex.MALE);
        Member runnerDude = new Member("Usain St. Leo Bolt", LocalDate.of(1986, Month.AUGUST, 21), Sex.MALE);
        Member fitnessHottie = new Member("Darya Klishina", LocalDate.of(1991, Month.JANUARY, 15), Sex.FEMALE);
        //System.out.println(swimmerDude.toString()+"\n"+baby.toString()+"\n"+runnerDude.toString()+"\n"+fitnessHottie.toString());

        Pass swimmerDudeCard = new Pass(PassType.SINGLE, swimmerDude, LocalDate.now(), LocalDate.now());
        System.out.println(swimmerDudeCard.toString());
        Pass fitnessBabeCard = new Pass(PassType.FULL, fitnessHottie, LocalDate.now().minusDays(12), LocalDate.now().plusDays(3));
//        Pass babyPass = new Pass(PassType.FULL, baby, LocalDate.now().minusDays(-5), LocalDate.now().plusDays(-3));
        Pass runnerCard = new Pass(PassType.FULL, runnerDude, LocalDate.of(2023, 10, 19), LocalDate.of(2024, 5, 3));
        System.out.println(runnerCard.toString());
        System.out.println(fitnessBabeCard.toString());
//        System.out.println(babyPass.toString());
//        System.out.println(Fitness.validPass(babyPass));
        Fitness fitApp = Fitness.createFitness();
        System.out.println(PassType.validPass(fitnessBabeCard));
        System.out.println(PassType.validPass(runnerCard));
        System.out.println(PassType.validPass(swimmerDudeCard));
        //Fitness.registerMember(TrainingArea.swimPool, babyPass);
        System.out.println("Registering...");
        fitApp.registerMember(TrainingArea.SWIM_POOL, swimmerDudeCard);
        fitApp.registerMember(TrainingArea.GROUP_CLASS, fitnessBabeCard);
        fitApp.verboseRegistration(TrainingArea.GYM_ZONE, runnerCard);
        fitApp.registerMember(TrainingArea.SWIM_POOL, swimmerDudeCard);
        fitApp.registerMember(TrainingArea.GYM_ZONE, fitnessBabeCard);

        fitApp.printStatus();
    }
}
