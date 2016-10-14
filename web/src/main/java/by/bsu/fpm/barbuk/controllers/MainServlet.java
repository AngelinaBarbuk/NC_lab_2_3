package by.bsu.fpm.barbuk.controllers;


import by.bsu.fpm.barbuk.comands.ActionCommand;
import by.bsu.fpm.barbuk.comands.AllGiftsCommand;
import by.bsu.fpm.barbuk.comands.ViewCandyCommand;
import by.bsu.fpm.barbuk.comands.ViewGiftCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/controller")
public class MainServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = "";
        String action = request.getParameter("command");
        if(action==null)
            action="";
        ActionCommand command = null;
        switch (action) {
            case "ViewCandy":
                command = new ViewCandyCommand();
                break;
            case "ViewGift":
                command = new ViewGiftCommand();
                break;
            default:
                command = new AllGiftsCommand();
                break;
        }
        page = command.execute(request);
        if (page != null) {
            getServletContext().getRequestDispatcher(page).forward(request, response);
        } else {
            page = "fail.jsp";
            request.setAttribute("nullPage", "Page not found. Business logic error.");
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
