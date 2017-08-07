package com.cgreger.persistence;

import com.cgreger.entity.db.DBItem;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.complexPhrase.ComplexPhraseQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class DBItemDAOTest {

    private DBItemDAO dbItemDAO = new DBItemDAO();
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();
    private Logger log = Logger.getLogger(this.getClass());

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

    @Test
    public void getDBItemByName() throws Exception {

        DBItem dbItem = dbItemDAO.getDBItemByName("Mighty Worn Chain Greaves");
        assertEquals("Failed to retrieve correct DBItem by name", "Mighty Worn Chain Greaves", dbItem.getName());

    }

    @Test
    public void addDBItem() throws Exception {

        DBItem dbItem = new DBItem(400, "Test Item", "Test Type", "ICON");
        dbItemDAO.addDBItem(dbItem);

        //TODO: Check database for item

    }

    @Test
    public void updateItemDatabase() throws Exception {

        assertTrue(dbItemDAO.updateItemDatabase(0));

    }

    @Test
    public void truncateItemDatabase() throws Exception {

        dbItemDAO.addDBItem(new DBItem(404, "Delete Me", "Trash", "ICON"));

        dbItemDAO.truncateItemDatabase();

        //TODO: Check that table is empty

    }

}