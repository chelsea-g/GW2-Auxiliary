package com.cgreger.persistence;

import com.cgreger.entity.api.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by katana on 2/28/17.
 */
public class ItemDAOTest {

    Logger log = Logger.getLogger(this.getClass());
    ItemDAO dao;
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            tr = session.beginTransaction();

            session.createSQLQuery("INSERT INTO TEST_gw2_auxiliary.item " +
                    "(gw2_id, name, type) VALUES" +
                    "(1, 'MONSTER ONLY Moa Unarmed Pet', 'Weapon')," +
                    "(2, 'Assassin Pill', 'Consumable')," +
                    "(6, '((208738))', 'Weapon')," +
                    "(11, 'Undead Unarmed', 'Weapon')," +
                    "(15, 'Abomination Hammer', 'Weapon')," +
                    "(23, 'RC Controller', 'Weapon')," +
                    "(24, 'Sealed Package of Snowballs', 'Consumable')," +
                    "(32, 'PvP Heavy Gloves of the Warrior', 'Armor')," +
                    "(46, 'Gladiator Weapon', 'Weapon')," +
                    "(50, 'Flame Legion Hammer', 'Weapon')," +
                    "(56, 'Strong Back Brace', 'Back')," +
                    "(57, 'Hearty Back Brace', 'Back')," +
                    "(58, 'Enduring Back Brace', 'Back')," +
                    "(59, 'Berserkers Spineguard of Ruby', 'Back')," +
                    "(60, 'Clerics Spineguard of Sapphire', 'Back')," +
                    "(61, 'Rampagers Spineguard of Coral', 'Back')," +
                    "(62, 'Shirt', 'Armor')," +
                    "(63, 'Leggings', 'Armor')," +
                    "(64, 'Boots', 'Armor')," +
                    "(68, 'Mighty Country Coat', 'Armor')," +
                    "(69, 'Mighty Country Coat', 'Armor')," +
                    "(70, 'Mighty Studded Coat', 'Armor')," +
                    "(71, 'Mighty Worn Chain Greaves', 'Armor')," +
                    "(72, 'Berserker''s Sneakthief Mask of the Afflicted', 'Armor')," +
                    "(73, 'Berserker''s Sneakthief Mask of Dwayna', 'Armor')," +
                    "(74, 'Mighty Worn Chain Greaves', 'Armor')," +
                    "(75, 'Berserker''s Sneakthief Mask of Strength', 'Armor')")
                    .executeUpdate();


        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

        } finally {

            session.close();

        }


    }
    //TODO: finish tests

    @Before
    public void setUp() throws  Exception {

         dao = new ItemDAO();

    }

    @Test
    public void getItemByName() throws Exception {

        Item item = dao.getItemByName("Mighty Worn Chain Greaves");

        assertEquals("Failed to retrieve correct Item. ", "Mighty Worn Chain Greaves" , item.getName());

    }

    @Test
    public void getItem() throws Exception {

        Item item = dao.getItem(50065);
        log.info(item.getClass().toString());

        assertEquals("Failed to retrieve correct Item.", 50065, item.getId());
        assertEquals("Failed to retrieve correct Item.", "Gift of Blades", item.getName());

        log.info("\n\n" + item.toString());

    }

//    @Test
//    public void getItems() throws Exception {
//
//        ArrayList<Integer> itemIds = new ArrayList<Integer>();
//
//        itemIds.add(70892);
//        itemIds.add(1);
//        itemIds.add(255);
//
//        List<Item> items = dao.getItems(itemIds);
//
//        for (Item item : items) {
//
//            log.info(item.toString());
//
//        }
//
//    }

    @Test
    public void getItemRecipes() throws Exception {

        ArrayList<Integer> recipes = dao.getItemRecipes(50065);
        ArrayList<Integer> recipesExpected = new ArrayList<Integer>();
        recipesExpected.add(8455);
        recipesExpected.add(8459);
        recipesExpected.add(8460);

        assertEquals("Failed to retrieve list of Item Recipes for Item (id50065)", recipesExpected, recipes);

    }

    @Test
    public void getRecipe() throws Exception {

        Recipe recipe = dao.getRecipe(100);
        ArrayList<String> disciplinesExpected = new ArrayList<String>();
        disciplinesExpected.add("Leatherworker");
        disciplinesExpected.add("Armorsmith");
        disciplinesExpected.add("Tailor");


        assertEquals("Failed to retrieve correct Recipe.", 100, recipe.getId());
        assertEquals("Failed to retrieve correct Recipe.", disciplinesExpected, recipe.getDisciplines());

        log.info("\n\n" + recipe.toString());

        ArrayList<Ingredient> ingredients = (ArrayList<Ingredient>) recipe.getIngredients();


        log.info(ingredients);

    }

    @Test
    public void setItemRecipes() throws Exception {

        Item item = new Item();

        ArrayList<Integer> recipes = new ArrayList<Integer>();
        recipes.add(8455);
        recipes.add(8459);
        recipes.add(8460);

        item.setRecipes(recipes);

        assertEquals("Failed to set Recipes for Item (id" + item.getId() + ")",
                recipes, item.getRecipes());

    }

}