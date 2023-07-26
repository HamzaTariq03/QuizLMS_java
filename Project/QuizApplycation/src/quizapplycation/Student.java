/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizapplycation;
/*
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Hamza
 */
/*
public class Student extends JFrame implements ActionListener{
    
    JButton rules,back;
    JTextField tfname,tfname2;
    JLabel wrong;
    Student(){
        
        getContentPane().setBackground(Color.BLACK);
       setLayout(null);
       
       JLabel heading =new JLabel("Student Portel");
       heading.setBounds(50,20,700,30);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
       heading.setForeground(Color.RED);
       add(heading);
       
       JLabel name =new JLabel("Enter your name");
       name.setBounds(400,200,300,20);
       name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
       name.setForeground(Color.red);
       add(name);
       
       tfname=new JTextField();
       tfname.setBounds(350,240,300,25);
       tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(tfname);
       
       JLabel pass =new JLabel("Enter your Password");
       pass.setBounds(400,300,300,20);
       pass.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
       pass.setForeground(Color.red);
       add(pass);
       
       tfname2=new JPasswordField();
       tfname2.setBounds(350,340,300,25);
       tfname2.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(tfname2);
       
       rules=new JButton("Enter");
       rules.setBounds(350,410,100,25);
       rules.setBackground(Color.BLUE);
       rules.setForeground(Color.BLACK);
       rules.addActionListener(this);
       add(rules);
       
       
       back=new JButton("Back");
       back.setBounds(450,410,130,25);
       back.setBackground(Color.WHITE);
       back.setForeground(Color.RED);
       back.addActionListener(this);
       add(back);
       
       
       
        
        setSize(800,650); 
        setLocation(250,70);
        setVisible(true);
    }
         @Override
public void actionPerformed(ActionEvent ae){
     String userValue = tfname.getText();
     String passValue = tfname2.getText();
     
    if(ae.getSource()==back){
            setVisible(false);
            Login login=new Login();
            login.setupLogin();
            
        }
        else if(ae.getSource()==rules )
        {
            if(userValue.equals("student") && passValue.equals("12345"))
            {
            setVisible(false);
            new StudentOptions();
            }
            else
            {
                    JOptionPane.showMessageDialog(null, "Invalid password. Please try again.");
            }
        }
      }





   public static void main(String[] args){ 
       new Student();
   }   

}
*/


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Student Portal Frame for login and access options.
 * Extends JFrame to create the student portal window.
 * Implements ActionListener to handle button clicks.
 * 
 * This class represents the Student Portal login screen and options.
 * Users can enter their name and password to log in as a student.
 * After successful login, students can access various options.
 */

public class Student extends JFrame implements ActionListener {
    
    private JButton enterButton, backButton;
    private JTextField tfName;
    private JPasswordField tfPassword;

    /**
     * Constructs the Student Portal UI and sets up the components.
     */

    public void setupStudentPortal() {
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        // Create and customize the heading label
        JLabel heading = new JLabel("Student Portal");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);
        
        // Create and customize the name label and text field
        JLabel nameLabel = new JLabel("Enter your name");
        nameLabel.setBounds(400, 200, 300, 20);
        nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        nameLabel.setForeground(Color.RED);
        add(nameLabel);
        
        tfName = new JTextField();
        tfName.setBounds(350, 240, 300, 25);
        tfName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfName);
        
        // Create and customize the password label and password field
        JLabel passLabel = new JLabel("Enter your Password");
        passLabel.setBounds(400, 300, 300, 20);
        passLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        passLabel.setForeground(Color.RED);
        add(passLabel);
        
        tfPassword = new JPasswordField();
        tfPassword.setBounds(350, 340, 300, 25);
        tfPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfPassword);
        
        // Create the enter button
        enterButton = new JButton("Enter");
        enterButton.setBounds(350, 410, 100, 25);
        enterButton.setBackground(Color.BLUE);
        enterButton.setForeground(Color.BLACK);
        enterButton.addActionListener(this);
        add(enterButton);
        
        // Create the back button
        backButton = new JButton("Back");
        backButton.setBounds(450, 410, 130, 25);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.RED);
        backButton.addActionListener(this);
        add(backButton);
        
        setSize(800, 650);
        setLocation(250, 70);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String userValue = tfName.getText();
        String passValue = tfPassword.getText();
        
        if (ae.getSource() == backButton) {
            setVisible(false);
            Login login=new Login();
            login.setupLogin();
            
        } else if (ae.getSource() == enterButton) {
            if (userValue.equals("student") && passValue.equals("12345")) {
                setVisible(false);
                StudentOptions studentOptions=new StudentOptions();
                studentOptions.Studentpotal();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Student studentPortal = new Student();
        studentPortal.setupStudentPortal();
    }
} 