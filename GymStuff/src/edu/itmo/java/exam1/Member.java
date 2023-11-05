package edu.itmo.java.exam1;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Member {
    private static final AtomicInteger counter = new AtomicInteger(111);
    private final int memberID;
    private String memberName;
    private LocalDate dob;
    private Sex gender;
    private LocalDate registered;

    public Member(String memberName, LocalDate dob, Sex gender) {
        this.memberID = counter.getAndIncrement();
        this.memberName = memberName;
        this.gender = gender;
        if (dob.isBefore(LocalDate.now().minusYears(3))) this.dob = dob;
        else {System.out.println("This baby is too young!"); return;}
        this.registered = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", registered=" + registered +
                '}';
    }

    public int getMemberID() {
        return memberID;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public String getMemberName() {
        return memberName;
    }
}
