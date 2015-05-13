
public class DisplayConsole
{
	public void displayDirectionChoice()
	{
		System.out.println("Please choose a direction using Z,Q,S,D");
	}
	public void displayMap(Map mapToDisplay)
	{
		System.out.println(mapToDisplay);
	}
	
	public void displayVictoryMessage()
	{
		System.out.println("Victory !");
	}
	
	public void displayGiveUpMessage()
	{
		System.out.println("You give up, pusher's stronger than you!");
	}

}
