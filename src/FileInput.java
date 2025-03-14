/*
 * Name: Lavneet Singh
 * Date: May 15, 2022
 * Project: SDP 1
 * Description: This class inputs the data from the spreadsheet into the program
 */

//Import required libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Start of class
public class FileInput {

	//Start of method that inputs the file
	@SuppressWarnings("unused")
	public FileInput() {

		//Tells the program to try to do a section of code, and if it doesn't work, print file error
		try {

			//Call on the file from the folder
			File FileScanner = new File("data/laptops.csv");
			
			//Makes a scanner for the file(reads the file)
			Scanner fileInput = new Scanner(FileScanner);

			//Sections the code off based on new lines and commas
			fileInput.useDelimiter(",|\r\n");

			//For loop to iterate through all items of the file
			for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

				//Stores the values in the spreadsheet to the variables of the same data type as in the Laptop type object
				String titles = fileInput.nextLine();
				int number = fileInput.nextInt() - 1;
				String brand = fileInput.next();
				String laptopModel = fileInput.next();
				String type = fileInput.next();
				double price = fileInput.nextDouble();
				String brandCPU = fileInput.next();
				String modelCPU = fileInput.next();
				int cores = fileInput.nextInt();
				double speed = fileInput.nextDouble();
				int ram = fileInput.nextInt();
				int storage = fileInput.nextInt();
				String gpu = fileInput.next();
				int ports = fileInput.nextInt();
				String system = fileInput.next();
				double display = fileInput.nextDouble();
				int widthResolution = fileInput.nextInt();
				int heightResolution = fileInput.nextInt();
				double weight = fileInput.nextDouble();
				boolean touchscreen = fileInput.nextBoolean();
				double qualityRating = fileInput.nextDouble();
				double speedRating = fileInput.nextDouble();
				double memoryRating = fileInput.nextDouble();
				double displayRating = fileInput.nextDouble();
				double overallRating = fileInput.nextDouble();
				String hyperlink = fileInput.next();
				String imageURL = "data/images/" + i + ".png";

				
				//Assigns the data directly to the characteristics in the laptop type object for each of the 40 laptops
				LaptopStoreApplication.laptopArray[i] = new Laptop(number, brand, laptopModel, type, price, brandCPU,
						modelCPU, cores, speed, ram, storage, gpu, ports, system, display, widthResolution,
						heightResolution, weight, touchscreen, qualityRating, speedRating, memoryRating, displayRating,
						overallRating, hyperlink, imageURL);
			}

			//Closes the fileInput
			fileInput.close();

		//If the file isn't found, print's file error
		} catch (FileNotFoundException e) {
			System.out.println("file error");
		}

	//End of file input Method
	}
	
//End of class
}