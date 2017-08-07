package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Attribute object defined by GW2 API
 *
 * @author Chelsea Greger
 */
public class Attribute {

    @JsonProperty("attribute")
    private String attributeType;

    @JsonProperty("modifier")
    private int modifierValue;

    public Attribute() { }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public int getModifierValue() {
        return modifierValue;
    }

    public void setModifierValue(int modifierValue) {
        this.modifierValue = modifierValue;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "attributeType='" + attributeType + '\'' +
                ", modifierValue=" + modifierValue +
                '}';
    }

}
