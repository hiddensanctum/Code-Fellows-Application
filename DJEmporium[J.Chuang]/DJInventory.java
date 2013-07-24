/* 	
 * James Chuang
 * Turner 1
 * DJ Inventory
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DJInventory {
	
	private ArrayList <CDs> inven; //stores the CDs in the inventory
	private File fileOpened; //file that is opened
	
	public DJInventory(){
		
		inven = new ArrayList <CDs>();
		
	}
	
	//adds a CD
	public void addCD(CDs c){
		
		inven.add(c);
		
	}//end addCD
	
	//gets the file name
	public String getFileName(){
		
		return fileOpened.toString();
		
	}//end getFileName
	
	//get the file
	public void getFile(){
		
		JFileChooser jfc = new JFileChooser();
		
		// pop up the file menu box, "null" means we don't want to associate it with a component
		int result = jfc.showOpenDialog(null);
		
		//the box will stay open until the user hits ok, cancel, x....
		
		//if the user selectes "Ok", extract the file 
		
		File f=null;
		Scanner sc = null;
		if(result == JFileChooser.APPROVE_OPTION)
			f = jfc.getSelectedFile();
		fileOpened = f;
		
		
		//read and display the data from the file
		
		try{
			sc = new Scanner(f);
		}catch(FileNotFoundException e){
			System.out.println("File Not Found!");
			System.exit(-1);
		}catch(NullPointerException n){
			
		}
		
		//seperates them into students name and grade
		while(sc != null && sc.hasNext()){
			CDs temp = new CDs(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()),Double.parseDouble(sc.nextLine()));
			inven.add(temp);
		}
		
	}//end getFile
	
	//saves file
	public void saveFile(){
		
		File f=null;
		if(fileOpened == null){
			JFileChooser jfc = new JFileChooser();
			
			// pop up the file menu box, "null" means we don't want to associate it with a component
			int result = jfc.showSaveDialog(null);
			
			//the box will stay open until the user hits ok, cancel, x....
			
			//if the user selectes "Ok", extract the file 
			
			
			
			if(result == JFileChooser.APPROVE_OPTION)
				f = jfc.getSelectedFile();
		}
		else{
			f = fileOpened;
		}
		//read and display the data from the file
		FileWriter fw = null;
		try{
			fw = new FileWriter(f);
			for(CDs c : inven){
				fw.write(c.getSku() + "\r\n");
				fw.write(c.getArtist() + "\r\n");
				fw.write(c.getAlbum() + "\r\n");
				fw.write(c.getQuantity() + "\r\n");
				fw.write(c.getPrice() + "\r\n");
			}
			fw.close();
		}catch(IOException e){
			System.out.println("File Not Found!");
			System.exit(-1);
		}
		
	}//end saveFile
	
	//gets the list of CDs in the inventory
	public Object[] getList(){
		
		Object [] temp = new Object [inven.size()];
		for(int i = 0; i < inven.size(); i++)
			temp[i]= inven.get(i).getArtist() + " " + inven.get(i).getAlbum() + " " + inven.get(i).getQuantity() + "\n";
		return temp;
		
	}//end getList
	
	//sells a CD
	public void sellCD(int select,int sell){
		
		if(select < 0)
			JOptionPane.showMessageDialog(null, "No CD Selected", "ERROR", JOptionPane.ERROR_MESSAGE); 
		else{
			int currentQ = inven.get(select).getQuantity();
			if(sell > currentQ)
				JOptionPane.showMessageDialog(null, "Sell Quantity is greater than CD Quantity", "ERROR", JOptionPane.ERROR_MESSAGE); 
			else{
				inven.get(select).setQuantity(currentQ - sell);
				JOptionPane.showMessageDialog(null, "Total Cost: $" + inven.get(select).getPrice()*sell , "CD has been sold", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
	}//end sellCD
	
	//returns a string representation of the inventory
	public String toString(){
		
		String temp = "";
		for(CDs c: inven)
			temp+= "<tr>"+c+"</tr>";
		return temp;
		
	}//end toString
	
}
