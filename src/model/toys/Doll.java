package model.toys;

import enums.AgeGroup;
import enums.Sex;
import enums.ToySize;

/**
 * Created by Miha on 11.08.2017.
 */
public class Doll extends Toy {

    public Doll(String name, int cost, ToySize size, AgeGroup ageGroup, Sex sex) {
        super(name, cost, size, ageGroup, sex);
    }
}
