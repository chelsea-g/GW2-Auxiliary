package com.cgreger.entity.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * Item object defined by GW2 API
 *
 * @author Chelsea Greger
 */
@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private String type;

	@JsonProperty("vendor_value")
	private int vendorValue;

	@JsonProperty("level")
	private int level;

	@JsonProperty("default_skin")
	private int defaultSkin;

	@JsonProperty("flags")
	private List<String> flags;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("description")
	private String description;

	@JsonProperty("restrictions")
	private List<String> restrictions;

	@JsonProperty("game_types")
	private List<String> gameTypes;

	@JsonProperty("chat_link")
	private String chatLink;

	@JsonProperty("details")
	private Details details;

	@JsonProperty("rarity")
	private String rarity;

	//TODO: make this array of Recipe items convert within dao?
    private ArrayList<Integer> recipes;

    public Item() {

       // ItemDAO itemDAO = new ItemDAO();
        //itemDAO.setItemRecipes(this);

    }

	public void setVendorValue(int vendorValue){
		this.vendorValue = vendorValue;
	}

	public int getVendorValue(){
		return vendorValue;
	}

	public void setLevel(int level){
		this.level = level;
	}

	public int getLevel(){
		return level;
	}

	public void setDefaultSkin(int defaultSkin){
		this.defaultSkin = defaultSkin;
	}

	public int getDefaultSkin(){
		return defaultSkin;
	}

	public void setFlags(List<String> flags){
		this.flags = flags;
	}

	public List<String> getFlags(){
		return flags;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setRestrictions(List<String> restrictions){
		this.restrictions = restrictions;
	}

	public List<String> getRestrictions(){
		return restrictions;
	}

	public void setGameTypes(List<String> gameTypes){
		this.gameTypes = gameTypes;
	}

	public List<String> getGameTypes(){
		return gameTypes;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setChatLink(String chatLink){
		this.chatLink = chatLink;
	}

	public String getChatLink(){
		return chatLink;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDetails(Details armorDetails){
		this.details = armorDetails;
	}

	public Details getArmorDetails(){
		return details;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setRarity(String rarity){
		this.rarity = rarity;
	}

	public String getRarity(){
		return rarity;
	}

    public ArrayList<Integer> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Integer> recipes) {
        this.recipes = recipes;
    }

	@Override
	public String toString() {
		return "\n\nItem{" +
				"\n\tvendorValue=" + vendorValue +
				", \n\tlevel=" + level +
				", \n\tdefaultSkin=" + defaultSkin +
				", \n\tflags=" + flags +
				", \n\ticon='" + icon + '\'' +
				", \n\tdescription='" + description + '\'' +
				", \n\trestrictions=" + restrictions +
				", \n\tgameTypes=" + gameTypes +
				", \n\ttype='" + type + '\'' +
				", \n\tchatLink='" + chatLink + '\'' +
				", \n\tname='" + name + '\'' +
				", \n\tdetails=" + details +
				", \n\tid=" + id +
				", \n\trarity='" + rarity + '\'' +
				", \n\trecipes=" + recipes +
				"\n}";
	}
}