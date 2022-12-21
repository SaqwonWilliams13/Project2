
public class Character
{
	private String name;
	private double health;
	private Weapon weapon;
	
	/**
	 * Constructor 
	 */
	public Character()
	{
		name = "McLovin";
		health = 100;
		weapon = new Weapon("ID Card", 15);
	}
	
	/**
	 * Constructor 
	 * 
	 * @param name Used to create an object with the User's name
	 */
	public Character(String name)
	{
		this.name = name;
		health = 100;
		weapon = new Weapon("Good Ol' Foot Sole", 15);
	}
	
	/** 
	 * @param Receiver  The character who will lose health
	 * @param Hitter    The character who's weapon's damage will be used
	 * 					against the receiver
	 */
	public void attack1(Character attacked, Character attacker) 
	{
		//potential error in fighting self
		if(attacked.getHealth() < 0)
		{
			//put something to end the game
			System.out.println("YOU WIN");
		}
		else if(attacked.getHealth() < attacker.getWeaponDamage(attacker.getWeapon()))
		{
			attacked.setHealth(-1);
			attacker.setHealth(100);
		}
		else
		{
			attacked.setHealth(attacked.getHealth() - attacker.getWeaponDamage(attacker.getWeapon()));
		}
		
	}
	
	/** 
	 * @param Receiver  The character who will lose health
	 * @param Hitter    The character who's weapon's damage will be used
	 * 					against the receiver
	 */
	public void attack2(Character attacked, Character attacker)
	{
		if(attacked.getHealth() < 0)
		{
			//put something to end the game
			System.out.println("YOU WIN");
		}
		else if(attacked.getHealth() < attacker.getWeaponDamage(attacker.getWeapon()))
		{
			attacked.setHealth(0);
			attacker.setHealth(100);
		}
		else
		{
			attacked.setHealth(attacked.getHealth() - 1.1 * attacker.getWeaponDamage(attacker.getWeapon()));
		}
	}
	
	/** 
	 * 	@purpose To retrieve the name of the Character.			
	 */
	public String getName()
	{
		return name;
	}
	
	/** 
	 * 	@purpose To set the name of the Character.			
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/** 
	 * 	@purpose To retrieve the health of the Character.			
	 */
	public double getHealth()
	{
		return health;
	}
	
	/** 
	 * 	@purpose To set the health of the Character.			
	 */
	public void setHealth(double health)
	{
		this.health = health;
	}
	
	/** 
	 * 	@purpose To retrieve the Weapon object of the Character.			
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}
	
	/** 
	 * @purpose To retrieve the damage field of
	 * the Weapon object of the Character, to be used for the attack methods
	 * @param weapon gets weapon's damage field		
	 */
	public double getWeaponDamage(Weapon weapon)
	{
		return weapon.getDamage();
	}
		
	/** 
	 * 	@purpose To set the Weapon object of the Character.			
	 */
	public String getWeaponName()
	{
		return weapon.getNameOfWeapon();
	}

}
