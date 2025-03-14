//When using graphics into programs, swing packages are recommended. Java FX packages are ideal too
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/*

Name: Kenneth Hu
Group 5; Lavneet Signh, Christina Huang, Jeffery Ma
Date: May 18th 2022
Date of Submission: May 18th 2022
Course Code: ICS3U1-03 Mr.Fernandes
Title: Laptop Education GUI Frame

Description: The program educates the user about the corollary components of laptops, and if they choose so, 
	they can learn more about the components, or know what is the best of the component

Major Skills: swing GUI (JButton, Jframe, ScrollPane, JLabel), HTML Text Display manipulation (<HTML> and <br/>(used for new lines))

Added Features: List of features that you want others to notice 
	(you can add notes besides these to inform readers about partial solutions/issues)
	Type ‘none’ if there is nothing to indicate

Areas of Concern: there is the concern of faults with the projection of the image and the components depending on the settings of the computer running
	the program. They are attuned to operate as though the computer is running at 1920 by 1080 pixels, but anything less or more, I fear will ruin the
	experience.  

	Contribution to Assignment
		Education Screen and Application Class for the Project
		Background image used by the programs everyone else in my group use
	Student Name: Kenneth Hu
	Which Java file did you contribute to completing assignment?
		JCKLEducationApp, JCKLEducationFrame, and LaptopStoreApplication
	Which methods you completed?
		JCKLEducationFrame, and LaptopStoreApplication
	What percentage (%)of the work on this page you completed?
		90%, 10% were assisted by other sources such as teacher and teammates
		
*/


	@SuppressWarnings("serial")
	public class JCKLEducationFrame extends JFrame implements ActionListener{
		//importing image files from separate file in the project called images
		//will require you to make the label an ImageIcon method
		JLabel backgroundLabel = new JLabel(new ImageIcon("data/images/Education background.png"));
		
		//GUI Objects
		//Scrollbar GUI component
		JScrollPane scrollPane = new JScrollPane();
		
		//Return to main page/Title frame
		JButton backSpace = new JButton ("Back");
		
		//Go to the store, or to the survey page
		JButton surveyPage = new JButton ("To Survey Page");
		JButton shopPage = new JButton ("To Store Page");
		
		//component/characteristic icon to easily have the user recognize what the component is
		JLabel presentationEntityOne = new JLabel (new ImageIcon("data/images/RAM.Icon.png"));
		JLabel presentationEntityTwo = new JLabel (new ImageIcon("data/images/Memory.Icon.png"));
		JLabel presentationEntityThree = new JLabel (new ImageIcon("data/images/Size.Icon.png"));
		JLabel presentationEntityFour = new JLabel (new ImageIcon("data/images/OS.Icon.png"));
		JLabel presentationEntityFive = new JLabel (new ImageIcon("data/images/Touchscreen.Icon.png"));
		JLabel presentationEntitySix = new JLabel (new ImageIcon("data/images/USB.Icon.png"));
		JLabel presentationEntitySeven = new JLabel (new ImageIcon("data/images/CPU.Icon.png"));
		
		//Information page
		//RAM information
		JLabel informationEntityOne = new JLabel ("<html>RAM<br/><br/>"
				+ "RAM stands for random-access memory, is essentially short term memory where data is stored as the processor needs it."
				+ "<br/>Not to be confused with long-term data that's stored on your hard drive, which stays there even when your computer is turned off."
				+ "<br/><br/>4 gigabyte: Recommended for web browsing and low-intensity productivity applications such as Microsoft,"
				+ "<br/>8 gigabyte: Recommended for entry-level gaming, graphic design, programming,"
				+ "<br/>16 gigabyte: Recommended for high-end gaming, video editing, streaming,"
				+ "<br/>32 gigabyte: Recommended for editing high resolution videos, modelling 3D environments, machine learning, and processing large amounts of data,"
				+ "<html>");
		
		//Memory/storage information
		JLabel informationEntityTwo = new JLabel ("<html>Memory<br/><br/>"
				+ "Device that is used to store data or programs (sequences of instructions) on a temporary or permanent basis "
				+ "for use in an electronic digital computer."
				+ "<br/>Computers represent information in binary code, written as sequences of 0s and 1s."
				+ "<br/><br/>128 gigabyte: Recommended for users with a limited number of applications and media,"
				+ "<br/>256 gigabyte: Recommended for users with light media, games, and videos,"
				+ "<br/>512 gigabyte: Recommended for users with moderate media, games, and videos,"
				+ "<br/>1 terabyte, or more: Recommended for users with massive media or game libraries,"
				+ "<br/><br/>Note: An external hard drive can be used to store collections of photos, music and videos,"
				+ "<html>");
		
		//Size of the laptop information
		JLabel informationEntityThree = new JLabel ("<html>Size<br/><br/>"
				+ "Laptops are designed to be portable, but their portability depends on the size and weight of the device."
				+ "<br/><br/>13 inches and under: Extremely portable, lightweight, thin, limited readability and processing power,"
				+ "<br/>13 inches to 14 inches: Portable and usable, relatively smaller display size,"
				+ "<br/>14 inches to 16 inches: Lower portability, good display size and readability,"
				+ "<br/>17 inches to 18 inches: Limited portability, strong processing power, large screen size,"
				+ "<html>");
		
		//Operating system information
		JLabel informationEntityFour = new JLabel ("<html>OS<br/><br/>"
				+ "The software that supports a computer's basic functions, such as scheduling tasks, "
				+ "<br/><br/>executing applications, and controlling peripherals. It manages computer hardware, "
				+ "<br/>software resources, and provides common services for computer programs"
				+ "<br/>Microsoft Windows:  Best for Apps, Browsing, Personal Use, Gaming,"
				+ "<br/>Mac OS: Best for Apple-exclusive Apps, Dynamic Desktop,"
				+ "<br/>Chrome OS: Best for Web applications,"
				+ "<br/>Linux-based OS: Best for Business Entreprises,"
				+ "<html>");
		
		//Touchscreen information
		JLabel informationEntityFive = new JLabel ("<html>Touchscreen<br/><br/>"
				+ "A touchscreen or touch screen is the assembly of both an input and output device. "
				+ "<br/>The touch panel is normally layered on the top of an electronic visual display of an information processing system."
				+ "<br/><br/>Recommended for graphic designers, artists, and digital note-taking,"
				+ "<html>");
		
		//Laptop ports for the laptop information
		JLabel informationEntitySix = new JLabel ("<html>Ports<br/><br/>"
				+ "In computer hardware, a port serves as an interface between the computer and other computers or peripheral devices. "
				+ "<br/>In computer terms, a port generally refers to the part of a computing device available for "
				+ "<br/>connection to peripherals such as input and output devices."
				+ "<br/><br/>When choosing what ports on a laptop you want, as what external devices do you plan on connecting to your laptop?"
				+ "<br/>Note: If a laptop does not have a specific port, an adapter can be used to connect the device to the laptop,"
				+ "<html>");
		
		//CPU information
		JLabel informationEntitySeven = new JLabel ("<html>CPU<br/><br/>"
				+ "A central processing unit, also called a central processor, main processor or just processor, is the electronic "
				+ "circuitry that executes instructions comprising a computer program. "
				+ "<br/>The CPU performs basic arithmetic, logic, controlling, and input/output operations specified by the instructions in the program."
				+ "<br/><br/>Single Core: Oldest CPU available. Capable of carrying out certain tasks, but it was a bit slow,"
				+ "<br/>Dual Core: Capable of multitasking more comfortably and much better than processors that have only one core,"
				+ "<br/>Quad Core: Capable of performing any task for which it has been intended, at high speed, and above all, performing several tasks at the same time,"
				+ "<br/>Hexa Core: Capable of multitasking with its working speed, clock speed, performance will be faster,"
				+ "<br/>Octa Core: Capable of separating various activities between the different sorts that’s why it is also known as a “dual quad-core processor,“"
				+ "<br/>Deca Core: Capable of executing a task will be much efficient and rapid than all the core processors until now. "
				+ "<br/>It is the most powerful and successful CPU than the above CPU processors for any computer device,"
				+ "<html>");
		
	//constructor method
		public JCKLEducationFrame(){
			
			//JLabel, Application Screen, and Application Naming
			setSize(1920,1080);
			setTitle("JCKL Education Page v.1");
			setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			
			//Adding the background image as the background
			//named BackgroundLabel
			//add(backgroundLabel);
		
			//allowing GUI objects to be added onto the screen
			backgroundLabel.setLayout(null);
			
			//setup the numbers to be input
			//bounds being (x,y,width of entity,height of entity), origin of the frame being the top left corner
			
			//so the program exits back to the title frame
			backSpace.setBounds(10,10,75,75);
			backSpace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			backSpace.addActionListener(this);
			backgroundLabel.add(backSpace);
			
			//so the program exits to the survey frame
			surveyPage.setBounds(960,2500,910,100);
			surveyPage.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			surveyPage.addActionListener(this);
			backgroundLabel.add(surveyPage);
			
			//so the program exits to the shopping page
			shopPage.setBounds(25,2500,910,100);
			shopPage.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			shopPage.addActionListener(this);
			backgroundLabel.add(shopPage);
			
			//First Space reserved for the RAM component
			presentationEntityOne.setBounds(100,50,300,300);
			backgroundLabel.add(presentationEntityOne);
			informationEntityOne.setBounds(450,50,3000,300);
			informationEntityOne.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			backgroundLabel.add(informationEntityOne);

			//Second Space reserved for the Storage/Memory component
			presentationEntityTwo.setBounds(100,400,300,300);
			backgroundLabel.add(presentationEntityTwo);
			informationEntityTwo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			informationEntityTwo.setBounds(450,400,3000,300);
			backgroundLabel.add(informationEntityTwo);
			
			//Third Space reserved for the Size of the laptop
			presentationEntityThree.setBounds(100,750,300,300);
			backgroundLabel.add(presentationEntityThree);
			informationEntityThree.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			informationEntityThree.setBounds(450,750,3000,300);
			backgroundLabel.add(informationEntityThree);
			
			//Fourth Space reserved for the Operating System component
			presentationEntityFour.setBounds(100,1100,300,300);
			backgroundLabel.add(presentationEntityFour);
			informationEntityFour.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			informationEntityFour.setBounds(450,1100,3000,300);
			backgroundLabel.add(informationEntityFour);
			
			//Fifth Space reserved for the Touchscreen component
			presentationEntityFive.setBounds(100,1450,300,300);
			backgroundLabel.add(presentationEntityFive);
			informationEntityFive.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			informationEntityFive.setBounds(450,1450,3000,300);
			backgroundLabel.add(informationEntityFive);
			
			//Sixth Space reserved for the Ports of the Laptop
			presentationEntitySix.setBounds(100,1800,300,300);
			backgroundLabel.add(presentationEntitySix);
			informationEntitySix.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			informationEntitySix.setBounds(450,1800,3000,300);
			backgroundLabel.add(informationEntitySix);
			
			//Seventh Space reserved for the CPU component
			presentationEntitySeven.setBounds(100,2150,300,300);
			backgroundLabel.add(presentationEntitySeven);
			informationEntitySeven.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			informationEntitySeven.setBounds(450,2150,3000,300);
			backgroundLabel.add(informationEntitySeven);
			
			//Scroll Bar of the frame (note to self: scrollbar is tied to the resolution of the JLabel image. Just manipulate the dimensions of the image dimensions)
			scrollPane.setViewportView(backgroundLabel);
			add(scrollPane);

			//adding so it actually shows up
	        setVisible(true);
		
	}

		@Override
		public void actionPerformed(ActionEvent event) {
			/*
			
			note to self: this is frame-changing buttons 101
			1. make the current frame invisible when pressed (this.setVisible(false)
			2. set up a new method that presents the desired class/frame you want to see
			3. set the desired class/frame visible using the variable established for the desired class/frame
			
			 */
			
			if (event.getSource() == backSpace) {				
				
				LaptopStoreTitleFrame titleFrame = new LaptopStoreTitleFrame();
				titleFrame.setVisible(true);
				this.setVisible(false);
				
		}
			
			if (event.getSource() == surveyPage) {				
				

				LaptopSurveyFrame surveyPage = new LaptopSurveyFrame();
				surveyPage.setVisible(true);
				this.setVisible(false);
				
		}
			
			if (event.getSource() == shopPage) {				
				
				InventoryFrame shopPage = new InventoryFrame();
				shopPage.setVisible(true);
				this.setVisible(false);
				
		}


	}
}