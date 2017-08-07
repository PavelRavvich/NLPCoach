package ru.nlpcoach.model;

import java.sql.Timestamp;

/**
 * Determines entity comment.
 */
public class Comment {
    /**
     * Determines primary key of comment.
     */
    private int id;
    /**
     * Author of comment.
     */
    private User author;
    /**
     * Body of comment.
     */
    private String text;
    /**
     * Time of create.
     */
    private Timestamp create;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author=" + author +
                ", text='" + text + '\'' +
                ", create=" + create +
                '}';
    }
}
