package adv;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {

		System.out.println("Welcome to the Adventure Game!");
		System.out.print("Before start the game enter your username: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectChar();
	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("=================================");
			System.out.println();
			System.out.println("Select a location to perform the action!");
			System.out.println("1. Safe House --> A safe place of your own, no enemies.");
			System.out.println("2. Cave --> Maybe there are some zombies!");
			System.out.println("3. Forest --> Maybe there are some vampires!");
			System.out.println("4. River --> Maybe there are some bears!");
			System.out.println("5. Shop --> You can buy weapon or armor!");
			System.out.print("Your choice : ");
			int selectLoc = scan.nextInt();
			while (selectLoc < 1 || selectLoc > 5) {
				System.out.println("Enter a number between 1-5!");
				System.out.print("Your choice : ");
				selectLoc = scan.nextInt();
			}

			switch (selectLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}

			if (location.getName() == "Safe House") {
				if (player.getInventory().isFirewood() && player.getInventory().isFood()
						&& player.getInventory().isWater()) {
					System.out.println("Congratulations! You finish the game succesfully!");
					break;
				}
			}

			if (!location.getLocation()) {
				System.out.println("GAME OVER!");
				break;
			}

		}
	}
}
