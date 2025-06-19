/**
* @author Eli
* @version 1.0
* @date 2025-6-18
* A program to simulate the hunger games.
*/
import java.util.ArrayList;
import java.util.Scanner;
//goon
public class HungerGames {
    // Constants
    public static ArrayList<String> tributes = new ArrayList<>();
    public static ArrayList<String> players = new ArrayList<>();
    public static String[] items = {"Sword", "Shield", "Bow", "Arrow", "Food", "Water"};
    public static String[] deaths = {"drowned", "stabbed", "shot", "poisoned", "burned", "crushed"};
    public static ArrayList<String> kills = new ArrayList<>();
    public static int numTributes = 0;
    public static int day = 1;

    /**
     * Main method to run the Hunger Games simulation.
     * It prompts the user for the number of tributes and their names,
     * then simulates the games until only one tribute remains.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of tributes: ");
        numTributes = input.nextInt();
        
        //cycle through the number of tributes and get their names
        for(int i = 0; i < numTributes; i++) {
            System.out.print("Enter the name of tribute " + (i + 1) + ": ");
            String name = input.next();
            tributes.add(name);
        }
        System.out.println("Tributes: " + tributes);
        
        //simulate days until only one tribute remains
        while(numTributes > 1){
            simulateDay();

        }

        //print winner information
        System.out.println("The winner is: " + tributes.get(0) + "! congratulations!");
        System.out.println(tributes.get(0) + " got " + kills.get(0) + " kills.");

        
        input.close();
    }

    /**
     * Simulate a day in the hunger games
     * Uses random events to determine if tributes die, recieve items, or kill others.
     * This method will be called repeatedly until only one tribute remains.
     * PvE will be sent back to the player to decide what to do with the items.
     */
    public static void simulateDay() {


    }

    /** 
     * Simulate a turn in combat
     * This method will be called when two tributes are in combat.
     */
    public static void combatTurn(){


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



}