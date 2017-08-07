package ru.nlpcoach.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.nlpcoach.model.Point;

import java.io.Serializable;

public class DAOImpl implements DAO {
    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    /**
     * Default constructor.
     *
     * @param factory of connection to database.
     */
    public DAOImpl(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Point getPoint(int id) {

        Point result;

        try (final Session session = factory.openSession()) {

            final Transaction tx = session.beginTransaction();

            result = session.get(Point.class, id);

            tx.commit();

            return result;
        }
    }

    @Override
    public int savePoint(final Point point) {

        int id;

        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            id = (int) session.save(point);

            session.getTransaction().commit();

            return id;
        }
    }

    @Override
    public void deletePointById(final Point point) {

        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(point);

            session.getTransaction().commit();
        }
    }

    @Override
    public void updatePoint(Point point) {

        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(point);

            session.getTransaction().commit();
        }
    }

//    @Override
//    public List<Phrase> getSprintSet() {
//
//        List<Phrase> result;
//
//        final String hql = String.format("%s%s", "select p from Phrase p ",
//                "where p.id > 0");
//
//        try (final Session session = factory.openSession()) {
//
//            result = session.createQuery(hql, Phrase.class).getResultList();
//        }
//
//        return result;
//    }
//
//    @Override
//    public void addPhrase(final Phrase phrase) {
//
//        try (final Session session = factory.openSession()) {
//
//            session.beginTransaction();
//
//            session.save(phrase);
//
//            session.getTransaction().commit();
//        }
//    }
}
