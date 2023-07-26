/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizapplycation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Hamza
 */
public class TeachersOption extends JFrame implements ActionListener{
   
    JButton back,View,marks;
    void Teacherpotal(){
        getContentPane().setBackground(Color.BLACK);
       setLayout(null);
       
       // Heading label
        JLabel heading = new JLabel("Teacher's Portal");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);
       
        // Create the "View Courses" button
       View = new JButton("select Course");
       View.setBounds(300,180,200,100);
       View.setBackground(Color.BLACK);
       View.setForeground(Color.BLUE);
       View.setFont(new Font("Times New Roman",Font.BOLD,20));
       View.addActionListener(this);
       add(View);
       
       marks = new JButton("Quiz Update");
       marks.setBounds(300,300,200,100);
       marks.setBackground(Color.BLACK);
       marks.setForeground(Color.BLUE);
       marks.setFont(new Font("Times New Roman",Font.BOLD,20));
       marks.addActionListener(this);
       add(marks);
       
       
       back = new JButton("back");
       back.setBounds(300,430,130,45);
       back.setBackground(Color.WHITE);
       back.setForeground(Color.RED);
       back.addActionListener(this);
       add(back);
       
       
         setSize(800,650); 
        setLocation(250,70);
        setVisible(true);
    }
    public static void main(String[] args){
        TeachersOption  teacherOptions=new TeachersOption();
         teacherOptions. Teacherpotal();
    }

    // ActionListener implementation for the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        
         
        if(e.getSource()== View)
        {
            setVisible(false);
             Courses obj=new Courses();
              obj.courses();

        }
        else if(e.getSource()== marks){
            displayQuizMarks();
        }
        else{
            setVisible(false);
              Teacher teacher=new Teacher();
              teacher.setupTeachersPortal();

        }
         
    }
    
      // Method to read and display quiz marks from a file
    private void displayQuizMarks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("QuizMarks.txt"))) {
            String score = reader.readLine();
            String message = "Quiz Marks: " + score;
            JOptionPane.showMessageDialog(null, "Hamza is present in Quiz\n"+message);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the quiz marks.");
        }
    }
}
    


    

