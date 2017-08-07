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

import static java.lang.Integer.parseInt;

/**
 * Control matches user's version and database version.
 */
public class ChartVersionControlServlet extends HttpServlet {
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


        final int chartId = parseInt(req.getParameter("chartId"));

        final int current = parseInt(req.getParameter("currentVersion"));

        final int actual = dao.get().getChartActualVersionById(chartId);

        Result result;

        if (current == actual) {

            //Send empty obj.
            result = new Result(true, new Chart());

        } else {

            //Get from database.
            final Chart actualState = dao.get().getChart(chartId);

            //False flag for client for parse actual Chart's state.
            result = new Result(false, actualState);
        }

        resp.getWriter().write(result.getJson());
    }

    /**
     * Format of result for Json server answer.
     * <p>
     * If user's version matches with database version return empty Chart obj.
     * And valid field - flag is true.
     * <p>
     * If user's version not matches with database version.
     * Then return whole Chart object from database. And valid - false.
     */
    private final class Result {
        /**
         * Matches current user version and database version.
         */
        private final boolean valid;
        /**
         * Chart which send to user. If valid true, - will empty.
         */
        private final Chart chart;

        /**
         * Default constructor.
         */
        private Result(final boolean valid, final Chart chart) {
            this.valid = valid;
            this.chart = chart;
        }

        /**
         * Converting this obj to Json style.
         */
        private String getJson() {
            return new Gson().toJson(this);
        }
    }
}
