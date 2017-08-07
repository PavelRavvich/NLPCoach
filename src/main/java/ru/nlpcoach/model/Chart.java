package ru.nlpcoach.model;

import java.sql.Timestamp;
import java.util.List;

public class Chart {

    private int id;

    private int version;

    private List<Point> points;

    private User author;

    private Timestamp create;

    public Chart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", points=" + points +
                ", author=" + author +
                ", create=" + create +
                '}';
    }
}
