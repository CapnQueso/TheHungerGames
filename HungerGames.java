/**
* @author Eli
* @version 0.6
* A program to simulate the hunger games.
*/
import java.util.ArrayList;
import java.util.Scanner;
//file import java.io.File;

public class HungerGames {
    // Constants
    public static ArrayList<HungerGames> tributes = new ArrayList<>();
    public static ArrayList<String> Pairs = new ArrayList<>();
    public static String[] items = {"Sword", "Shield", "Bow", "Food", "Water"}; //make txt file
    public static String[] deaths = {"stabbed", "bashed", "shot", "poisoned", "drowned"};
    public static ArrayList<Integer> kills = new ArrayList<>();
    public static int numTributes = 0;
    public static int day = 1;
    public static int difficulty = 1; //1 = easy, 2 = medium, 3 = hard

    /**
     * Main method to run the Hunger Games simulation.
     * It prompts the user for the number of tributes and their names,
     * then simulates the games until only one tribute remains.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

/**
        //prompt for difficulty of games
        System.out.print("Enter the difficulty of the games (1 = easy, 2 = medium, 3 = hard): ");
        difficulty = input.nextInt();
*/    

        //prompt for number of tributes
        System.out.print("Enter the number of tributes: ");
        numTributes = input.nextInt();
        
        //cycle through the number of tributes and get their names, and initialize kills
        //also determine if the tribute is a player or a bot
        for(int i = 0; i < numTributes; i++) {
            System.out.print("Enter the name of tribute " + (i + 1) + ": ");
            String name = input.next();
         //   tributes.add(name);
            //store the kills for each tribute with their object in arraylist tribute
            
/**         //identify if the tribute is a player or a bot and save it in the players list
            System.out.print("Is this tribute a player? (yes/no): ");
            String isPlayer = input.next();
            if (isPlayer.toLowerCase().substring(0, 1).equals("y")) {
                players.add(1);
            } else {
                players.add(0);
            }
*/
        }

        //print initial test information
        System.out.println("Tributes: " + tributes);
//        System.out.println("Players: " + players);
        
        //intro
        System.out.println("Welcome to the Hunger Games!");
        System.out.println("There are " + numTributes + " tributes in the arena");
        System.out.println("May the odds be ever in your favor!");
        simulateBloodBath();

        //test print for pairs
        System.out.println("Pairs: " + Pairs);

        //simulate days until only one tribute remains
        while(numTributes > 1){
            simulateDay();

        }

        //print winner information
        if(players.get(0) == 1){
            System.out.println("The winner is player: " + tributes.get(0) + "! congratulations!");
        } else {
            System.out.println("The winner is bot: " + tributes.get(0) + "! awww man...");

        }
        System.out.println(tributes.get(0) + " got " + kills.get(0) + " kills.");
        

        input.close();
    }

    /**
     * Simulate the bloodbath at the start of the Hunger Games.
     * This method will be called once at the beginning of the simulation.
     * It selects tributes to die in the initial chaos.
     */
    public static void simulateBloodBath(){
        System.out.println("Day 1: The Bloodbath.");
        //pick a random % of the tributes to die
        int numKills = (int) ((Math.random() * numTributes));
        System.out.println(numKills);

        if ( numKills == 0 ){
            numKills = (int) ((Math.random() * numTributes));
            System.out.println(numKills);
            System.out.println(Math.random() * numTributes);
        }

        //make sure it is correctly passed to the createPairs method
        if(numKills % 2 == 0){
            System.out.println(numKills);
            createPairs(numKills);
        } else {
            System.out.println(numKills);
            createPairs(numKills + 1);
        }

    }

    /**
     * Simulate a day in the hunger games
     * Uses random events to determine if tributes die, recieve items, or kill others.
     * This method will be called repeatedly until only one tribute remains.
     * PvE will be sent back to the player to decide what to do with the items.
     */
    public static void simulateDay() {
        //order:
        //events
        //sponsors
        //scavenge
        //combat
        //announce deaths
        //update variables
        //check for winner
        //if no winner, repeat

        }

    /** 
     * Simulate a turn in combat
     * This method will be called when two tributes are in combat.
     */
    public static void combatTurn(){
        //pokemon style combat
        //each combat turn, players choice(s) will be given a score, out of two options
        //items are greater than not having items/weapons
        //the tribute with the highest score of the engagement will be the victor
    }

    /** Simulate combat between two tributes
    *   Returns true if the attacker wins, false if the defender wins
    *   @param attackerIndex The index of the attacking tribute in the tributes list
    *   @param defenderIndex The index of the defending tribute in the tributes list
    *   @return boolean indicating the outcome of the combat
    */
    public static boolean aiCombat(int attackerIndex, int defenderIndex) {

        return true;
    }


    /**
     *  
     */
    public static void createPairs(int numKills){
        System.out.println("Creating Pairings...");
        System.out.println(numKills);
        System.out.println(Pairs.size());
        while(Pairs.size() < numKills){
            int tribute1 = (int) (Math.random() * numTributes);
            int tribute2 = (int) (Math.random() * numTributes);
            System.out.println("test5");
            //ensure that the tributes are not the same and that they are not already paired
            if(tribute1 == tribute2){                
                tribute2++;
            }
            //Pairs.add(tributes.get(tribute1));
            //Pairs.add(tributes.get(tribute2));
        }

    }
   }   