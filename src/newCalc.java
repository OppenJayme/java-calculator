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
        "AC", "+/-", "%", "÷",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "="
    };

    String[] right = {
        "÷", "x", "-", "+", "="
    };
    String[] top = {
        "AC", "+/-", "%"
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

    // A AND B WILL REPRESENT THE 2 NUMBERS!
    String A = "0";
    String operator = null;
    String B = null;
    
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
        frame.add(displayPanel, BorderLayout.NORTH); //DISPLAYS DISPLAYPANEL

        buttonsPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonsPanel.setBackground(backgroundCalc);
        frame.add(buttonsPanel);

        for (int i = 0; i < buttons.length; i++) {
           JButton button = new JButton(); // new button
           String buttonValue = buttons[i]; // values of each buttons from the string which contains operators and digits.
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

           // do something buttons! 
           button.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e){ //action performed will be a mouse click, E refers to the action
                    JButton button = (JButton) e.getSource(); //we nbeed to get the button that we clicked  E = action event, source is where it came from s oevent is a jButton
                    // next we need to identity that is clicked on, could be operators, or numbers;
                    String buttonValue = button.getText();
                    if (Arrays.asList(right).contains(buttonValue)){
                        if (buttonValue == "="){
                            if (A != null){
                                B = displayLabel.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                double result = 0;
                                switch (operator) {
                                    case "+": result = numA + numB; break;
                                    case "-": result = numA - numB; break;
                                    case "x": result = numA * numB; break;
                                    case "÷": result = numA / numB; break;
                                }
                                displayLabel.setText(removeZeroDecimal(result));
                                clearAll();
                               
                            }
                        } else if ("+-x÷".contains(buttonValue)){
                            if (operator == null){
                                A = displayLabel.getText();
                                displayLabel.setText("0");
                                B = "0";
                            }
                            operator = buttonValue; // checks for null because they can check operator twice, so if we check null we dont want them to press it twice/appear twice;
                            // basically it updates the operator everytime user presses an oeprator and changes into that operator
                        }
                    }
                    else if (Arrays.asList(top).contains(buttonValue)){
                        if (buttonValue == "AC"){   
                            clearAll();
                            displayLabel.setText("0");
                        }
                        else if (buttonValue == "+/-"){
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay *= -1;
                            displayLabel.setText(removeZeroDecimal(numDisplay));
                        }
                        else if (buttonValue == "%"){
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay /= 100;
                            displayLabel.setText(removeZeroDecimal(numDisplay));
                        }
                    }
                    else { // nubmers or .
                        if (buttonValue == "."){
                            if (!displayLabel.getText().contains(buttonValue)){
                                displayLabel.setText(displayLabel.getText() + buttonValue); // can add numbers after .
                            }

                        } else if ("0123456789".contains(buttonValue)){
                            if (displayLabel.getText() == "0"){
                                displayLabel.setText(buttonValue); 
                            } else {
                                displayLabel.setText(displayLabel.getText() + buttonValue); //can add numbers after 
                            }
                        }
                    }
                }
           });
        }
    }
    void clearAll(){
        A = "0";
        operator = null;
        B = "0";
    }
    
    String removeZeroDecimal(double numDisplay){
        if (numDisplay % 1 == 0){
            return Integer.toString((int)numDisplay);
        }
        return Double.toString(numDisplay);
    }
}
