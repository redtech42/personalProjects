package characterProperties;

abstract public class Character {
	private int HP;
	private double[] subjectStrengths = new double[4];
	private Attack[] attacks = new Attack[3];
	private String name;
	
	public Character(int HP, double[] strengths,
					 Attack[] attacks, String name) {
		this.HP = HP;
		this.subjectStrengths = strengths;
		this.attacks = attacks;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHP() {
		return this.HP;
	}
	
	public Attack getAttack(int index) {
		return this.attacks[index];
	}
	
	public double getStrength(int index) {
		//0 is math
		//1 is Japanese
		//2 is geography
		//3 is science
		return this.subjectStrengths[index];
	}
	
	
}
