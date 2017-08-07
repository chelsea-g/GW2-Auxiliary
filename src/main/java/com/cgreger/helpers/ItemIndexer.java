package com.cgreger.helpers;

import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;

/**
 *  Item Indexer indexes database items
 *  so that Lucene can search items
 *  quickly. Currently in a main method
 *  for easy development.
 *
 *  Will be implemented into application
 *  in the future
 *
 *  @author Chelsea Greger
 */
public class ItemIndexer {

    public static void main(String args[]) throws IOException, ParseException {

        LuceneUtils lutil = new LuceneUtils();
        lutil.indexItems();

        System.exit(0);

    }

}
