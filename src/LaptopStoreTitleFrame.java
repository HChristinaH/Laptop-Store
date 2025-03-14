/* Name: Christina Huang
 * Date: May 16, 2022
 * Course: ICS3U1-03
 * Instructor: Mr. Fernandes
 * Title: Laptop Store Title Frame
 * Project: Software Development Project #1 - Laptop Store
 * Description: This is the first frame that the user sees and lets user choose to go to survey frame, inventory frame, 
 * education frame, or exit the program.
 * Major Skills: Swing GUI components
 */

// import classes
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// this frame greets user and lets them choose to go to other frames
@SuppressWarnings("serial")
public class LaptopStoreTitleFrame extends JFrame implements ActionListener {

	// global variables
	JButton surveyButton = new JButton("Want to find the best laptop match? Take a survey.");
	JButton inventoryButton = new JButton("Don't know what you're looking for? Browse through our inventory.");
	JButton eduScreenButton = new JButton("Want to learn more about laptops? Visit the educational screen.");

	// constructor - sets up GUI components
	public LaptopStoreTitleFrame() {

		// fonts
		Font titleFont = new Font(Font.DIALOG, Font.BOLD, 48);
		Font buttonFont = new Font(Font.DIALOG, Font.BOLD, 16);
		Font greetingFont = new Font(Font.DIALOG, Font.PLAIN, 16);
		
		// colors
		Color lightGreen = new Color(206, 210, 194);
		Color teal = new Color(146, 177, 182);
		Color lightBlue = new Color(191, 209, 223);
		
		// frame
		setSize(1920, 1080);
		setContentPane(new JLabel(new ImageIcon("data/images/background.png")));
		setTitle("JCKL TECH");
		setLayout(null);

		// title label
		JLabel titleLabel = new JLabel("JCKL TECH");
		titleLabel.setFont(titleFont);
		titleLabel.setBounds(820, 50, 300, 50);
		add(titleLabel);
		
		// greeting label
		JLabel greetingLabel = new JLabel("Welcome! How may we help you?");
		greetingLabel.setFont(greetingFont);
		greetingLabel.setBounds(835, 150, 300, 50);
		add(greetingLabel);

		// exit button
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(lightBlue);
		exitButton.addActionListener(this);
		exitButton.setBounds(1748, 55, 100, 30);
		add(exitButton);

		// button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setBounds(560, 250, 1125, 800);
		buttonPanel.setLayout(null);
		add(buttonPanel);

		// survey button
		surveyButton.setBounds(100, 0, 600, 200);
		surveyButton.setFont(buttonFont);
		surveyButton.setBackground(lightBlue);
		surveyButton.addActionListener(this);
		buttonPanel.add(surveyButton);

		// inventory button
		inventoryButton.setBounds(100, 250, 600, 200);
		inventoryButton.setFont(buttonFont);
		inventoryButton.setBackground(lightGreen);
		inventoryButton.addActionListener(this);
		buttonPanel.add(inventoryButton);

		// education screen button
		eduScreenButton.setBounds(100, 500, 600, 200);
		eduScreenButton.setFont(buttonFont);
		eduScreenButton.setBackground(teal);
		eduScreenButton.addActionListener(this);
		buttonPanel.add(eduScreenButton);

	}

	// responds to user's actions
	@Override
	public void actionPerformed(ActionEvent event) {

		// go to survey screen
		if (event.getSource() == surveyButton) {
			
			// makes survey screen visible
			LaptopSurveyFrame surveyFrame = new LaptopSurveyFrame();
			setVisible(false);
			
		}

		// go to inventory screen
		else if (event.getSource() == inventoryButton) {

			// makes inventory screen visible
			InventoryFrame inventoryFrame = new InventoryFrame();
			inventoryFrame.setVisible(true);
			setVisible(false);

		}

		// go to educational screen
		else if (event.getSource() == eduScreenButton) {
			
			// makes educational screen visible
			JCKLEducationFrame educationFrame = new JCKLEducationFrame();
			setVisible(false);

		}

		// exit store
		else {

			System.exit(0);

		}

	}

}
