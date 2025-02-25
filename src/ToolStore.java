package adv;

public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Tool Store");
	}

	public boolean getLocation() {
		System.out.println("Your money : " + player.getMoney());
		System.out.println("1- Weapons");
		System.out.println("2- Armors");
		System.out.println("3- Quit");
		System.out.println("Your choice : ");
		int selectTool = scan.nextInt();
		int selItemID;
		switch (selectTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}

		return true;
	}

	public int weaponMenu() {
		System.out.println("1- Pistol\t <Price : 25 - Damage : 2>");
		System.out.println("2- Sword\t <Price : 35 - Damage : 3>");
		System.out.println("3- Rifle\t <Price : 45 - Damage : 7>");
		System.out.println("4- Quit");
		System.out.println("Choose a weapon : ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}

	public int armorMenu() {
		System.out.println("1- Light\t <Price : 15 - Avoid : 1>");
		System.out.println("2- Mid \t\t <Price : 25 - Avoid : 3>");
		System.out.println("3- Heavy\t <Price : 40 - Avoid : 5>");
		System.out.println("4- Quit");
		System.out.println("Choose an armor : ");
		int selArmorID = scan.nextInt();
		return selArmorID;
	}

	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			wName = "Pistol";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Sword";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Rifle";
			price = 45;
			break;
		case 4:
			System.out.println("Quitting..");
			break;
		default:
			System.out.println("Invalid transaction!");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setDamage(damage);
				player.getInventory().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " you bought. Previous damage : " + player.getDamage() + ", New damage : "
						+ player.getTotalDamage());
				System.out.println("Your remaining money : " + player.getMoney());
			} else {
				System.out.println("Insufficient funds!");
			}
		}

	}

	public void buyArmor(int itemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "Light Armor";
			price = 15;
			break;
		case 2:
			avoid = 3;
			aName = "Mid Armor";
			price = 25;
			break;
		case 3:
			avoid = 5;
			aName = "Heavy Armor";
			price = 40;
			break;
		case 4:
			System.out.println("Quitting..");
			break;
		default:
			System.out.println("Invalid transaction!");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setArmor(avoid);
				player.getInventory().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " you bought. Damage avoided : " + player.getInventory().getArmor());
				System.out.println("Your remaining money : " + player.getMoney());
			} else {
				System.out.println("Insufficient funds!");
			}
		}

	}

}
