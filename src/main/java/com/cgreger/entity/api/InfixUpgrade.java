package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Infix Upgrade object defined by GW2 API
 *
 * @author Chelsea Greger
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfixUpgrade {

    @JsonProperty("attributes")
    private List<Attribute> attributes = new ArrayList<Attribute>();

    @JsonProperty("buff")
    private Buff buff;

    public InfixUpgrade() { }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Buff getBuff() {
        return buff;
    }

    public void setBuff(Buff buff) {
        this.buff = buff;
    }

    @Override
    public String toString() {
        return "InfixUpgrade{" +
                "attributes=" + attributes +
                ", buff=" + buff +
                '}';
    }

}

