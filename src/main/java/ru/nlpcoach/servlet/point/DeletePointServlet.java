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
 * Delete Chart's Point from database.
 */
public class DeletePointServlet extends HttpServlet {
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

        final boolean result = dao.get().deletePoint(point);

        final Result objResult = new Result(point.getId(), result);

        final String jsonResult = new Gson().toJson(objResult);

        resp.getWriter().write(jsonResult);
    }


    private final class Result {
        private final boolean success;
        private final int pointId;

        private Result(final int pointId, final boolean success) {
            this.success = success;
            this.pointId = pointId;
        }
    }
}
