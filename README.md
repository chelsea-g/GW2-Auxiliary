# GW2 Auxiliary

### Background

Guild Wars 2 is a massively multiplayer online role-playing game that lets users create and play customizable, levelable, characters in the fantasy world of Tyria. The game's main features are centered around real-time events where players collectively complete achievements, quests, and defeat powerful enemies. 

GW2 has its own economy through the game's Trading Post where the player can buy, list items at their own price, or instantly sell (for a lower return). While some players like to buy their items quickly, others prefer to use GW2's extensive crafting system.

The crafting system in Guild Wars 2 can be visualized as each item having its own item hierarchy. Many of the low tier (basic or fine) items are built from materials that can be harvested from landscapes or looted from enemies, but rarer items such as top tier (ascended or legendary) weapons and armor may be built from many more items. Each of these items may consist of even more items or materials.

Here is a hierarchial visual of the items needed to make an Ascended Greatsword:
![Item Hierarchy Example](https://github.com/cgreger/GW2Auxiliary/blob/master/images/example-item-hierarchy.jpg)

### Issue

Crafting in GW2 is almost impossible without first researching item recipes. The most popular place to find item recipes is on the [Guild Wars 2 Wiki](https://wiki.guildwars2.com/wiki/Main_Page). It is a good resource when a player wants quick background information about a single item, but it is quite limited when trying to find out exactly which items and materials are needed to craft a high quality or rarer item. It often takes opening more than 10 browser tabs to figure out the full recipe of one single weapon/armor piece.

### Solution

GW2 Auxiliary will make crafting recipes easy to view and track. Keeping to a smaller scope it will feature:
* An intuitive recipe viewer with hierarchical dropdowns.
* Easy to view item details.
* User accounts to track item completion based on the user's current game inventory.

I have many more features I want to add, but this project will be focused on the 3 goals listed above.

In the future I would like GW2 Auxiliary to serve as a go-to gameplay supplement/resource for more than just crafting.

### Project Technologies/Techniques 

* Security/Authentication
  * All: Anyone can view item details and item recipes
  * User Role: Anyone with a GW2 API Key (generated through the user's [ArenaNet](https://www.arena.net/) account) will be able to create an acocunt & log in, allowing them to track item builds
* Database (MySQL and Hibernate)
  * Store users
  * Store api keys
  * Store user's tracked items
* Web Services or APIs
  * Guild Wars 2 [Official API](https://wiki.guildwars2.com/wiki/API:Main)
* Visuals
  * Bootstrap (may change)
  * HTML5 Progress Element (Progress bar for tracking item completion)
* Logging
  * Log4j - allows only errors in production.
* Site and database hosted on AWS
* Unit Testing
  * JUnit tests to achieve 80% code coverage
* Independent Research Topic
  * Apache Lucene

* [Screen Design](DesignDocuments/Screens.md)
