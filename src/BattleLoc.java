package adv;

public abstract class BattleLoc extends Location {

	protected Obstacle obstacle;
	protected String item;

	BattleLoc(Player player, String name, Obstacle obstacle, String item) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.item = item;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Now you are in the " + this.getName());
		System.out.println("Be careful! There are " + obsCount + " " + obstacle.getName() + " here!");
		System.out.println("<F>ight or <R>un");
		String selectCase = scan.next();
		selectCase = selectCase.toUpperCase();
		if (selectCase.equals("F")) {
			if (combat(obsCount)) {
				System.out.println("You killed all the enemies in " + this.getName() + " area.");
				if (this.item.equals("Food") && player.getInventory().isFood() == false) {
					System.out.println("You won " + this.item);
					player.getInventory().setFood(true);
				} else if (this.item.equals("Water") && player.getInventory().isWater() == false) {
					System.out.println("You won " + this.item);
					player.getInventory().setWater(true);
				} else if (this.item.equals("Firewood") && player.getInventory().isFirewood() == false) {
					System.out.println("You won " + this.item);
					player.getInventory().setFirewood(true);
				}
				return true;
			}
			if (player.getHealth() <= 0) {
				System.out.println("You dead!");
				return false;
			}
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
				System.out.println();
				System.out.print("<H>it or <R>un : ");
				String selectCase = scan.next();
				selectCase = selectCase.toUpperCase();
				if (selectCase.equals("H")) {
					System.out.println("You hit!");
					System.out.println("------------------");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println();
						System.out.println(obstacle.getName() + " hit!");
						System.out.println("------------------");
						if (player.getInventory().getArmor() > obstacle.getDamage()) {
							System.out.println("You did not take damage thanks to your armor!");
						} else {
							player.setHealth(
									player.getHealth() - (obstacle.getDamage() - player.getInventory().getArmor()));
							afterHit();
						}
					}
				} else {
					return false;
				}
			}

			if (obstacle.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println("You won!");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Your current money : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("------------------");
		}
		return true;
	}

	public void playerStats() {
		System.out.println("Player Stats\n-----------------");
		System.out.println("Health : " + player.getHealth());
		System.out.println("Damage : " + player.getTotalDamage());
		System.out.println("Money : " + player.getMoney());
		if (player.getInventory().getDamage() > 0) {
			System.out.println("Weapon : " + player.getInventory().getwName());
		}
		if (player.getInventory().getArmor() > 0) {
			System.out.println("Armor : " + player.getInventory().getaName());
		}
	}

	public void enemyStats() {
		System.out.println("\n" + obstacle.getName() + " Stats\n-----------------");
		System.out.println("Health : " + obstacle.getHealth());
		System.out.println("Damage : " + obstacle.getDamage());
		System.out.println("Award : " + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Player health : " + player.getHealth());
		System.out.println(obstacle.getName() + " health : " + obstacle.getHealth());
	}

}
