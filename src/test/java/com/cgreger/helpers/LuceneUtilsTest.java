package com.cgreger.helpers;

import com.cgreger.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by katana on 5/2/17.
 */
public class LuceneUtilsTest {

    private LuceneUtils lutils = new LuceneUtils("/home/katana/EnterpriseRepos/GW2Auxiliary/lucene/indexes/testindex");
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();
    private Logger log = Logger.getLogger(this.getClass());

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            tr = session.beginTransaction();

            session.createSQLQuery("INSERT INTO TEST_gw2_auxiliary.item " +
                    "(gw2_id, name, type, icon) VALUES" +
                    "(1, 'MONSTER ONLY Moa Unarmed Pet', 'Weapon', 'ICON')," +
                    "(2, 'Assassin Pill', 'Consumable', 'ICON')," +
                    "(6, '((208738))', 'Weapon', 'ICON')," +
                    "(11, 'Undead Unarmed', 'Weapon', 'ICON')," +
                    "(15, 'Abomination Hammer', 'Weapon, 'ICON'')," +
                    "(23, 'RC Controller', 'Weapon', 'ICON')," +
                    "(24, 'Sealed Package of Snowballs', 'Consumable', 'ICON')," +
                    "(32, 'PvP Heavy Gloves of the Warrior', 'Armor', 'ICON')," +
                    "(46, 'Gladiator Weapon', 'Weapon', 'ICON')," +
                    "(50, 'Flame Legion Hammer', 'Weapon', 'ICON')," +
                    "(56, 'Strong Back Brace', 'Back', 'ICON')," +
                    "(57, 'Hearty Back Brace', 'Back', 'ICON')," +
                    "(58, 'Enduring Back Brace', 'Back', 'ICON')," +
                    "(59, 'Berserkers Spineguard of Ruby', 'Back', 'ICON')," +
                    "(60, 'Clerics Spineguard of Sapphire', 'Back', 'ICON')," +
                    "(61, 'Rampagers Spineguard of Coral', 'Back', 'ICON')," +
                    "(62, 'Shirt', 'Armor', 'ICON')," +
                    "(63, 'Leggings', 'Armor', 'ICON')," +
                    "(64, 'Boots', 'Armor'), 'ICON'," +
                    "(68, 'Mighty Country Coat', 'Armor', 'ICON')," +
                    "(69, 'Mighty Country Coat', 'Armor', 'ICON')," +
                    "(70, 'Mighty Studded Coat', 'Armor', 'ICON')," +
                    "(71, 'Mighty Worn Chain Greaves', 'Armor', 'ICON')," +
                    "(72, 'Berserker''s Sneakthief Mask of the Afflicted', 'Armor', 'ICON')," +
                    "(73, 'Berserker''s Sneakthief Mask of Dwayna', 'Armor', 'ICON')," +
                    "(74, 'Mighty Worn Chain Greaves', 'Armor', 'ICON')," +
                    "(75, 'Berserker''s Sneakthief Mask of Strength', 'Armor', 'ICON')")
                    .executeUpdate();


        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

        } finally {

            session.close();

        }


    }

    //TODO: add assertions
    @Test
    public void indexItems() throws Exception {

        lutils.indexItems();

    }

    @Test
    public void fuzzyQuery() throws Exception {

        lutils.indexItems();
        lutils.fuzzyQuery("bak string");

    }

}