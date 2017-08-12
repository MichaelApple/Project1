package model.toys;

import enums.AgeGroup;
import enums.Sex;
import enums.ToySize;

/**
 * Created by Miha on 10.08.2017.
 */
public class Ball extends Toy {

    public Ball(String name, int cost, ToySize size, AgeGroup ageGroup, Sex sex) {
        super(name, cost, size, ageGroup, sex);
    }
}
