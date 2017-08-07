package com.cgreger.entity.db;

import javax.persistence.*;

/**
 * APIKey Hibernate database object
 *
 * @author Chelsea Greger
 */
@Entity
@Table(name = "gw2_api_key")
public class APIKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "api_key")
    private String apiKey;

    public APIKey() { }

    public APIKey(User user, String apiKeyString) {

        this.user = user;
        this.apiKey = apiKeyString;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "APIKey{" +
                "id=" + id +
                ", user=" + user +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}
