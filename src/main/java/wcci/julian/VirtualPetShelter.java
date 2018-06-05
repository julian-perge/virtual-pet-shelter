package wcci.julian;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter
{
	Map<String, VirtualPet> pets = new HashMap<>();

	public Collection<VirtualPet> getPets()
	{
		return pets.values();
	}

	public VirtualPet returnSpecificPet(String petToGet)
	{
		return pets.get(petToGet);
	}

	public void addPet(VirtualPet pet)
	{
		pets.put(pet.getName(), pet);
	}

	public void adoptPet(VirtualPet pet)
	{
		pets.remove(pet.getName(), pet);
	}

	public void feedAll()
	{
		for (VirtualPet pet : getPets())
		{
			pet.feed();
		}
	}

	public void playWithAll()
	{
		for (VirtualPet pet : getPets())
		{
			pet.play();
		}
	}

	public void tick(int test)
	{
		switch (test)
		{
			// is fed
			case 1:
				for (VirtualPet pet : getPets())
				{
					pet.setFun(pet.getFun() - 5);
				}
				break;
			// is played with
			case 2:
				for (VirtualPet pet : getPets())
				{
					pet.setHunger(pet.getHunger() - 5);
					pet.setEnergy(pet.getEnergy() - 5);
				}
				break;
			// adoption and others
			case 0:
			case 4:
			case 5:
				for (VirtualPet pet : getPets())
				{
					pet.setHunger(pet.getHunger() - 1);
					pet.setEnergy(pet.getEnergy() - 1);
					pet.setFun(pet.getFun() - 1);
				}
				break;
			// admit
			case 6:
				System.exit(0);
				break;
			default:
				break;
		}
	}
}
