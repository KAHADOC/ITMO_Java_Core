package edu.java.itmo_course.hw10.task.animals;

import java.util.Arrays;
import java.util.Objects;

public class Wolf extends WildAnimal{
    private final String[] likeToEat;
    private final String color;

    public Wolf(String[] likeToEat, String color) {
        this.likeToEat = likeToEat;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wolf wolf)) return false;
        return Arrays.equals(likeToEat, wolf.likeToEat) && // Objects.equals(color, wolf.color); непонятно, почему так сгенерировалось?
                (this.color).equals((((Wolf) o).color)); // здесь используется String.equals()? То есть тут по значению проверка?
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(color);
        result = 31 * result + Arrays.hashCode(likeToEat);
        return result;
    }
}
