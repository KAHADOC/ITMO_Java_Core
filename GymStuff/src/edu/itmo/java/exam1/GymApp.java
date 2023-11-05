package edu.itmo.java.exam1;

import java.time.LocalDate;
import java.time.Month;

public class GymApp {



    public static void main(String[] args) {
        Member baby = new Member("Sabrina Juana Lopez", LocalDate.now().plusMonths(3), Sex.female);
        Member swimmerDude = new Member("Michael Fred Phelps II", LocalDate.of(1985, Month.JUNE, 30), Sex.male);
        Member runnerDude = new Member("Usain St. Leo Bolt", LocalDate.of(1986, Month.AUGUST, 21), Sex.male);
        Member fitnessHottie = new Member("Darya Klishina", LocalDate.of(1991, Month.JANUARY, 15), Sex.female);
        //System.out.println(swimmerDude.toString()+"\n"+baby.toString()+"\n"+runnerDude.toString()+"\n"+fitnessHottie.toString());

        Pass swimmerDudeCard = new Pass(PassType.single, swimmerDude, LocalDate.now(), LocalDate.now());
        System.out.println(swimmerDudeCard.toString());
        Pass fitnessBabeCard = new Pass(PassType.full, fitnessHottie, LocalDate.now().minusDays(12), LocalDate.now().plusDays(3));
//        Pass babyPass = new Pass(PassType.full, baby, LocalDate.now().minusDays(-5), LocalDate.now().plusDays(-3));
        Pass runnerCard = new Pass(PassType.full, runnerDude, LocalDate.of(2023, 10, 19), LocalDate.of(2024, 5, 3));
        System.out.println(runnerCard.toString());
        System.out.println(fitnessBabeCard.toString());
//        System.out.println(babyPass.toString());
//        System.out.println(Fitness.validPass(babyPass));
        System.out.println(Fitness.validPass(fitnessBabeCard));
        System.out.println(Fitness.validPass(runnerCard));
        System.out.println(Fitness.validPass(swimmerDudeCard));
        //Fitness.registerMember(TrainingArea.swimPool, babyPass);
        System.out.println("Registering...");
        Fitness.registerMember(TrainingArea.swimPool, swimmerDudeCard);
        Fitness.registerMember(TrainingArea.groupClass, fitnessBabeCard);
        Fitness.verboseRegistration(TrainingArea.gymZone, runnerCard);
        Fitness.registerMember(TrainingArea.swimPool, swimmerDudeCard);
        Fitness.registerMember(TrainingArea.gymZone, fitnessBabeCard);

        Fitness.printStatus();
    }
}
