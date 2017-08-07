package ru.nlpcoach.servlet.point;

import com.google.gson.Gson;
import ru.nlpcoach.dao.DAOFake;
import ru.nlpcoach.model.Point;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Update Chart's Point from database.
 */
public class UpdatePointServlet extends HttpServlet {
    /**
     * Database representation.
     */
    private AtomicReference<DAOFake> dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new AtomicReference<>((DAOFake) getServletContext()
                .getAttribute("dao"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final String jsonPoint = req.getParameter("point");

        final Point point = new Gson().fromJson(jsonPoint, Point.class);

        final boolean result = dao.get().updatePoint(point);

        resp.getWriter().write(new Gson().toJson(result));
    }
}
