package by.bsu.fpm.barbuk.entity.candies;


public class NutCandy extends Candy {

    private String nutName;

    public NutCandy() {
        super();
    }

    public NutCandy(String candyName, int weight, int cost, String nutName) {
        super(candyName, weight, cost);
        this.nutName = nutName;
    }

    public String getNutName() {
        return nutName;
    }

    public void setNutName(String nutName) {
        this.nutName = nutName;
    }

    @Override
    public String toString() {
        return "<p>Type: NutCandy</p>" +
                super.toString()+
                "<p>Nut: " + nutName + "</p>";
    }
}
