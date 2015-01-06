package arrayTools;

import java.awt.*;

import javax.swing.*;

import project.Color;
import project.ColorDisplay;

import java.util.Timer;
import java.util.TimerTask;

public class TextFlowAppDavidTestar extends JPanel{
	private static final long serialVersionUID = -2910434031371935286L; //Because of JPanel

	/**
	 * The main method asks for a string from the user and displays it
	 * character by character in a 7x7 grid.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		
		//ColorDisplay is a frame. 1,1 in arguments mean 7*7. 2,1 is 14*7 and so on. 
		ColorDisplay d = new ColorDisplay(2,1,Color.RED, Color.CYAN);
		
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

		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(d);
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
	            		//the elements which contains value 1 changes to a int-value representing a color. 
	                	for(int row = 0; row < 7; row++) {
	            			for(int col = 0; col < 7; col++) {
	            				if(txtArrays[counter].getElement(row, col) == 1) {
	            					txtArrays[counter].setElement(row, col, Color.BLACK);
	            				}
	            			}
	            		}
	                	//setDisplay argument is a 2D array
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
