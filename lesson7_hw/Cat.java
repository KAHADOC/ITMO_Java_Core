package edu.java.itmo_course.hw07;

public class Cat {
    private String catName = "Moorzick";
    private int weight;
    private int winsCount = 0;

    public void setCatName(String catName) {
        if (catName.replaceAll("\s+","").length() >=3)
            this.catName = catName;
    }

    public void setWeight(int weight) {
        if (weight >= 1 && weight < 9)
            this.weight = weight;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public Cat(int weight) {
        if (weight >= 1 && weight < 9)
            this.weight = weight;
    }

    public Cat(String catName, int weight) {
        this(weight);
        this.setCatName(catName);
    }

    public boolean attack(Cat enemy) throws NullPointerException{
        if (enemy != null) {
            boolean won = false;
            if (this.weight > enemy.weight) {
                won = true;
                this.winsCount += 1;
            }
            return  won;
        }
        else throw new NullPointerException("enemy cat object is Null");
    }
}
