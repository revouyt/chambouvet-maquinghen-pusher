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

	public static Square parseSquare(String squareAscii) {
		String[] tokens = squareAscii.split(",");
		
		char fixedItemChar = tokens[0].charAt(1);
		char movableItemChar = tokens[1].charAt(0);
		
		FixedItem fixedItem = null;
		MovableItem movableItem = null;
		
		
		if (Character.isDigit(fixedItemChar))
		{
			fixedItem = new Exit(Character.getNumericValue(fixedItemChar));
		}
		else if (fixedItemChar == 'f')
		{
			fixedItem = null;
		}
		else if (fixedItemChar == 'w')
		{
			fixedItem = new Wall();
		}
		
		
		if (Character.isDigit(movableItemChar))
		{
			movableItem = new Box(Character.getNumericValue(movableItemChar));
		}
		else if (movableItemChar == '-')
		{
			movableItem = null;
		}
		else if (movableItemChar == 'p')
		{
			movableItem = new Player();
		}

		return new Square(fixedItem, movableItem);

	}
	
}