package edu.itmo.java.exam1;

import java.time.LocalDate;

public class Pass {
    private PassType type;
    private final long passID;
    private LocalDate startDate;
    private LocalDate expiryDate;
    private LocalDate registration;
    private Member owner;
    private TrainingArea regZone = null;

    public Pass(PassType type, Member owner, LocalDate startDate, LocalDate expiryDate) {
        this.passID = owner.getMemberID() + 777;
        this.owner = owner;
        if (owner.getRegistered() == null) return;
        this.type = type;
        if (type == PassType.SINGLE)
            if (!startDate.isBefore(LocalDate.now())) {
                this.startDate = startDate;
                this.expiryDate = startDate;
            } else return;
        else {
            if (!startDate.isAfter(expiryDate))
                if (!LocalDate.now().isAfter(expiryDate)) {
                    this.startDate = startDate;
                    this.expiryDate = expiryDate;
                } else return;
            else return;
        }
        this.registration = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Pass{" +
                "type=" + type +
                ", passID=" + passID +
                ", startDate=" + startDate +
                ", expiryDate=" + expiryDate +
                ", owner=" + owner +
                '}';
    }

    public PassType getType() {
        return type;
    }

    public long getPassID() {
        return passID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public TrainingArea getRegZone() {
        return regZone;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }

    public void setRegZone(TrainingArea regZone) {
        this.regZone = regZone;
    }

    public Member getOwner() {
        return owner;
    }

}
