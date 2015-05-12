
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
	 * @param fixedContentOfTheMap map content
	 */
	public Map(Square[][] squares)
	{
		this.numberOfRows = squares.length;
		this.numberOfColumns = squares[0].length;
		this.map = squares;
		
	}

	
	
	public Position getPlayerPosition() 
	{

		for (int rowNumber = 0; rowNumber < this.numberOfRows; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < this.numberOfColumns; columnNumber++)
			{
				if (this.map[rowNumber][columnNumber].getMovableContent() instanceof Player)
					return new Position(rowNumber, columnNumber);
			}
		}
		
		return null;
		
	}
	
	public Player getPlayer()
	{
		for (int rowNumber = 0; rowNumber < this.numberOfRows; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < this.numberOfColumns; columnNumber++)
			{
				if (this.map[rowNumber][columnNumber].getMovableContent() instanceof Player)
					return (Player)this.map[rowNumber][columnNumber].getMovableContent();
			}
		}
		
		return null;
	}
	
	public MovableItem getMovableContentAt(Position p_position)
	{
		return this.map[p_position.getX()][p_position.getY()].getMovableContent();
	}
	
	public void setMovableContentAt(Position p_position, MovableItem p_movableItem)
	{
		this.map[p_position.getX()][p_position.getY()].setMovableContent(p_movableItem);
	}
	
	public String toString()
	{
		String aRetourner = "";

			for (int columnNumber = 0; columnNumber < this.numberOfColumns * 5; columnNumber++)
			{
				aRetourner += "-";
			}
			aRetourner += "\n";



		
		for (int rowNumber = 0; rowNumber < this.numberOfRows; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < this.numberOfColumns; columnNumber++)
			{
				if (this.map[rowNumber][columnNumber].getFixedContent() == null)
					aRetourner += "  ";
				else if (this.map[rowNumber][columnNumber].getFixedContent() instanceof Wall)
					aRetourner += " X";
				else if (this.map[rowNumber][columnNumber].getFixedContent() instanceof Exit)
					aRetourner += "E" + ((Exit)this.map[rowNumber][columnNumber].getFixedContent()).getExitNumber();
				
				if (this.map[rowNumber][columnNumber].getMovableContent() == null)
					aRetourner += "  ";
				else if (this.map[rowNumber][columnNumber].getMovableContent() instanceof Player)
					aRetourner += " P";
				else if (this.map[rowNumber][columnNumber].getMovableContent() instanceof Box)
					aRetourner += "B" + ((Box)this.map[rowNumber][columnNumber].getMovableContent()).getNumber();
				
				aRetourner += "|";
			}
			
			aRetourner += "\n";
			for (int columnNumber = 0; columnNumber < this.numberOfColumns * 5; columnNumber++)
			{
				aRetourner += "-";
			}
			aRetourner += "\n";
		}
		
		return aRetourner;
	}

/*
	public static Square[] (String stringToParse)
	{
		
	}*/
	
	public static Map parseMap(String fixedContentOfTheMap) {
		
		int numberOfRows = fixedContentOfTheMap.split("\n").length;
		int numberOfColumns = fixedContentOfTheMap.split("\n")[0].split(";").length;
		
		Square[][] squares = new Square[numberOfRows][numberOfColumns];
		
		
		String lines[] =  fixedContentOfTheMap.split("\n");
		

		for (int currentRow = 0; currentRow < numberOfRows; currentRow++)
		{
			String cases[] = lines[currentRow].split(";");
			
			for (int currentColumn = 0; currentColumn < numberOfColumns; currentColumn++)
			{
				char fixedItemChar = cases[currentColumn].split(",")[0].charAt(1);
				char movableItemChar = cases[currentColumn].split(",")[1].charAt(0);
				
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


				squares[currentRow][currentColumn] = new Square(fixedItem, movableItem);

						
			}
			

		}
		
		
		

		return new Map(squares);
		
	}

}
