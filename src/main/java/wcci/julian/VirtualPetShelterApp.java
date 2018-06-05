package wcci.julian;

import java.util.Scanner;

public class VirtualPetShelterApp
{
	private static VirtualPetShelter vps = new VirtualPetShelter();
	private static boolean isOnShift = true;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		VirtualPet pet1 = new VirtualPet("Jojo", "Jojo's Bizarre Adventure", 75, 75, 75);
		VirtualPet pet2 = new VirtualPet("Vash", "Trigun", 90, 90, 90);
		VirtualPet pet3 = new VirtualPet("Nails", "A band?", 66, 66, 66);
		VirtualPet pet4 = new VirtualPet("Blue", "Lugato from Trigun", 70, 70, 70);

		vps.addPet(pet1);
		vps.addPet(pet2);
		vps.addPet(pet3);
		vps.addPet(pet4);

		System.out.println("Thank you for volunteering at Big Al's Virtual Pet Shelter and Delicatessen!");

		printAllPetsInShelter(vps);

		//printListOfActions();
		String userMenuChoice = "";
//		isValidMenuChoice(userMenuChoice);

		do
		{
			gameLoop(input, userMenuChoice);
			while (!isValidMenuChoice(userMenuChoice))
			{
				System.out.println("That is not correct, please try again.");
				userMenuChoice = input.nextLine();
			}
		} while (isValidMenuChoice(userMenuChoice));

	}

	private static void printListOfActions()
	{
		System.out.println("\nWhat would you like to do next?");

		System.out.println("1. Feed the pets\n" + "2. Play with all the pets\n" + "3. Play with a specific pet\n"
				+ "4. Adopt a pet\n" + "5. Admit a pet\n" + "6. Quit");
	}

	private static boolean isValidMenuChoice(String userMenuChoice)
	{
		if (!userMenuChoice.equals("1") && !userMenuChoice.equals("2") && !userMenuChoice.equals("3")
				&& !userMenuChoice.equals("4") && !userMenuChoice.equals("5") && !userMenuChoice.equals("6"))
		{
			return false;
		}

		return true;
	}

	private static void printAllPetsInShelter(VirtualPetShelter vps)
	{
		for (VirtualPet pet : vps.getPets())
		{
			System.out.println(pet.getName() + "\t" + pet.getHunger() + "\t" + pet.getFun() + "\t" + pet.getEnergy());
		}
	}

	private static void printAllPetsAndDescriptions(VirtualPetShelter vps)
	{
		for (VirtualPet pet : vps.getPets())
		{
			System.out.println("[" + pet.getName() + "]\t" + pet.getDesc());
		}
	}

	private static Boolean gameLoop(Scanner input, String userMenuChoice)
	{
		isOnShift = true;

		while (isOnShift)
		{
			printListOfActions();
			userMenuChoice = input.nextLine();
			switch (userMenuChoice)
			{
				case "0":
					printAllPetsInShelter(vps);
					break;
				case "1":
					vps.feedAll();
					vps.tick(1);
					System.out.println("\nYou feed all the pets! They are very happy! ^_^");
					break;
				case "2":
					vps.playWithAll();
					vps.tick(2);
					System.out.println("\nYou play with all the pets! They seem very tired...");
					break;
				case "3":
					System.out.println("\nWhich pet would you like to interact with?");
					printAllPetsAndDescriptions(vps);
					String petToInteractWith = input.nextLine();
					// error is thrown if pet to interact with is entered in lowercase
					// will fix at some point
					vps.returnSpecificPet(petToInteractWith).play();
					System.out.println("You played with " + vps.returnSpecificPet(petToInteractWith).getName() + "!");
					break;
				case "4":
					System.out.println("\nWhich pet would you like to adopt?");
					String petToAdopt = input.nextLine();
					vps.adoptPet(vps.returnSpecificPet(petToAdopt));
					vps.tick(4);
					break;
				case "5":
					System.out.println("That poor thing! What would you like to name it?");
					String petToAdmit = input.nextLine();
					System.out.println("And what about a description?");
					String petToAdmitsDesc = input.nextLine();
					vps.tick(5);
					System.out.println(
							"Let's make sure " + petToAdmit + " has a cozy time here until he goes to a loving home.");
					vps.addPet(new VirtualPet(petToAdmit, petToAdmitsDesc));
					System.out.println("[" + petToAdmit + "] " + petToAdmitsDesc + " has joined the shelter crew!");
					vps.tick(5);
					break;
				case "6":
					System.out.println("Shift is over. See you tomorrow!");
					isOnShift = false;
					System.exit(0);
					break;
				default:
					System.out.println("I'm sorry, what did you want to do again?");
					printListOfActions();
					gameLoop(input, userMenuChoice);
					break;
			}
		}
		return isOnShift;
	}
}
