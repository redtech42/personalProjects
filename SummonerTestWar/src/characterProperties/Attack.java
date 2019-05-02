package characterProperties;

public class Attack {
	private String name;
	private int damage;
	private int accuracy;
	private String description;

	public Attack(String name, int damage, int accuracy, String description) {
		this.name = name;
		this.damage = damage;
		this.accuracy = accuracy;
		this.description = description;
	}

	
	public String getName() {
		return this.name;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getAccuracy() {
		return this.accuracy;
	}

	public String getDescription() {
		return this.description;

	}
}
