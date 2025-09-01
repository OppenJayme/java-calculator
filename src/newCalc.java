// imports for graphics handling and event handling
import java.awt.*;
import java.awt.event.*;

// array
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder; // modyifing border if bttons

public class newCalc {
    int windowWidth = 360;
    int windowHeight = 540;

    // colors
    Color operators = new Color(113, 90, 90); // orangergb(55, 53, 62)
    Color text = new Color(211, 218, 217); // rgb(211, 218, 217)
    Color backgroundCalc = new Color(55, 53, 62); // rgb(55, 53, 62)
    Color numPad = new Color(68,68,78); //

    String[] buttons = {
        "AC", "±", "%", "÷",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "="
    };

    String[] right = {
        "÷", "x", "-", "+", "="
    };
    String[] top = {
        "AC", "±", "%"
    };


    JFrame frame = new JFrame("Jayme's Calculator"); // new Frame with Title Jayme's Calculator;
    /*JFrame in Java is a class that allows you to crеatе and manage a 
    top-lеvеl window in a Java application. It sеrvеs as thе main window for GUI-basеd Java 
    applications and providеs a platform-indеpеndеnt way to crеatе graphical usеr intеrfacеs. 
        - Geeksfor Geeks
    */
    JLabel displayLabel = new JLabel(); // to display numbers and results
    JPanel displayPanel = new JPanel(); // to hold buttons in a panel
    JPanel buttonsPanel = new JPanel(); // to hold buttons in a panel


    
    void Calculator(){

        frame.setVisible(true); // so we can see the frame;
        frame.setSize(windowWidth, windowHeight); // height and width
        frame.setLocationRelativeTo(null); // Positions the JFrame relative to the specified component. If null, it centers the frame on the screeen.
        frame.setResizable(false); // user cannot change the size of jFrame, width and height of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the operation/program when user exits
        frame.setLayout(new BorderLayout()); // i can place components north, south, east or west within the window
        
        displayLabel.setBackground(backgroundCalc);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonsPanel.setBackground(backgroundCalc);
        frame.add(buttonsPanel);

        for (int i = 0; i < buttons.length; i++) {
           JButton button = new JButton();
           String buttonValue = buttons[i];
           button.setFont(new Font("Arial", Font.PLAIN, 24));
           button.setText(buttonValue);
           button.setFocusable(false);
            button.setBorder(new LineBorder(backgroundCalc));
           if (Arrays.asList(top).contains(buttonValue)) {
                button.setBackground(operators);
                button.setForeground(text);
           } else if (Arrays.asList(right).contains(buttonValue)) {
                button.setBackground(operators);
                button.setForeground(text);
           } else {
                button.setBackground(numPad);
                button.setForeground(text);
           }
           buttonsPanel.add(button);
        }
    }
}
