package controller;

import model.PlayRoom;
import model.toys.Toy;
import view.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Miha on 10.08.2017.
 */
public class ControllerWeb implements Comparator<Toy> {

    PlayRoom playRoom;
    View view;

    public ControllerWeb(PlayRoom playRoom, View view) {
        this.playRoom = playRoom;
        this.view = view;
    }

//    public List<Toy> fillPlayRoom() {
//        double totalCost = 0;
//
//        List<Toy> toys = playRoom.fillRoomByDefault();
//        List<Toy> room = new ArrayList<Toy>();
//
//        while (totalCost <= playRoom.getMoneyAmount()) {
//            for (Toy toy : toys) {
//                totalCost += toy.getCost();
//                if (totalCost >= playRoom.getMoneyAmount()) {
//                    totalCost -= toy.getCost();
//                    return room;
//                }
//                room.add(toy);
//            }
//            playRoom.setQuantity(room.size());
//        }
//        return room;
//    }

    public static final Comparator<Toy> SORT_BY_SIZE = new Comparator<Toy>() {
        public int compare(Toy o1, Toy o2) {
            return o1.getSize().compareTo(o2.getSize());
        }
    };

    public static final Comparator<Toy> SORT_BY_COST = new Comparator<Toy>() {
        public int compare(Toy o1, Toy o2) {
            return o1.getCost() - o2.getCost();
        }
    };

    public List<Toy> findByCost(List<Toy> toyList, int min, int max) {
        List<Toy> sortedByCost = new ArrayList<Toy>();

        for (Toy toy : toyList) {
            if (toy.getCost() >= min & toy.getCost() <= max)
                sortedByCost.add(toy);
        }
        return sortedByCost;
    }

    public int compare(Toy o1, Toy o2) {
        return o1.getSize().compareTo(o2.getSize());
    }
}
