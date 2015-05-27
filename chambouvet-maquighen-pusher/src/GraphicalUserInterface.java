import java.awt.Color;
import java.awt.FlowLayout;
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
	 * number of columns of the grid where the player can play
	 */
	private final static int NUMBER_OF_COLUMN =9;
	
	public static void main(String[] args){
		
		
		JFrame fenetre = new JFrame();
		fenetre.setSize(800, 600);
		fenetre.setLocationRelativeTo(null);
		fenetre.setTitle("Sokoban");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(); 
		//JPanel panelboard[] = new JPanel[9];
		//GridLayout layout = new GridLayout(NUMBER_OF_LINES,NUMBER_OF_COLUMN);
		//layout.setHgap(10);
	    //layout.setVgap(10);
	    //panel.setLayout(layout);
		//panel.add(panelboard[0]);
		//panel.add(panelboard[1]);
		//panelboard[0].setText("test");
		//panelboard[1].setText("retest");
	    Icon Floor = new ImageIcon("G:\\Floor.png");
	    JLabel test = new JLabel();
	    panel.add(test);
	    test.setIcon(Floor); 
	    fenetre.add(test);
		panel.setLayout(new FlowLayout());
		JButton ButtonHelp = new JButton("Help");
		panel.add(ButtonHelp);
		//fenetre.getContentPane().add(new JButton("TEST"), BorderLayout.CENTER);
		panel.setBackground(Color.WHITE);
		JButton ButtonExit = new JButton("Exit");
		panel.add(ButtonExit);
		JButton ButtonPlay = new JButton("Play");
		panel.add(ButtonPlay);
		JLabel[][] tableau = new JLabel[NUMBER_OF_COLUMN][NUMBER_OF_LINES];
		for (int xmap = 0; xmap < NUMBER_OF_COLUMN; xmap++) {
			for (int ymap = 0; ymap <  NUMBER_OF_LINES; ymap++) {
				JLabel cases=new JLabel();
				tableau[xmap][ymap]=cases;
				cases.setIcon(Floor);
				panel.add(tableau[xmap][ymap]);
				}
				}
		fenetre.setContentPane(panel);
		fenetre.setVisible(true);
		return;
		}
}


