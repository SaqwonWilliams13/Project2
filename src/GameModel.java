import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameModel extends Character
{
	private Character player1;
	private Character player2;
	
	
	/**
	 * 
	 * @param name instantiates the player1 Character with name and default weapon
	 */
	public void setPlayer1(String name)
	{
		player1 = new Character(name);	
	}
	
	/**
	 * 
	 * @param name instantiates the player2 Character with n
	 */
	public void setPlayer2(String name)
	{
		player2.setName(name);
	}
	
	/**
	 * 
	 * @purpose to retrieve the Character Object of player1
	 */
	public Character getPlayer1()
	{
		return player1;
	}
	
	/**
	 * 
	 * @purpose to retrieve the Character Object of player2
	 */
	public Character getPlayer2()
	{
		return player2;
	}
	
	/**
	 * 
	 * @purpose Gets the name either declared by the player or the 
	 * Character constructor
	 */
	public String getPlayer1Name()
	{
		return player1.getName();
	}
	
	/**
	 * 
	 * @purpose Gets the name either declared, or in the constructor
	 * 
	 */
	public String getPlayer2Name()
	{
		return player2.getName();
	}
		
	/**
	 * 
	 * @param character Takes in character to be used for player1
	 * 
	 */
	public void setPlayer1(Character character)
	{
		player1 = character;
	}
	
	/**
	 * 
	 * @param character Takes in character to be used for player2
	 * 
	 */
	public void setPlayer2(Character character)
	{
		player2 = character;
	}
	
	/**
	 * 
	 * @purpose retrieves the damage of player1's weapon, to be used for attacks
	 * 
	 */
	public double getPlayer1Damage()
	{
		return player1.getWeaponDamage(player1.getWeapon());
	}
	
	/**
	 * 
	 * @purpose retrieves the damage of player2's weapon, to be used for attacks
	 * 
	 */
	public double getPlayer2Damage()
	{
		return player2.getWeaponDamage(player2.getWeapon());
	}
	
	/**
	 * 
	 * @purpose retrieves the health of player2 for GUI display and game function
	 * 
	 */
	public double getPlayer2Health()
	{
		return player2.getHealth();
	}

	/**
	 * 
	 * @purpose retrieves the health of player2 for GUI display and game function
	 * 
	 */
	public double getPlayer1Health()
	{
		return player1.getHealth();
	}
	
	/**
	 * 
	 * @purpose retrieves the health of player2 for GUI display and game function
	 * 
	 */
	public String getPlayer1Weapon()
	{
		return player1.getWeapon().getNameOfWeapon();
	}
	
	public void resetGame()
	{
		player1.setHealth(100);
		player2.setHealth(100);
		
	}

	

	public void setPlayer1Name(String letters)
	{
		player1.setName(letters);
		
	}



}




 