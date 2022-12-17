import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GameController
{
	private GameModel gameMod;
	private GameView gameView;
	
	
	
	
	public GameController(GameModel m, GameView v)
	{
		gameMod = m;
		gameView = v;
		

		gameView.addPlayListener(new GameListener());
		gameView.addATK1Listener(new ATK1Listener());
		gameView.addATK2Listener(new ATK2Listener());
		gameView.addBrawlerButton(new BrawlListener());
		gameView.addResetGameButton(new ResetListener());
		gameView.addSaveGameButton(new SaveButtonListener());
		
		
	}
	
	class ResetListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			gameView.resetGame();
			gameMod.resetGame();
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
			gameView.updateWinCount();
		}
		
	}
	
	class GameListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
	
			gameView.gamePanelSetNotVisible();
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
			
		
		}
	}
	
	

	
	
	
	class ATK2Listener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			gameView.addToAttackLog("You: used Foot and Furious, Opponent lost " + gameMod.getPlayer1Damage() * 1.1 + " health");
			gameMod.attack2(gameMod.getPlayer2(), gameMod.getPlayer1());
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
			gameMod.attack1(gameMod.getPlayer1(), gameMod.getPlayer2());
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
			
			if(gameMod.getPlayer2Health() < gameMod.getPlayer1Health() && gameMod.getPlayer2Health() < 5)
			{
				
				gameView.setWinnerBackground();
				
			}
			
		}
		
	}
	
	
	class SaveButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				BufferedWriter bWriter = new BufferedWriter(new FileWriter("/Users/rodneywiththefatassbutt/git/Project2/src/SaveFile", true));
				bWriter.write("\n " + gameMod.getPlayer1Name() + "\n" + gameView.getWinCount());
				bWriter.close();
			}
			catch (IOException ioe)
			{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(gameView.getGamePanel2(), null);
				System.out.println("File not found");
			}
		}
	}
	
	
	class LoadSaveListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			File file = new File(gameView.getLoadSaveField());
			String charName = "";
			int wins = -1;
		
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(file));
				if(br.readLine() != null && !charName.equals("") && wins != -1)
				{
					
					charName = br.readLine();
					wins = br.read();
					
					
					System.out.println(charName);
					System.out.println(wins);
					gameView.setWinCount(wins);
					
				}
				else
				{
					Character player = new Character(gameView.getName());
					gameMod.setPlayer1(player);
					gameMod.setPlayer2(new Character("Karen"));
					gameView.setWeaponName(gameMod.getPlayer1Weapon());
					
					System.out.println(charName);
					System.out.println(wins);
				}
			
				br.close();
			}	
			catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
			
			Character player = new Character(gameView.getName());
			gameMod.setPlayer1(player);
			gameMod.setPlayer2(new Character("Karen"));
			gameView.setWeaponName(gameMod.getPlayer1Weapon());
			gameView.setWinCount(wins);
	
		}
		
	}
	
	class BrawlListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			Character player = new Character(gameView.getName());
			gameMod.setPlayer1(player);
			gameMod.setPlayer2(new Character("Karen"));
			gameView.setWeaponName(gameMod.getPlayer1Weapon());
		}
	}
	
	
	class ATK1Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			gameView.addToAttackLog(" You: used Razor Toe Nails, Opponent lost " + gameMod.getPlayer1Damage() + " health");
			gameMod.attack1(gameMod.getPlayer2(), gameMod.getPlayer1());
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
			gameMod.attack1(gameMod.getPlayer1(), gameMod.getPlayer2());
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());

		}
	}
	
}
