import java.util.Scanner;
import java.util.Random;

public class MainstreamRPG 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner (System.in); 
		Random rand = new Random();
		
		//Monster variables
		String [] monsters = {
				"Hip-Hop Music",
				"Fast Food",
				"A Gas Guzzling Car",
				"A Pair of Contact Lenses",
				"A Real Bed",
				"A Digital Camera",
				"Shampoo",
				"A Band's New Album",
				"Seth Rogen",
				"Brand Name Clothing"};
			
		int monsterAttackDamage = 25; //max damage a monster can do
		int maxMonsterHealth = 100; //max health a monster can have
		
		//Player variables
		int playerHealth = 125; //health the player starts with
		int playerAttackDamage = 50; //max damage player can do
		int numGreenSmoothies = 3; //health boosters that player starts with
		int greenSmoothieHealAmount = 50; //amount that smoothies heal for
		int greenSmoothieDropChance = 25; //percentage that smoothie will be dropped
		int monstersDefeated=0; //counter for number of monsters player has already defeated
		
		String [] attacks = {
				"flashing your Cochella tickets",
				"throwing kale",
				"unleashing your beard", 
				"throwing Sperrys",
				"throwing your beanie",
				"throwing hot coffee",
				"throwing hot herbal tea",
				"using your mad yoga skills",
				"throwing your typewriter",
				"swinging around your flower crown",
				"using your flannel as a whip",
				"throwing your succulents",
				"throwing your Doc Martins",
				"throwing your fixie bike",
				"throwing your vinyl collection",
				"calling in your barista friend to help fight",
				"calling in your favroite band, Arcade Fire, for back up",};
		
		boolean running = true;
		
		//Prints welcome statement
		System.out.println("Hello, Hipster! Welcome to the World!");
		System.out.println("\nA wonderful place where non-hipsters and hipsters live in harmony...");
		System.out.println("But everything changed when the Mainstream Monsters attacked!");
		System.out.println("\nThese Mainstream Monsters' goal is to get rid of all the hipsters by reducing their 'Hipster Points' to zero.");
		System.out.println("If a hipster loses all their Hipster Points, they will become every hipster's worst nightmare: MAINSTREAM!");
		System.out.println("\nIt is your duty to fight back!");
		System.out.println("So grab your birkenstocks & iPod full of indie music and prepare to fight.");
		System.out.println("\nGoodluck!");
		
		GAME:
		while (running)
		{
			System.out.println("----------------------------------------------------------------------------------------");
			
			int monsterHealth = rand.nextInt(maxMonsterHealth); //assigns monster a random health value
			String monster = monsters[rand.nextInt(monsters.length)]; //picks a random monster from list
			System.out.println("\t~ " +monster+ " has appeared! ~\n");
			
			
			while(monsterHealth > 0)
			{
				String attack = attacks[rand.nextInt(attacks.length)]; //picks a random attack method
				System.out.println("\tYour Hipster Points (HP): "+ playerHealth);
				System.out.println("\t"+monster+"'s Health: "+ monsterHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack "+monster+" by "+attack);
				System.out.println("\t2. Drink Green Smoothie to restore Hipster Points.You have "+numGreenSmoothies+" left.");
				System.out.println("\t3. Run to the nearest thrift shop to hide");
				
				int choice1 = scan.nextInt();
				
				if(choice1==1)
				{
					int damageDealt = rand.nextInt(playerAttackDamage); //assigns random amount of damage to be dealt
					int damageTaken = rand.nextInt(monsterAttackDamage); //assigns random amount of damage to be dealt
					
					monsterHealth -= damageDealt; //subtracts damage from existing health
					playerHealth -= damageTaken; //sbtracts damage from existing health
					
					System.out.println("\t> You attack "+ monster+" for "+damageDealt+ " damage.");
					System.out.println("\t> You receive a loss of "+damageTaken+" Hipster Points in retaliation.");
					
					//If player loses all health, prints statement and breaks out of loop
					if (playerHealth <= 0)
					{
						System.out.println("\t> You have lost all of your Hipster Points.");
						break;
					}
				}
				else if (choice1==2)
				{
					//If player has smoothies left, allows player to drink smoothie
					if (numGreenSmoothies > 0)
					{
						playerHealth += greenSmoothieHealAmount; //heals player
						numGreenSmoothies--; //decrements number of smoothies
						System.out.println("\t> You drink a Green Smoothie and gain " +greenSmoothieHealAmount+ " Hipster Points.");
						System.out.println("\t> You now have " + playerHealth + " Hipster Points.");
						System.out.println("\t> You have "+numGreenSmoothies+" Green Smoothies left.");
					}
					else
					{
						System.out.println("\t> You ran out of kale and have no more Green Smothies left! Defeat the Mainstream Monsters for a chance to get more!");
					}
				}
				else if (choice1==3)
				{
					//If player chooses to run, loop starts over and new monster appears
					System.out.println("\t> You run to a thrift shop to hide from "+monster+ ".");
					continue GAME;
				}
				else
				{
					System.out.println("\tInvalid Command"); //validates input
				}
			}
			
			//Print losing statement if player loses all health
			if(playerHealth<=0)
			{
				System.out.println("You walk away from battle listening to the radio, wearing brand name clothes.");
				System.out.println("You trade in your bike for a Hummer, and your polaroid for a new Cannon digital camera.");
				System.out.println("You wash your hair and now have the sudden urge to sleep in a real bed rather than your hammock.");
				System.out.println("You trade in your glasses for a pair of contact lenses, and Seth Rogen is now your new best friend.");
				System.out.println("You have become your worst nightmare...MAINSTREAM.");
				break;
			}
			
			//Statement that prints after a monster is defeated
			System.out.println("----------------------------------------------------------------------------------------");
			monstersDefeated++; //increments number of monsters defeated
			System.out.println("~ " +monster+ " was defeated! ~");
			System.out.println("~ You have " +playerHealth+ " Hipster Points left. ~");
			
			//Based on greenSmoothieDropChance, randomly drops smoothie
			if(rand.nextInt(100) < greenSmoothieDropChance)
			{
				numGreenSmoothies++;
				System.out.println("~ The " +monster+ " dropped some kale for more Green Smoothies! ~");
				System.out.println("~ You now have " +numGreenSmoothies+ " Green Smoothie(s). ~");
			}
			
			//Asks user if they would like to keep playing
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("So far you have defeated "+monstersDefeated+" Mainstream Monster(s)!");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Recognize that peace is the way to go and head to your favorite coffee shop for a nice latte");
			
			int choice2 = scan.nextInt();
			
			//Validates input
			while (choice2!=1 && choice2!=2)
			{
				System.out.println("Invalid command");
				choice2 = scan.nextInt();
			}
			
			if (choice2==1)
			{
				System.out.println("You continue fighting the Mainstream Monsters!");
			}
			
			//If user chooses not to continue, breaks out of loop
			else if (choice2==2)
			{
				System.out.println("You leave the fight scene and reward your valiant fighting with a nice cup of coffee.");
				break;
			}
			
		}		
		
		//Prints end statement
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~ You defeated a total of " +monstersDefeated+ " Mainstream Monsters ~");
		System.out.println("~ Thanks for playing! ~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
