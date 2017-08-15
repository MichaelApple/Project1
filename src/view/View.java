package view;

import model.Toy;

import java.util.List;

/**
 * Created by Miha on 11.08.2017.
 */
public class View {

    public void printToys(List<Toy> toys){
        for (Toy toy : toys)
            System.out.println(toy);

        System.out.println("=================");
        System.out.println();
    }
    public void printMessage(String message){
        System.out.println(message);
    }
}
