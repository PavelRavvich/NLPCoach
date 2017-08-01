package ru.nlpcoach.dao;

import ru.nlpcoach.model.Phrase;

import java.util.List;

public interface DAO {
    List<Phrase> getSprintSet();

    void addPhrase(Phrase phrase);
}
