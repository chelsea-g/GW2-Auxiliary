package com.cgreger.persistence;

import com.cgreger.entity.api.*;
import com.cgreger.entity.db.DBItem;
import com.cgreger.entity.db.User;
import com.fasterxml.jackson.databind.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Item DAO used to
 * Read and map items using the
 * Guildwars 2 api.
 *
 * Also used to retrieve and map item recipes
 *
 * @author Chelsea Greger
 */
public class ItemDAO {

    private GW2ServiceClient gw2Client = new GW2ServiceClient();
    private ObjectMapper mapper = new ObjectMapper();

    private Logger log = Logger.getLogger(this.getClass());

    public ItemDAO() { }

    /**
     * Request an item by name (uses DBItem data for faster
     * results)
     *
     * @param name  name of the requested item
     * @return      Item requested if exists, null if doesn't exist
     */
    public Item getItemByName(String name) {

        DBItemDAO dbItemDAO = new DBItemDAO();
        DBItem dbItem = dbItemDAO.getDBItemByName(name);

        Item item = getItem(dbItem.getGw2Id());

        return item;

    }

    /**
     * Requests an item by its Guildwars 2 ID
     *
     * @param id    the Guildwars 2 item id of the requested item
     * @return      Item requested if exists, null if doesn't exist
     */
    public Item getItem(int id) {

        Item item = null;
        String response = null;

        log.info("Retrieving Item (id=" + id + ")");

        try {

            response = gw2Client.request("https://api.guildwars2.com/v2/items?id=" + id);
            item = mapper.readValue(response, Item.class);
            setItemRecipes(item);

        } catch (IOException e) {

            e.printStackTrace();

        }

        log.info("Successfully retrieved Item (id=" + id + ")");

        return item;
    }

    /**
     * Retrieves all items based on keys in a map
     * (utilized by ItemTracker to convert user inventory ids into
     * actual Item objects
     *
     * @param itemIds   Requested map of items and quantities of inventory items
     * @return          Map of Item objects and quanties, null map if fails
     */
    public Map<Item, Integer> getItems(Map<Integer, Integer> itemIds) {

        Map<Item, Integer> items = new HashMap<Item, Integer>();
        JsonNode itemNodes = null;
        String response = null;
        String request = "https://api.guildwars2.com/v2/items?ids=";

        for (int itemId : itemIds.keySet()) {

            request += itemId + ",";

        }

        response = gw2Client.request(request);

        try {

            itemNodes = mapper.readValue(response, JsonNode.class);

            for(JsonNode itemNode : itemNodes) {

                log.info(itemNode.toString());

                Item item = mapper.readValue(itemNode.toString(), Item.class);
                int itemCount = itemIds.get(item.getId());
                items.put(item, itemCount);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return items;

    }

    /**
     * Retrieves ids of all recipes of a requested Guildwars 2 item ID
     *
     * @param id    Guildwars 2 item ID
     * @return      Arraylist of recipe ids belonging to the requested item
     */
    protected ArrayList<Integer> getItemRecipes(int id) {

        log.info("Retrieving Recipes for Item (id=" + id + ")");
        String response = null;
        ArrayList<Integer> recipeIds = null;

        try {

            response = gw2Client.request("https://api.guildwars2.com/v2/recipes/search?output=" + id);
            recipeIds = mapper.readValue(response, ArrayList.class);

        } catch (IOException e) {

            e.printStackTrace();

        }

        log.info("Successfully retrieved Recipes for Item (id=" + id + ")");

        return recipeIds;

    }


    /**
     * Retrieve a recipe by it's Guildwars 2 id
     *
     * @param id    Guildwars 2 recipe id
     * @return      Recipe object of recipe requested,
     *              null if doesn't exist
     */
    public Recipe getRecipe(int id) {

        log.info("Retrieving Recipe (id" + id + ")");
        String response = null;
        Recipe recipe = null;

        try {

            response= gw2Client.request("https://api.guildwars2.com/v2/recipes?id=" + id);
            recipe = mapper.readValue(response, Recipe.class);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return recipe;
    }

    /**
     * Sets an Item object's recipe list
     *
     * @param item  the Item object to link the recipes to
     */
    public void setItemRecipes(Item item) {

        log.info("Setting Recipes list for Item (id=" + item.getId() + ")");

        item.setRecipes(getItemRecipes(item.getId()));

        if (item.getRecipes() != null) {

            log.info("Setting Recipes list for Item (id=" + item.getId() + ")");

        } else {

            log.error("Failed to set Recipes list for Item (id=" + item.getId() + ")");

        }

    }

}
