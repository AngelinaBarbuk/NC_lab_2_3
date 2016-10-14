package by.bsu.fpm.barbuk;


import by.bsu.fpm.barbuk.dao.CandyDAO;
import by.bsu.fpm.barbuk.dao.implementation.CandyDAOImpl;
import by.bsu.fpm.barbuk.entity.candies.Candy;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CandyService {
    private CandyDAO dao;
    private static CandyService newsService;

    private CandyService() {
        dao = new CandyDAOImpl();
    }

    public static CandyService getInstance() {
        if (newsService == null) {
            newsService = new CandyService();
        }
            return newsService;
    }

    public List<Candy> getAllCandies() throws PropertyVetoException, SQLException, IOException{
        return dao.getAllCandies();
    }
    public Candy getCandyById(int id) throws PropertyVetoException, SQLException, IOException{
        return dao.getCandyById(id);
    }
}
