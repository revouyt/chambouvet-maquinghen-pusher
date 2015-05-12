

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
	public Square(FixedItem p_fixedItem)
	{
		this.fixedContent = p_fixedItem;
	}
	
	public FixedItem getFixedContent()
	{
		return this.fixedContent;
	}

	public void setMovableContent(MovableItem p_movableItem)
	{
		this.movableContent = p_movableItem;
	}
	
	public MovableItem getMovableContent()
	{
		return this.movableContent;
	}
	
}
