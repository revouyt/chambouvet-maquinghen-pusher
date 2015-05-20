
public class DisplayConsole implements PlayerDisplay
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
	
	public void displayInvalidDirectionMessage()
	{
		System.out.println("Invalid direction");
	}
	
	public void displayHowToGiveUpMessage()
	{
		System.out.println("Type \"give up\" to stop your game");
	}
	
	public void displayGiveUpMessage()
	{
		System.out.println("You give up, pusher's stronger than you!");
	}


}
