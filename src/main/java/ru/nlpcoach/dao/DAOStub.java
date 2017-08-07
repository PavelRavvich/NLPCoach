package ru.nlpcoach.dao;

import ru.nlpcoach.model.Chart;
import ru.nlpcoach.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DAOStub implements DAOFake {
    private final Map<Integer, Chart> charts = new ConcurrentHashMap<>();
    private int idCounterChart = 0;
    private int idCounterPoint = 0;

    @Override
    public Chart getChart(int id) {
        return charts.get(id);
    }

    @Override
    public List<Chart> getAllCharts() {
        final List<Chart> allCharts = new ArrayList<>();
        allCharts.addAll(charts.values());
        return allCharts;
    }

    @Override
    public int createChart(Chart chart) {
        chart.setId(++idCounterChart);
        charts.put(idCounterChart, chart);
        return idCounterChart;
    }

    @Override
    public void deleteChart(Chart chart) {
        charts.remove(chart.getId(), chart);
    }


    @Override
    public void updateChart(Chart chart) {
        charts.replace(chart.getId(), chart);
    }

    @Override
    public int addPoint(Point point) {
        final Chart chart = charts.get(point.getChartId());
        final List<Point> points = chart.getPoints();

        if(points.add(point)) chart.setVersion(chart.getVersion() + 1);

        point.setId(++idCounterPoint);

        return idCounterPoint;
    }

    @Override
    public boolean updatePoint(Point point) {
        boolean result = false;

        final Chart chart = charts.get(point.getChartId());
        final List<Point> points = chart.getPoints();

        for (Point target : points) {
            if (target.getId() == point.getId()) {
                target.setX(point.getX());
                target.setY(point.getY());
                chart.setVersion(chart.getVersion() + 1);
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean deletePoint(Point point) {

        boolean result = false;

        final Chart chart = charts.get(point.getChartId());
        final List<Point> points = chart.getPoints();

        for (Point target : points) {
            if (target.getId() == point.getId()) {
                points.remove(point);
                result = true;
                break;
            }
        }

        return result;
    }

    //todo
    @Override
    public int getChartActualVersionById(int id) {
        return 0;
    }
}
