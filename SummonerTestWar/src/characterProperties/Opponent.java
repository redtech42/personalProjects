package characterProperties;

public class Opponent extends Character {

	public String weakness;
	public Opponent(int HP, double[] strengths, Attack[] attacks, String name, String weakness) {
		super(HP, strengths, attacks, name);
		this.weakness = weakness;
	}

	
}
