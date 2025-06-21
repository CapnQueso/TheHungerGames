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
    public static ArrayList<Tribute> tributes = new ArrayList<>();
    public static ArrayList<Integer> Pairs = new ArrayList<>();
    public static String[] items = {"Punch", "Sword", "Shield", "Bow", "Food", "Water"}; //make txt file
    public static String[] deaths = {"knocked out", "stabbed", "bashed", "shot", "poisoned", "drowned"};
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

            //logic to determine if the tribute is a bot or a player
            System.out.print("Is this tribute a human player? (yes/no): ");
            String isBot = input.next();
            boolean bot = isBot.substring(0,1).equalsIgnoreCase("n");
            
            Tribute tribute = new Tribute(name, bot, 0);
            tributes.add(tribute);

        }

        //print initial test information
        //System.out.println("Tributes: " + tributes);

        //intro
        System.out.println("Welcome to the Hunger Games!");
        System.out.println("There are " + numTributes + " tributes in the arena");
        System.out.println("May the odds be ever in your favor!");
        simulateBloodBath();

        

        //simulate days until only one tribute remains
        while(numTributes > 1){
            simulateDay();
        }

        //print winner information
        if(tributes.get(0).isBot() == false){
            System.out.println("The winner is player: " + tributes.get(0).getName() + "! congratulations!");
        } else {
            System.out.println("The winner is bot: " + tributes.get(0).getName() + "! awww man...");

        }
        System.out.println(tributes.get(0) + " got " + tributes.get(0).getKills() + " kills.");
        

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
        int numKills = (int) (Math.random() * numTributes) + 2;

        //make sure it is correctly passed to the createPairs method
        if(numKills % 2 == 0){
            createPairs(numKills);
        } else {
            createPairs(numKills + 1);
        }

        //turn one combat
        for(int i = 0; i < (Pairs.size() / 2); i++){
            int index1 = (int) (Math.random() * numTributes);
            int index2 = (int) (Math.random() * numTributes);
            //ensure that the tributes are not the same
            if(index1 == index2){
                index2++;
            }
            combatTurn(index1, index2);
        }

        //announce deaths
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
        //setup combat
        int numKills = (int) (Math.random() * numTributes);

        if(numKills % 2 == 0){
            createPairs(numKills);
        } else {
            createPairs(numKills + 1);
        }
        //combat
        //update variables
        //check for winner
        //if no winner, repeat

        }

    /** 
     * Simulate a turn in combat
     * This method will be called when two tributes are in combat.
     */
    public static void combatTurn(int index1, int index2) {
        Scanner console = new Scanner(System.in);
        System.out.println(tributes.get(index1).getName() + " vs " + tributes.get(index2).getName());

        int[] values1 = {(int)(Math.random()*10), (int)(Math.random()*50), (int)(Math.random()*30), (int)(Math.random()*40), (int)(Math.random()*20), (int)(Math.random()*20)};
        int[] values2 = {(int)(Math.random()*10), (int)(Math.random()*50), (int)(Math.random()*30), (int)(Math.random()*40), (int)(Math.random()*20), (int)(Math.random()*20)};

        int score1 = 0;
        int score2 = 0;

        int weaponIndex1 = -1;
        int weaponIndex2 = -1;

        //tribute 1 turn/choice
        if(tributes.get(index1).isBot() == false) {
            System.out.println(tributes.get(index1).getName() + "'s turn");
            System.out.println(tributes.get(index1).getName() + "'s items: ");
            System.out.println(tributes.get(index1).getItems());
            System.out.print(tributes.get(index1).getName() + ". Choose a weapon to use: ");
            String chosenWeapon1 = console.nextLine();

            for (int i = 0; i < items.length; i++) {
                if (items[i].equalsIgnoreCase(chosenWeapon1)) {
                    weaponIndex1 = i;
                    break;
                }
            }

            if (weaponIndex1 == -1) {
                System.out.println("Invalid weapon chosen. Defaulting to 'Punch'.");
                weaponIndex1 = 0;
            }
            score1 = values1[weaponIndex1];
        } else {
            weaponIndex1 = (int) (Math.random() * tributes.get(index1).getItems().size() - 1) + 1;
            score1 = values1[weaponIndex1];
            System.out.println(tributes.get(index1).getName() + "'s items: ");
            System.out.println(tributes.get(index1).getItems());
            System.out.println("Bot chose weapon: " + items[weaponIndex1]);
        } 
        

        //tribute 2 turn/choice
        if(tributes.get(index1).isBot() == false) {
            System.out.println(tributes.get(index2).getName() + "'s turn");
            System.out.println(tributes.get(index2).getName() + "'s items: ");
            System.out.println(tributes.get(index2).getItems());
            System.out.print(tributes.get(index2).getName() + ". Choose a weapon to use: ");
            String chosenWeapon2 = console.nextLine();

            for (int i = 0; i < items.length; i++) {
                if (items[i].equalsIgnoreCase(chosenWeapon2)) {
                    weaponIndex2 = i;
                    break;
                }
            }
            if (weaponIndex2 == -1) {
                System.out.println("Invalid weapon chosen. Defaulting to 'Punch'.");
                weaponIndex2 = 0;
            }
            score2 = values2[weaponIndex2];
        } else {
            weaponIndex2 = (int) (Math.random() * tributes.get(index2).getItems().size() - 1) + 1;
            score2 = values2[weaponIndex2];
            System.out.println(tributes.get(index2).getName() + "'s items: ");
            System.out.println(tributes.get(index2).getItems());
            System.out.println("Bot chose weapon: " + items[weaponIndex2]);
        } 


        if(score1 >= score2){
            System.out.println("DEATH: " + tributes.get(index1).getName() + " " + deaths[weaponIndex1] + " " + tributes.get(index2).getName());
            tributes.get(index1).addKills(1);
                
            //remove the tribute that died
            tributes.remove(index2);
            Pairs.remove(index2);
            numTributes--;
        } else if(score2 > score1){
            System.out.println("DEATH: " + tributes.get(index2).getName() + " " + deaths[weaponIndex2] + " " + tributes.get(index1).getName());
            tributes.get(index2).addKills(1);
                
            //remove the tribute that died
            tributes.remove(index1);
            Pairs.remove(index1);
            numTributes--;
        } else {
            System.out.println("mate i cant lie somthing happened");
        }

        console.close();
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
     *  Creates pairs of tributes for combat.
     *  This method will randomly select pairs of tributes to fight based on the number of kills.
     *  It ensures that no tribute is paired with themselves
     *  @param numKills the number of people fighting to divivde into pairs
     */
    public static void createPairs(int numKills){
        System.out.println("Creating Pairings...");

        while(Pairs.size() < numKills){
            int tribute1 = (int) (Math.random() * numTributes);
            int tribute2 = (int) (Math.random() * numTributes);
            //ensure that the tributes are not the same and that they are not already paired
            if(tribute1 == tribute2){                
                tribute2++;
            }
            Pairs.add(tribute1);
            Pairs.add(tribute2);
        }

    }
}   