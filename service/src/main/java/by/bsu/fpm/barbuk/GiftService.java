package by.bsu.fpm.barbuk;


import by.bsu.fpm.barbuk.dao.GiftDAO;
import by.bsu.fpm.barbuk.dao.implementation.GiftDAOImpl;
import by.bsu.fpm.barbuk.entity.gifts.Gift;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GiftService {
    private GiftDAO dao;
    private static GiftService newsService;

    private GiftService() {
        dao = new GiftDAOImpl();
    }

    public static GiftService getInstance() {
        if (newsService == null) {
            newsService = new GiftService();
        }
            return newsService;
    }

    public List<Gift> getAllGifts() throws PropertyVetoException, SQLException, IOException{
        return dao.getAllGifts();
    }
    public Gift getGiftById(int id) throws PropertyVetoException, SQLException, IOException{
        return dao.getGiftById(id);
    }
}
