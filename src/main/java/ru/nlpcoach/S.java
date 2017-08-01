package ru.nlpcoach;

import com.google.gson.Gson;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.nlpcoach.dao.DAOImpl;
import ru.nlpcoach.model.Phrase;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class S {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Map<String, Boolean> map = new LinkedHashMap<>();
        /**
         * Connection factory to database.
         */
        final SessionFactory f = new Configuration()
                .configure()
                .buildSessionFactory();

        final AtomicReference<SessionFactory> factory = new AtomicReference<>(f);
        map.put("Я ", false);
        map.put("не ", false);
        map.put("хочу ", false);
        map.put("этого ", true);
        map.put("потому что ", false);
        map.put("будет ", false);
        map.put("плохо.", true);

        final Phrase phrase = new Phrase(0, new Gson().toJson(map));

        new DAOImpl(factory).addPhrase(phrase);

        new DAOImpl(factory).getSprintSet().forEach(System.out::println);

        f.close();


    }
}
