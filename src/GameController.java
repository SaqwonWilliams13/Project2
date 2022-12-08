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
		
		gameView.addTextListener(new WeaponListener());
		gameView.addPlayListener(new GameListener());
	}
	
	
	
	class WeaponListener implements ActionListener
	{
	
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String weaponName = "";
			double weaponDamage = 0.0;
			String name = "";
			
			
			try
			{
				gameMod.setPlayer1(gameView.getName(),gameView.getWeaponName(), gameView.getWeaponDamage());
				gameMod.setPlayer1Weapon(gameView.getWeaponName(), gameView.getWeaponDamage());
				System.out.println(gameMod.getPlayer1());
				
			}
			
			catch(NumberFormatException nfe)
			{
				gameView.errorMessage("Choose A valid number/name please!");
			}
			
			
		}
		
	}

	
	class GameListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			gameView.gamePanelSetNotVisible();
			
		}
		
	}
}
