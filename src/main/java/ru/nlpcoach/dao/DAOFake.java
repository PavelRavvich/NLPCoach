package ru.nlpcoach.dao;

import ru.nlpcoach.model.Chart;
import ru.nlpcoach.model.Point;

import java.util.List;

public interface DAOFake {
    Chart getChart(int id);
    List<Chart> getAllCharts();
    int createChart(Chart chart);
    void deleteChart(Chart chart);
    void updateChart(Chart chart);

    int addPoint(Point point);

    boolean updatePoint(Point point);
    boolean deletePoint(Point point);

    int getChartActualVersionById(int id);
}
