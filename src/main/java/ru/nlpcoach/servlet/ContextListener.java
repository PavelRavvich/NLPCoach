package ru.nlpcoach.servlet;

import ru.nlpcoach.dao.DAOFake;
import ru.nlpcoach.dao.DAOStub;
import ru.nlpcoach.model.Chart;
import ru.nlpcoach.model.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Timestamp;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DAOFake dao = new DAOStub();
        dao.createChart(createDemoChart());

        servletContextEvent.getServletContext().setAttribute("dao", dao);
    }

    private Chart createDemoChart() {
        final User user = new User();
        user.setName("Pavel");

        Chart chart = new Chart();
        chart.setId(1);
        chart.setAuthor(user);
        chart.setCreate(new Timestamp(System.currentTimeMillis()));

        user.getCharts().add(chart);
        return chart;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
