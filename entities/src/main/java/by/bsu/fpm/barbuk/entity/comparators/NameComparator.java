package by.bsu.fpm.barbuk.entity.comparators;


import by.bsu.fpm.barbuk.entity.candies.Candy;

import java.util.Comparator;

public class NameComparator implements Comparator<Candy> {
    public int compare(Candy o1, Candy o2) {
        return o1.getCandyName().compareTo(o2.getCandyName());
    }
}
