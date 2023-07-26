/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizapplycation;

/**
 *
 * @author Hamza
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Teacher extends JFrame implements ActionListener {
    // UI Components
    private JButton enterButton, backButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel invalidLabel;

    

     void setupTeachersPortal() {
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        // Heading label
        JLabel heading = new JLabel("Teacher Portal");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        // Username label and field
        JLabel usernameLabel = new JLabel("Enter your Name");
        usernameLabel.setBounds(400, 200, 300, 20);
        usernameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        usernameLabel.setForeground(Color.RED);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(350, 240, 300, 25);
        usernameField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(usernameField);

        // Password label and field
        JLabel passwordLabel = new JLabel("Enter your Password");
        passwordLabel.setBounds(400, 300, 300, 20);
        passwordLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        passwordLabel.setForeground(Color.RED);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(350, 340, 300, 25);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(passwordField);

        // Enter button
        enterButton = new JButton("Enter");
        enterButton.setBounds(350, 410, 100, 25);
        enterButton.setBackground(Color.BLUE);
        enterButton.setForeground(Color.BLACK);
        enterButton.addActionListener(this);
        add(enterButton);

        // Back button
        backButton = new JButton("Back");
        backButton.setBounds(450, 410, 130, 25);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.RED);
        backButton.addActionListener(this);
        add(backButton);

        // Invalid login label
        invalidLabel = new JLabel("Invalid");
        invalidLabel.setBounds(450, 450, 130, 25);
        invalidLabel.setBackground(Color.WHITE);
        invalidLabel.setForeground(Color.RED);
        invalidLabel.setVisible(false);
        add(invalidLabel);

        setSize(800, 650);
        setLocation(250, 70);
        setVisible(true);
    }

    public static void main(String[] args) {
         Teacher teacher=new Teacher();
         teacher.setupTeachersPortal();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (ae.getSource() == backButton) {
            setVisible(false);
            Login login = new Login();
            login.setupLogin();
        } else if (ae.getSource() == enterButton) {
            if (isValidLogin(username, password)) {
                setVisible(false);
                TeachersOption  teacherOptions=new TeachersOption();
                teacherOptions. Teacherpotal();
            } else {
                // Show the invalid login message
                invalidLabel.setVisible(true);
                // Display a dialog box with an error message
                JOptionPane.showMessageDialog(this, "Invalid password. Please try again.");
            }
        }
    }

    // Add a method to check the validity of the login credentials
    private boolean isValidLogin(String username, String password) {
        return username.equals("teacher") && password.equals("12345");
    }
}