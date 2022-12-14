import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
	}
	
	class GameListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			gameView.gamePanelSetNotVisible();
			
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
			gameView.setWeaponName(player.getWeaponName());
			
			
		}
		
	}
	
	class ATK2Listener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			gameView.addToAttackLog("You: used Foot and Furious, Opponent lost " + gameMod.getPlayer1Damage() * 1.1 + " health");
//			gameView.addFootSoleImage();
			gameMod.attack2(gameMod.getPlayer2(), gameMod.getPlayer1());
			System.out.println("Opponent Health: " + gameMod.getPlayer2Health());
			System.out.println(gameMod.getPlayer1Weapon());
			
			if(gameMod.getPlayer2Health() < 0)
			{
				gameView.setWinnerBackground();
				gameView.win();
				
			}
			
		}
		
	}
	
	class ATK1Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			gameView.addToAttackLog("You: used Razor Toe Nails, Opponent lost " + gameMod.getPlayer1Damage() + " health");
			gameMod.attack1(gameMod.getPlayer2(), gameMod.getPlayer1());
			System.out.println(gameMod.getPlayer1Weapon());
			System.out.println("Opponent Health: " + gameMod.getPlayer2Health());
			
			if(gameMod.getPlayer2Health() < 0)
			{
				gameView.setWinnerBackground();
				gameView.win();
			
			}

			
		}
	}

}
