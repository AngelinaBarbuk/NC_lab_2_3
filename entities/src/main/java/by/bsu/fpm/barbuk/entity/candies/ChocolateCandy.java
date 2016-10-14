package by.bsu.fpm.barbuk.entity.candies;


public class ChocolateCandy extends Candy {

    public ChocolateCandy()  {
        super();
    }

    public ChocolateCandy(String candyName, int weight, int cost) {
        super(candyName, weight, cost);
    }

    @Override
    public String toString() {
        return "<p>Type: ChocolateCandy </p>" +
                super.toString();
    }
}
