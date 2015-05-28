import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author revouyt
 *	The Graphical user interface on which you can play a game of pusher
 */
public class GraphicalUserInterface extends JFrame
{
		
	/**
	 * Table where we put the game
	 */
	private JLabel[][] tableau;

	/**
	 * We recuperate the map of the game
	 */
	private Map map;
	
	
	
	public GraphicalUserInterface(Map map)
	{
		
		this.map = map;
		int number_Of_Columns = map.getNumberOfColumns();
		int number_Of_Lines = map.getNumberOfRows();
		
		this.setSize(380, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Sokoban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanel panel = new JPanel(); 
		panel.setBounds(00, 0, 200, 500);
		GridLayout layout = new GridLayout(number_Of_Columns,number_Of_Lines,10,15);
	    panel.setLayout(layout);
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.WHITE);
		tableau = new JLabel[number_Of_Columns][number_Of_Lines];
		for (int ymap = 0; ymap < number_Of_Lines; ymap++)
		{
			for (int xmap = 0; xmap <  number_Of_Columns; xmap++)
			{
				JLabel cases=new JLabel();
				tableau[xmap][ymap]=cases;
				Icon Floor = new ImageIcon("G:\\Floor.png");
				cases.setIcon(Floor);
				panel.add(tableau[xmap][ymap]);
				
			//	Position currentposition = new Position(xmap,ymap);
			//	if (map.getFixedContentAt(currentposition)instanceof Exit) 
			//	{
			//		ImageIcon exit = new ImageIcon("G:\\Exit.png");
			//		cases.setIcon(exit);
			//		panel.add(tableau[xmap][ymap]);
			 //   }
			//	
			//	if (map.getMovableContentAt(currentposition) instanceof Box)
			//	{
			//		ImageIcon box = new ImageIcon("G:\\Caisse.png");
			//		cases.setIcon(box);
			//	}
			//	
			//	if (map.getFixedContentAt(currentposition)instanceof Wall) 
			//	{
			//		ImageIcon wall = new ImageIcon("G:\\Wall.png");
			//		cases.setIcon(wall);
			//		panel.add(tableau[xmap][ymap]);
			//   }

			}
		}
		this.setContentPane(panel);
		this.setVisible(true);
		
		int positionPlayerx = map.getPlayerPosition().getX();
		int positionPlayery = map.getPlayerPosition().getY();
		ImageIcon tractopelle = new ImageIcon("G:\\Tractopellemaggle.png");
		tableau[positionPlayerx][positionPlayery].setIcon(tractopelle);
	
		//JButton ButtonHelp = new JButton("Help");
		//panel.add(ButtonHelp);
		}
}