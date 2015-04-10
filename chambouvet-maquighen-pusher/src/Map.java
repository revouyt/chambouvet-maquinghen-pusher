
/**
 * This class represents a grid where a Pusher game is played
 * @author chamboug
 * 
 */
public class Map {
	
	/**
	 * number of columns 
	 */
	private final int numberOfColumns;
	/**
	 *number of rows 
	 */
	private final int numberOfRows;
	
	/**
	 *  Square array which compose the map
	 */
	private final Square[][] map;
	
	/**
	 * Unique map builder
	 */
	public Map()
	{
		numberOfColumns = 8;
		numberOfRows = 9;
		
		map = new Square[numberOfRows][numberOfColumns];
		
		
	}

}
