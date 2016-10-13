package by.bsu.fpm.barbuk.entity.comparators;


import by.bsu.fpm.barbuk.entity.candies.Candy;

import java.util.Comparator;

public class CostComparator implements Comparator<Candy> {

    public int compare(Candy o1, Candy o2) {
        if(o1.getCost()<o2.getCost())
            return -1;
        else if(o1.getCost()>o2.getCost())
            return 1;
        return 0;
    }
}
