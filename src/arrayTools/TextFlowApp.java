package arrayTools;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class TextFlowApp extends JPanel{
	private static final long serialVersionUID = -2910434031371935286L; //Because of JPanel
	private JLabel[][] labels = new JLabel[7][7];						//Graphical grid of JLabels
	private Dimension block = new Dimension(40,40);						//size for all the JLabel components
	private Font font = new Font( "SansSerif", Font.BOLD, 30 );
	
	
	/**
	 * Creating an instance gives a blank grid panel
	 */
	public TextFlowApp(){
		initGraphics();
	}
	
	/**
	 * Displays provided 7x7 array in the window.
	 *  Can only handle values 1 and 0 at the moment.
	 *  
	 * @param array77
	 */
	public void setChar(Array7x7 array77){
		
		for(int i = 0; i < labels.length; i++) {
			for(int j = 0; j < labels[i].length; j++) {
				String value = array77.getElement(i, j) + "";
				labels[i][j].setText(value);
				if (value.equals("1")) {
					labels[i][j].setBackground(Color.BLACK);
					labels[i][j].setForeground(Color.BLACK);
				} else if (value.equals("0")) {
					labels[i][j].setBackground(Color.RED);
					labels[i][j].setForeground(Color.RED);
				}
			}
		}
	}
	
	/**
	 * Initializes the graphical interface, sets properties and so on
	 */
	private void initGraphics(){
		setPreferredSize(new Dimension(500,400));
		setLayout(new BorderLayout());
		
		// Creates a GridLayout panel with all the labels inside
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(7,7, 5, 5));
		center.setBorder(BorderFactory.createEmptyBorder(2,20,20,20));
		
		// Sets the properties of each label component
		for (int row = 0; row < labels.length; row++) {
			for (int col = 0; col < labels[row].length; col++) {
				labels[row][col] = new JLabel("");
				labels[row][col].setPreferredSize(block);
				labels[row][col].setBackground(Color.GRAY);
				labels[row][col].setOpaque(true);
				labels[row][col].setHorizontalAlignment(SwingConstants.CENTER);
				labels[row][col].setFont(font);
				center.add(labels[row][col]);
			}
		}
		// Adds the panel to the main panel
		add(center, BorderLayout.CENTER);		
	}
	
	/**
	 * The main method asks for a string from the user and displays it
	 * character by character in a 7x7 grid.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		//An object with all possible characters
		ArrayChars chars = new ArrayChars();						
		
		//An input window asking for a string
		String txt = JOptionPane.showInputDialog(
				"Ange en text, bara STORA bokstäver, siffror och tecken");	
		
		//An array of Array7x7 object to hold the graphical string
		Array7x7[] txtArrays = new Array7x7[txt.length()];			
		
		//Inserts the graphical counterpart for each character
		for(int i = 0; i < txt.length(); i++){
			txtArrays[i] = chars.getChar(txt.charAt(i));
		}
		
		TextFlowApp app = new TextFlowApp();
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(app);
		frame.pack();
		frame.setVisible(true);
		
		//New Timer object to delay each char 1 second
		Timer timer = new Timer();
		
		//TimerTask is an object, and requires a written class
		timer.schedule(new TimerTask() { // Here starts the class
				int counter = 0;

				// A run() method is required
	            @Override
	            public void run() {
	            	// if there's more characters to show, the timer will keep on going
	                if(counter < txt.length()){
	                	app.setChar(txtArrays[counter]);
	                	counter++;
	                // If there's no more characters, the timer will stop
	                }else{
	                	timer.cancel();
	                }
	            }
	           // Initial delay and period in milliseconds
	        }, 1000, 1000);
		}
	

}
