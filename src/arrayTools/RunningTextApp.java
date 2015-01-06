package arrayTools;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class RunningTextApp extends JPanel {
	private static final long serialVersionUID = 3029527800326573341L;	//Because of JPanel
	private JLabel[][] labels = new JLabel[7][35];						//Graphical grid of JLabels
	private Dimension block = new Dimension(40,40);						//size for all the JLabel components
	private Font font = new Font( "SansSerif", Font.BOLD, 30 );
	private String runningTxt;											//Text to visualize
	private Array7x7[] txtArrays;										//Text in graphical grid
	private ArrayChars chars;											//An object with all possible characters
	private Timer timer = new Timer();
	
	/**
	 * Creating an instance gives a blank grid panel
	 */
	public RunningTextApp(){
		initGraphics();
		try{
			chars = new ArrayChars();
		} catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	/**
	 * Initializes the graphical interface, sets properties and so on
	 */
	private void initGraphics(){
		setPreferredSize(new Dimension(1000,400));
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
	
	public void textInput(){
		//An input window asking for a string
		runningTxt = JOptionPane.showInputDialog(
				"Ange en text, bara STORA bokstäver, siffror och tecken");
		//An array of Array7x7 object to hold the graphical string
		txtArrays = new Array7x7[runningTxt.length()];
		//Inserts the graphical counterpart for each character
		for(int i = 0; i < runningTxt.length(); i++){
			txtArrays[i] = chars.getChar(runningTxt.charAt(i));
		}
	}
	
	public void startRunningText(){
		//TimerTask is an object, and requires a written class
		timer.schedule(new TimerTask() { // Here starts the class
			int counter = 0;

			// A run() method is required
			@Override
			public void run() {
			// if there's more characters to show, the timer will keep on going
				if(counter < (runningTxt.length()*7+35)){
					
					//TODO Something that moves the text across the 7*35 grid
					
					counter++;
				// If there's no more characters, the timer will stop
				}else{
					timer.cancel();
				}
			}
		// Initial delay and period in milliseconds
		}, 1000, 1000);
	}
	
	public static void main(String[] args) throws Exception{
		
		RunningTextApp app = new RunningTextApp();
		app.textInput();
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(app);
		frame.pack();
		frame.setVisible(true);
		app.startRunningText();
						
	}

}
