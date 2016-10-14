package by.bsu.fpm.barbuk.dao.implementation;

import by.bsu.fpm.barbuk.connector.DBConnector;
import by.bsu.fpm.barbuk.dao.CandyDAO;
import by.bsu.fpm.barbuk.entity.candies.Candy;
import by.bsu.fpm.barbuk.entity.patterns.CandyFactory;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by B on 13.10.2016.
 */
public class CandyDAOImpl implements CandyDAO {

    private static final String GET_ALL_CANDIES = "SELECT * FROM CANDIES";
    private static final String GET_CANDY_BY_ID = "SELECT * FROM CANDIES WHERE CANDY_ID=?";

    @Override
    public List<Candy> getAllCandies() throws PropertyVetoException, SQLException, IOException {
        ArrayList<Candy> list = new ArrayList<>();
        Statement statement = DBConnector.getInstance().getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ALL_CANDIES);
        while (resultSet.next()){
            Candy candy = CandyFactory.getCandy(resultSet);
            list.add(candy);
        }
        return list;
    }

    @Override
    public Candy getCandyById(int id) throws PropertyVetoException, SQLException, IOException {
        PreparedStatement preparedStatement= DBConnector.getInstance().getConnection().prepareStatement(GET_CANDY_BY_ID);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            Candy candy = CandyFactory.getCandy(resultSet);
            return candy;
        }
        return null;
    }

    public static void main(String [] args) throws PropertyVetoException, IOException, SQLException {
        CandyDAO candyDAO=new CandyDAOImpl();
        List<Candy> list = candyDAO.getAllCandies();
        for (Candy gift:list)
            System.out.println(gift);

        System.out.println(candyDAO.getCandyById(1));
    }

}
