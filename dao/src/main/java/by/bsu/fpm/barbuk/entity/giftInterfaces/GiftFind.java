package by.bsu.fpm.barbuk.entity.giftInterfaces;


import by.bsu.fpm.barbuk.entity.candies.Candy;

import java.util.List;

public interface GiftFind {
    List<Candy> findByName(String name);
    List<Candy> findByCostRange(int minCost, int maxCost);
    List<Candy> findByWeightRange(int minWeight, int maxWeight);
}
