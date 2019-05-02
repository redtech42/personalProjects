package library;

import characterProperties.Attack;

public class AttackLibrary {

	public static Attack[] attackList = new Attack[10];

	public static Attack invalid = new Attack("invalid", 0, 0, "This is not an attack, it's a code solution");

	public static Attack slash = new Attack("Slash", 15, 70, "Your Shoukanjuu draws a sword and slashes at the enemy.");

	public static Attack stab = new Attack("Stab", 100, 10, "Your Shoukanjuu draws a sword and stabs at the enemy. "
			+ "This is a one hit kill, assuming you can even hit them...");

	public static Attack sleepDeprivedRush = new Attack("Sleep Deprived Rush", 50, 60,
			"You didn't get enough sleep last night, "
					+ "your enemy is pissing you off, and you've just about had it. You rush your enemy, but not all of your attacks hit");

	public static Attack severePapercut = new Attack("Severe Papercut", 30, 90,
			"Pages from a textbook appear in the air, and slice the opponent.");

	public static Attack massiveBook = new Attack("Massive Book", 40, 70,
			"Your Shoukanjuu spawns a large textbook in its hand, and hits the opponent upside the head.");

	public static void defineAttackList() {
		attackList[0] = slash;
		attackList[1] = stab;
		attackList[2] = sleepDeprivedRush;
		attackList[3] = severePapercut;

		// TODO make attacks 4-8.
		attackList[4] = slash;
		attackList[5] = stab;
		attackList[6] = sleepDeprivedRush;
		attackList[7] = severePapercut;
		attackList[8] = slash;
		// TODO make attacks 4-8.
		
		attackList[9] = massiveBook;
	}

	public static Attack getAttack(String input) {
		for (Attack attack : attackList) {
			/*
			 * if(attack.name.length() == input.length()) { if(attack.name.substring(0,
			 * 2).equals(input.substring(0, 2))){ return attack; } }
			 */
			if (attack.getName().equalsIgnoreCase(input)) {
				return attack;
			}
		}
		return invalid;
	}

	public static Attack getAttack(int attackIndex) {
		if(attackIndex >= 0 && attackIndex < attackList.length) {
			return attackList[attackIndex];
		}
		return invalid;
	}
}