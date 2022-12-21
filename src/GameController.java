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
	private boolean previous = false;
	private File saveGameFile;
	
	
	/**
	 *  
	 *  Class Constructor with the GUI class and the game class 
	 *  
	 *  This GameController allows a bridge between classes 
	 *  GameModel and GameView. It employs the interactive JComponent listeners
	 *  so that a response is elicited when an action is taken.
	 *  @param Game     The game itself without a visual
	 *  @param GameView	The game's visual piece that allows for user interaction
	 */
	public GameController(GameModel m, GameView v)
	{
		gameMod = m;
		gameView = v;

		gameView.addPlayListener(new GameListener());
		gameView.addATK1Listener(new ATK1Listener());
		gameView.addATK2Listener(new ATK2Listener());
		gameView.addResetGameButton(new ResetListener());
		gameView.addSaveGameButton(new SaveButtonListener());
		gameView.addLoadGame(new LoadSaveListener());
		
		
	}
	
	/**
	 * 
	 * @author Saqwon Williams
	 *
	 */
	class ResetListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			gameView.resetGame();
			gameMod.resetGame();
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
			gameView.updateWinCount();
			gameView.setATK1ButtonVisible(true);
			gameView.setATK2ButtonVisible(true);
		}
		
	}
	
	/**
	 * 
	 * @author Saqwon Williams
	 *
	 */
	class GameListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
	
			gameView.gamePanelSetNotVisible();
			
			if(previous == false)
			{
				Character player = new Character(gameView.getName());
				gameMod.setPlayer1(player);
				gameMod.setPlayer2(new Character("Karen"));
				gameView.setOppLabel(gameMod.getPlayer2Name());
				gameView.setWeaponName(gameMod.getPlayer1Weapon());
				gameView.setPlayerLabel(gameView.getName());

				
				
			}
			else
			{
				gameMod.setPlayer2(new Character("Crazy Karen"));
				gameView.setOppLabel(gameMod.getPlayer2Name());
				gameView.setWeaponName(gameMod.getPlayer1Weapon());
			}
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
		
		}
	}
	
	/**
	 * 
	 * @author Saqwon Williams
	 *
	 */
	class SaveButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			
			
			gameView.addToAttackLog("Saved Game!");
			try
			{
				BufferedWriter bWriter = new BufferedWriter(new FileWriter(saveGameFile, false));
				bWriter.write(gameMod.getPlayer1Name() + " " + gameView.getWinCount());
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
	
	/**
	 * 
	 * @author Saqwon Williams
	 *
	 */
	class LoadSaveListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String holder = "";
			String characterName = "";
			String numHolder = "";
			int wins = 0;
			int spaceLocation = 0;
	
			if(gameView.getSaveTextField().equals("Enter new File here"))
			{
				try
				{
					BufferedReader br = new BufferedReader(new FileReader(gameView.getPreviousSaveField()));
					
					if((holder = br.readLine()) != null)
					{
	
						spaceLocation = holder.indexOf(" ");
						characterName = holder.substring(0, spaceLocation);
						numHolder = holder.substring(spaceLocation, holder.length());
						numHolder = numHolder.substring(1);
						wins = Integer.parseInt(numHolder);
						
						Character player = new Character(characterName);
						gameMod.setPlayer1(player);
						gameView.setPlayerLabel(characterName);
						gameView.setWeaponName(gameMod.getPlayer1Weapon());
						gameView.setWinCount(wins);
						previous = true;
						saveGameFile = new File(gameView.getPreviousSaveField());
					}
					br.close();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
			else
			{
				saveGameFile = new File(gameView.getSaveTextField());
			}
		}
	}
	
	/**
	 * 
	 * @author Saqwon Williams
	 *
	 */
	class ATK1Listener implements ActionListener, Runnable
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ATK1Listener atk1 = new ATK1Listener();
			Thread one = new Thread(atk1);
			one.start();
		}

		@Override
		public void run()
		{
			gameView.setATK1ButtonVisible(false);
			gameView.setATK2ButtonVisible(false);
			gameView.addToAttackLog(" You: used Razor Toe Nails, Opponent lost " + gameMod.getPlayer1Damage() + " health");
			gameMod.attack1(gameMod.getPlayer2(), gameMod.getPlayer1());
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{

			}
			if(gameMod.getPlayer1Health() <= 0 || gameMod.getPlayer2Health() <= 0)
			{
				gameView.setWinnerBackground();
			}
			else
			{
				gameView.addToAttackLog(" Opp: Speed Dial: 'Police', You lost " + gameMod.getPlayer2Damage() + " health");
				gameMod.attack1(gameMod.getPlayer1(), gameMod.getPlayer2());
				gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
				gameView.setATK1ButtonVisible(true);
				gameView.setATK2ButtonVisible(true);
			}
		}
	}
	
	/**
	 * 
	 * @author Saqwon Williams
	 *
	 */
	class ATK2Listener implements ActionListener, Runnable
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			ATK2Listener two = new ATK2Listener();
			Thread myThread = new Thread(two);
			
			if(gameMod.getPlayer2Health() <= 0 || gameMod.getPlayer1Health() <= 0 )
			{
				
			}
			else
			{
				myThread.start();
			}
		}

		@Override
		public void run()
		{
			gameView.setATK1ButtonVisible(false);
			gameView.setATK2ButtonVisible(false);
			gameView.addToAttackLog("You: used Foot and Furious, Opponent lost " + gameMod.getPlayer1Damage() * 1.1 + " health");
			gameMod.attack2(gameMod.getPlayer2(), gameMod.getPlayer1());
			gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
			try
			{
				Thread.sleep(1000);
				
			}
			catch (InterruptedException e)
			{
			}
			
			if(gameMod.getPlayer1Health() <= 0 || gameMod.getPlayer2Health() <= 0)
			{
				gameView.setWinnerBackground();
			}
			else
			{
				gameView.addToAttackLog("Opp: Argument of Delusion, You lost" + gameMod.getPlayer1Damage() * 1 + " health");
				gameMod.attack1(gameMod.getPlayer1(), gameMod.getPlayer2());
				gameView.showCharacterHealth(gameMod.getPlayer1Health(), gameMod.getPlayer2Health());
				gameView.setATK1ButtonVisible(true);
				gameView.setATK2ButtonVisible(true);
			}
		}
	}
	
}
