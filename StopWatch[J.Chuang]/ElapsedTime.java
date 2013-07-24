/*
James Chuang
Turner 1
Class that calculates the elapsed time
 */
public class ElapsedTime {
	private double starting; //the starting time
	private double stopping; //the ending time
	
	//stores the starting time
	public void getStart(){
		
		starting = System.currentTimeMillis();
		
	}//end getStart
	
	//stores the ending time
	public void getEnd(){
		
		stopping = System.currentTimeMillis();
		
	}//end getEnd
	
	//returns the Elapsed time
	public String toString(){
		
		return String.format("%.1f",((stopping - starting)/1000));
		
	}//end toString
}
