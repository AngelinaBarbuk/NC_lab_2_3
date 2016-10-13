package by.bsu.fpm.barbuk.dao;

import by.bsu.fpm.barbuk.entity.candies.Candy;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by B on 13.10.2016.
 */
public interface CandyDAO {
    List<Candy> getAllCandies() throws PropertyVetoException, SQLException, IOException;
    Candy getCandyById(int id) throws PropertyVetoException, SQLException, IOException;
}
