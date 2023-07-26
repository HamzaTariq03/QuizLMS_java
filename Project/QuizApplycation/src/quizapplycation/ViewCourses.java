/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizapplycation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Hamza
 */
public class ViewCourses extends JFrame implements ActionListener{
    
    JButton back;
    
    void Courses(){
        getContentPane().setBackground(Color.BLACK);
       setLayout(null);
       
       
         // Create buttons for different courses
       JButton DBT = new JButton("Database Management System Theory (DBT-2001)");
       DBT.setBounds(200,150,450,35);
       DBT.setBackground(Color.BLACK);
       DBT.setForeground(Color.BLUE);
       DBT.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(DBT);
       
       JButton DBL = new JButton("Database Management System Lab (DBL-2001)");
       DBL.setBounds(200,190,450,35);
       DBL.setBackground(Color.BLACK);
       DBL.setForeground(Color.BLUE);
       DBL.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(DBL);
       
       JButton OOPT = new JButton("Object Oriented Programming Theory(OOPT-2002)");
       OOPT.setBounds(200,230,470,35);
       OOPT.setBackground(Color.BLACK);
       OOPT.setForeground(Color.BLUE);
       OOPT.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(OOPT);
       
       JButton OOPL = new JButton("Object Oriented Programming Lab");
       OOPL.setBounds(200,270,450,35);
       OOPL.setBackground(Color.BLACK);
       OOPL.setForeground(Color.BLUE);
       OOPL.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(OOPL);
       
       
       JButton OSL = new JButton("Operating System Lab (OSL-2003)");
       OSL.setBounds(200,310,450,35);
       OSL.setBackground(Color.BLACK);
       OSL.setForeground(Color.BLUE);
       OSL.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(OSL);
       
       JButton OST = new JButton("Operating System Theory (OSL-2003)");
       OST.setBounds(200,350,450,35);
       OST.setBackground(Color.BLACK);
       OST.setForeground(Color.BLUE);
       OST.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(OST);
       
       JButton SDA = new JButton("Software Design and Architecture (SDA-2004)");
       SDA.setBounds(200,390,450,35);
       SDA.setBackground(Color.BLACK);
       SDA.setForeground(Color.BLUE);
       SDA.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(SDA);
       
        // Create the "Back" button
       back=new JButton("Back");
       back.setBounds(200,480,120,45);
       back.setBackground(Color.WHITE);
       back.setForeground(Color.RED);
       back.addActionListener(this);
       add(back);
        
        setSize(800,650); 
        setLocation(250,70);
        setVisible(true);
    }
    public static void main(String[] args){
        ViewCourses viewCourses=new ViewCourses();
        viewCourses.Courses();
    }

    // ActionListener implementation for the "Back" button
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
             StudentOptions studentOptions=new StudentOptions();
             studentOptions.Studentpotal();
            
        }
    }
    
}
