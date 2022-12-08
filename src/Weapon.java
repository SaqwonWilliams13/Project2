
public class Weapon
{
	private String nameOfWeapon;
	private double damageOfWeapon;
	
	public Weapon()
	{
		setNameOfWeapon("Sword");
		damageOfWeapon = 15.0;
	}
	
	public Weapon(String weaponName, double damage)
	{
		setNameOfWeapon(weaponName);
		if(damage < 25 && damage > 0)
		{
			damageOfWeapon = damage;
		}
		else
		{
			damageOfWeapon = 20;
		}
	}
	public double getDamage()
	{
		return damageOfWeapon;
	}

	public String getNameOfWeapon()
	{
		return nameOfWeapon;
	}

	public void setNameOfWeapon(String nameOfWeapon)
	{
		this.nameOfWeapon = nameOfWeapon;
	}
}
