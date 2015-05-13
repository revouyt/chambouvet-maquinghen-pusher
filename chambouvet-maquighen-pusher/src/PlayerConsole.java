import java.util.Scanner;


public class PlayerConsole 
{
	
	public Direction getDirectionToGo()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir une direction parmis h,b,g,d :");
		String str = sc.nextLine();
		
		if (str.equals("d"))
			return Direction.RIGHT;
		else if (str.equals("g"))
			 return Direction.LEFT;
		else if (str.equals("h"))
			return Direction.UP;
		else if (str.equals("b"))
			return Direction.DOWN;
		
		return null;
	}
}
