package by.bsu.fpm.barbuk.entity.patterns;


import by.bsu.fpm.barbuk.entity.candies.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CandyFactory {

    private static final String LOLLIPOP = "Lollipop";
    private static final String CHOCOLATE = "Chocolate";
    private static final String NUT = "Nut";

    public static Candy getCandy(Scanner scanner, String candyType){
        if(candyType==null)
            return null;
        switch (candyType){
            case LOLLIPOP:
                return getLollipop(scanner);
            case CHOCOLATE:
                return getChocolateCandy(scanner);
            case NUT:
                return getNutCandy(scanner);
        }
        return null;
    }

    private static Candy getNutCandy(Scanner scanner) {
        NutCandy nutCandy = new NutCandy();
        nutCandy.setCandyName(scanner.next());
        nutCandy.setWeight(scanner.nextInt());
        nutCandy.setCost(scanner.nextInt());
        nutCandy.setNutName(scanner.next());
        return nutCandy;
    }

    private static Candy getChocolateCandy(Scanner scanner) {
        ChocolateCandy chocolateCandy = new ChocolateCandy();
        chocolateCandy.setCandyName(scanner.next());
        chocolateCandy.setWeight(scanner.nextInt());
        chocolateCandy.setCost(scanner.nextInt());
        return chocolateCandy;
    }

    private static Candy getLollipop(Scanner scanner) {
        Lollipop lollipop = new Lollipop();
        lollipop.setCandyName(scanner.next());
        lollipop.setWeight(scanner.nextInt());
        lollipop.setCost(scanner.nextInt());
        lollipop.setColor(scanner.next());
        return lollipop;
    }

    public static Candy getCandy(ResultSet resultSet) throws SQLException {
        String candyType = resultSet.getString(5);
        if (candyType == null)
            return null;
        switch (candyType) {
            case LOLLIPOP:
                return getLollipop(resultSet);
            case CHOCOLATE:
                return getChocolateCandy(resultSet);
            case NUT:
                return getNutCandy(resultSet);
        }
        return null;
    }

    private static Candy getNutCandy(ResultSet resultSet) throws SQLException {
        NutCandy nutCandy = new NutCandy();
        nutCandy.setId(resultSet.getInt(1));
        nutCandy.setCandyName(resultSet.getString(2));
        nutCandy.setCost(resultSet.getInt(3));
        nutCandy.setWeight(resultSet.getInt(4));
        nutCandy.setNutName(resultSet.getString("NUT_CANDY_NUT_NAME"));
        return nutCandy;
    }

    private static Candy getChocolateCandy(ResultSet resultSet) throws SQLException {
        ChocolateCandy chocolateCandy = new ChocolateCandy();
        chocolateCandy.setId(resultSet.getInt(1));
        chocolateCandy.setCandyName(resultSet.getString(2));
        chocolateCandy.setCost(resultSet.getInt(3));
        chocolateCandy.setWeight(resultSet.getInt(4));
        return chocolateCandy;
    }

    private static Candy getLollipop(ResultSet resultSet) throws SQLException {
        Lollipop lollipop = new Lollipop();
        lollipop.setId(resultSet.getInt(1));
        lollipop.setCandyName(resultSet.getString(2));
        lollipop.setCost(resultSet.getInt(3));
        lollipop.setWeight(resultSet.getInt(4));
        lollipop.setColor(resultSet.getString("LOLLIPOP_COLOR"));
        return lollipop;
    }
}
