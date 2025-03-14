/*
 * Name: Lavneet Singh
 * Date: May 15, 2022
 * Project: SDP 1
 * Description: This class shows the user what they chose
 */

//Import necessary libraries
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Start of class
@SuppressWarnings("serial")
public class ResultsReviewFrame extends JFrame implements ActionListener {
	
	
	//Variables - Variables above a method is called "Instance Variables" of "Fields"
	//Background image upload/ declaration
	JLabel background = new JLabel(new ImageIcon("data/background.png"));
	
	//Rescale image
	ImageIcon laptopImage = new ImageIcon("data/"+LaptopStoreApplication.userChoice.getNumber()+".png"); 
	Image laptopImageCasted = laptopImage.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT); 
	JLabel newLaptopImage = new JLabel(new ImageIcon(laptopImageCasted));
		 
	//GUI Objects
	//JLabels
	//Titles
	JLabel title = new JLabel("Review Order:");
	JLabel yourInfo = new JLabel("Your Information:");
	JLabel name = new JLabel("Name:");
	JLabel address = new JLabel("Address:");
	JLabel yourCart = new JLabel("Your Cart:");
	JLabel laptopName = new JLabel("Laptop:");
	JLabel specs = new JLabel("Specifications:");
	JLabel OGprice = new JLabel("Price:");
	JLabel tax = new JLabel("Tax:");
	JLabel total = new JLabel("Total:");
	
	//Data for each section under titles
	JLabel nameData = new JLabel(LaptopSurveyFrame.answerArray[0] + " "+LaptopSurveyFrame.answerArray[1]);
	JLabel addressData = new JLabel(LaptopSurveyFrame.answerArray[2]);
	JLabel laptopNameData = new JLabel(LaptopStoreApplication.userChoice.getBrand()+"  -  "+LaptopStoreApplication.userChoice.getLaptopModel());
	JLabel specsData = new JLabel("<html>"+LaptopStoreApplication.userChoice.getBrandCPU() +"  -  " + LaptopStoreApplication.userChoice.getModelCPU() + ", <br/>" + LaptopStoreApplication.userChoice.getStorage() 
			+ " GB, " + LaptopStoreApplication.userChoice.getSystem() + LaptopStoreApplication.userChoice.getSystem() +"\" " +"<br/>"+"Overall Rating: "+ LaptopStoreApplication.userChoice.getOverallRating()
			+"<br/>"+ LaptopStoreApplication.userChoice.getWeight()+"lbs, "+" Type: "+LaptopStoreApplication.userChoice.getType()+"<html>");
	JLabel OGpriceData = new JLabel("$"+LaptopStoreApplication.userChoice.getPrice());
	JLabel taxData = new JLabel("$"+(double)Math.round((LaptopStoreApplication.userChoice.getPrice()*0.13)*100)/100);
	JLabel totalData = new JLabel("$"+ (double)Math.round((LaptopStoreApplication.userChoice.getPrice()*1.13)*100)/100);
	
	//Buttons
	JButton exitButton = new JButton("Exit");
	JButton PlaceOrderButton = new JButton("Place Order");
	JButton backButton = new JButton("Back");
	

	//Constructor method - line that runs after the first class runs this class
	public ResultsReviewFrame() {
		
		//Sets the size and title of the panel/frame
		setSize(1920,1080);
		setTitle("Review Order frame");
	
		
		
		//Setup buttons
		//Sets position(location x, location y, width x, length y)
		exitButton.setBounds(1700, 75, 100, 100);
		
		//sets font and size
		exitButton.setFont(new Font("Serif", Font.PLAIN, 35));
		
		//Has the program listen to any actions performed by the button
		exitButton.addActionListener(this);
		
		//Adds the GUI object to the screen
		add(exitButton);
		
		PlaceOrderButton.setBounds(1600, 825, 225, 100);
		PlaceOrderButton.setFont(new Font("Serif", Font.PLAIN, 35));
		PlaceOrderButton.addActionListener(this);
		add(PlaceOrderButton);
		
		backButton.setBounds(125, 850, 125, 100);
		backButton.setFont(new Font("Serif", Font.PLAIN, 35));
		backButton.addActionListener(this);
		add(backButton);
		
		//Setup title labels
		yourInfo.setBounds(300, 175, 400, 50);
		yourInfo.setFont(new Font("Serif", Font.PLAIN, 36));
		add(yourInfo);
		
		name.setBounds(300, 250, 600, 50);
		name.setFont(new Font("Serif", Font.PLAIN, 32));
		add(name);
		
		address.setBounds(300, 400, 600, 50);
		address.setFont(new Font("Serif", Font.PLAIN, 32));
		add(address);
		
		yourCart.setBounds(1160, 175, 600, 50);
		yourCart.setFont(new Font("Serif", Font.PLAIN, 36));
		add(yourCart);
		
		laptopName.setBounds(1160, 250, 600, 50);
		laptopName.setFont(new Font("Serif", Font.PLAIN, 32));
		add(laptopName);
		
		specs.setBounds(1160, 400, 600, 50);
		specs.setFont(new Font("Serif", Font.PLAIN, 32));
		add(specs);
		
		OGprice.setBounds(1160, 750, 125, 50);
		OGprice.setFont(new Font("Serif", Font.PLAIN, 32));
		add(OGprice);
		
		tax.setBounds(1160, 800, 125, 50);
		tax.setFont(new Font("Serif", Font.PLAIN, 32));
		add(tax);
		
		total.setBounds(1160, 850, 125, 50);
		total.setFont(new Font("Serif", Font.PLAIN, 32));
		add(total);
		
		
		//Setup data labels
		nameData.setBounds(300, 300, 600, 50);
		nameData.setFont(new Font("Serif", Font.PLAIN, 32));
		add(nameData);
		
		addressData.setBounds(300, 450, 600, 50);
		addressData.setFont(new Font("Serif", Font.PLAIN, 32));
		add(addressData);
		
		laptopNameData.setBounds(1160, 300, 600, 50);
		laptopNameData.setFont(new Font("Serif", Font.PLAIN, 32));
		add(laptopNameData);
		
		specsData.setBounds(1160, 450, 600, 275);
		specsData.setFont(new Font("Serif", Font.PLAIN, 32));
		add(specsData);
		
		OGpriceData.setBounds(1300, 750, 200, 50);
		OGpriceData.setFont(new Font("Serif", Font.PLAIN, 32));
		add(OGpriceData);
		
		taxData.setBounds(1300, 800, 200, 50);
		taxData.setFont(new Font("Serif", Font.PLAIN, 32));
		add(taxData);
		
		totalData.setBounds(1300, 850, 200, 50);
		totalData.setFont(new Font("Serif", Font.PLAIN, 32));
		add(totalData);
		
		//Setup Laptop image
		newLaptopImage.setBounds(300, 600, 250, 200);
		add(newLaptopImage);
		
		//Sets the title
		title.setBounds(785, 75, 350, 100);
		title.setFont(new Font("Serif", Font.PLAIN, 50));
		add(title);
		
		//Adds the background
		add(background);
		
		
		//Setup frame itself(the entire thing)
		setVisible(true);
		
		//Sets a default operation if the user closes the window(terminates program)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	//This method handles the action or actions performed by the user while the application is running
	public void actionPerformed(ActionEvent event) {
		// Write instructions for the button(s)
		
		//Determine source of the action
		if(event.getSource()==exitButton) {
			//closes the window and terminates the program if exit button is clicked
			System.exit(DISPOSE_ON_CLOSE);	
			
			
		}else if (event.getSource()==backButton) {
			//Back button goes to the title frame and makes this frame invisible
			
			if (LaptopStoreApplication.previousFrame.equals("Survey")) {
				
				ResultsFrame results = new ResultsFrame();
				
			}
			
			else {
				
				InventoryFrame inventory = new InventoryFrame();
				inventory.setVisible(true);
				
			}
			
			this.setVisible(false);
				
			
			
		}else if (event.getSource()==PlaceOrderButton) {
			//place order button goes to the next frame and makes this frame invisible
			this.setVisible(false);
			ResultsEndFrame resultsFrame = new ResultsEndFrame();
		}
			
	}//End of action performed method 

}//End of class
