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
	
	
	private Position playerPosition;
	
	/**
	 * Unique map builder
	 * @param fixedContentOfTheMap map content
	 */
	public Map(Square[][] squares)
	{
		this.numberOfRows = squares.length;
		this.numberOfColumns = squares[0].length;
		this.map = squares;
		
		this.playerPosition = this.searchPlayerPosition();
		
	}

	
	
	private Position searchPlayerPosition() 
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
	
	public Position getPlayerPosition()
	{
		return this.playerPosition;
	}
	
	public void setPlayerPosition(Position p_playerPosition)
	{
		this.playerPosition = p_playerPosition;
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
	
	public FixedItem getFixedContentAt(Position p_position)
	{
		return this.map[p_position.getX()][p_position.getY()].getFixedContent();
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
		// int numberOfColumns = fixedContentOfTheMap.split("\n")[0].split(";").length;
		
		Square[][] squares = new Square[numberOfRows][];
		
		String lines[] =  fixedContentOfTheMap.split("\n");
		

		for (int currentRow = 0; currentRow < numberOfRows; currentRow++)
			squares[currentRow] = parseMapRow(lines[currentRow]);
		
		return new Map(squares);
		
	}



	private static Square[] parseMapRow(String rowAscii) {
		
		String cellsAscii[] = rowAscii.split(";");
		Square[] squares = new Square[cellsAscii.length];
		
		for (int currentColumn = 0; currentColumn < squares.length; currentColumn++)
			squares[currentColumn] = Square.parseSquare(cellsAscii[currentColumn]);
		return squares;
			
	}
	
	
	public boolean areAllBoxesOnExit()
	{
		for (int currentRow = 0; currentRow < this.numberOfRows; currentRow++)
		{
			for (int currentColumn = 0; currentColumn < this.numberOfColumns; currentColumn++)
			{
				FixedItem fixedCurrentSquareContent = this.map[currentRow][currentColumn].getFixedContent();
				MovableItem movableCurrentSquareContent = this.map[currentRow][currentColumn].getMovableContent();
				
				if (fixedCurrentSquareContent instanceof Exit)
				{
					if (!(movableCurrentSquareContent instanceof Box))
					{
						return false;
					}
					else if (movableCurrentSquareContent instanceof Box) 
					{
						if (((Box) movableCurrentSquareContent).getNumber() != ((Exit)fixedCurrentSquareContent).getExitNumber())
						{
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

}
