package wcci.julian;

public class VirtualPet
{
	public VirtualPet(String name, String desc, int hunger, int fun, int energy)
	{
		this.name = name;
		this.desc = desc;
		this.hunger = hunger;
		this.fun = fun;
		this.energy = energy;
	}

	public void setHunger(int hunger)
	{
		this.hunger = hunger;
	}

	public void setFun(int fun)
	{
		this.fun = fun;
	}

	public void setEnergy(int energy)
	{
		this.energy = energy;
	}

	public VirtualPet(String name, String desc)
	{
		this.name = name;
		this.desc = desc;
	}

	public String getName()
	{
		return name;
	}

	public String getDesc()
	{
		return desc;
	}

	public int getHunger()
	{
		return hunger;
	}

	public int getFun()
	{
		return fun;
	}

	public int getEnergy()
	{
		return energy;
	}
	
	public void feed()
	{
		this.hunger += 20;
	}
	
	public void play()
	{
		this.fun += 20;
		this.energy -= 20;
	}

	private String name = "";
	private String desc = "";
	private int hunger = 50;
	private int fun = 50;
	private int energy = 50;

}
