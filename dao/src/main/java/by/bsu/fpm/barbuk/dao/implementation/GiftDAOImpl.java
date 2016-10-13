package by.bsu.fpm.barbuk.dao.implementation;

import by.bsu.fpm.barbuk.connector.DBConnector;
import by.bsu.fpm.barbuk.dao.GiftDAO;
import by.bsu.fpm.barbuk.entity.candies.Candy;
import by.bsu.fpm.barbuk.entity.gifts.Gift;
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
public class GiftDAOImpl implements GiftDAO {

    private static final String GET_ALL_GIFTS = "SELECT GIFT_ID, NAME FROM GIFTS";
    private static final String GET_GIFT_BY_ID = "SELECT NAME FROM GIFTS WHERE GIFT_ID=?";
    private static final String GET_CANDIES_FROM_GIFT = "SELECT * FROM CANDIES C INNER JOIN GIFT_CANDY GC ON C.CANDY_ID=GC.CANDY_ID  WHERE GC.GIFT_ID=?";

    @Override
    public List<Gift> getAllGifts() throws PropertyVetoException, SQLException, IOException {
        ArrayList<Gift> list = new ArrayList<>();
        Statement statement = DBConnector.getInstance().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(GET_ALL_GIFTS);
        while (rs.next()){
            Gift gift = new Gift();
            gift.setId(rs.getInt(1));
            gift.setName(rs.getString(2));
            list.add(gift);
        }
        return list;
    }

    @Override
    public Gift getGiftById(int id) throws PropertyVetoException, SQLException, IOException {
        Gift gift = new Gift();
        PreparedStatement preparedStatement= DBConnector.getInstance().getConnection().prepareStatement(GET_GIFT_BY_ID);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            gift.setId(id);
            gift.setName(resultSet.getString(1));
        }else return null;
        preparedStatement= DBConnector.getInstance().getConnection().prepareStatement(GET_CANDIES_FROM_GIFT);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        List<Candy> candies = new ArrayList<>();
        while (resultSet.next()){
            Candy candy = CandyFactory.getCandy(resultSet);
            candies.add(candy);
        }
        gift.setCandies(candies);
        return gift;
    }

    public static void main(String[] args) throws PropertyVetoException, IOException, SQLException {
        GiftDAO giftDAO = new GiftDAOImpl();
        List<Gift> list = giftDAO.getAllGifts();
        for (Gift gift:list)
            System.out.println(gift);

        System.out.println(giftDAO.getGiftById(1));
    }
}
