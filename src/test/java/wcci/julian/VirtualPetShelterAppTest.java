package wcci.julian;
import java.util.Scanner;

public class VirtualPetShelterAppTest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		VirtualPetShelter vps = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Jojo", "Jojo's Bizarre Adventure", 75, 75, 75);
		VirtualPet pet2 = new VirtualPet("Vash", "Trigun", 90, 90, 90);
		VirtualPet pet3 = new VirtualPet("Nails", "A band?", 66, 66, 66);
		VirtualPet pet4 = new VirtualPet("Blue", "Lugato from Trigun", 70, 70, 70);
		
		vps.addPet(pet1);
		vps.addPet(pet2);
		vps.addPet(pet3);
		vps.addPet(pet4);
		
		System.out.println("Thank you for volunteering at Big Al's Virtual Pet Shelter and Delicatessen!");
		
		for (VirtualPet pet : vps.getPets())
		{
			System.out.println(pet.getName() + "\t" + pet.getHunger() + "\t" + pet.getFun() + "\t" + pet.getEnergy());
		}
		
		System.out.println("What would you like to do next?");
		
		System.out.println("1. Feed the pets"
				+ "2. Play with all the pets"
				+ "3. Play with a specific pet"
				+ "4. Adopt a pet"
				+ "5. Admit a pet"
				+ "6. Quit");
		
		String userMenuChoice = input.nextLine();
		
		switch (userMenuChoice)
		{
			case "1":
				System.out.println("You feed all the pets! They are very happy! ^_^");
				break;
			case "2":
				System.out.println("You play with all the pets! They seem very tired...");
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				System.out.println("Quitting");
				break;

			default:
				break;
		}
	}
}
