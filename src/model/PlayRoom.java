package model;

import enums.AgeGroup;
import enums.Sex;
import enums.ToySize;
import model.toys.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Miha on 10.08.2017.
 */
public class PlayRoom {
    private List<Toy> allToys = new ArrayList<>();
    private double moneyAmount;
    private int quantity;

    public PlayRoom() {
    }

    public PlayRoom(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Toy> getAllToys() {
        return allToys;
    }

    public void setAllToys(List<Toy> allToys) {
        this.allToys = allToys;
    }


    /**
     * Add all types of toys in room by default. Later we can get all this data from database
     * @return
     */
    private List<Toy> fillRoomByDefault() {
        List<Toy> allToys = new ArrayList<Toy>();
        allToys.add(new Ball("Ball",10, ToySize.SMALL, AgeGroup.INFANT, Sex.UNISEX));
        allToys.add(new Ball("Ball",12, ToySize.MEDIUM, AgeGroup.INFANT, Sex.UNISEX));
        allToys.add(new Ball("Ball",15, ToySize.BIG, AgeGroup.INFANT, Sex.UNISEX));
        allToys.add(new Cube("Cube",5, ToySize.SMALL, AgeGroup.INFANT, Sex.UNISEX));
        allToys.add(new Cube("Cube",7, ToySize.MEDIUM, AgeGroup.INFANT, Sex.UNISEX));
        allToys.add(new Cube("Cube",10, ToySize.BIG, AgeGroup.INFANT, Sex.UNISEX));

        allToys.add(new Ball("Ball",10, ToySize.SMALL, AgeGroup.KID, Sex.UNISEX));
        allToys.add(new Ball("Ball",12, ToySize.MEDIUM, AgeGroup.KID, Sex.UNISEX));
        allToys.add(new Ball("Ball",15, ToySize.BIG, AgeGroup.KID, Sex.UNISEX));
        allToys.add(new Car("Car",30, ToySize.SMALL, AgeGroup.KID, Sex.MALE));
        allToys.add(new Car("Car",50, ToySize.MEDIUM, AgeGroup.KID, Sex.MALE));
        allToys.add(new Car("Car",100, ToySize.BIG, AgeGroup.KID, Sex.MALE));
        allToys.add(new Cube("Cube",5, ToySize.SMALL, AgeGroup.KID, Sex.UNISEX));
        allToys.add(new Cube("Cube",7, ToySize.MEDIUM, AgeGroup.KID, Sex.UNISEX));
        allToys.add(new Cube("Cube",10, ToySize.BIG, AgeGroup.KID, Sex.UNISEX));
        allToys.add(new Doll("Doll",50, ToySize.SMALL, AgeGroup.KID, Sex.FEMALE));
        allToys.add(new Doll("Doll",75, ToySize.MEDIUM, AgeGroup.KID, Sex.FEMALE));
        allToys.add(new Doll("Doll",100, ToySize.BIG, AgeGroup.KID, Sex.FEMALE));

        //Collections.shuffle(allToys);
        return allToys;
    }

    public List<Toy> fillPlayRoom() {
        double totalCost = 0;

        List<Toy> toys = this.fillRoomByDefault();
        List<Toy> room = new ArrayList<Toy>();

        while (totalCost <= this.getMoneyAmount()) {
            for (Toy toy : toys) {
                totalCost += toy.getCost();
                if (totalCost >= this.getMoneyAmount()) {
                    totalCost -= toy.getCost();
                    return room;
                }
                room.add(toy);
            }
            this.setQuantity(room.size());
        }
        return room;
    }

    public static final Comparator<Toy> SORT_BY_COST = Comparator.comparingInt(Toy::getCost);

    public static final Comparator<Toy> SORT_BY_SIZE = Comparator.comparing(Toy::getSize);

    public List<Toy> findByCost(List<Toy> toyList, String range) {
        List<Toy> sortedByCost = new ArrayList<Toy>();
        System.out.println(range);
        int min = Integer.parseInt(range.split(",")[0]);
        int max = Integer.parseInt(range.split(",")[1]);

        for (Toy toy : toyList) {
            if (toy.getCost() >= min & toy.getCost() <= max)
                sortedByCost.add(toy);
        }
        return sortedByCost;
    }
}
