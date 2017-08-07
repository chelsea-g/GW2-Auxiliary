package com.cgreger.entity.api;

/**
 * Buff object defined by GW2 API
 *
 * @author Chelsea Greger
 */
public class Buff {

    private int skillId;
    private String description;

    public Buff() { }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Buff{" +
                "skillId=" + skillId +
                ", description='" + description + '\'' +
                '}';
    }
}
