
/**
 * decor items, which can't move
 * @author chamboug
 *
 */
public enum FixedItem {
	/**
	 * Square which delimit the map, and where no movable item can pass
	 */
	WALL, 
	/**
	 * Empty square where every movable item can pass
	 */
	GROUND, 
	/**
	 * is a GROUND where there is a number associate to a unique box
	 */
	EXIT;

}
