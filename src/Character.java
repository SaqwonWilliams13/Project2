
public class Character
{
	private String name;
	private double health;
	private Weapon weapon;
	
	
	public Character()
	{
		name = "McLovin";
		health = 100;
		weapon = new Weapon();
	}
	
	public Character(String name)
	{
		this.name = name;
		health = 100;
		weapon = new Weapon();
	}
	
	public Character(String name, String weaponName, double weaponDamage)
	{
		this.name = name;
		health = 100;
		weapon = new Weapon(weaponName ,weaponDamage);
	}

	public void attack1(Character attacked, Character attacker)
	{
		//potential error in fighting self
		if(attacked.getHealth() < 0)
		{
			//put something to end the game
			System.out.println("YOU WIN");
		}
		else
		{
			attacked.setHealth(attacked.getHealth() - attacker.getWeaponDamage(attacker.getWeapon()));
		}
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getHealth()
	{
		return health;
	}
	
	public void setHealth(double health)
	{
		this.health = health;
	}
	
	public Weapon getWeapon()
	{
		return weapon;
	}
	
	public double getWeaponDamage(Weapon weapon)
	{
		return weapon.getDamage();
	}
	
	public String getWeaponName(Weapon weapon)
	{
		return weapon.getNameOfWeapon();
	}
	
	public void setWeapon(String name, double damage)
	{
		weapon = new Weapon(name, damage);
	}


}
