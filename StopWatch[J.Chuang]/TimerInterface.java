/*
James Chuang
Turner 1
Program that makes a stopwatch
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TimerInterface implements ActionListener{

	private JButton first; //the start button of the timer
	private JButton second; //the stop button of the timer
	private JLabel display; //the display of the timer
	private JFrame frame; //the frame of the timer
	private String lastPressed; //the button last pressed
	private ElapsedTime time; //the elapsed time
	
	//constructor for time interface
	public TimerInterface(){
		
		lastPressed = "None";//default sets the lastPressed button
		time = new ElapsedTime(); //creates an Elasped Time object
		
		frame = new JFrame();
		frame.setTitle("StopWatch v1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(220,90);
		
		//Values displayed on top of the buttons
		first = new JButton("Start");
		second = new JButton("Stop");
		
		//initial value stored in JLabel
		display = new JLabel("Elapsed Time:");
		
		//register event handling with the buttons and this program
		first.addActionListener(this);
		second.addActionListener(this);
		
		//change the layout to insert widgets from left to right
		frame.setLayout(new FlowLayout());
		
		//add all widgets
		frame.add(first);
		frame.add(second);
		frame.add(display);
		
		frame.setVisible(true);
		
	}//end constructor
	
	//prints out the time between the starting and stopping time
	public void actionPerformed(ActionEvent ae){
	
		String currentPressed= ae.getActionCommand(); //stores the current button pressed
		
		//determines that the current buttom pressed isn't the same as the last button pressed
		if(!lastPressed.equals(currentPressed)){
			
			//if the button pressed is start
			if(currentPressed.equals("Start"))
				time.getStart();
			else{
				time.getEnd();
				display.setText("Elapsed Time: " + time + " seconds");
			}
			//stores the current button pressed as the last button pressed
			lastPressed = currentPressed;
			
		}
	}//end actionPerformed
	
	public static void main(String[] args){
		TimerInterface bd = new TimerInterface();
	}
}
