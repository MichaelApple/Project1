package model;

import db.Database;

import java.util.ArrayList;
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

    public List<Toy> fillPlayRoom() {
        double totalCost = 0;

        List<Toy> toys = Database.fillRoomByDefault();
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

    public List<Toy> findByRangeCost(List<Toy> toyList, String range) {
        List<Toy> findByRangeCost = new ArrayList<Toy>();
        System.out.println(range);
        int min = Integer.parseInt(range.split(",")[0]);
        int max = Integer.parseInt(range.split(",")[1]);

        for (Toy toy : toyList) {
            if (toy.getCost() >= min & toy.getCost() <= max)
                findByRangeCost.add(toy);
        }
        return findByRangeCost;
    }
}
