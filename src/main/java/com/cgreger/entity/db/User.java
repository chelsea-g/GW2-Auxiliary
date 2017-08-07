package com.cgreger.entity.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * User Hibernate database object
 *
 * @author Chelsea Greger
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name="join_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") //, nullable = false)
    private Calendar joinDate;

    @OneToMany(targetEntity = APIKey.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<APIKey> apiKeys = new ArrayList<APIKey>();

    @OneToMany(targetEntity = TrackedItem.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TrackedItem> trackedItems = new ArrayList<TrackedItem>();

    @OneToMany(targetEntity = UserRole.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserRole> userRoles = new ArrayList<UserRole>();

    public User() { }

    public User(String email, String password, String salt) {

        this.email = email;
        this.password = password;
        this.salt = salt;
        this.joinDate = Calendar.getInstance();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Calendar getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
    }

    public List<APIKey> getApiKeys() {
        return apiKeys;
    }

    public void setApiKeys(List<APIKey> apiKeys) {
        this.apiKeys = apiKeys;
    }

    public List<TrackedItem> getTrackedItems() {
        return trackedItems;
    }

    public void setTrackedItems(List<TrackedItem> trackedItems) {
        this.trackedItems = trackedItems;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }


}
