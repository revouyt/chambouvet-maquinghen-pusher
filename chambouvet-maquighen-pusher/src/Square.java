
/**
 * Contains a final fixed item, and could also contains a movable item which can change during the game
 * @author chamboug
 * 
 */
public class Square 
{
	/**
	 *  Initial content
	 */
	private final FixedItem fixedContent;
	
	/**
	 * Movable content
	 */
	private MovableItem movableContent;
	
	/**
	 * Creation of a square
	 * @param p_fixedItem the initial state of the square
	 * @param p_movableItem 
	 */
	public Square(FixedItem p_fixedItem, MovableItem p_movableItem)
	{
		this.fixedContent = p_fixedItem;
		this.movableContent = p_movableItem;
	}
	
}
