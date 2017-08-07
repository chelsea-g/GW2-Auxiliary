package com.cgreger.helpers;

import com.cgreger.entity.api.Ingredient;
import com.cgreger.entity.api.Item;
import com.cgreger.entity.api.Recipe;
import com.cgreger.entity.db.TrackedItem;
import com.cgreger.entity.db.User;
import com.cgreger.persistence.ItemDAO;
import com.cgreger.persistence.TrackedItemDAO;

import java.util.ArrayList;

/**
 * Item Tracker utilities
 *
 * (Work in progress)
 *
 * @author Chelsea Greger
 */
public class ItemTracker {

    private ItemDAO itemDAO = new ItemDAO();
    private TrackedItemDAO trackedItemDAO = new TrackedItemDAO();

    //TODO: IMPORTANT figure this out!!!!

    /**
     * Calculate a user's tracked item completion
     * percentage
     *
     * @param user      User that is tracking the item
     * @param item      The gw2 api item that will be compared to
     *                  the user's tracked item
     * @return          percentage of item completion
     */
    public double calculateItemCompletion(User user, Item item) {

        double completionPercent = 0.0;

        Recipe recipe = itemDAO.getRecipe(item.getRecipes().get(0));

        for (Ingredient ingredient : recipe.getIngredients()) {

            ingredient.getCountNeeded();

        }

        for (Item inventoryItem : trackedItemDAO.getUserInventory(user).keySet()) {

            if (inventoryItem.getId() == recipe.getIngredients().get(0).getId()) {



            }

        }


        return completionPercent;

    }

    /**
     * Calculates the list of items still needed
     * to complete a tracked item build
     *
     * @param user  the User the tracked item belongs to
     * @param item  the Item to compare the users tracked item
     *              to
     * @return      List of Items that are still needed to build
     *              the user's tracked item
     */
    public ArrayList<Item> getNeededItems(User user, Item item) {

        ArrayList<Item> items = null;

        return items;

    }

}
