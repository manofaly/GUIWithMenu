/*Welcome to this simple GUI containing a menu. This GUI contains an option and a text area. 
The option menu has four items:
    - Display Current Date and Time: Prints current date and time to the text area
    - Write Content to a Text File: Writes the text area content to the text file:
        C:\\Users\\new user\\Desktop\\coding\\java\\prog2 - module3\\logfile.txt.
    - Change Frame Background Color: Changes the frame background color to a color
        hue of green each time code is executed.  
    - Exit Window: displays a 'Goodbye' message and exits the application.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class GUIWithMenu {
    public static void main (String [] args) {

        Random rand = new Random();
        int randomNum = rand.nextInt(150);  // Generating a random int between 0 and 151 to serve as the red and black color values

        JFrame frame = new JFrame();                                // Creating the frame
        frame.setSize(600, 600);                    // Setting frame size
        frame.setTitle("Simple GUI with Menu");             // Setting frame title
        frame.setLayout(null);                            // Setting frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // Setting frame to close when close button is clicked

        Date currentDate = new Date();                            // Creating a new date object
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");         // Setting the date format
        String dateString = formatter.format(currentDate);                                      // Formatting the date 

        JMenuBar menuBar = new JMenuBar();                          // Creating a menu bar
        menuBar.setBounds(20, 20, 110, 25);      // Setting dimensions and position
        menuBar.setBackground(new Color(150, 100, 200));    // Setting background color

        JMenu menu = new JMenu("Options Menu");                  // Creating the menu

        // Creating menu options
        JMenuItem dateAndTime = new JMenuItem("Display Current Date and Time");
        JMenuItem logFile = new JMenuItem("Write Content to a Text File");
        JMenuItem frameColor = new JMenuItem("Change Frame Background Color");
        JMenuItem exit = new JMenuItem("Exit Window");

        JTextArea textArea = new JTextArea();      // Creating a textArea
        textArea.setBounds(150, 150 , 310, 310);          // Setting textArea dimensions and position

        // Setting the actions triggered when each menu option is clicked
        dateAndTime.addActionListener(e -> {
            textArea.setText("Current Date and Time: " + dateString);  // Print current date and time as a string to text area
            textArea.setFont(new Font("Times New Roman", 0, 17));     // Set font

        });

        logFile.addActionListener(e -> {
            try {
                String textAreaContent = textArea.getText();     // Get current text of textArea
                String file = "C:\\Users\\new user\\Desktop\\coding\\java\\prog2 - module3\\logfile.txt";  // Set text file name and destination
                FileWriter writer = new FileWriter(file);    // Defining a new FileWriter object writing to the given text file
                writer.write(textAreaContent);               // Write textArea content to the given text file 
                writer.close();                              // Close the FileWriter object
                JOptionPane.showMessageDialog(null, "Content written to text file successfully.");
                

            } catch (IOException error) {                   // In case an error occurred
                JOptionPane.showMessageDialog(null, "Could not save to text file.");
            }

        });


        frameColor.addActionListener(e -> { 
            // change frame backgound color to a random color hue of the color green
            frame.getContentPane().setBackground(new Color(randomNum, 255, randomNum));  

        });

        exit.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Exiting this application. Goodbye");
            System.exit(0);   // Exit application

        });



        // Adding menu items to menu
        menu.add(dateAndTime);
        menu.add(logFile);
        menu.add(frameColor);
        menu.add(exit);

        // Adding menu to menu bar
        menuBar.add(menu);

        // Adding menu bar and text area to frame
        frame.add(menuBar);
        frame.add(textArea);
        frame.setVisible(true);     // Setting frame to be visible
    }

}