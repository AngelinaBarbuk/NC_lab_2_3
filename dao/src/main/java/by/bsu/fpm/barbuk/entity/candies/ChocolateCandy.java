package by.bsu.fpm.barbuk.entity.candies;


public class ChocolateCandy extends Candy {

    public ChocolateCandy()  {
    }

    public ChocolateCandy(String candyName, int weight, int cost) {
        super(candyName, weight, cost);
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +
                super.toString()+
                "}";
    }
}
