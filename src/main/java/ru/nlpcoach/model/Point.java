package ru.nlpcoach.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Represent entity of Point in Chart.
 */
public class Point {
    /**
     * Primary key of point.
     */
    private int id;
    /**
     * Chart id
     */
    private int chartId;
    /**
     * X attribute. Value feel.
     */
    private int x;
    /**
     * Y attribute. Create time of point.
     */
    private Timestamp y;
    /**
     * Comment to point.
     */
    private List<Comment> comments;

    public Point() {
    }

    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Timestamp getY() {
        return y;
    }

    public void setY(Timestamp y) {
        this.y = y;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", chartId=" + chartId +
                ", x=" + x +
                ", y=" + y +
                ", comments=" + comments +
                '}';
    }
}
