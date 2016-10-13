package by.bsu.fpm.barbuk.entity.gifts;


import by.bsu.fpm.barbuk.entity.candies.Candy;
import by.bsu.fpm.barbuk.entity.comparators.CostComparator;
import by.bsu.fpm.barbuk.entity.comparators.NameComparator;
import by.bsu.fpm.barbuk.entity.comparators.WeightComparator;
import by.bsu.fpm.barbuk.entity.giftInterfaces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Gift implements GiftSort,GiftWeight, GiftFind {

    private int id;
    private String name;
    private List<Candy> candies;

    public Gift() {
        candies = new ArrayList<>();
    }

    public void addCandy(Candy candy){
        candies.add(candy);
    }

    public void printCandiesList(){
        for (Candy candy :candies)
            System.out.println(candy);
    }

    public int calculateGiftWeight() {
        int weight=0;
        for(Candy candy:candies){
            weight+=candy.getWeight();
        }
        return weight;
    }

    public void sortByName() {
        Collections.sort(candies,new NameComparator());
    }

    public void sortByWeight() {
        Collections.sort(candies,new WeightComparator());
    }

    public void sortByCost() {
        Collections.sort(candies,new CostComparator());
    }

    public List<Candy> findByName(String name) {
        List<Candy> findCandies = new ArrayList<>();
        for(Candy candy:candies)
            if(candy.getCandyName().equals(name))
                findCandies.add(candy);
        return findCandies;
    }

    public List<Candy> findByCostRange(int minCost, int maxCost) {
        List<Candy> findCandies = new ArrayList<>();
        for(Candy candy:candies)
            if(candy.getCost()>=minCost&&candy.getCost()<=maxCost)
                findCandies.add(candy);
        return findCandies;
    }

    public List<Candy> findByWeightRange(int minWeight, int maxWeight) {
        List<Candy> findCandies = new ArrayList<>();
        for(Candy candy:candies)
            if(candy.getWeight()>=minWeight&&candy.getWeight()<=maxWeight)
                findCandies.add(candy);
        return findCandies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "candies=" + candies +
                '}';
    }
}
