/*
 * Name: Lavneet Singh
 * Date: May 15, 2022
 * Project: SDP 1
 * Description: This class calculates the top three choices for the user
 */

//Start of class
public class findChoices {			
	
	//Declare different types of laptops for step of the determining process
	static Laptop[] displayLaptops = new Laptop[40];
	static Laptop[] typeLaptops = new Laptop[40];
	static Laptop[] priceLaptops = new Laptop[40];
	static Laptop[] extraLaptops1 = new Laptop[40];
	static Laptop[] extraLaptops2 = new Laptop[40];
	static Laptop[] finalLaptops = new Laptop[40];
	
	//Start of choice-determining method
	public static void determineChoices() {
		
		//Iterates through each of the 40 original laptops to find the ones that match the display given by the user
		//Counter ensures that chosen laptops are at the front of the new array and stores the number of them 
		int counter = 0;
		for (int i = 0; i<40; i++) {
			//Checks that the display of the laptop is plus or minus on of the user's choice
			if (Double.parseDouble(LaptopSurveyFrame.answerArray[3]) >= LaptopStoreApplication.laptopArray[i].getDisplay()-1 
					&& Double.parseDouble(LaptopSurveyFrame.answerArray[3]) <= LaptopStoreApplication.laptopArray[i].getDisplay()+1) {
				//Stores variables
				displayLaptops[counter] = LaptopStoreApplication.laptopArray[i];
				
				//Increment counter
				counter++;
			}
		}	
		
		//Iterates through all of the laptops that match the display to narrow down options 
		//Counter ensures that chosen laptops are at the front of the new array and stores the number of them 
		int counter2 = 0;
		
		for (int i = 0; i<counter; i++) {
			//Checks if any of the narrowed down laptops also have the right laptop type chosen by the user
			if (displayLaptops[i].getType().equals(LaptopSurveyFrame.answerArray[4])) {
				
				//Store laptop
				typeLaptops[counter2] = displayLaptops[i];
				
				//increment counter
				counter2++;
				
			}		
		}
		
		//Creates a minimum and maximum price value based on user selection
		int minValue;
		int maxValue;
		if (LaptopSurveyFrame.answerArray[5].equals("Budget")) {
			minValue = 0;
			maxValue = 500;
		}else if (LaptopSurveyFrame.answerArray[5].equals("Mid")) {
			minValue = 500;
			maxValue = 1000;
		}else if (LaptopSurveyFrame.answerArray[5].equals("Highend")) {
			minValue = 1000;
			maxValue = 2000;
		}else {
			minValue = 2000;
			maxValue = 100000;
		}
		
		//Counter used once more to ensure laptops are at the front of the array and stores the number of them
		int counter3 = 0;
		
		//Checks if the laptops that match the type description and display description also match the price outlined by the user to find the 
		//more best fitted laptop based on the user's prefernces
		for (int i = 0; i<counter2; i++) {
			
			//Check if laptop price for each of the laptops in within the price range
			if (typeLaptops[i].getPrice()>=minValue && typeLaptops[i].getPrice()<maxValue) {
				
				//Store variable
				priceLaptops[counter3] = typeLaptops[i];
				
				//increment counter
				counter3++;
				
			}		
		}
		
		//As a second resort, if there are not 3 laptops that match all three user decriptions, checks if there are laptops that match just 
		//the display and the price, and not the type
		int counter4 = 0;
		if(counter3<3) {
			
			//Test variable used to reference if the laptop in question is the same as any of the ones already chosen
			int testVar=0;
			
			//iterates through all 40 original laptops
			for (int i = 0; i<counter; i++) {
				
				//iterates through all laptops in the priceLaptops array
				for (int n=0;n<counter3;n++) {
					if (displayLaptops[i]==priceLaptops[n]) {
						testVar = 1;
					}
				}
				
				//If the laptop does not already exist, check if both the display and the price are true to the user's choice
				if (testVar ==0){
					if (displayLaptops[i].getPrice()>=minValue && displayLaptops[i].getPrice()<maxValue) {
						extraLaptops1[counter4] = displayLaptops[i];
						counter4++;
						
					}	
				}
			}
		}
		
		
		//3rd resort if the combined total of the ideal laptop and the display+price laptops is less than 3
		//Counter stores number of new laptops that match the description
		int counter5 = 0;
		if(counter3+counter4<3) {
			
			//Test variable used to reference if the laptop in question is the same as any of the ones already chosen
			int testVar=0;
			
			//iterates through all 40 original laptops
			for (int i = 0; i<40; i++) {
				for (int n=0;n<counter3;n++) {
					//iterates through all laptops in the priceLaptops array
					if (LaptopStoreApplication.laptopArray[i]==priceLaptops[n] ) {
						testVar = 1;
					}
				}
				for (int n=0;n<counter4;n++) {
					//iterates through all laptops in the extraLaptops1 array
					if ( LaptopStoreApplication.laptopArray[i]==extraLaptops1[n]) {
						testVar = 1;
					}
				}
				
				//If the laptop does not already exist, check if both the type and the price are true to the user's choice
				if (testVar ==0){
					if (LaptopStoreApplication.laptopArray[i].getType().equals(LaptopSurveyFrame.answerArray[4])) {
						if (LaptopStoreApplication.laptopArray[i].getPrice()>=minValue && LaptopStoreApplication.laptopArray[i].getPrice()<maxValue) {
							extraLaptops2[counter5] = LaptopStoreApplication.laptopArray[i];
							counter5++;
						}	
					}	
				}
			}
		}
		
		//Assign values to the final laptops array
		
		//Initiates the values of the first 10 laptops to ensure that there is always at least something that meets one of the user's choice
		// by selects the 10 laptops that fit in the price catagory selected
		
		//counter ensures the laptops are at the front
		int p =0;
		for(int i = 0; i<40; i++) {
			
			//Check argument
			if (LaptopStoreApplication.laptopArray[i].getPrice()>=minValue && LaptopStoreApplication.laptopArray[i].getPrice()<=maxValue) {
				
				//Store data
				finalLaptops[p] = LaptopStoreApplication.laptopArray[i];
				
				//Increment counter
				p++;
			}
		}
		
		//Reassigns the very front of the array into the ideal choices if any exist, as they are the best choices
		if (counter3>0) {
			for (int i = 0; i<counter3; i++) {
				finalLaptops[i] = priceLaptops[i];
			}
		}
		
		//Reassigns the next section the array into the less-ideal choices if any exist(price+display), as they are the second-best choices
		if (counter4>0) {
			int n = 0;
			for (int i = counter3; i<(counter3+counter4); i++) {
				finalLaptops[i] = extraLaptops1[n];
				n++;
			}
		}
		
		//Reassigns the next section the array into the less-than-ideal choices if any exist(price+type), as they are the third-best choices
		if(counter5>0) {
			int g = 0;
			for (int i = counter3+counter4; i<(counter3+counter4+counter5); i++) {
				finalLaptops[i] = extraLaptops2[g];
				g++;
			}	
		}		
	}
}//End of class
