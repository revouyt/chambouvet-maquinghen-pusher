
public class Position {
	private final int x;
	private final int y;
	
	public Position(int p_x, int p_y)
	{
		this.x = p_x;
		this.y = p_y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public String toString()
	{
		return "X : " + this.x + "      Y : " + this.y;
	}
}
