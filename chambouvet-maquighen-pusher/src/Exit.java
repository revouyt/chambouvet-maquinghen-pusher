
/**
 * is a Ground where there is a number associate to a unique box
 * @author chamboug
 *
 */
public class Exit extends FixedItem
{
	private int exitNumber;
	
	public Exit (int p_exitNumber)
	{
		this.exitNumber = p_exitNumber;
	}
	
	public int getExitNumber()
	{
		return this.exitNumber;
	}
}
