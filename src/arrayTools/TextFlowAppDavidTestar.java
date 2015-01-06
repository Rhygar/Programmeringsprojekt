package arrayTools;

import java.awt.*;

import javax.swing.*;

import project.Color;
import project.ColorDisplay;

import java.util.Timer;
import java.util.TimerTask;

public class TextFlowAppDavidTestar extends JPanel{
	private static final long serialVersionUID = -2910434031371935286L; //Because of JPanel
	private JLabel[][] labels = new JLabel[7][7];						//Graphical grid of JLabels
	private Dimension block = new Dimension(40,40);						//size for all the JLabel components
	private Font font = new Font( "SansSerif", Font.BOLD, 30 );
	
	
	/**
	 * Creating an instance gives a blank grid panel
	 */
	public TextFlowAppDavidTestar(){
		initGraphics();
	}
	
	/**
	 * Displays provided 7x7 array in the window.
	 *  Can only handle values 1 and 0 at the moment.
	 *  
	 * @param array77
	 */
//	public void setChar(Array7x7 array77){
//		
//		for(int i = 0; i < labels.length; i++) {
//			for(int j = 0; j < labels[i].length; j++) {
//				String value = array77.getElement(i, j) + "";
//				labels[i][j].setText(value);
//				if (value.equals("1")) {
//					labels[i][j].setBackground(Color.BLACK);
//					labels[i][j].setForeground(Color.BLACK);
//				} else if (value.equals("0")) {
//					labels[i][j].setBackground(Color.RED);
//					labels[i][j].setForeground(Color.RED);
//				}
//			}
//		}
//	}
	
	/**
	 * Initializes the graphical interface, sets properties and so on
	 */
	private void initGraphics(){
		ColorDisplay d = new ColorDisplay(1,1,Color.RED, Color.CYAN);				//New ColorDisplay. 1,1 represents how many "7s" in the display. 2 means 14 squares. 
	
	
	}
	/**
	 * The main method asks for a string from the user and displays it
	 * character by character in a 7x7 grid.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		
		ColorDisplay d = new ColorDisplay(1,1,Color.RED, Color.CYAN);
		
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
		
		TextFlowAppDavidTestar app = new TextFlowAppDavidTestar();
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(app);
		frame.add(d);
		frame.pack();
		frame.setVisible(true);
		
		
	
		//New Timer object to delay each char 1 second
		Timer timer = new Timer();
		
		//TimerTask is an object, and requires a written class
		timer.schedule(new TimerTask() { // Here starts the class
				int counter = 0;
				int a = Color.BLACK;
				// A run() method is required
	            @Override
	            public void run() {
	            	// if there's more characters to show, the timer will keep on going
//	            	JOptionPane.showMessageDialog(null,d);
	            	
	            	if(counter < txt.length()){
	                	for(int row = 0; row < 7; row++) {
	            			for(int col = 0; col < 7; col++) {
	            				if(txtArrays[counter].getElement(row, col)==1){
	            					txtArrays[counter].setElement(row, col, a);
	            				}
	            			}
	            		}
	                	d.setDisplay(txtArrays[counter].getArray());
	                	d.updateDisplay();
	                	
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
