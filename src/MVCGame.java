
public class MVCGame
{

	public static void main(String[] args)
	{
		
		GameView view = new GameView();
		GameModel gModel = new GameModel();
		GameController gCon = new GameController(gModel, view);
		view.setVisible(true);

	}
}
