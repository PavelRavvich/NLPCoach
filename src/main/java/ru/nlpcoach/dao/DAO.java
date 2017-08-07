package ru.nlpcoach.dao;

import ru.nlpcoach.model.Point;

public interface DAO {
    Point getPoint(int id);
    int savePoint(Point point);
    void deletePointById(Point point);
    void updatePoint(Point point);
}
