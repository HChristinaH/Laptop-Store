/*
 * Name: Lavneet Singh
 * Date: May 15, 2022
 * Project: SDP 1
 * Description: This class Asks the user to choose an option from the three options found
 */

//Import necessary libraries
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

//Start of class
@SuppressWarnings("serial")
public class ResultsFrame extends JFrame implements ActionListener {
	
	
	//Instance Variables - Variables above a method is called "Instance Variables" of "Fields"
	//Background image upload/ declaration
	JLabel background = new JLabel(new ImageIcon("data/images/background.png"));
	
	//GUI Objects
	//JLabels
	JLabel Blankmessagelabel = new JLabel(); // This is a blank Jlabel behind everything in the middle as the warning message needs to take the place of an object
	JLabel title = new JLabel("Results:");
	JLabel selectAnswerLabel = new JLabel("Please select the laptop you want to buy:");
	
	//Buttons
	JButton exitButton = new JButton("Exit");
	JButton continueButton = new JButton("Continue");
	JButton backButton = new JButton("Back");
	
	//Radio buttons(the options)
	JRadioButton option1 = new JRadioButton("<html>Laptop:<br/>"+findChoices.finalLaptops[0].getBrand()+"  "+findChoices.finalLaptops[0].getLaptopModel()
			+"<br/><br/>"+"Specs:" +"<br/>" +findChoices.finalLaptops[0].getBrandCPU() +"  -  " + findChoices.finalLaptops[0].getModelCPU() + ", <br/>" + findChoices.finalLaptops[0].getStorage() 
			+ " GB, " + findChoices.finalLaptops[0].getSystem()+", " + findChoices.finalLaptops[0].getDisplay() +"\" " +"<br/>"+"Overall Rating: "+ findChoices.finalLaptops[0].getOverallRating()+
			"<br/><br/>Price: $"+findChoices.finalLaptops[0].getPrice()+"<html>");
	
	JRadioButton option2 = new JRadioButton("<html>Laptop:<br/>"+findChoices.finalLaptops[1].getBrand()+"  "+findChoices.finalLaptops[1].getLaptopModel()
			+"<br/><br/>"+"Specs:" +"<br/>" +findChoices.finalLaptops[1].getBrandCPU() +"  -  " + findChoices.finalLaptops[1].getModelCPU() + ", <br/>" + findChoices.finalLaptops[1].getStorage() 
			+ " GB, " + findChoices.finalLaptops[1].getSystem()+", " + findChoices.finalLaptops[1].getDisplay() +"\" " +"<br/>"+"Overall Rating: "+ findChoices.finalLaptops[1].getOverallRating()+
			"<br/><br/>Price: $"+findChoices.finalLaptops[1].getPrice()+"<html>");
	
	JRadioButton option3 = new JRadioButton("<html>Laptop:<br/>"+findChoices.finalLaptops[2].getBrand()+"  "+findChoices.finalLaptops[2].getLaptopModel()
			+"<br/><br/>"+"Specs:" +"<br/>" +findChoices.finalLaptops[2].getBrandCPU() +"  -  " + findChoices.finalLaptops[2].getModelCPU() + ", <br/>" + findChoices.finalLaptops[2].getStorage() 
			+ " GB, " + findChoices.finalLaptops[2].getSystem()+", " + findChoices.finalLaptops[2].getDisplay() +"\" " +"<br/>"+"Overall Rating: "+ findChoices.finalLaptops[2].getOverallRating()+
			"<br/><br/>Price: $"+findChoices.finalLaptops[2].getPrice()+"<html>");
	//Button group (makes sure only one radio button is selected at a time)
	ButtonGroup optionGroup = new ButtonGroup(); 
	
	
	//Constructor method - line that runs after the first class runs this class
	public ResultsFrame() {
		
		//Sets the size and title of the panel/frame
		setSize(1920,1080);
		setTitle("Choose option frame");
	
		//Sets the bounds of the blank label made for the warning message
		Blankmessagelabel.setBounds(960, 540, 5, 5);
		add(Blankmessagelabel);
		

		//Sets the radio buttons
		//Sets position(location x, location y, width x, length y)
		option1.setBounds(200, 275, 500, 450); 
		
		//sets font and size
		option1.setFont(new Font("Serif", Font.PLAIN, 30));
		
		//Makes background clear
		option1.setOpaque(false);
		
		//Adds a custom action to each button
		option1.setActionCommand("1");
		
		//Adds the GUI object to the screen
		add(option1); 
		
		option2.setBounds(750, 275, 500, 450); 
		option2.setFont(new Font("Serif", Font.PLAIN, 30));
		option2.setOpaque(false);
		option2.setActionCommand("2");
		add(option2); 
		
		option3.setBounds(1300, 275, 500, 450); 
		option3.setFont(new Font("Serif", Font.PLAIN, 30));
		option3.setOpaque(false);
		option3.setActionCommand("3");
		add(option3); 
		
		//Adds the radio buttons to the button group
		optionGroup.add(option1); 
		optionGroup.add(option2); 
		optionGroup.add(option3); 


		//Setup buttons
		exitButton.setBounds(1700, 75, 100, 100);
		exitButton.setFont(new Font("Serif", Font.PLAIN, 35));
		
		//Has the program listen to any actions performed by the button
		exitButton.addActionListener(this);
		add(exitButton);
		
		continueButton.setBounds(1600, 850, 200, 100);
		continueButton.setFont(new Font("Serif", Font.PLAIN, 35));
		continueButton.addActionListener(this);
		add(continueButton);
		
		backButton.setBounds(125, 850, 125, 100);
		backButton.setFont(new Font("Serif", Font.PLAIN, 35));
		backButton.addActionListener(this);
		add(backButton);
		
		
		//Setup "please select" question
		selectAnswerLabel.setBounds(125, 175, 850, 50);
		selectAnswerLabel.setFont(new Font("Serif", Font.PLAIN, 38));
		add(selectAnswerLabel);
		
		//Sets the title
		title.setBounds(860, 75, 200, 50);
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
		
		//If exit button is clicked, terminate the program 
		if(event.getSource()==exitButton) {
			System.exit(DISPOSE_ON_CLOSE);
			
		}else if (event.getSource()==continueButton) {//If continue button is clicked, hide this frame and open up the next class(with the next frame)
			
			//Make sure at least one of the radio buttons is selected
			if (option1.isSelected() || option2.isSelected() || option3.isSelected()) {
				
				//Assigns the user final choice depending on the button selected
				if (optionGroup.getSelection().getActionCommand()=="1") {
					LaptopStoreApplication.userChoice = findChoices.finalLaptops[0];
					
					
				}else if (optionGroup.getSelection().getActionCommand()=="2") {
					LaptopStoreApplication.userChoice = findChoices.finalLaptops[1];
					
				}else if (optionGroup.getSelection().getActionCommand()=="3") {
					LaptopStoreApplication.userChoice = findChoices.finalLaptops[2];
					
				}
				//Hide this frame and go to the next frame
				this.setVisible(false);
				@SuppressWarnings("unused")
				ResultsReviewFrame reviewOrder = new ResultsReviewFrame();
	
			}
			
			
		}else if (event.getSource()==backButton) { //If back button is clicked, hide this frame and open up the previous frame
			
			//Shows an error message
			JOptionPane.showMessageDialog(Blankmessagelabel, "Warning, You are about to lose your selection!", "Warning Message", JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			LaptopStoreApplication.titleFrame.setVisible(true);
		}
			
	}//End of action performed method

}//End of class
