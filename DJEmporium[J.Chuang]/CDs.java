/* 	
 * James Chuang
 * Turner 1
 * CD
*/
import javax.swing.JLabel;


public class CDs{
	private int sku; //stores the sku of the CD
	private String artist; //stores the artist of the CD
	private String album; //stores the album name
	private int quantity; //stores the quantity
	private double price; //stores the price
	
	//Constructor
	public CDs(int s, String a, String al, int q, double p){
		
		this.sku = s;
		this.artist = a;
		this.album = al;
		this.quantity = q;
		this.price = p;
		
	}//end Constructor
	
	//returns the artist of the CD
	public String getArtist(){
		
		return artist;
		
	}//end getArtist
	
	//returns the sku of the CD
	public int getSku(){
		
		return sku;

	}//end getSku
	
	//returns the Album of the CD
	public String getAlbum(){
		
		return album;

	}//end getAlbum
	
	//returns the Quantity of CDs
	public int getQuantity(){
		
		return quantity;

	}//end getQuantity
	
	//returns the price of the CD
	public Double getPrice(){
		
		return price;

	}//end getPrice
	
	public void setQuantity(int s){
		
		quantity = s;
		
	}
	
	//returns String representation of class
	public String toString(){
		
		return "<td>" + sku + "</td><td>" +artist+"</td><td>"+album+"</td><td>"+quantity+"</td><td>"+price+"</td>";
	
	}//end toString

}
