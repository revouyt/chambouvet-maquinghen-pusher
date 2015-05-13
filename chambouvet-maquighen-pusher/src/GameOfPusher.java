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
	
	private PlayerConsole playerConsole;
	
	private DisplayConsole displayConsole;
	
	/**
	 * Creation of a new pusher game
	 * with an initialized map
	 * @param p_map the map to be used
	 */
	public GameOfPusher(Map p_map)
	{
		this.map = p_map;
		
		this.playerConsole = new PlayerConsole();
		this.displayConsole = new DisplayConsole();
		
	}
	
	
	/**
	 * Start the game
	 */
	public boolean jouer()
	{
		Direction directionToGo;
		
		boolean isFinished = false;
		while(!isFinished)
		{

			this.displayConsole.displayMap(this.map);
			this.displayConsole.displayDirectionChoice();
			
			directionToGo = this.playerConsole.getDirectionToGo();
			
			if (directionToGo == null)
			{				
				this.displayConsole.displayGiveUpMessage();
				return false;
			}
			else
			{
				this.moveTo(directionToGo);
			}
				
			
			if (this.map.areAllBoxesOnExit())
			{
				this.displayConsole.displayMap(this.map);
				this.displayConsole.displayVictoryMessage();
				return true;
			}

		}
		
		return false;
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
