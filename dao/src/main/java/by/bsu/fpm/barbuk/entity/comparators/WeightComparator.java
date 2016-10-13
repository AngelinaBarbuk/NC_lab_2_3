package by.bsu.fpm.barbuk.entity.comparators;


import by.bsu.fpm.barbuk.entity.candies.Candy;

import java.util.Comparator;

public class WeightComparator implements Comparator<Candy> {

    public int compare(Candy o1, Candy o2) {
        if(o1.getWeight()<o2.getWeight())
            return -1;
        else if(o1.getWeight()>o2.getWeight())
            return 1;
        return 0;
    }
}
