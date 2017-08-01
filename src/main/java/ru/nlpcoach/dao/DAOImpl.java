package ru.nlpcoach.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.nlpcoach.model.Phrase;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DAOImpl implements DAO {
    /**
     * Connection factory to database.
     */
    private final AtomicReference<SessionFactory> factory;

    /**
     * Default constructor.
     *
     * @param factory of connection to database.
     */
    public DAOImpl(final AtomicReference<SessionFactory> factory) {
        this.factory = factory;
    }

    @Override
    public List<Phrase> getSprintSet() {

        List<Phrase> result;

        final String hql = String.format("%s%s", "select p from Phrase p ",
                "where p.id > 0");

        try (final Session session = factory.get().openSession()) {

            result = session.createQuery(hql, Phrase.class).getResultList();
        }

        return result;
    }

    @Override
    public void addPhrase(final Phrase phrase) {

        try (final Session session = factory.get().openSession()) {

            session.beginTransaction();

            session.save(phrase);

            session.getTransaction().commit();
        }
    }
}
