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
		
	private JLabel[][] tableau;

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
		//JPanel panelboard[] = new JPanel[9];
		GridLayout layout = new GridLayout(number_Of_Lines,number_Of_Columns,10,15);
		//layout.setHgap(10);
	    //layout.setVgap(10);
	    panel.setLayout(layout);
		//panel.add(panelboard[0]);
		//panel.add(panelboard[1]);
		//panelboard[0].setText("test");
		//panelboard[1].setText("retest");
		
	    Icon Floor = new ImageIcon("G:\\Floor.png");
	//    JLabel test = new JLabel();
	 //   panel.add(test);
	 //   test.setIcon(Floor); 
	 //   this.add(test);
		panel.setLayout(new FlowLayout());
	//	JButton ButtonHelp = new JButton("Help");
	//	panel.add(ButtonHelp);
		//fenetre.getContentPane().add(new JButton("TEST"), BorderLayout.CENTER);
		panel.setBackground(Color.WHITE);
		//JButton ButtonExit = new JButton("Exit");
		//panel.add(ButtonExit);
		//JButton ButtonPlay = new JButton("Play");
		//panel.add(ButtonPlay);
		tableau = new JLabel[number_Of_Columns][number_Of_Lines];
		for (int xmap = 0; xmap < number_Of_Columns; xmap++)
		{
			for (int ymap = 0; ymap <  number_Of_Lines; ymap++)
			{
				JLabel cases=new JLabel();
				tableau[xmap][ymap]=cases;
				
				Position currentposition = new Position(xmap,ymap);
				if (map.getFixedContentAt(currentposition) == instanceof (Exit)) 
				{
					ImageIcon exit = new ImageIcon("bla")
					cases.setIcon(exit);
					panel.add(tableau[xmap][ymap]);
				}
				if getMovableContentAt
					box
				
				cases.setIcon(Floor);
				panel.add(tableau[xmap][ymap]);
			}
		}
		this.setContentPane(panel);
		this.setVisible(true);
		
		int positionPlayerx = map.getPlayerPosition().getX();
		int positionPlayery = map.getPlayerPosition().getY();
		ImageIcon tracto = new ImageIcon("G:\\Tractopellemaggle.png");
		tableau[positionPlayerx][positionPlayery].setIcon(tracto);
		
		
		}
}


