package adv;

public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "Safe House");
	}
	
	public boolean getLocation() {
		player.setHealth(player.getRhealth());
		System.out.println("\nYour health is full!");
		System.out.println("You are in safe house now.");
		System.out.println(player.getInventory().isFood());
		System.out.println(player.getInventory().isFirewood());
		System.out.println(player.getInventory().isWater());
		return true;
	}
}
