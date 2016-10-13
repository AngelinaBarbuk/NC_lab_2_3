package by.bsu.fpm.barbuk.dao;

import by.bsu.fpm.barbuk.entity.gifts.Gift;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by B on 13.10.2016.
 */
public interface GiftDAO {
    List<Gift> getAllGifts() throws PropertyVetoException, SQLException, IOException;
    Gift getGiftById(int id) throws PropertyVetoException, SQLException, IOException;

}
