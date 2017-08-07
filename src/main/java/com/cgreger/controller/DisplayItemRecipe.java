package com.cgreger.controller;

import com.cgreger.entity.api.Ingredient;
import com.cgreger.entity.api.Item;
import com.cgreger.entity.api.Recipe;
import com.cgreger.persistence.ItemDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "DisplayItemRecipe",
        urlPatterns = {"/recipe"}

)

/**
 *
 */
public class DisplayItemRecipe extends HttpServlet {

    private ItemDAO itemDAO = new ItemDAO();
    private ObjectMapper mapper = new ObjectMapper();
    private Logger log = Logger.getLogger(this.getClass());

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int itemId = Integer.parseInt(request.getParameter("item_id"));

        Item item = itemDAO.getItem(itemId);
        log.info(item.getId());
        log.info(item.getRecipes());
        log.info(item.getName());
        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.put("root_item_icon", item.getIcon());
        rootNode.put("root_item_name", item.getName());
        rootNode.put("root_item_rarity", item.getRarity());
        rootNode.put("root_item_type", item.getType());

        ArrayNode recipeArray = rootNode.putArray("recipes");

        log.info("ITEM RECIPESSSSSSSSSSs  ---->" + item.getRecipes());

        for (int recipeId : item.getRecipes()) {

            log.info(recipeId);
            Recipe recipe = itemDAO.getRecipe(recipeId);

            //TODO: fix variable names in this stuff

            for (Ingredient ingredient : recipe.getIngredients()) {

                ObjectNode ingredientNode = mapper.createObjectNode();
                ingredientNode.put("item_id", ingredient.getId()); //Needed item for recipe
                ingredientNode.put("item_count_needed", ingredient.getCountNeeded()); //Quantity of the item needed
                recipeArray.add(ingredientNode);

            }

        }

        log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode));

        String recipeData = mapper.writeValueAsString(rootNode);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(recipeData);


    }

}