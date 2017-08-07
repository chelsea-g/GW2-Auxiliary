package com.cgreger.entity.db;

import javax.persistence.*;

/**
 * Database Item Hibernate database object
 *
 * @author Chelsea Greger
 */
@Entity
@Table(name = "item")
public class DBItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "gw2_id")
    private int gw2Id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name= "icon")
    private String icon;

    public DBItem() { }

    public DBItem(int gw2Id, String name, String type, String icon) {

        this.gw2Id = gw2Id;
        this.name = name;
        this.type = type;
        this.icon = icon;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGw2Id() {
        return gw2Id;
    }

    public void setGw2Id(int gw2Id) {
        this.gw2Id = gw2Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "DBItem{" +
                "id=" + id +
                ", gw2Id=" + gw2Id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
