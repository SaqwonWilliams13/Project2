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
	
	public void setPlayer1(String name)
	{
		player1 = new Character(name);	
	}
	
	public void setPlayer1Weapon(String name, double damage)
	{
		player1.setWeapon(name, damage);
	}
	
	public void setPlayer2(String name)
	{
		player2.setName(name);
	}
	
	public void setPlayer2Weapon(String name, double damage)
	{
		player2.setWeapon(name, damage);
	}
	
	public Character getPlayer1()
	{
		return player1;
	}
	
	public Character getPlayer2()
	{
		return player2;
	}
	
	public String getPlayer1Name()
	{
		return player1.getName();
	}
	
	public String getPlayer2Name()
	{
		return player2.getName();
	}
		
	public void setPlayer1(Character character)
	{
		player1 = character;
	}
	
	public void setPlayer2(Character character)
	{
		player2 = character;
	}
	
	public double getPlayer1Damage()
	{
		return player1.getWeaponDamage(player1.getWeapon());
	}
	
	public double getPlayer2Health()
	{
		return player2.getHealth();
	}

	public double getPlayer1Health()
	{
		return player1.getHealth();
	}
	
	public String getPlayer1Weapon()
	{
		return player1.getWeapon().getNameOfWeapon();
	}
	
	public void resetGame()
	{
		player1.setHealth(100);
		player2.setHealth(100);
		
	}

}




 