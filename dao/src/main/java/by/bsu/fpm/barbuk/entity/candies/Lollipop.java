package by.bsu.fpm.barbuk.entity.candies;


public class Lollipop extends Candy {

    private String color;

    public Lollipop() {
        super();
    }

    public Lollipop(String candyName, int weight, int cost, String color) {
        super(candyName, weight, cost);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Lollipop{" +
                super.toString()+
                "color='" + color + '\'' +
                '}';
    }
}
