package ru.nlpcoach.model;

/**
 * Determined word set.
 */
public class Phrase {
    /**
     * Id of jsonPhrase.
     */
    private int id;
    /**
     * All word of phrase represent map.
     * Key is word value, value is boolean param.
     * Example {Hello:"false ","world":true}.
     * Word mark as 'true' is target in game.
     */
    private String jsonPhrase;

    /**
     * Constructor for Hibernate.
     */
    public Phrase() {
    }

    public Phrase(int id, String jsonPhrase) {
        this.jsonPhrase = jsonPhrase;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJsonPhrase() {
        return jsonPhrase;
    }

    public void setJsonPhrase(String jsonPhrase) {
        this.jsonPhrase = jsonPhrase;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "id=" + id +
                ", jsonPhrase='" + jsonPhrase + '\'' +
                '}';
    }
}