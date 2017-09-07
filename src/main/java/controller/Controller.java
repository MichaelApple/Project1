package main.java.controller;


import main.java.model.PlayRoom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by Miha on 12.08.2017.
 */
@WebServlet(name = "Controller", urlPatterns = "/playRoom")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher view;
        PlayRoom playRoom;

        if (request.getParameter("roomPrice") != null) {
            playRoom = new PlayRoom(Double.valueOf(request.getParameter("roomPrice")));
            playRoom.setAllToys(playRoom.fillPlayRoom());
        } else if (request.getParameter("sort") != null) {
            playRoom = (PlayRoom) getServletContext().getAttribute("playRoom");
            if (request.getParameter("sort").equals("Price"))
                (playRoom.getAllToys()).sort(PlayRoom.SORT_BY_COST);
            else if (request.getParameter("sort").equals("Size"))
                (playRoom.getAllToys()).sort(PlayRoom.SORT_BY_SIZE);
        } else {
            playRoom = (PlayRoom) getServletContext().getAttribute("playRoom");
        }

        getServletContext().setAttribute("playRoom", playRoom);

        request.setAttribute("playRoom", playRoom);

        view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
