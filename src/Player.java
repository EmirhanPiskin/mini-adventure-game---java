package adv;

import java.util.Scanner;

public class Player {
	Scanner scan = new Scanner(System.in);
	private int damage, health, money, rhealth;
	private String userName, charName;
	private Inventory inventory;

	public Player(String name) {
		this.inventory = new Inventory();
	}

	public void selectChar() {
		switch (charMenu()) {

		case 1:
			initPlayer("Samurai", 5, 21, 15);
			break;
		case 2:
			initPlayer("Archer", 7, 18, 20);
			break;
		case 3:
			initPlayer("Swordman", 8, 24, 5);
			break;
		default:
			initPlayer("Samurai", 5, 21, 15);
			break;
		}
		System.out.println("\nYour character : " + getCharName() + "\nDamage : " + getDamage() + "\nHealth : "
				+ getHealth() + "\nMoney : " + getMoney());
	}

	public int charMenu() {
		System.out.println("------------------     CHARACTER LIST     ------------------");
		System.out.println("1- Samurai \t Damage : 5 \t Health : 21 \t Money : 15");
		System.out.println("2- Archer \t Damage : 7 \t Health : 18 \t Money : 20");
		System.out.println("3- Swordman \t Damage : 8 \t Health : 24 \t Money : 5");
		System.out.print("Please choose a character : ");
		int charID = scan.nextInt();

		while (charID < 1 || charID > 3) {
			System.out.println("Enter a number between 1-3!");
			System.out.print("Please choose a character : ");
			charID = scan.nextInt();
		}
		return charID;
	}
	
	public int getTotalDamage() {
		return this.getDamage() + this.getInventory().getDamage();
	}
	
	public void initPlayer(String charName, int dmg, int heal, int money) {
		setCharName(charName);
		setDamage(dmg);
		setHealth(heal);
		setMoney(money);
		setRhealth(heal);
	}

	// GETTER & SETTER SECTION

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getRhealth() {
		return rhealth;
	}

	public void setRhealth(int rhealth) {
		this.rhealth = rhealth;
	}

}