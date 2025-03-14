/* Name: Christina Huang
 * Date: May 18, 2022
 * Course: ICS3U1-03
 * Instructor: Mr. Fernandes
 * Title: Inventory Frame
 * Project: Software Development Project #1 - Laptop Store
 * Description: This frame lets user browse through laptops and select a laptop to buy
 * Added Features: Search bar, clicks to enlarge image, and takes user to another frame to review their order.
 * Major skills: Swing GUI components (ScrollPane, RadioButton, CheckBox, TextField, OptionPane, ClientProperties), 
 * Listener interfaces(Action, Key, Focus), layout managers (Grid Layout, BoxLayout), arrays, try catch exceptions
 * Contributions: Christina (100%)
 */

// import classes
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

// this frame lets user browse through laptops and select a laptop to buy
@SuppressWarnings("serial")
public class InventoryFrame extends JFrame implements ActionListener, KeyListener, FocusListener {

	// colors
	Color lightGreen = new Color(206, 210, 194);
	Color teal = new Color(146, 177, 182);
	Color lightBlue = new Color(191, 209, 223);
	Color salmon = new Color(236, 221, 208);

	// fonts
	Font font1 = new Font("Dialog", Font.PLAIN, 16); // laptop specs
	Font font2 = new Font("Dialog", Font.BOLD, 16); // spec headers
	Font font3 = new Font("Dialog", Font.BOLD, 16); // filter headers
	Font font4 = new Font("Dialog", Font.PLAIN, 16); // filter specs

	// filter panel fields
	ButtonGroup sortBy = new ButtonGroup(); // group of sorting option buttons (toggled)
	JPanel filterPanel = new JPanel(); // panel with filter options
	JCheckBox sixteenInch = new JCheckBox("16"); // distinguishes the duplicate action commands (display and ram)
	JCheckBox sixteenGB = new JCheckBox("16");
	JCheckBox thirtyTwoGBram = new JCheckBox("32"); // distinguishes the duplicate action commands (ram and storage)
	JCheckBox thirtyTwoGB = new JCheckBox("32");
	JTextField min = new JTextField("Min"); // where user enters price range
	JTextField max = new JTextField("Max");
	Laptop[] laptopArrayCopy = new Laptop[40]; // copy of laptop array used to sort laptops

	// inventory panel fields
	JPanel[] laptopPanelArray = new JPanel[40]; // array of laptop panels with their image, specs, and buy button
	JPanel inventoryPanel = new JPanel(); // panel where laptops are displayed
	boolean[] filters = new boolean[39]; // keeps track of selected filters (true = selected)
	boolean[][] laptopFilters = new boolean[39][40]; // [filter index][laptop matches]
														// keeps track of which laptops match a filter (true = match)
	/*
	 * Filter indexes -- Display size -- 0 = 10; 1 = 11; 2 = 12; 3 = 13; 4 = 14; 5 =
	 * 15; 6 = 16; 7 = 17 -- Price -- 8 = Within price range -- Laptop type -- 9 =
	 * Professional; 10 = Student; 11 = Creative; 12 = Gaming; -- Storage size -- 13
	 * = 32; 14 = 64; 15 = 128; 16 = 256; 17 = 512; 18 = 1000; 19 = 1512; 20 = 2000
	 * -- RAM size -- 21 = 4; 22 = 8; 23 = 16; 24 = 32 -- Laptop brand -- 25 = Acer;
	 * 26 = Alienware; 27 = Apple; 28 = Asus; 29 = Dell; 30 = Dynabook; 31 = HP; 32
	 * = Lenovo; 33 = Microsoft; 34 = MSI; 35 = Samsung -- Touchscreen -- 36 = Yes;
	 * 37 = No -- Search -- 38 = Keyword matches
	 */
	boolean[] sortCategories = new boolean[8]; // categories that user can sort by
	/*
	 * Sort category indexes 0 - Quality rating 1 - Speed rating 2 - Memory rating 3
	 * - Display rating 4 - Overall rating 5 - Price (low to high) 6 - Price (high
	 * to low) 7 - None
	 */
	ButtonGroup laptopSelect = new ButtonGroup(); // group of laptop buy options (user can only select one laptop)
	boolean laptopSelected; // keeps track of whether user has selected to buy a laptop

	// search bar fields
	JTextField searchTextField = new JTextField();

	// constructor method
	public InventoryFrame() {

		// set up frame
		setSize(1920, 1080);
		setContentPane(new JLabel(new ImageIcon("data/images/background.png")));
		setLayout(null);

		// set up laptop display panel
		setUpLaptopDisplayPanel();

		// set up filter panel
		setUpFilterPanel();

		// set up search bar
		setUpSearchBar();

		// set up navigation buttons
		setUpNavigationButtons();

	}

	// this method takes a laptop and index number as the argument, and returns a
	// formatted JPanel with the laptop's data
	private JPanel createPanel(Laptop laptop, int i) {

		// set up laptop panel
		JPanel laptopPanel = new JPanel();
		laptopPanel.setBackground(Color.white);
		laptopPanel.setLayout(new BoxLayout(laptopPanel, BoxLayout.Y_AXIS)); // vertically stacks components
		laptopPanel.putClientProperty("laptopNumber", i); // store index number in panel

		// scale laptop image
		ImageIcon laptopImage = new ImageIcon(
				new ImageIcon(laptop.getImageURL()).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT));

		// set up image button
		JButton imageButton = new JButton(laptopImage);
		imageButton.setBackground(Color.white);
		imageButton.putClientProperty("laptopNumber", i);
		imageButton.addActionListener(this);
		laptopPanel.add(imageButton);

		// set up laptop specifications

		// create an array of the laptop's specs
		String[] laptopSpecs = new String[] { laptop.getBrand(), laptop.getLaptopModel(), laptop.getType(),
				String.valueOf(laptop.getPrice()), laptop.getBrandCPU(), laptop.getModelCPU(),
				String.valueOf(laptop.getCores()), String.valueOf(laptop.getSpeed()), String.valueOf(laptop.getRam()),
				String.valueOf(laptop.getStorage()), laptop.getGpu(), String.valueOf(laptop.getPorts()),
				laptop.getSystem(), String.valueOf(laptop.getDisplay()), String.valueOf(laptop.getWidthResolution()),
				String.valueOf(laptop.getHeightResolution()), String.valueOf(laptop.getQualityRating()),
				String.valueOf(laptop.getSpeedRating()), String.valueOf(laptop.getMemoryRating()),
				String.valueOf(laptop.getDisplayRating()), String.valueOf(laptop.getOverallRating()),
				String.valueOf(laptop.getWeight()), String.valueOf(laptop.isTouchscreen()) };

		// create a JLabel for each specification
		for (String spec : laptopSpecs) {

			JLabel specLabel = new JLabel(spec);
			specLabel.setFont(font1);
			laptopPanel.add(specLabel);

		}

		// set up radio button to select laptop for purchase
		JRadioButton selectRadioButton = new JRadioButton("Buy");
		selectRadioButton.setBackground(Color.white);
		selectRadioButton.setFont(font1);
		selectRadioButton.addActionListener(this);
		laptopSelect.add(selectRadioButton);
		laptopPanel.add(selectRadioButton);

		return laptopPanel;

	}

	// this method creates the section where the user can view and compare laptops
	private void setUpLaptopDisplayPanel() {

		// set up inventory scroll pane
		JScrollPane inventoryScrollPane = new JScrollPane();
		inventoryScrollPane.setBounds(550, 150, 1300, 740);
		inventoryScrollPane.getHorizontalScrollBar().setUnitIncrement(10); // makes the bar scroll faster

		// make scroll bar always visible
		// (so that laptop data always aligns with the header)
		inventoryScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		// set up inventory panel layout
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.X_AXIS));

		// create specification headings
		JPanel headingPanel = new JPanel();
		headingPanel.setOpaque(false);
		headingPanel.setBounds(400, 152, 150, 738);
		headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.Y_AXIS));

		// create empty space (since the heading does not have a laptop image)
		headingPanel.add(Box.createRigidArea(new Dimension(0, 209)));

		// array of specification headings
		String headings[] = new String[] { "Brand:", "Model:", "Type:", "Price (CAD):", "CPU Brand:", "CPU Model:",
				"CPU Cores:", "CPU Speed (GHz):", "RAM (GB):", "Storage (GB):", "GPU:", "USB ports:", "OS:",
				"Display (\"):", "Resolution Width:", "Resolution Height:", "Quality Rating:", "Speed Rating:",
				"Memory Rating:", "Display Rating:", "Overall Rating:", "Weight (lbs):", "Touchscreen:" };

		// create JLabels for each heading
		for (String specHeading : headings) {

			JLabel headingLabel = new JLabel(specHeading);
			headingLabel.setFont(font2);
			headingPanel.add(headingLabel); // add JLabel to panel

		}

		// create a button to unselect a laptop
		JRadioButton clearLaptopSelection = new JRadioButton("Clear");
		clearLaptopSelection.setOpaque(false);
		clearLaptopSelection.setFont(font2);
		clearLaptopSelection.addActionListener(this);
		laptopSelect.add(clearLaptopSelection);
		headingPanel.add(clearLaptopSelection);

		// add heading panel to inventory frame
		add(headingPanel);

		// fill laptop panel array and display laptops
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			// create a variable for the laptop instance
			Laptop laptop = LaptopStoreApplication.laptopArray[i];

			laptopPanelArray[i] = createPanel(laptop, i); // create a panel for laptop
			inventoryPanel.add(laptopPanelArray[i]); // laptop array indices match the panel array's indices
		}

		// display the inventory panel in the scroll pane
		inventoryScrollPane.setViewportView(inventoryPanel);

		// add scroll pane to the inventory frame
		add(inventoryScrollPane);

	}

	// this sets up the filter panel where user can filter laptops shown in
	// inventory panel
	private void setUpFilterPanel() {

		// initialize index counters
		int categoryIndex = -1; // index starts at zero, and uses pre-increments
		int filterIndex = -1;

		// initialize filter arrays
		Arrays.fill(filters, false); // filter status
		Arrays.fill(sortCategories, false); // sorting categories

		// initialize laptops' match status for each filter
		for (boolean[] row : laptopFilters) {

			Arrays.fill(row, false);

		}

		// set up filter panel
		filterPanel.setBackground(Color.white);
		filterPanel.setLayout(new GridLayout(55, 1)); // 55 rows, 1 column

		// set up scroll pane for filter panel
		JScrollPane filterScrollPane = new JScrollPane();
		filterScrollPane.setBounds(100, 180, 200, 710);
		filterScrollPane.getVerticalScrollBar().setUnitIncrement(15); // makes scroll bar scroll faster

		// set up button to reset filters
		JButton resetFilters = new JButton("Reset Filters");
		resetFilters.setBackground(lightBlue);
		resetFilters.setBounds(100, 150, 200, 30);
		resetFilters.addActionListener(this);
		add(resetFilters);

		// set up filter components

		// create a sort header
		JLabel sortLabel = new JLabel("Sort by:");
		sortLabel.setFont(font3);
		filterPanel.add(sortLabel);

		// create an array of categories to sort by
		String categories[] = new String[] { "Quality", "Speed", "Memory", "Display", "Overall", "Price (low to high)",
				"Price (high to low)" };

		// create radio buttons for each sort category
		for (String category : categories) {

			JRadioButton sortRadioButton = new JRadioButton(category);
			sortRadioButton.setBackground(Color.white);
			sortRadioButton.setFont(font4);
			sortRadioButton.putClientProperty("category", ++categoryIndex); // store category index
			sortRadioButton.addActionListener(this);
			sortBy.add(sortRadioButton); // add to a button group
			filterPanel.add(sortRadioButton); // add to filter panel panel

		}

		// display size filters

		// create a header for display size category
		JLabel displaySizeLabel = new JLabel("Display Size (\")");
		displaySizeLabel.setFont(font3);
		filterPanel.add(displaySizeLabel);

		// create an array of display sizes
		String[] displaySizes = new String[] { "10", "11", "12", "13", "14", "15", "17" }; // skip 16 since it is a
																							// global variable

		// create a check box for each display size filter
		for (String displaySize : displaySizes) {

			// set up check box for 16 inch display that has already been created
			if (filterIndex == 5) {

				sixteenInch.setBackground(Color.white);
				sixteenInch.setFont(font4);
				sixteenInch.putClientProperty("filter", ++filterIndex);
				sixteenInch.addActionListener(this);
				filterPanel.add(sixteenInch);

			}

			JCheckBox sizeCheckBox = new JCheckBox(displaySize);
			sizeCheckBox.setBackground(Color.white);
			sizeCheckBox.setFont(font4);
			sizeCheckBox.putClientProperty("filter", ++filterIndex); // store filter index
			sizeCheckBox.addActionListener(this);
			filterPanel.add(sizeCheckBox);

		}

		// price categories or price range
		JLabel priceLabel = new JLabel("Price (CAD)");
		priceLabel.setFont(font3);
		filterPanel.add(priceLabel);

		min.setFont(font4); // global variable (JTextField)
		min.addFocusListener(this);
		filterPanel.add(min);

		max.setFont(font4); // global variable (JTextField)
		max.addFocusListener(this);
		filterPanel.add(max);

		JButton enterPrice = new JButton("Enter");
		enterPrice.setBackground(teal);
		enterPrice.addActionListener(this);
		filterPanel.add(enterPrice);

		filterIndex++; // increment filter index by one since price is a filter

		// laptop type category

		// create a header for laptop type
		JLabel laptopTypeLabel = new JLabel("Laptop Type");
		laptopTypeLabel.setFont(font3);
		filterPanel.add(laptopTypeLabel);

		// create an array for laptop types
		String[] laptopTypes = new String[] { "Professional", "Student", "Creative", "Gaming" };

		// create a check box for each laptop type filter
		for (String laptopType : laptopTypes) {

			JCheckBox typeCheckBox = new JCheckBox(laptopType);
			typeCheckBox.setBackground(Color.white);
			typeCheckBox.setFont(font4);
			typeCheckBox.putClientProperty("filter", ++filterIndex);
			typeCheckBox.addActionListener(this);
			filterPanel.add(typeCheckBox);

		}

		// storage size category

		// create a header for storage size category
		JLabel storageLabel = new JLabel("Storage Size (GB)");
		storageLabel.setFont(font3);
		filterPanel.add(storageLabel);

		// create an array of storage sizes
		String[] storageSizes = new String[] { "64", "128", "256", "512", "1000", "1512", "2000" }; // skip 32 since it
																									// is a global
																									// variable

		// create a check box for each storage size filter
		for (String storagesize : storageSizes) {

			// setup 32 GB check box that has already been created
			if (filterIndex == 12) {

				thirtyTwoGB.setBackground(Color.white);
				thirtyTwoGB.setFont(font4);
				thirtyTwoGB.putClientProperty("filter", ++filterIndex);
				thirtyTwoGB.addActionListener(this);
				filterPanel.add(thirtyTwoGB);

			}

			JCheckBox storageSizeCheckBox = new JCheckBox(storagesize);
			storageSizeCheckBox.setBackground(Color.white);
			storageSizeCheckBox.setFont(font4);
			storageSizeCheckBox.putClientProperty("filter", ++filterIndex);
			storageSizeCheckBox.addActionListener(this);
			filterPanel.add(storageSizeCheckBox);

		}

		// ram size category

		// create a header for ram size category
		JLabel ramLabel = new JLabel("RAM Size (GB)");
		ramLabel.setFont(font3);
		filterPanel.add(ramLabel);

		// create a check box for each ram size filter
		JCheckBox fourGB = new JCheckBox("4");
		fourGB.setBackground(Color.white);
		fourGB.setFont(font4);
		fourGB.putClientProperty("filter", ++filterIndex);
		fourGB.addActionListener(this);
		filterPanel.add(fourGB);

		JCheckBox eightGB = new JCheckBox("8");
		eightGB.setBackground(Color.white);
		eightGB.setFont(font4);
		eightGB.putClientProperty("filter", ++filterIndex);
		eightGB.addActionListener(this);
		filterPanel.add(eightGB);

		sixteenGB.setBackground(Color.white);
		sixteenGB.setFont(font4);
		sixteenGB.putClientProperty("filter", ++filterIndex); // global variable
		sixteenGB.addActionListener(this);
		filterPanel.add(sixteenGB);

		thirtyTwoGBram.setBackground(Color.white);
		thirtyTwoGBram.setFont(font4);
		thirtyTwoGBram.putClientProperty("filter", ++filterIndex); // global variable
		thirtyTwoGBram.addActionListener(this);
		filterPanel.add(thirtyTwoGBram);

		// laptop brand category

		// create a header for laptop brand category
		JLabel brandLabel = new JLabel("Laptop Brand");
		brandLabel.setFont(font3);
		filterPanel.add(brandLabel);

		// create an array of laptop brands
		String[] brands = new String[] { "Acer", "Alienware", "Apple", "Asus", "Dell", "Dynabook", "HP", "Lenovo",
				"Microsoft", "MSI", "Samsung" };

		// create a checkbox for each laptop brand filter
		for (String brand : brands) {

			JCheckBox brandCheckBox = new JCheckBox(brand);
			brandCheckBox.setBackground(Color.white);
			brandCheckBox.setFont(font4);
			brandCheckBox.putClientProperty("filter", ++filterIndex);
			brandCheckBox.addActionListener(this);
			filterPanel.add(brandCheckBox);

		}

		// touchscreen category

		// create a header for touchscreen category
		JLabel touchscreenLabel = new JLabel("Touchscreen");
		touchscreenLabel.setFont(font3);
		filterPanel.add(touchscreenLabel);

		// create check boxes for yes and no options
		JCheckBox yes = new JCheckBox("Yes");
		yes.setBackground(Color.white);
		yes.setFont(font4);
		yes.putClientProperty("filter", ++filterIndex);
		yes.addActionListener(this);
		filterPanel.add(yes);

		JCheckBox no = new JCheckBox("No");
		no.setBackground(Color.white);
		no.setFont(font4);
		no.putClientProperty("filter", ++filterIndex);
		no.addActionListener(this);
		filterPanel.add(no);

		// add filter panel to the scroll pane
		filterScrollPane.setViewportView(filterPanel);

		// add scroll pane to inventory frame
		add(filterScrollPane);

		// create a variable of the original laptop array
		Laptop[] originalArray = LaptopStoreApplication.laptopArray;

		// fill copy of laptop array by creating an array new objects
		// Note: This is so that altering the copy will not affect the original array
		for (int index = 0; index < laptopArrayCopy.length; index++) {

			laptopArrayCopy[index] = new Laptop(originalArray[index].getNumber(), originalArray[index].getBrand(),
					originalArray[index].getLaptopModel(), originalArray[index].getType(),
					originalArray[index].getPrice(), originalArray[index].getBrandCPU(),
					originalArray[index].getModelCPU(), originalArray[index].getCores(),
					originalArray[index].getSpeed(), originalArray[index].getRam(), originalArray[index].getStorage(),
					originalArray[index].getGpu(), originalArray[index].getPorts(), originalArray[index].getSystem(),
					originalArray[index].getDisplay(), originalArray[index].getWidthResolution(),
					originalArray[index].getHeightResolution(), originalArray[index].getWeight(),
					originalArray[index].isTouchscreen(), originalArray[index].getQualityRating(),
					originalArray[index].getSpeedRating(), originalArray[index].getMemoryRating(),
					originalArray[index].getDisplayRating(), originalArray[index].getOverallRating(),
					originalArray[index].getHyperlink(), originalArray[index].getImageURL());

		}

	}

	// this method adds a laptop search tool
	private void setUpSearchBar() {

		// set up text field where user enters a keyword
		searchTextField.setBounds(550, 55, 500, 40);
		searchTextField.setFont(font1);
		searchTextField.setText("Search for a keyword..."); // text prompt
		searchTextField.addFocusListener(this);
		searchTextField.addKeyListener(this);
		add(searchTextField);

		// set up search button
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(teal);
		searchButton.addActionListener(this);
		searchButton.setBounds(1050, 55, 150, 40);
		add(searchButton);

	}

	// this method sets up buttons to visit other frames
	private void setUpNavigationButtons() {

		// sets up checkout button that takes user to another frame to place an order
		JButton checkOut = new JButton("Checkout");
		checkOut.setBackground(salmon);
		checkOut.addActionListener(this);
		checkOut.setBounds(1748, 950, 100, 30);
		add(checkOut);

		// sets up button to exit program
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(lightBlue);
		exitButton.addActionListener(this);
		exitButton.setBounds(1748, 55, 100, 30);
		add(exitButton);

		// sets up button to go to title frame
		JButton backButton = new JButton("Back");
		backButton.setBackground(lightGreen);
		backButton.addActionListener(this);
		backButton.setBounds(100, 55, 80, 30);
		add(backButton);

	}

	// this method responds to users clicked buttons
	@Override
	public void actionPerformed(ActionEvent event) {

		// create a variable for the button component
		Component button = (Component) event.getSource();

		// get the button's text
		String buttonText = event.getActionCommand();

		// if the user wants to reset the filters
		if (buttonText == "Reset Filters") {

			// clear all filters
			clearFilters();

		}

		// if the user wants to search with a keyword
		else if (buttonText == "Search") {

			// get keyword and filter laptops
			filterKeyword();

		}

		// if the user wants to sort laptops by rating or price
		else if (buttonText == "Quality" || buttonText == "Speed" || buttonText == "Memory" || buttonText == "Display"
				|| buttonText == "Overall" || buttonText == "Price (low to high)"
				|| buttonText == "Price (high to low)") {

			// get sort category and display sorted laptops
			changeCategoryFilter(event, button);
			showLaptops();

		}

		// if user selects a laptop to buy
		else if (buttonText == "Buy") {

			// update status of laptop selection
			if (!laptopSelected)
				laptopSelected = true;

			// get the selected laptop
			JPanel selectedPanel = (JPanel) button.getParent(); // determine which panel the button is in
			int laptopNum = (int) selectedPanel.getClientProperty("laptopNumber"); // get the panel's laptop number

			// update user's choice
			LaptopStoreApplication.userChoice = LaptopStoreApplication.laptopArray[laptopNum];

		}

		// if user wants to clear a selected laptop
		else if (buttonText == "Clear") {

			// clear all buttons in the button group
			laptopSelect.clearSelection();

			// clear user's laptop choice
			LaptopStoreApplication.userChoice = null;

		}

		// if user wants to checkout
		else if (buttonText == "Checkout") {

			// take user to review their order
			checkOutLaptop();

		}

		// if user wants to exit program
		else if (buttonText == "Exit") {

			// close program
			System.exit(0);

		}

		// if user wants to return to title screen
		else if (buttonText == "Back") {

			// show title frame;
			LaptopStoreApplication.titleFrame.setVisible(true);

			// hide inventory frame
			setVisible(false);

		}

		// if user clicked on a check box in display size category
		else if (buttonText == "10" || buttonText == "11" || buttonText == "12" || buttonText == "13"
				|| buttonText == "14" || buttonText == "15" || button == sixteenInch || buttonText == "17") {

			// filter laptops by selected display size
			filterDisplaySize(event, button, buttonText);

		}

		// if user clicked on a check box in storage size
		else if (button == thirtyTwoGB || buttonText == "64" || buttonText == "128" || buttonText == "256"
				|| buttonText == "512" || buttonText == "1000" || buttonText == "1512" || buttonText == "2000") {

			// filter laptops by selected storage size
			filterStorageSize(event, button, buttonText);

		}

		// if user clicked on a check box in ram size category
		else if (buttonText == "4" || buttonText == "8" || button == sixteenGB || button == thirtyTwoGBram) {

			// filter laptops by selected ram size
			filterRamSize(event, button, buttonText);

		}

		// if user clicked on a button in price category
		else if (buttonText == "Enter") {

			// validate user's price entry
			try {

				// filter laptops by user's price range
				filterPriceRange(event);
			}

			// if enters a character that is not a number
			catch (NumberFormatException VariableDeclarorID) {

				// show error message
				JOptionPane.showMessageDialog(null, "Invalid Price Entry: Enter only numbers.");

			}

		}

		// if user clicked on a check box in type category
		else if (buttonText == "Professional" || buttonText == "Student" || buttonText == "Creative"
				|| buttonText == "Gaming") {

			// filter laptops by selected type
			filterLaptopType(event, button, buttonText);

		}

		// if user clicked on a check box in touchscreen category
		else if (buttonText == "Yes" || buttonText == "No") {

			// filter laptops by user's selected touchscreen preference
			filterTouchScreen(event, button, buttonText);
		}

		// remaining check boxes are a laptop brand filter
		else if (button instanceof JCheckBox) {

			// filter laptops by selected brand
			filterLaptopBrand(event, button, buttonText);
		}

		// remaining buttons are a laptop image button,
		else {

			// get the selected laptop number
			int laptopNum = (int) ((JButton) event.getSource()).getClientProperty("laptopNumber");

			// get the selected laptop
			Laptop laptop = LaptopStoreApplication.laptopArray[laptopNum];

			// create a new, larger image
			ImageIcon laptopImage = new ImageIcon(
					new ImageIcon(laptop.getImageURL()).getImage().getScaledInstance(900, 720, Image.SCALE_DEFAULT));

			// display a larger image of the laptop
			JOptionPane.showInternalMessageDialog(null, "", laptop.getBrand() + " " + laptop.getLaptopModel() + " "
					+ laptop.getBrandCPU() + " " + laptop.getModelCPU(), JOptionPane.INFORMATION_MESSAGE, laptopImage);

		}

	}

	// this method verifies a laptop selection and takes user to review their order
	private void checkOutLaptop() {

		// if user did not select a laptop
		if (LaptopStoreApplication.userChoice == null || !laptopSelected) {

			// display a message
			JOptionPane.showMessageDialog(null, "Please select a laptop.");
		}

		else {

			// scale laptop image
			ImageIcon laptopImage = new ImageIcon(new ImageIcon(LaptopStoreApplication.userChoice.getImageURL())
					.getImage().getScaledInstance(125, 100, Image.SCALE_DEFAULT));

			// ask user to confirm laptop
			if (JOptionPane.showConfirmDialog(null,
					("Do you wish to buy: " + LaptopStoreApplication.userChoice.getBrand() + " "
							+ LaptopStoreApplication.userChoice.getLaptopModel() + "?"),
					"Confirm Purchase", JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION,
					laptopImage) == JOptionPane.YES_OPTION) {

				// go to checkout frame
				LaptopStoreApplication.previousFrame = "Inventory";
				ResultsReviewFrame resultsReview = new ResultsReviewFrame();
				resultsReview.setVisible(true);
				dispose(); // destroys inventory frame

			}

		}

	}

	// default KeyListener class (unused)
	@Override
	public void keyTyped(KeyEvent event) {

		// do nothing
	}

	// default KeyListener class (unused)
	@Override
	public void keyPressed(KeyEvent event) {

		// do nothing

	}

	// this method searches user's keyword as they release a character
	@Override
	public void keyReleased(KeyEvent event) {

		// ignore keys released in price entry

		// if user released a key in the search bar
		if (event.getSource() == searchTextField) {

			// show laptops that match keyword and all other filters (as user types)
			filterKeyword();
		}

	}

	// this method removes placeholders for text fields when clicked
	@Override
	public void focusGained(FocusEvent event) {

		// if user clickes on the default text in a textbox, remove default text

		// if user clicks on minimum price entry
		if (event.getSource() == min && min.getText().equals("Min")) {

			min.setText("");

		}

		// if user clicks on maximum price entry
		else if (event.getSource() == max && max.getText().equals("Max")) {

			max.setText("");

		}

		// if user clickes on search bar
		else if (event.getSource() == searchTextField && searchTextField.getText().equals("Search for a keyword...")) {

			searchTextField.setText("");

		}

	}

	// this method makes a text field's placeholder reappear when user leaves field
	// empty and clicks away
	@Override
	public void focusLost(FocusEvent event) {

		// if user clicks on minimum price entry
		if (event.getSource() == min && min.getText().equals("")) {

			min.setText("Min");

		}

		// if user clicks on maximum price entry
		else if (event.getSource() == max && max.getText().equals("")) {

			max.setText("Max");

		}

		// if user clicks on search bar
		else if (event.getSource() == searchTextField && searchTextField.getText().equals("")) {

			searchTextField.setText("Search for a keyword...");
		}

	}

	// this method resets the selected filters and shows all laptops
	private void clearFilters() {

		// remove all filters
		Arrays.fill(filters, false);

		// uncheck buttons
		for (Component button : filterPanel.getComponents()) {

			if (button instanceof JCheckBox) {

				((JCheckBox) button).setSelected(false);

			}

			if (button instanceof JRadioButton) {

				((JRadioButton) button).setSelected(false);

			}

		}

		// clear search bar
		searchTextField.setText("Search for a keyword...");

		// clear category sort
		sortBy.clearSelection();
		Arrays.fill(sortCategories, false);

		// reset price entry
		min.setText("Min");
		max.setText("Max");

		// display laptops after filters have been removed
		showLaptops();

	}

	// this method updates the sorting category filters
	private void changeCategoryFilter(ActionEvent event, Component button) {

		// create an object for the clicked radiobutton
		JRadioButton clickedRadioButton = (JRadioButton) button;

		// get the category index
		int categoryIndex = (int) ((JComponent) button).getClientProperty("category");

		// if button is selected,
		if (clickedRadioButton.isSelected()) {

			// remove previous filter
			Arrays.fill(sortCategories, false);

			// record the new category as selected
			sortCategories[categoryIndex] = true;

		}

	}

	// this method updates the search filter status and matching laptops, and
	// shows filtered laptops
	private void filterKeyword() {

		// set keyword filter as off by default
		filters[38] = false;

		// reset laptop filter matches
		for (int i = 0; i < laptopPanelArray.length; i++) {

			laptopFilters[38][i] = false; // 38 is the index for search filter's status

		}

		// get the user's serached keyword
		String keyword = searchTextField.getText();

		// check if user entered a keyword (if its not empty or the default prompt)
		if (keyword.equals("Search for a keyword...") || keyword.equals("")) {

			// if there is no keyword filter
			showLaptops(); // show laptops without any added search filters
			return;

		}

		// add search filter
		filters[38] = true;

		// for each laptop
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			// create a variable for the laptop
			Laptop laptop = LaptopStoreApplication.laptopArray[i];

			// check if laptop brand matches
			if (laptop.getBrand().toLowerCase().contains(keyword.toLowerCase())) {

				laptopFilters[38][laptop.getNumber()] = true; // record that laptop matches the search filter

			}

			// check if laptop model matches
			if (laptop.getLaptopModel().toLowerCase().contains(keyword.toLowerCase())) {
				laptopFilters[38][laptop.getNumber()] = true;
			}

			// check if laptop type matches
			if (laptop.getType().toLowerCase().contains(keyword.toLowerCase())) {
				laptopFilters[38][laptop.getNumber()] = true;
			}

			// check if CPU model matches
			if (laptop.getModelCPU().toLowerCase().contains(keyword.toLowerCase())) {
				laptopFilters[38][laptop.getNumber()] = true;
			}

			// check if CPU brand matches
			if (laptop.getBrandCPU().toLowerCase().contains(keyword.toLowerCase())) {
				laptopFilters[38][laptop.getNumber()] = true;
			}

			// check if GPU matches
			if (laptop.getGpu().toLowerCase().contains(keyword.toLowerCase())) {
				laptopFilters[38][laptop.getNumber()] = true;
			}

			// check if operating system matches
			if (laptop.getSystem().toLowerCase().contains(keyword.toLowerCase())) {
				laptopFilters[38][laptop.getNumber()] = true;
			}

		}

		showLaptops();

	}

	// this method filters laptops by display size based on user's clicked display
	// size filter, and shows filtered laptops
	private void filterDisplaySize(ActionEvent event, Component button, String buttonText) {

		// create a variable for the selected display size
		int displaySize = (int) Double.parseDouble(buttonText);

		// create an object for the clicked checkbox
		JCheckBox clickedCheckBox = (JCheckBox) button;

		// get the index of the selected filter
		int filterNum = (int) ((JComponent) button).getClientProperty("filter");

		// compare selected display size to the laptops' display size
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			// get the truncated display of the laptop
			int laptopSize = (int) Math.floor(LaptopStoreApplication.laptopArray[i].getDisplay());

			// record if the laptop matches the filter
			if (laptopSize == displaySize)
				laptopFilters[filterNum][i] = true;

			// if the checkbox is unselected, remove a filter
			if (!clickedCheckBox.isSelected())
				filters[filterNum] = false;

			// if check box is selected, add a filter
			else
				filters[filterNum] = true;

		}

		// show laptops after a filter is added (pass true) or removed (pass false)
		showLaptops();

	}

	// this method filters laptops by storage size based on user's clicked storage
	// filter, and shows filtered laptops
	private void filterStorageSize(ActionEvent event, Component button, String buttonText) {

		// create a variable for the selected storage size
		int selectedStorageSize = (int) Double.parseDouble(buttonText);

		// create an object for the clicked checkbox
		JCheckBox clickedCheckBox = (JCheckBox) button;

		// get the index of the filter
		int filterNum = (int) ((JComponent) button).getClientProperty("filter");

		// compare selected storage size to the laptops
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			// get the laptop's storage size
			int laptopStorage = LaptopStoreApplication.laptopArray[i].getStorage();

			// record if the laptop matches the filter
			if (laptopStorage == selectedStorageSize)
				laptopFilters[filterNum][i] = true;

			// if the checkbox is unselected, remove a filter
			if (!clickedCheckBox.isSelected())
				filters[filterNum] = false;

			// if check box is selected, add a filter
			else
				filters[filterNum] = true;

		}

		showLaptops();

	}

	// this method filters laptops by ram size based on user's clicked ram filter,
	// and shows filtered laptops
	private void filterRamSize(ActionEvent event, Component button, String buttonText) {

		// create a variable for the selected ram size
		int selectedRamSize = (int) Integer.parseInt(buttonText);

		// create an object for the clicked checkbox
		JCheckBox clickedCheckBox = (JCheckBox) button;

		// get the index of the filter
		int filterNum = (int) ((JComponent) button).getClientProperty("filter");

		// compare selected ram size to the laptops
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			// get the laptop's ram size
			int ramSize = LaptopStoreApplication.laptopArray[i].getRam();

			// record if the laptop matches the filter
			if (ramSize == selectedRamSize)
				laptopFilters[filterNum][i] = true;

			// if the checkbox is unselected, remove a filter
			if (!clickedCheckBox.isSelected())
				filters[filterNum] = false;

			// if check box is selected, add a filter
			else
				filters[filterNum] = true;

		}

		showLaptops();
	}

	// this method filters laptops based on the user's given price range
	private void filterPriceRange(ActionEvent event) throws NumberFormatException {

		// clear laptop matches for price filter
		for (int i = 0; i < laptopPanelArray.length; i++) {

			laptopFilters[8][i] = false; // 8 is the index of the price range filter

		}

		// create variables for min and max price
		double min;
		double max;

		// get the user's price range

		// if user did not change minimum price
		if (this.min.getText().equals("Min")) {

			min = 0; // set min price to zero
		}

		// if user entered a minimum price
		else {

			// set min price to user's entry
			min = Double.parseDouble(this.min.getText());

		}

		// if user did not change maximum price
		if (this.max.getText().equals("Max")) {

			max = Double.POSITIVE_INFINITY; // set max price to positive infinity

		}

		// if user entered a maximum price
		else {

			// set max price to user's entry
			max = Double.parseDouble(this.max.getText());

		}

		// check if the price range is valid
		if (min < 0 || max < 0) {

			// if not, display an error message
			JOptionPane.showMessageDialog(null, "Invalid Price Entry: Cannot be negative.");
			return;

		}

		// check that max price is greater than min price
		if (max < min) {

			// if not, display an error message
			JOptionPane.showMessageDialog(null, "Invalid Price Entry: Max cannot be less than Min.");
			return;

		}

		// record that there is a price filter
		filters[8] = true;

		// compare the prices of laptops to the price range
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			double laptopPrice = LaptopStoreApplication.laptopArray[i].getPrice();

			// if the laptop is in the price range
			if (laptopPrice >= min && laptopPrice <= max) {

				// record that the laptop is in user's price range
				laptopFilters[8][i] = true;

			}

		}

		showLaptops();

	}

	// this method filters laptops based on the user's clicked laptop type filter
	private void filterLaptopType(ActionEvent event, Component button, String buttonText) {

		// create a variable for the selected laptop type
		String selectedType = buttonText;

		// create an object for the clicked checkbox
		JCheckBox clickedCheckBox = (JCheckBox) button;

		// get the index of the filter
		int filterNum = (int) ((JComponent) button).getClientProperty("filter");

		// loop through the array of laptops
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			// get the laptop's type
			String laptopType = LaptopStoreApplication.laptopArray[i].getType();

			// ignore white spaces
			laptopType.replaceAll("\\s+", "");

			// record if the laptop matches the filter
			if (laptopType.equals(selectedType))
				laptopFilters[filterNum][i] = true;

			// if the checkbox is unselected, remove a filter
			if (!clickedCheckBox.isSelected())
				filters[filterNum] = false;

			// if check box is selected, add a filter
			else
				filters[filterNum] = true;

		}

		showLaptops();

	}

	// this method filters laptops based on the user's clicked brand filter
	private void filterLaptopBrand(ActionEvent event, Component button, String buttonText) {

		// create a variable for the selected laptop brand
		String selectedBrand = buttonText;

		// create an object for the clicked checkbox
		JCheckBox clickedCheckBox = (JCheckBox) button;

		// get the index of the filter
		int filterNum = (int) ((JComponent) button).getClientProperty("filter");

		// compare laptop brands to the selected brand
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			// get the laptop's brand
			String laptopBrand = LaptopStoreApplication.laptopArray[i].getBrand();

			// ignore whitespaces
			laptopBrand.replaceAll("\\s+", "");

			// record if the laptop matches the filter
			if (laptopBrand.equals(selectedBrand)) {

				laptopFilters[filterNum][i] = true;
			}

			// if the checkbox is unselected, remove a filter
			if (!clickedCheckBox.isSelected())
				filters[filterNum] = false;

			// if check box is selected, add a filter
			else
				filters[filterNum] = true;

		}

		showLaptops();

	}

	// this method filters laptops based on the user's clicked touchscreen
	// preference
	private void filterTouchScreen(ActionEvent event, Component button, String buttonText) {

		// get the user's touchscreen preference
		boolean preference;

		if (buttonText == "Yes")
			preference = true;
		else
			preference = false;

		// create an object for the clicked check box
		JCheckBox clickedCheckBox = (JCheckBox) button;

		// get the index of the filter
		int filterNum = (int) ((JComponent) button).getClientProperty("filter");

		// compare laptops' touchscreen option to user's selected touchscreen option
		for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

			// get the laptop's touchscreen option
			boolean touchscreenOption = LaptopStoreApplication.laptopArray[i].isTouchscreen();

			// record if the laptop matches the filter
			if (touchscreenOption == preference) {

				laptopFilters[filterNum][i] = true;
			}

			// if the checkbox is unselected, remove a filter
			if (!clickedCheckBox.isSelected())
				filters[filterNum] = false;

			// if check box is selected, add a filter
			else
				filters[filterNum] = true;

		}

		showLaptops();

	}

	// this method shows filtered laptops
	private void showLaptops() {

		// initialize category index
		int category = 7; // no sort category by default

		// get the index category to sort by (if there is one)
		for (int i = 0; i < sortCategories.length; i++) {

			if (sortCategories[i])
				category = i;

		}

		// get the sorted laptop order based on sort category
		int[] laptopOrder = getSortedLaptops(category);

		// create a variable to keep track of whether a laptop is shown
		boolean laptopShown = false;

		// loop through the array of sorted laptops
		for (int laptopNumber : laptopOrder) {

			// if laptop matches all category filters
			if (meetsFilters(laptopNumber)) {

				// before adding the first laptop, remove previous laptops
				if (!laptopShown) {

					laptopShown = true; // update laptop display status
					inventoryPanel.removeAll();

				}

				// show the laptop
				inventoryPanel.add(laptopPanelArray[laptopNumber]);

			}

		}

		System.out.println();

		// if no laptop matches the filters
		if (!laptopShown) {

			// display a message
			JOptionPane.showMessageDialog(null, "No matches found.");

		}

		// update the frame to show new changes
		revalidate();
		repaint();

	}

	// this method sorts the laptop array by a category and returns an array of
	// sorted indices
	private int[] getSortedLaptops(int category) {

		// create an array for sorted indices
		int[] sortedArray = new int[40];

		// if user wants to sort by quality rating
		if (category == 0) {

			// sort the array copy
			Arrays.sort(laptopArrayCopy, (Comparator.comparing(Laptop::getQualityRating).reversed()));

			// fill index array
			for (int i = 0; i < sortedArray.length; i++) {

				sortedArray[i] = laptopArrayCopy[i].getNumber();

			}

		}

		// if user wants to sort by speed rating
		else if (category == 1) {

			// sort the array copy
			Arrays.sort(laptopArrayCopy, (Comparator.comparing(Laptop::getSpeedRating)).reversed());

			// fill index array
			for (int i = 0; i < sortedArray.length; i++) {

				sortedArray[i] = laptopArrayCopy[i].getNumber();

			}

		}

		// if user wants to sort by memory rating
		else if (category == 2) {

			// sort the array copy
			Arrays.sort(laptopArrayCopy, (Comparator.comparing(Laptop::getMemoryRating)).reversed());

			// fill index array
			for (int i = 0; i < sortedArray.length; i++) {

				sortedArray[i] = laptopArrayCopy[i].getNumber();

			}

		}

		// if user wants to sort by display rating
		else if (category == 3) {

			// sort the array copy
			Arrays.sort(laptopArrayCopy, (Comparator.comparing(Laptop::getDisplayRating)).reversed());

			// fill index array
			for (int i = 0; i < sortedArray.length; i++) {

				sortedArray[i] = laptopArrayCopy[i].getNumber();

			}

		}

		// if user wants to sort by overall rating
		else if (category == 4) {

			// sort the array copy
			Arrays.sort(laptopArrayCopy, (Comparator.comparing(Laptop::getOverallRating)).reversed());

			// fill index array
			for (int i = 0; i < sortedArray.length; i++) {

				sortedArray[i] = laptopArrayCopy[i].getNumber();

			}

		}

		// if user wants to sort by price (low to high)
		else if (category == 5) {

			// sort the array copy
			Arrays.sort(laptopArrayCopy, (Comparator.comparing(Laptop::getPrice)));

			// fill index array
			for (int i = 0; i < sortedArray.length; i++) {

				sortedArray[i] = laptopArrayCopy[i].getNumber();

			}

		}

		// if user wants to sort by price (high to low)
		else if (category == 6) {

			// sort the array copy
			Arrays.sort(laptopArrayCopy, (Comparator.comparing(Laptop::getPrice)).reversed());

			// fill index array
			for (int i = 0; i < sortedArray.length; i++) {

				sortedArray[i] = laptopArrayCopy[i].getNumber();

			}

		}

		// if no selected sort category
		else {

			// fill index array (in its original order)
			for (int i = 0; i < sortedArray.length; i++) {

				sortedArray[i] = LaptopStoreApplication.laptopArray[i].getNumber();

			}
		}

		return sortedArray;

	}

	// this method determines if a laptop meets all of user's filter requirements
	private boolean meetsFilters(int laptopNum) {

		// create an array of start and end indexes of each filter category
		int[][] filterIndexRanges = { { 0, 7 }, { 8, 8 }, { 9, 12 }, { 13, 20 }, { 21, 24 }, { 25, 35 }, { 36, 37 },
				{ 38, 38 } };

		// determine if the laptop meets each filter category
		for (int[] indexRange : filterIndexRanges) {

			// determine the total number of filters to count the selected filters
			int selectedFilters = indexRange[1] - indexRange[0] + 1;

			// create a variable for whether a filter is met
			boolean filterMet = false;

			// check all filters in the category
			for (int filterIndex = indexRange[0]; filterIndex <= indexRange[1]; filterIndex++) {

				// if a filter is selected
				if (filters[filterIndex]) {

					// check if laptop matches the display size
					if (laptopFilters[filterIndex][laptopNum] == true) {
						filterMet = true; // record that the laptop met a filter in the category
					}

				}

				// else, the filter is not selected
				else {

					// keep track of the number of filters selected
					selectedFilters--;

				}

			}

			// if the laptop did not meet any of the selected filters
			if (!filterMet && selectedFilters > 0)

				return false; // laptop does not meet the category's filters

		}

		return true; // otherwise, the laptop has met all category filters

	}

}
