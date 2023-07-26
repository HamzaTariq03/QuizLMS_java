/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizapplycation;

/**
 *
 * @author Hamza
 */
/*
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    
    JButton back,teacher,student;
    
    Login(){
       getContentPane().setBackground(Color.BLACK);
       setLayout(null);
       
       JLabel heading =new JLabel("QUIZ MANAGEMENT SYSTEM");
       heading.setBounds(300,50,500,45);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
       heading.setForeground(Color.RED);
       add(heading);
       
       
       teacher=new JButton("Teacher");
       teacher.setBounds(400,110,150,70);
       teacher.setBackground(Color.BLACK);
       teacher.setForeground(Color.BLUE);
       teacher.setFont(new Font("Times New Roman",Font.BOLD,20));
       teacher.addActionListener(this);
       add(teacher);
       
       student=new JButton("Student");
       student.setBounds(400,200,150,70);
       student.setBackground(Color.BLACK);
       student.setForeground(Color.BLUE);
       student.setFont(new Font("Times New Roman",Font.BOLD,20));
       student.addActionListener(this);
       add(student);
       
       /*
       rules=new JButton("Enter");
       rules.setBounds(350,250,100,25);
       rules.setBackground(Color.BLUE);
       rules.setForeground(Color.BLACK);
       rules.addActionListener(this);
       add(rules);
       */
       
    /*   back=new JButton("EXIT");
       back.setBounds(400,290,130,45);
       back.setBackground(Color.WHITE);
       back.setForeground(Color.RED);
       back.addActionListener(this);
       add(back);
       
       setSize(900,500);
       setLocation(200,150);
       setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== teacher){
            setVisible(false);
            new Teacher();
        
        }
        else if(ae.getSource()== student)
        {
            setVisible(false);
            new Student();
           
        }
        else if(ae.getSource()==back){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
       //Login obj= new Login();
       new Login();
       //obj.Login();
    }
    
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    // Buttons for UI
    private JButton back, teacher, student;

    // Method to set up the Login UI
    public void setupLogin() {
        // Set the background color and layout for the frame
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        // Create and customize the heading label
        JLabel heading = new JLabel("QUIZ MANAGEMENT SYSTEM");
        heading.setBounds(300, 50, 500, 45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        // Create and customize the Teacher button
        teacher = new JButton("Teacher");
        teacher.setBounds(400, 110, 150, 70);
        teacher.setForeground(Color.BLUE);
        teacher.setFont(new Font("Times New Roman", Font.BOLD, 20));
        teacher.addActionListener(this);
        add(teacher);

        // Create and customize the Student button
        student = new JButton("Student");
        student.setBounds(400, 200, 150, 70);
        student.setForeground(Color.BLUE);
        student.setFont(new Font("Times New Roman", Font.BOLD, 20));
        student.addActionListener(this);
        add(student);

        // Create and customize the Exit button
        back = new JButton("EXIT");
        back.setBounds(400, 290, 130, 45);
        back.setForeground(Color.RED);
        back.addActionListener(this);
        add(back);

        // Set the frame size, location, and make it visible
        setSize(900, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Handle button clicks
        if (ae.getSource() == teacher) {
            setVisible(false);
            Teacher teacher=new Teacher();
            teacher.setupTeachersPortal();
        } else if (ae.getSource() == student) {
            setVisible(false);
             Student studentPortal = new Student();
             studentPortal.setupStudentPortal();
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setupLogin();
    }
}   
