package by.bsu.fpm.barbuk.comands;

import by.bsu.fpm.barbuk.GiftService;
import by.bsu.fpm.barbuk.entity.gifts.Gift;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by B on 14.10.2016.
 */
public class ViewGiftCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // извлечение из запроса выбора курса обучения
        HttpSession session = request.getSession();
        try {
            int giftId = Integer.parseInt(request.getParameter("id"));
            Gift gift = GiftService.getInstance().getGiftById(giftId);
            session.setAttribute("Gift",gift);
        } catch (SQLException e) {
            page = "/fail.jsp";
            return page;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        page = "/Gift.jsp";
        return page;

    }
}
