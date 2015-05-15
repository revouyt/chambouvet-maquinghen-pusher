import java.util.Scanner;


public class PlayerConsole 
{
	
	/**
	 * get a direction by listening a keyboard entry
	 * @return
	 */
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
		
		return null;
	}
}
