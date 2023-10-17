package edu.java.itmo_course.hw08;

public class Scooter extends Bicycle {
    private boolean isElectric;


    public Scooter(String regNumber, int maxSpeed, boolean isElectric) {
        super(regNumber, maxSpeed);
        this.isElectric = isElectric;
    }

    // Количество колёс самоката всегда равно 2, а тип - "Городской".
    // Они и так по умолчанию. Нужно запретить как-то вызывать конструктор
    // родителя либо методы, где эти значения меняются?

    @Override
    public void repair() {
        if (isElectric && this.wearOut > 2) this.wearOut -= 2;
        else if (isElectric && wearOut > 0) wearOut = 0;
        if (!isElectric && wearOut > 3) wearOut -= 3;
        else if (!isElectric && wearOut > 0) wearOut = 0;
    }
}
