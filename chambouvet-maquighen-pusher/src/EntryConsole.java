import java.util.Scanner;


/**
 * To ask the player in the console
 * @author chamboug
 *
 */
public class EntryConsole implements PlayerEntry
{
	

	public Direction getDirectionToGo()
	{
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		if (str.equals("d"))
			return Direction.RIGHT;
		else if (str.equals("q"))
			 return Direction.LEFT;
		else if (str.equals("z"))
			return Direction.UP;
		else if (str.equals("s"))
			return Direction.DOWN;
		else if (str.equals("give up"))
			return null;
		
		return Direction.NOWHERE;
	}
}
