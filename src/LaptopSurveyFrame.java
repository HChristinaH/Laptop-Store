import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

//Name: Jeffrey Ma
//Date: May 11th, 2022
//Description: If prompted, this frame will display a survey to the user to figure out what the best laptop for them.
//Major Skills: Array,Jlabel, Button group, radio buttons, setting bounds, action listener, 
//Additional Features: backButton, storing data
//Areas of Concerns: none	
//Contribution: Jeffrey Ma 95% Lavneet Sidhu 5% helped with collecting data (line 228-237).

@SuppressWarnings("serial")
public class LaptopSurveyFrame extends JFrame implements ActionListener {
	
	// Creates an array to store the data
	public static String[] answerArray = new String[6];

	// GUI objects
	JLabel backgroundLabel = new JLabel(new ImageIcon("data/images/background.png"));
	JLabel surveyLabel = new JLabel("JCKL Survey");
	JLabel surveyQ1 = new JLabel("Enter your first name:");
	JLabel surveyQ2 = new JLabel("Enter your last name:");
	JLabel surveyQ3 = new JLabel("What is your address:");
	JLabel surveyQ4 = new JLabel("What kind of computer are you looking for? (Student, Professional, Creative, Gaming)");
	JLabel surveyQ5 = new JLabel("What is the price range that you are looking for?");
	JLabel surveyQ6 = new JLabel("What display size are you looking for?");

	// Textboxes
	JTextArea nameText = new JTextArea("Insert Name here");
	JTextArea lastText = new JTextArea("Insert Last Name here ");
	JTextArea addressText = new JTextArea("Insert Address here");
	JTextArea displayText = new JTextArea("Display Size");

	// Buttons
	JButton exitButton = new JButton("Exit");
	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Back");

	// Multiple choice for question 4
	ButtonGroup optionGroup = new ButtonGroup();
	ButtonGroup optionGroup2 = new ButtonGroup();

	JRadioButton studentButton = new JRadioButton("Student");
	JRadioButton professionalButton = new JRadioButton("Professional");
	JRadioButton creativeButton = new JRadioButton("Creative");
	JRadioButton gamingButton = new JRadioButton("Gaming");

	// Multiple choice for question 5
	JRadioButton budgetButton = new JRadioButton("Budget $0-500");
	JRadioButton midButton = new JRadioButton("Mid $500-1000");
	JRadioButton highendButton = new JRadioButton("High-end $1000-2000");
	JRadioButton ultraButton = new JRadioButton("Ultra $2000+");

	// Constructor Method
	public LaptopSurveyFrame() {

		// setting background
		add(backgroundLabel);
		backgroundLabel.setLayout(null);

		// Groups the radio buttons together so it can be stored for later
		optionGroup.add(studentButton);
		studentButton.setActionCommand("Student");

		optionGroup.add(professionalButton);
		professionalButton.setActionCommand("Professional");

		optionGroup.add(creativeButton);
		creativeButton.setActionCommand("Creative");

		optionGroup.add(gamingButton);
		gamingButton.setActionCommand("Gaming");

		budgetButton.setActionCommand("Budget");
		midButton.setActionCommand("Mid");
		highendButton.setActionCommand("Highend");
		ultraButton.setActionCommand("Ultra");

		optionGroup2.add(budgetButton);
		optionGroup2.add(midButton);
		optionGroup2.add(highendButton);
		optionGroup2.add(ultraButton);

		// Setting Boundaries for the objects
		surveyLabel.setBounds(960, 100, 800, 50);
		surveyLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		backgroundLabel.add(surveyLabel);

		surveyQ1.setBounds(200, 250, 800, 50);
		surveyQ1.setFont(new Font("Serif", Font.PLAIN, 20));
		backgroundLabel.add(surveyQ1);

		backgroundLabel.add(nameText);
		nameText.setFont(new Font("Serif", Font.PLAIN, 15));
		nameText.setBounds(700, 267, 200, 30);

		surveyQ2.setBounds(200, 300, 800, 50);
		surveyQ2.setFont(new Font("Serif", Font.PLAIN, 20));
		backgroundLabel.add(surveyQ2);

		lastText.setBounds(700, 318, 200, 30);
		lastText.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(lastText);

		surveyQ3.setBounds(200, 350, 400, 50);
		surveyQ3.setFont(new Font("Serif", Font.PLAIN, 20));
		backgroundLabel.add(surveyQ3);

		addressText.setBounds(700, 367, 300, 30);
		addressText.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(addressText);

		surveyQ4.setBounds(1160, 250, 800, 50);
		surveyQ4.setFont(new Font("Serif", Font.PLAIN, 20));
		backgroundLabel.add(surveyQ4);

		studentButton.setBounds(1160, 288, 800, 30);
		studentButton.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(studentButton);
		studentButton.setOpaque(false);
		studentButton.addActionListener(this);

		professionalButton.setBounds(1160, 318, 800, 30);
		professionalButton.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(professionalButton);
		professionalButton.setOpaque(false);
		professionalButton.addActionListener(this);

		creativeButton.setBounds(1160, 348, 800, 30);
		creativeButton.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(creativeButton);
		creativeButton.setOpaque(false);
		creativeButton.addActionListener(this);

		gamingButton.setBounds(1160, 378, 800, 30);
		gamingButton.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(gamingButton);
		gamingButton.setOpaque(false);
		gamingButton.addActionListener(this);

		surveyQ5.setBounds(1160, 410, 800, 50);
		surveyQ5.setFont(new Font("Serif", Font.PLAIN, 20));
		backgroundLabel.add(surveyQ5);

		budgetButton.setBounds(1160, 450, 800, 30);
		budgetButton.setFont(new Font("Serif", Font.PLAIN, 15));

		budgetButton.setOpaque(false);
		backgroundLabel.add(budgetButton);

		midButton.setBounds(1160, 480, 800, 30);
		midButton.setFont(new Font("Serif", Font.PLAIN, 15));

		midButton.setOpaque(false);
		backgroundLabel.add(midButton);

		highendButton.setBounds(1160, 510, 800, 30);
		highendButton.setFont(new Font("Serif", Font.PLAIN, 15));

		highendButton.setOpaque(false);
		backgroundLabel.add(highendButton);

		ultraButton.setBounds(1160, 540, 800, 30);
		ultraButton.setFont(new Font("Serif", Font.PLAIN, 15));

		ultraButton.setOpaque(false);
		backgroundLabel.add(ultraButton);

		surveyQ6.setBounds(200, 410, 350, 30);
		surveyQ6.setFont(new Font("Serif", Font.PLAIN, 20));
		backgroundLabel.add(surveyQ6);

		displayText.setBounds(700, 418, 300, 30);
		displayText.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(displayText);

		exitButton.setBounds(1700, 20, 175, 50);
		exitButton.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(exitButton);
		exitButton.addActionListener(this);

		submitButton.setBounds(1700, 900, 175, 50);
		submitButton.setFont(new Font("Serif", Font.PLAIN, 15));
		backgroundLabel.add(submitButton);
		submitButton.addActionListener(this);

		backButton.setBounds(35, 900, 100, 50);
		backButton.setFont(new Font("Serif", Font.PLAIN, 15));
		backButton.addActionListener(this);
		backgroundLabel.add(backButton);

		setVisible(true);
		setSize(1920, 1080);

	}

	@Override
	// If statements for when certain buttons are clicked
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exitButton) {
			System.exit(DISPOSE_ON_CLOSE);

		}

		// If backButton is clicked then it will
		else if (e.getSource() == backButton) {
			LaptopStoreApplication.titleFrame.setVisible(true);
			this.setVisible(false);

		}

		else if (e.getSource() == submitButton)
			;

		{

			// Stores the data for the results frame
			answerArray[0] = nameText.getText();
			answerArray[1] = lastText.getText();
			answerArray[2] = addressText.getText();
			answerArray[3] = displayText.getText();

			// If the selections are clicked, they will be stored
			if (studentButton.isSelected() || professionalButton.isSelected() || creativeButton.isSelected()
					|| gamingButton.isSelected()) {
				answerArray[4] = (String) optionGroup.getSelection().getActionCommand();

				if (budgetButton.isSelected() || midButton.isSelected() || highendButton.isSelected()
						|| ultraButton.isSelected()) {
					answerArray[5] = (String) optionGroup2.getSelection().getActionCommand();
					this.setVisible(false);
					findChoices.determineChoices();
					LaptopStoreApplication.previousFrame = "Survey";
					ResultsFrame results = new ResultsFrame();

				}

			}

		}

	}

}