
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
		this.numberOfColumns = 8;
		this.numberOfRows = 9;
		
		this.map = new Square[this.numberOfRows][this.numberOfColumns];
		
		
		char[][] fixedContentOfTheMap = 
		{{' ', ' ', 'X', 'X', 'X', 'X', 'X', ' '},
		 {'X', 'X', 'X', ' ', ' ', ' ', 'X', ' '},
		 {'X', '1', ' ', ' ', ' ', ' ', 'X', ' '},
		 {'X', 'X', 'X', ' ', ' ', '2', 'X', ' '},
		 {'X', '7', 'X', 'X', ' ', ' ', 'X', ' '},
		 {'X', ' ', 'X', ' ', '3', ' ', 'X', 'X'},
	     {'X', ' ', ' ', '6', ' ', ' ', '4', 'X'},
		 {'X', ' ', ' ', ' ', '5', ' ', ' ', 'X'},
		 {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
		};
		
		
		for (int rowNumber = 0; rowNumber < this.numberOfRows; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < this.numberOfColumns; columnNumber++)
			{
				if (Character.isDigit(fixedContentOfTheMap[rowNumber][columnNumber]))
				{
					this.map[rowNumber][columnNumber] = new Square(new Exit(Character.getNumericValue(fixedContentOfTheMap[rowNumber][columnNumber])));
				}
				else if (fixedContentOfTheMap[rowNumber][columnNumber] == ' ')
				{
					this.map[rowNumber][columnNumber] = new Square(null);
				}
				else if (fixedContentOfTheMap[rowNumber][columnNumber] == 'X')
				{
					this.map[rowNumber][columnNumber] = new Square(new Wall());
				}
			}
		}
		
		this.map[2][1].setMovableContent(new Player());
		
		this.map[2][3].setMovableContent(new Box(1));
		this.map[3][4].setMovableContent(new Box(2));
		this.map[4][4].setMovableContent(new Box(3));
		this.map[6][5].setMovableContent(new Box(4));
		this.map[6][4].setMovableContent(new Box(5));
		this.map[6][3].setMovableContent(new Box(6));
		this.map[6][1].setMovableContent(new Box(7));
		
		System.out.println(this.getPlayerPosition());
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

}
