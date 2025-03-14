/*

Name: Kenneth Hu
Group 5; Lavneet Singh, Christina Huang, Jeffrey Ma
Date: May 16th 2022
Date of Submission: 
Course Code: ICS3U1-03 Mr.Fernandes
Title: Laptop Application Class

Description: It is a program that makes it so the other programs can run at all. No pressure. It's not like everything is in shambles in I screw up. 
	Just have it store the information given by LaptopStoreFileInput to Laptop, 
	//and have Laptop feed into LaptopStoreTitleFrame

Major Skills: Referencing other classes within the project folder

Added Features: referencing data from other classes within the project folder

Areas of Concern: The potential of there being a fault in the referencing of data from File Input class, the organization of the Laptop class, and
	sending the data formated by the Laptop class to the Title Frame Class, and from Title Frame to everywhere else. It is the most central piece of 
	code from the piece of the project, after all; without it, the whole thing is gone.

	Contribution to Assignment:
		Kenneth: 
			LaptopStoreApplication		-	60%
			JCKLEducationFrame  		-	100%
			
		Christina: 
			InventoryFrame				-	100%
			LaptopStoreTitleFrame		-	100%
			
		Jeffrey: 
			Laptop						-	100%
			LaptopSurveyFrame			-	90%
			
		Lavneet: 
			FileInput					-	100%
			ResultsFrame				-	100%
			ResultsReviewFrame			-	100%
			ResultsEndFrame				-	100%
			LaptopStoreApplication		-	40%
			LaptopSurveyFrame			-	10%
			

	Student Name: Kenneth Hu
	Which Java file did you contribute to completing assignment?
		JCKLEducationApp, JCKLEducationFrame, and LaptopStoreApplication
	Which methods you completed?
		JCKLEducationFrame, and LaptopStoreApplication
		
*/

public class LaptopStoreApplication {

	// public variables required to run the application class
	public static Laptop[] laptopArray = new Laptop[40];
	public static FileInput fillLaptopArray = new FileInput();
	static Laptop userChoice;
	static String previousFrame;

	// Class declarations and initializations
	public static LaptopStoreTitleFrame titleFrame = new LaptopStoreTitleFrame();

	public static void main(String[] args) {

		// note to self: if LaptopStoreTitleFrame is there, and the object of
		// laptopArray there is, logically, no need for lines of other classes
		// the variables make it so that we can reference the variables with ease, and
		// with little to no hassle. There is only the titleframe becoming visible run
		// the whole thing

		// makes the title frame show up at all
		titleFrame.setVisible(true);

	}

}