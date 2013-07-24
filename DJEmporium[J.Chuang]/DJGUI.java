/* 	
 * James Chuang
 * Turner 1
 * DJ GUI
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class DJGUI implements ActionListener{
	
	private JFrame frame; //the frame of the store
	private DJInventory inv; //stores the inventory of the CDs
	
	//tab components
	private JTabbedPane djPanel; //the tab panel
	private JPanel invenPanel; //the inventory panel
	private JPanel addPanel; //the add panel
	private JPanel sellPanel; //the sell panel
	private JTextField skuText; //the sku text
	private JTextField priceText; //the price text
	private JTextField artistText; //the artist text
	private JTextField quantityText; //the quantity text
	private JTextField albumText; //the album text
	private JButton add; //the add button
	private JButton sell; //the sell button
	private JTextField sellText; //the sellText field
	private JList sellList; //the sell list
	private JLabel invD; //the inventory display
	private String disDefault; //the default inventory display
	
	//Menu components
	private JMenuItem jmiOpen; //the open button
	private JMenuItem jmiClose; //the close button
	private JMenuItem jmiSave; //the save button
	private JMenuItem jmiExit; //the exit button
	private JMenuBar jmb; //the menu bar
	
	public DJGUI(){
		
		//initializes all the panels and frames
		frame = new JFrame();
		inv = new DJInventory();
		
		frame.setTitle("DJStore --- No File Loaded");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,500);
		
		//-------------------tabs component declarations--------------------//
		djPanel = new JTabbedPane();
		invenPanel = new JPanel();
		addPanel = new JPanel();
		sellPanel = new JPanel();
		
		//addPanel declarations
		skuText=new JTextField(11);
		priceText=new JTextField(11);
		artistText=new JTextField(10);
		quantityText=new JTextField(9);
		albumText=new JTextField(9);
		add=new JButton("Add");
		
		JPanel skuP = new JPanel();
		skuP.add(new JLabel("Sku"));
		skuP.add(skuText);
		JPanel priceP = new JPanel();
		priceP.add(new JLabel("Price"));
		priceP.add(priceText);
		JPanel artistP = new JPanel();
		artistP.add(new JLabel("Artist"));
		artistP.add(artistText);
		JPanel quantityP = new JPanel();
		quantityP.add(new JLabel("Quantity"));
		quantityP.add(quantityText);
		JPanel albumP = new JPanel();
		albumP.add(new JLabel("Album"));
		albumP.add(albumText);
		JPanel addP = new JPanel();
		addP.add(add);

		addPanel.setLayout(new GridLayout(3,2));
		addPanel.add(skuP);
		addPanel.add(priceP);
		addPanel.add(artistP);
		addPanel.add(quantityP);
		addPanel.add(albumP);
		addPanel.add(addP);
		
		//inventory panel declarations
		invD = new JLabel();
		disDefault = "<html><table width = \"380\" align = left><tr><td>Sku</td><td>Artist</td><td>Album</td><td>Quantity</td><td>Price</td></tr>";
		invD.setText(disDefault);
		invenPanel.add(invD);
                                                  
		//sell panel declarations
		JPanel sellP = new JPanel();
		JPanel quant = new JPanel();
		JPanel listP = new JPanel();
		sellList = new JList();
		sellText = new JTextField(5);
		sell = new JButton("Sell");
		JScrollPane listS = new JScrollPane(sellList);
		
		sellP.setLayout(new FlowLayout(FlowLayout.CENTER,70,20));
		sellP.add(new JLabel("Quantity:"));
		quant.add(sell);
		sellP.add(sellText);
		sellP.add(quant);
		listP.setLayout(new BorderLayout());
		listP.add(listS,BorderLayout.CENTER);
		listP.add(new JLabel("         "),BorderLayout.NORTH);
		listP.add(new JLabel("         "),BorderLayout.WEST);
		listP.add(new JLabel("         "),BorderLayout.EAST);
		listP.add(new JLabel("         "),BorderLayout.SOUTH);
		sellPanel.setLayout(new GridLayout(1,2));
		sellPanel.add(listP);
		sellPanel.add(sellP);
		
		//add tabs
		djPanel.add("Inventory", invenPanel);
		djPanel.add("Add Record", addPanel);
		djPanel.add("Sell Record", sellPanel);
		//-------------------End tabs component declarations----------------//
		
		//-----------------------Menu component declarations---------------//
		jmb = new JMenuBar();
		// jmb typically contains JMenu objects
		// JMenu objects may contain MenuItem objects or other JMenu objects
		
		JMenu jmFile = new JMenu("File");
		
		jmiOpen = new JMenuItem("Open");
		jmiSave = new JMenuItem("Save");
		jmiClose = new JMenuItem("Close");
		jmiExit = new JMenuItem("Exit");
		
		// add File items to JMenu
		jmFile.add(jmiOpen);
		jmFile.add(jmiClose);
		jmFile.add(jmiSave);
		jmFile.add(jmiExit);
		
		jmb.add(jmFile);
		//-------------------End Menu component declarations----------------//

		
		//sets the layout for the panels and frames
		frame.setLayout(new BorderLayout());
		frame.setJMenuBar(jmb);
		frame.add(djPanel, BorderLayout.CENTER);
		frame.add(new JLabel(new ImageIcon("a1.jpg")), BorderLayout.WEST);
		JPanel title = new JPanel();
		title.add(new JLabel("<html>DJ Emporium<br><br></html>",10));
		frame.add(title, BorderLayout.NORTH);
		frame.add(new JLabel(new ImageIcon("a3.jpg")), BorderLayout.SOUTH);
		frame.add(new JLabel(new ImageIcon("a6.jpg")), BorderLayout.EAST);
		
		
		
		frame.setVisible(true);

		//button declaration
		add.addActionListener(this);
		jmiOpen.addActionListener(this);
		jmiClose.addActionListener(this);
		jmiExit.addActionListener(this);
		jmiSave.addActionListener(this);
		sell.addActionListener(this);


	}
	
	//defines what happens when certain button were pressed
	public void actionPerformed(ActionEvent ae){
		
		//stores the button pressed
		String currentPressed= ae.getActionCommand();
		
		//add button control
		if(currentPressed.equals("Add")){
			if(artistText.getText().equals("") || albumText.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Cannot Add CD", "ERROR", JOptionPane.ERROR_MESSAGE);
			else{
				try{
					CDs c = new CDs(Integer.parseInt(skuText.getText()),artistText.getText(), albumText.getText(), Integer.parseInt(quantityText.getText()), Double.parseDouble(priceText.getText()));
					inv.addCD(c);
					JOptionPane.showMessageDialog(null, "CD added succesfully", "Added", JOptionPane.PLAIN_MESSAGE);
					skuText.setText("");
					artistText.setText("");
					albumText.setText("");
					quantityText.setText("");
					priceText.setText("");
					
					//show that the file has not been saved
					if(frame.getTitle().indexOf('*') == -1)
						frame.setTitle("*"+frame.getTitle());
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Cannot Add CD", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				update();
			}
		}
		
		//open button control
		if(ae.getActionCommand().equals("Open")){
			inv.getFile();
			frame.setTitle("DJStore --- " + inv.getFileName());
			update();
		}
		
		//sell button control
		if(ae.getActionCommand().equals("Sell")){
			inv.sellCD(sellList.getSelectedIndex(),(Integer.parseInt(sellText.getText())));
			update();
		}
		
		//save button control
		if(ae.getActionCommand().equals("Save")){
			inv.saveFile();
		}
		
		//close button control
		if(ae.getActionCommand().equals("Close")){
			if(frame.getTitle().indexOf('*') != -1){
				String message = "Do you want to save?";
				String title = "WARNING";
				                                          
				int answer = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				                                          
				if (answer == JOptionPane.YES_OPTION)
					inv.saveFile();
			}
			invD.setText("");
			inv = new DJInventory();
			frame.setTitle("DJStore --- No File Loaded");
		}
		
		//exit button control
		if(ae.getActionCommand().equals("Exit")){
			if(frame.getTitle().indexOf('*') != -1){
				String message = "Do you want to save?";
				String title = "WARNING";
				                                          
				int answer = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				                                          
				if (answer == JOptionPane.YES_OPTION)
					inv.saveFile();
			}
			System.exit(0);
		}

	}//end actionPerformed
	
	//Updates the different inventories
	private void update(){
		
		invD.setText(disDefault+inv+"</table></html>");
		sellList.setListData(inv.getList());
		
	}//end update
	
	public static void main(String[] args) {
		
		DJGUI t = new DJGUI();
		
	}
}
