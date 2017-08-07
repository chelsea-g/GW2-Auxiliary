package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Recipe object defined by GW2 API
 *
 * @author Chelsea Greger
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {

    @JsonProperty("id")
    private int id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("output_item_id")
    private int outputItemId;

    @JsonProperty("output_item_count")
    private int outputItemCount;

    @JsonProperty("min_rating")
    private int minRating;

    @JsonProperty("time_to_craft_ms")
    private int timeToCraftInMili;

    @JsonProperty("disciplines")
    private List<String> disciplines;

    @JsonProperty("flags")
    private List<String> flags;

    //Ingredients are automatically mapped as each ingredient when using itemDAO.getRecipe()
    @JsonProperty("ingredients")
    private List<Ingredient> ingredients;

    @JsonProperty("chat_link")
    private String chatLink;

    public Recipe() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOutputItemId() {
        return outputItemId;
    }

    public void setOutputItemId(int outputItemId) {
        this.outputItemId = outputItemId;
    }

    public int getOutputItemCount() {
        return outputItemCount;
    }

    public void setOutputItemCount(int outputItemCount) {
        this.outputItemCount = outputItemCount;
    }

    public int getMinRating() {
        return minRating;
    }

    public void setMinRating(int minRating) {
        this.minRating = minRating;
    }

    public int getTimeToCraftInMili() {
        return timeToCraftInMili;
    }

    public void setTimeToCraftInMili(int timeToCraftInMili) {
        this.timeToCraftInMili = timeToCraftInMili;
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<String> disciplines) {
        this.disciplines = disciplines;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getChatLink() {
        return chatLink;
    }

    public void setChatLink(String chatLink) {
        this.chatLink = chatLink;
    }

    @Override
    public String toString() {
        return "Recipe{\n" +
                "id=" + id +
                ", \noutputItemId=" + outputItemId +
                ", \noutputItemCount=" + outputItemCount +
                ", \nminRating=" + minRating +
                ", \ntimeToCraftInMili=" + timeToCraftInMili +
                ", \ndisciplines=" + disciplines +
                ", \nflags=" + flags +
                ", \ningredients=" + ingredients +
                ", \nchatLink='" + chatLink + '\'' +
                "\n}";
    }

}
