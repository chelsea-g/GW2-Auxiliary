package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ingredient object defined by GW2 API
 *
 * @author Chelsea Greger
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {

    @JsonProperty("item_id")
    private int id;

    @JsonProperty("count")
    private int countNeeded;

    public Ingredient() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountNeeded() {
        return countNeeded;
    }

    public void setCountNeeded(int countNeeded) {
        this.countNeeded = countNeeded;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", countNeeded=" + countNeeded +
                '}';
    }
}
