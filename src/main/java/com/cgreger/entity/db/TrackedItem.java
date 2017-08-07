package com.cgreger.entity.db;

import javax.persistence.*;
import java.util.Calendar;


/**
 * Tracked Item Hibernate database object
 *
 * @author Chelsea Greger
 */
@Entity
@Table(name="tracked_item")
public class TrackedItem {

    //TODO: TEST
    //TODO: Finish

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "gw2_item_id")
    private int gw2ItemId;

    //@NotNull
    @Column(name = "date_added", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Calendar dateAdded;

    public TrackedItem() { }

    public TrackedItem(User user, int gw2ItemId) {

        this.user = user;
        this.gw2ItemId = gw2ItemId;
        this.dateAdded = Calendar.getInstance();

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

    public int getGw2ItemId() {
        return gw2ItemId;
    }

    public void setGw2ItemId(int gw2ItemId) {
        this.gw2ItemId = gw2ItemId;
    }

    public Calendar getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Calendar dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "TrackedItem{" +
                "id=" + id +
                ", user=" + user +
                ", gw2ItemId=" + gw2ItemId +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
