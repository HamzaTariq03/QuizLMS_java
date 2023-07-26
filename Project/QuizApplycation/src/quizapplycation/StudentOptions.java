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
import javax.swing.JOptionPane;


 
/**
 *
 * @author Hamza
 */
public class StudentOptions extends JFrame implements ActionListener{
   
    JButton back,quiz,View,marks;
    void Studentpotal(){
        getContentPane().setBackground(Color.BLACK);
       setLayout(null);
       
       // Create the "Attempt Quiz" button
       quiz = new JButton("Attempt Quiz");
       quiz.setBounds(300,150,180,80);
       quiz.setBackground(Color.BLACK);
       quiz.setForeground(Color.BLUE);
       quiz.setFont(new Font("Times New Roman",Font.BOLD,20));
       quiz.addActionListener(this);
       add(quiz);
        // Create the "View Courses" button
       View = new JButton("View Courses");
       View.setBounds(300,250,180,80);
       View.setBackground(Color.BLACK);
       View.setForeground(Color.BLUE);
       View.setFont(new Font("Times New Roman",Font.BOLD,20));
       View.addActionListener(this);
       add(View);
       
       marks = new JButton("Quiz Update");
       marks.setBounds(300,350,180,80);
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
        StudentOptions studentOptions=new StudentOptions();
        studentOptions.Studentpotal();
    }

    // ActionListener implementation for the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource()== quiz){
            setVisible(false);
             QuizCourse quizCourse=new QuizCourse();
             quizCourse.Course();
            //new Teacher();
        }
        else if(e.getSource()== View)
        {
            setVisible(false);
            ViewCourses viewCourses=new ViewCourses();
            viewCourses.Courses();  
        }
        else if(e.getSource()== marks){
            displayQuizMarks();
        }
        else{
            setVisible(false);
             Student studentPortal = new Student();
             studentPortal.setupStudentPortal();

        }
         
    }
    
      // Method to read and display quiz marks from a file
    private void displayQuizMarks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("QuizMarks.txt"))) {
            String score = reader.readLine();
            String message = "Quiz Marks: " + score;
            JOptionPane.showMessageDialog(null, "you are present in Quiz\n"+message);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the quiz marks.");
        }
    }
}
    

