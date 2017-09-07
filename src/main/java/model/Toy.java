package main.java.model;


import main.java.enums.AgeGroup;
import main.java.enums.Sex;
import main.java.enums.ToySize;

/**
 * Created by Miha on 10.08.2017.
 */
public class Toy {
    private String name;
    private int cost;
    private ToySize size;
    private AgeGroup ageGroup;
    private Sex sex;

    public Toy(String name, int cost, ToySize size, AgeGroup ageGroup, Sex sex) {
        this.name = name;
        this.cost = cost;
        this.size = size;
        this.ageGroup = ageGroup;
        this.sex = sex;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ToySize getSize() {
        return size;
    }

    public void setSize(ToySize size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", size=" + size +
                ", ageGroup=" + ageGroup +
                ", sex=" + sex +
                '}';
    }
}
