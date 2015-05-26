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
public class GraphicalUserInterface {
	
	/**
	 * number of lines of the grid where the player can play
	 */
	private final static int NUMBER_OF_LINES =9;
	
	/**
	 * number of colums of the grid where the player can play
	 */
	private final static int NUMBER_OF_COLUMN =9;
	
	public static void main(String[] args){
		
		JFrame fenetre = new JFrame();
		fenetre.setVisible(true);
		fenetre.setSize(800, 600);
		fenetre.setLocationRelativeTo(null);
		fenetre.setTitle("Sokoban");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(); 
		GridLayout layout = new GridLayout(NUMBER_OF_LINES,NUMBER_OF_COLUMN);
		layout.setHgap(10);
	    layout.setVgap(10);
	    panel.setLayout(layout);
	    Icon Floor = new ImageIcon("Floor.png");
	    JLabel test = new JLabel();
	    test.setIcon(Floor); 
	    fenetre.add(test);
		panel.setLayout(new FlowLayout());
		JButton ButtonHelp = new JButton("Help");
		panel.add(ButtonHelp);
		panel.setBackground(Color.WHITE);
		JButton ButtonExit = new JButton("Exit");
		panel.add(ButtonExit);
		JButton ButtonPlay = new JButton("Play");
		panel.add(ButtonPlay);
		fenetre.setContentPane(panel);
		return;
		}
}


