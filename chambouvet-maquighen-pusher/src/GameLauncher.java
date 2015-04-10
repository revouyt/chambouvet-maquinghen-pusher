
/**
 * @author chamboug
 * Project application class
 */
public class GameLauncher {

	public static void main(String[] args) {

		Map map = new Map();
		new GameOfPusher(map).jouer();
	}

}