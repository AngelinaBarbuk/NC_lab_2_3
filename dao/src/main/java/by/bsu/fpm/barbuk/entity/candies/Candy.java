package by.bsu.fpm.barbuk.entity.candies;


public abstract class Candy {
    private int id;
    private String candyName;
    private Integer weight;
    private Integer cost;

    public Candy() {
    }

    public Candy(String candyName, int weight, int cost) {
        this.candyName = candyName;
        this.weight = weight;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getCandyName() {
        return candyName;
    }

    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return  "candyName='" + candyName + '\'' +
                ", weight=" + weight +
                ", cost=" + cost;
    }
}
