import java.util.ArrayList;

/**
 * object class for HungerGames.java
 * manages name, items, kills, is a bot
 * makes my life easy
 */
public class Tribute {

    //fields
    private final String name;
    private ArrayList<String> Items = new ArrayList<>(java.util.Arrays.asList("Punch"));
    private int kills; 
    private final boolean bot;

    //constructor
    public Tribute(String name, boolean bot, int kills){
        this.name = name;
        this.bot = bot;
        this.kills = kills;
    }

    /**
     * method for getting tribute name
     */
    public String getName(){
        return name;
    }


    /**
     * method for giving items to a tribute
     * @param index the index of the item in the items array
     */
    public void giveItem(int index){
        Items.add(HungerGames.items[index]);
    }

    /**
     * method for getting items
     */
    public ArrayList<String> getItems(){
        return Items;
    }


    /**
     * method for adding kills
     * @param numKills the number of kills to add
     */
    public void addKills(int numKills){
        kills += numKills;
    }

    /**
     * method for getting kills of a tribute
     */
    public int getKills(){
        return kills;
    }

    /**
     * method for checking if a tribute is a bot
     */
    public boolean isBot(){
        return bot;
    }

}
