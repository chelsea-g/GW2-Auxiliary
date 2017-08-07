package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

/**
 * Item Details object defined by GW2 API
 *
 * @author Chelsea Greger
 */
@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Details {

    @JsonProperty("type")
    private String specificType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("flags")
    private List<String> upgradableItemTypes = new ArrayList<String>();

    @JsonProperty("infusion_upgrade_flags")
    private List<String> applicableInfusions = new ArrayList<String>();

    @JsonProperty("infix_upgrade")
    private InfixUpgrade infixUpgrade;

    @JsonProperty("suffix")
    private String suffix;

    @JsonProperty("bonuses")
    private List<String> bonuses = new ArrayList<String>();

    @JsonProperty("no_sell_or_sort")
    private boolean noSellOrSort;

    @JsonProperty("weight_class")
    private String weightClass;

    @JsonProperty("defense")
    private int defense;

    @JsonProperty("duration_ms")
    private int durationInMiliSec;

    @JsonProperty("unlock_type")
    private String unlockType;

    @JsonProperty("color_id")
    private int dyeId;

    @JsonProperty("recipe_id")
    private int recipeId; //TODO: redundant?

    @JsonProperty("name")
    private String effectName;

    @JsonProperty("infusion_slots")
    private List<InfusionSlot> infusionSlots = new ArrayList<InfusionSlot>();

    @JsonProperty("suffix_item_id")
    private int suffixItemId;

    @JsonProperty("secondary_suffix_item_id")
    private int secondarySuffixItemId;

    @JsonProperty("stat_choices")
    private List<String> statChoices = new ArrayList<String>();

    @JsonProperty("size")
    private int numberOfSlots;

    @JsonProperty("minipet_id")
    private int minipetId;

    @JsonProperty("charges")
    private int chargesLeft;

    public Details() { }

    public String getSpecificType() {
        return specificType;
    }

    public void setSpecificType(String specificType) {
        this.specificType = specificType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getUpgradableItemTypes() {
        return upgradableItemTypes;
    }

    public void setUpgradableItemTypes(List<String> upgradableItemTypes) {
        this.upgradableItemTypes = upgradableItemTypes;
    }

    public List<String> getApplicableInfusions() {
        return applicableInfusions;
    }

    public void setApplicableInfusions(List<String> applicableInfusions) {
        this.applicableInfusions = applicableInfusions;
    }

    public InfixUpgrade getInfixUpgrade() {
        return infixUpgrade;
    }

    public void setInfixUpgrade(InfixUpgrade infixUpgrade) {
        this.infixUpgrade = infixUpgrade;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public List<String> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<String> bonuses) {
        this.bonuses = bonuses;
    }

    public boolean isNoSellOrSort() {
        return noSellOrSort;
    }

    public void setNoSellOrSort(boolean noSellOrSort) {
        this.noSellOrSort = noSellOrSort;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDurationInMiliSec() {
        return durationInMiliSec;
    }

    public void setDurationInMiliSec(int durationInMiliSec) {
        this.durationInMiliSec = durationInMiliSec;
    }

    public String getUnlockType() {
        return unlockType;
    }

    public void setUnlockType(String unlockType) {
        this.unlockType = unlockType;
    }

    public int getDyeId() {
        return dyeId;
    }

    public void setDyeId(int dyeId) {
        this.dyeId = dyeId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    public List<InfusionSlot> getInfusionSlots() {
        return infusionSlots;
    }

    public void setInfusionSlots(List<InfusionSlot> infusionSlots) {
        this.infusionSlots = infusionSlots;
    }

    public int getSuffixItemId() {
        return suffixItemId;
    }

    public void setSuffixItemId(int suffixItemId) {
        this.suffixItemId = suffixItemId;
    }

    public int getSecondarySuffixItemId() {
        return secondarySuffixItemId;
    }

    public void setSecondarySuffixItemId(int secondarySuffixItemId) {
        this.secondarySuffixItemId = secondarySuffixItemId;
    }

    public List<String> getStatChoices() {
        return statChoices;
    }

    public void setStatChoices(List<String> statChoices) {
        this.statChoices = statChoices;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public int getMinipetId() {
        return minipetId;
    }

    public void setMinipetId(int minipetId) {
        this.minipetId = minipetId;
    }

    public int getChargesLeft() {
        return chargesLeft;
    }

    public void setChargesLeft(int chargesLeft) {
        this.chargesLeft = chargesLeft;
    }

    @Override
    public String toString() {
        return "\n\nDetails{" +
                "\n\tspecificType='" + specificType + '\'' +
                ",\n\tdescription='" + description + '\'' +
                ",\n\tupgradableItemTypes=" + upgradableItemTypes +
                ",\n\tapplicableInfusions=" + applicableInfusions +
                ",\n\tinfixUpgrade=" + infixUpgrade +
                ",\n\tsuffix='" + suffix + '\'' +
                ",\n\tbonuses=" + bonuses +
                ",\n\tnoSellOrSort=" + noSellOrSort +
                ",\n\tweightClass='" + weightClass + '\'' +
                ",\n\tdefense=" + defense +
                ",\n\tdurationInMiliSec=" + durationInMiliSec +
                ",\n\tunlockType='" + unlockType + '\'' +
                ",\n\tdyeId=" + dyeId +
                ", \n\trecipeId=" + recipeId +
                ", \n\teffectName='" + effectName + '\'' +
                ", \n\tinfusionSlots=" + infusionSlots +
                ", \n\tsuffixItemId=" + suffixItemId +
                ", \n\tsecondarySuffixItemId=" + secondarySuffixItemId +
                ", \n\tstatChoices=" + statChoices +
                ", \n\tnumberOfSlots=" + numberOfSlots +
                ", \n\tminipetId=" + minipetId +
                ", \n\tchargesLeft=" + chargesLeft +
                "\n}";
    }
}
