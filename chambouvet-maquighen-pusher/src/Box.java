
/**
 * item which can be move by the PLAYER
 * @author chamboug
 *
 */
public class Box extends MovableItem
{
	/**
	 * box number
	 */
	private int boxNumber;
	
	/**
	 * 
	 * @param p_boxNumber
	 */
	public Box (int p_boxNumber)
	{
		this.boxNumber = p_boxNumber;
	}
	
	/**
	 * get current box number
	 * @return boxNumber
	 */
	public int getNumber()
	{
		return this.boxNumber;
	}
}
