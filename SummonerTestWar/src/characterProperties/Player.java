package characterProperties;

import java.util.ArrayList;

import cartography.Location;

public class Player extends Character {

	public ArrayList<String> items;
	public Location position = new Location(1, 0, 0, true);

	public Player(int HP, double[] strengths, Attack[] attacks, String name, ArrayList<String> inventory) {
		super(HP, strengths, attacks, name);
		this.items = inventory;
		
	}

}
