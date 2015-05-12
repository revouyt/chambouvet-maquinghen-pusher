import java.util.Scanner;


/**
 * Create a pusher game
 * @author chamboug
 * 
 */

public class GameOfPusher
{
	/**
	 * The map containing game items
	 */
	private Map map;
	
	
	/**
	 * Creation of a new pusher game
	 * with an initialized map
	 * @param p_map the map to be used
	 */
	public GameOfPusher(Map p_map)
	{
		this.map = p_map;
	}
	
	
	/**
	 * Start the game
	 */
	public void jouer()
	{
		boolean isFinished = false;
		while(!isFinished)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir une direction parmis h,b,g,d :");
			String str = sc.nextLine();
			
			if (str.equals("d"))
				this.moveTo(Direction.RIGHT);
			else if (str.equals("g"))
				this.moveTo(Direction.LEFT);
			else if (str.equals("h"))
				this.moveTo(Direction.UP);
			else if (str.equals("b"))
				this.moveTo(Direction.DOWN);
			
			System.out.println(this.map);
		}
	}
	
	public boolean moveTo(Direction p_direction)
	{
		Position playerPosition = this.map.getPlayerPosition();
		
		if (p_direction == Direction.RIGHT)
		{
			
			if (this.map.getFixedContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1)) instanceof Wall)
			{
				return false;
			}

			if (this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1)) instanceof Box)
			{
				if (!(this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 2)) instanceof Box) && 
					!(this.map.getFixedContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 2)) instanceof Wall))
				{
					this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 2), this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1)));
					this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1), this.map.getPlayer());
					this.map.setMovableContentAt(playerPosition, null);
					
					this.map.setPlayerPosition(new Position(playerPosition.getX(), playerPosition.getY() + 1));
					
					return true;
				}
				return false;
			}
				
			this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1), this.map.getPlayer());
			this.map.setPlayerPosition(new Position(playerPosition.getX(), playerPosition.getY() + 1));
			this.map.setMovableContentAt(playerPosition, null);
			return true;
			
			
			
		}
		else if (p_direction == Direction.LEFT)
		{
			
			if (this.map.getFixedContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1)) instanceof Wall)
			{
				return false;
			}

			if (this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1)) instanceof Box)
			{
				if (!(this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 2)) instanceof Box) && 
					!(this.map.getFixedContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 2)) instanceof Wall))
				{
					this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 2), this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1)));
					this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1), this.map.getPlayer());
					this.map.setMovableContentAt(playerPosition, null);
					
					this.map.setPlayerPosition(new Position(playerPosition.getX(), playerPosition.getY() - 1));
					
					return true;
				}
				return false;
			}
				
			this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1), this.map.getPlayer());
			this.map.setPlayerPosition(new Position(playerPosition.getX(), playerPosition.getY() - 1));
			this.map.setMovableContentAt(playerPosition, null);
			return true;
		}
		else if (p_direction == Direction.UP)
		{
			
			if (this.map.getFixedContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY())) instanceof Wall)
			{
				return false;
			}

			if (this.map.getMovableContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY())) instanceof Box)
			{
				if (!(this.map.getMovableContentAt(new Position(playerPosition.getX() - 2, playerPosition.getY())) instanceof Box) && 
					!(this.map.getFixedContentAt(new Position(playerPosition.getX() - 2, playerPosition.getY())) instanceof Wall))
				{
					this.map.setMovableContentAt(new Position(playerPosition.getX() - 2, playerPosition.getY()), this.map.getMovableContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY())));
					this.map.setMovableContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY()), this.map.getPlayer());
					this.map.setMovableContentAt(playerPosition, null);
					
					this.map.setPlayerPosition(new Position(playerPosition.getX() - 1, playerPosition.getY()));
					
					return true;
				}
				return false;
			}
				
			this.map.setMovableContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY()), this.map.getPlayer());
			this.map.setPlayerPosition(new Position(playerPosition.getX() - 1, playerPosition.getY()));
			this.map.setMovableContentAt(playerPosition, null);
			return true;
			
			
			
		}
		else if (p_direction == Direction.DOWN)
		{
			
			if (this.map.getFixedContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY())) instanceof Wall)
			{
				return false;
			}

			if (this.map.getMovableContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY())) instanceof Box)
			{
				if (!(this.map.getMovableContentAt(new Position(playerPosition.getX() + 2, playerPosition.getY())) instanceof Box) && 
					!(this.map.getFixedContentAt(new Position(playerPosition.getX() + 2, playerPosition.getY())) instanceof Wall))
				{
					this.map.setMovableContentAt(new Position(playerPosition.getX() + 2, playerPosition.getY()), this.map.getMovableContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY())));
					this.map.setMovableContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY()), this.map.getPlayer());
					this.map.setMovableContentAt(playerPosition, null);
					
					this.map.setPlayerPosition(new Position(playerPosition.getX() + 1, playerPosition.getY()));
					
					return true;
				}
				return false;
			}
				
			this.map.setMovableContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY()), this.map.getPlayer());
			this.map.setPlayerPosition(new Position(playerPosition.getX() + 1, playerPosition.getY()));
			this.map.setMovableContentAt(playerPosition, null);
			return true;
			
			
			
		}
		
		return false;
	}
}
