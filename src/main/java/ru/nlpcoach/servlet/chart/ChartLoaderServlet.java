package ru.nlpcoach.servlet.chart;

import com.google.gson.Gson;
import ru.nlpcoach.dao.DAOFake;
import ru.nlpcoach.model.Chart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Load whole Chart by id.
 */
public class ChartLoaderServlet extends HttpServlet {
    /**
     * Representation DAO layer.
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


        final int id = Integer.parseInt(req.getParameter("id"));

        final Chart chart = dao.get().getChart(id);

        resp.getWriter().write(new Gson().toJson(chart));
    }
}
