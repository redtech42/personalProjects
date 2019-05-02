package gameEngine;

import java.util.ArrayList;
import java.util.Scanner;

import characterProperties.Attack;
import characterProperties.Player;
import library.AttackLibrary;
import library.CharacterLibrary;

public class Game {

	public static void main(String[] args) {
		AttackLibrary.defineAttackList();
		startGame();
	}
	
	public static String userInput() {
		Scanner scan = new Scanner(System.in);
		String output = scan.nextLine();
		scan.close();
		return output;
	}
	public static int userInputInt() {
		Scanner scan = new Scanner(System.in);
		int output = scan.nextInt();
		scan.close();
		return output;
	}

	public static void startGame() {
		dialoguePrint("Hello, and welcome to Fumizuki Academy. I'm the homeroom teacher of Class 2-F.",
				"Fukuhara-sensei");
		// waits for player to press enter before continuing
		userInput();
		dialoguePrint(
				"Here, there are battles fought with avatars called Shoukanjuu, that decide the allocation of class materials. Class A has luxury, and we...don't.",
				"Fukuhara-sensei");
		// waits for player to press enter before continuing
		userInput();
		dialoguePrint(
				"We can challenge Class A for their materials through the Summoner Test War though, using our most recent test scores",
				"Fukuhara-sensei");
		// waits for player to press enter before continuing
		userInput();
		dialoguePrint(
				"Thing is, the classes were also decided by an entrance exam, which means they're almost guaranteed to beat us.",
				"Fukuhara-sensei");
		// waits for player to press enter before continuing
		userInput();
		dialoguePrint("A much more attainable goal is Class E though, just one letter grade up.", "Fukuhara-sensei");
		// waits for player to press enter before continuing
		userInput();
		dialoguePrint(
				"In fact, we're about to start that battle now. Considering your higher entrance exam scores, you're going to be leading a team of 3 as a strike force",
				"Fukuhara-sensei");
		// waits for player to press enter before continuing
		userInput();
		dialoguePrint(
				"Kouta Tsuchiya, who was in charge of intel, hasn't come back yet, so we don't know what's out there, you'll be going in blind. ",
				"Fukuhara-sensei");
		// waits for player to press enter before continuing
		userInput();
		dialoguePrint(
				"Now, unfortunately you weren't able to take a qualifying test, so I'm going to have to break protocol and make you a Shoukanjuu to fight with",
				"Fukuhara-sensei");
		// waits for player to press enter before continuing
		userInput();
		createCharacter();
	}

	public static void createCharacter() {
		String name;
		int mathConfidence, japaneseConfidence, geographyConfidence, scienceConfidence;
		int HP = 100;

		dialoguePrint("First of all, what's your name?", "Fukuhara-sensei");
		name = userInput();

		dialoguePrint("Alright, so " + name
				+ " is your name. I'm going to ask you how comfortable you are in 4 topics for your 'test scores', alright? Keep in mind, "
				+ "the total of these four questions can't be above 30, you wouldn't be in Class F if you could manage that. ",
				"Fukuhara-sensei");
		userInput();

		dialoguePrint("On a scale of 1 to 10, how comfortable are you in math?", "Fukuhara-sensei");
		mathConfidence = userInputInt();
		dialoguePrint("On a scale of 1 to 10, how comfortable are you in Japanese?", "Fukuhara-sensei");
		japaneseConfidence = userInputInt();
		dialoguePrint("On a scale of 1 to 10, how comfortable are you in geography? ", "Fukuhara-sensei");
		geographyConfidence = userInputInt();
		dialoguePrint("On a scale of 1 to 10, how comfortable are you in science?", "Fukuhara-sensei");
		scienceConfidence = userInputInt();
		if ((mathConfidence + japaneseConfidence + geographyConfidence + scienceConfidence) >= 30 || mathConfidence < 0
				|| japaneseConfidence < 0 || geographyConfidence < 0 || scienceConfidence < 0) {

			while (mathConfidence + japaneseConfidence + geographyConfidence + scienceConfidence >= 30
					|| mathConfidence <= 0 || japaneseConfidence <= 0 || geographyConfidence <= 0
					|| scienceConfidence <= 0) {
				dialoguePrint("Looks like you didn't follow directions. I'll ask again.", "Fukuhara-sensei");
				dialoguePrint("On a scale of 1 to 10, how comfortable are you in math?", "Fukuhara-sensei");
				mathConfidence = userInputInt();
				dialoguePrint("On a scale of 1 to 10, how comfortable are you in Japanese?", "Fukuhara-sensei");
				japaneseConfidence = userInputInt();
				dialoguePrint("On a scale of 1 to 10, how comfortable are you in geography? ", "Fukuhara-sensei");
				geographyConfidence = userInputInt();
				dialoguePrint("On a scale of 1 to 10, how comfortable are you in science?", "Fukuhara-sensei");
				scienceConfidence = userInputInt();
			}
		}
		double[] scores = { mathConfidence / 5.0, japaneseConfidence / 5.0, geographyConfidence / 5.0,
				scienceConfidence / 5.0 };

		dialoguePrint(
				"Okay, so your attacks in a Math classroom will be " + scores[0] + " times stronger, "
						+ "attacks in a Japanese classroom will be " + scores[1] + " times stronger, "
						+ "attacks in a Geography classroom will be " + scores[2] + " times stronger, "
						+ "and attacks in a Science classroom will be " + scores[3] + " times stronger.",
				"Fukuhara-sensei");
		userInput();

		dialoguePrint("On the topic of attacks, here's a booklet with all the attacks. ", "Fukuhara-sensei");
		System.out.println("You picked up the booklet.");
		userInput();

		dialoguePrint("Choose three attacks from that booklet by entering the names in the console. ",
				"Fukuhara-sensei");
		userInput();
		
		int attackIndex = 0;
		Attack[] attackList = new Attack[3];
		Attack thisAttack;
		while (attackIndex < 3) {
			dialoguePrint("What will attack number " + (attackIndex + 1) + " be? ", "Fukuhara-sensei");
			
			//this is an attempt to get the user to use the attack name...it doesn't work yet.
			//thisAttack = AttackLibrary.getAttack(userInput());
			
			System.out.print("Enter the attack code that's in the booklet");
			thisAttack = AttackLibrary.getAttack(userInputInt());

			if (thisAttack.getName().equals("invalid")) {
				dialoguePrint("That isn't an attack.", "Fukuhara-sensei");

			} else {
				attackList[attackIndex] = thisAttack;
				attackIndex++;
			}
		}

		dialoguePrint("Your three attacks are: " + "%n" + attackList[0] + "%n" + attackList[1] + "%n" + attackList[2],
				"Fukuhara-sensei");
		userInput();
		
		dialoguePrint("You'll also have an inventory to store useful stuff you find along the way, but for now, it's empty", 
				"Fukuhara-sensei");
		ArrayList<String> inventory = new ArrayList<String>();
		
		Player protagonist = new Player(HP, scores, attackList, name, inventory);
		
	}
	
	
	// TODO create game libraries

	public static void dialoguePrint(String input, String character) {
		// prints out the name of the character saying the dialogue
		System.out.println(character + ":");

		// prints out the words letter per letter with a 16ms delay between each
		for (int i = 0; i < input.length(); i++) {
			System.out.print(input.charAt(i));
			if ((i + 1) % 60 == 0) {
				i++;
				while (i < input.length() && input.charAt(i) != ' ') {
					System.out.print(input.charAt(i));
					i++;
				}
				System.out.println();
			}
			try {
				Thread.sleep(16);
			}

			catch (InterruptedException ie) {
				for (int j = i; j < input.length(); j++) {
					System.out.print(input.charAt(j));
					if ((j + 1) % 60 == 0) {
						i++;
						while (input.charAt(j) != ' ' && j < input.length()) {
							System.out.print(input.charAt(i));
							j++;
						}
						System.out.println();
					}
				}
			}

		}
		// ends the dialogue
		System.out.println();
		System.out.println("...");

	}

}
