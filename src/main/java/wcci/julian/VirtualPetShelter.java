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
}
