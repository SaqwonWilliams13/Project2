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
	
	public void setPlayer1(String name, String wName, double dmg)
	{
		
		player1 = new Character(name, wName, dmg);
	
		
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
	
	public String getPlayer1()
	{
		return player1.getName();
	}
	
	public String getPlayer2()
	{
		return player2.getName();
	}
	
	public String getPlayer1Weapon()
	{
		return player1.getWeaponName(player1.getWeapon());
	}
	
	public String getPlayer2Weapon()
	{
		return player2.getWeaponName(player2.getWeapon());
	}
	
	public void setPlayer1(Character character)
	{
		player1 = character;
	}
	
	public void setPlayer2(Character character)
	{
		player2 = character;
	}
	


}




 