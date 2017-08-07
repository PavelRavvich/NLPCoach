package ru.nlpcoach.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Representation entity User.
 */
public class User {
    /**
     * Primary key Id of User.
     */
    private int id;
    /**
     * Login of user.
     */
    private String name;
    /**
     * Password of user.
     */
    private String password;
    /**
     * Email of user.
     */
    private String email;
    /**
     * List of chart.
     */
    private List<Chart> charts;
    /**
     * List of fiends.
     */
    private List<User> fiends;
    /**
     * Create date of account.
     */
    private Timestamp create;
    /**
     * Last visit.
     */
    private Timestamp lastVisit;

    public User() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }

    public List<User> getFiends() {
        return fiends;
    }

    public void setFiends(List<User> fiends) {
        this.fiends = fiends;
    }

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    public Timestamp getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Timestamp lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", charts=" + charts +
                ", fiends=" + fiends +
                ", create=" + create +
                ", lastVisit=" + lastVisit +
                '}';
    }
}
