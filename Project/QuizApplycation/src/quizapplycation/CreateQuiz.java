/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizapplycation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Hamza
 */
public class CreateQuiz extends JFrame implements ActionListener {
    
    JTextField ques,a,b,c,d,ans;
    JButton add,next,back,bank,exit;
    
    
    void EnterQues(){
        getContentPane().setBackground(Color.BLACK);
       setLayout(null);
        
        // Label and TextField for entering the question
       
        
       JLabel heading =new JLabel("Question: ");
       heading.setBounds(50,70,200,25);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
       heading.setForeground(Color.RED);
       add(heading);
       
       ques=new JTextField();
       ques.setBounds(150,50,600,55);
       ques.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(ques);
        
        // Labels and TextFields for entering options (a, b, c, d)
       
       JLabel t1 =new JLabel("a");
       t1.setBounds(130,120,100,20);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
       t1.setForeground(Color.RED);
       add(t1);
       
       a=new JTextField();
       a.setBounds(150,130,100,40);
       a.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(a);
       
       JLabel t2 =new JLabel("b");
       t2.setBounds(130,180,100,20);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
       t2.setForeground(Color.RED);
       add(t2);
       
       b=new JTextField();
       b.setBounds(150,180,100,40);
       b.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(b);
       
       JLabel t3 =new JLabel("c");
       t3.setBounds(130,230,100,20);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
       t3.setForeground(Color.RED);
       add(t3);
       
       c=new JTextField();
       c.setBounds(150,230,100,40);
       c.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(c);
       
       JLabel t4 =new JLabel("d");
       t4.setBounds(130,290,100,20);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
       t4.setForeground(Color.RED);
       add(t4);
       
       d=new JTextField();
       d.setBounds(150,280,100,40);
       d.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(d);
       
        // Label and TextField for entering the correct answer
        
       JLabel t5 =new JLabel("correct");
       t5.setBounds(100,340,100,20);
       heading.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
       t5.setForeground(Color.RED);
       add(t5);
       
       ans=new JTextField();
       ans.setBounds(150,330,100,40);
       ans.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(ans);
       
       // Buttons for adding question, moving to the next question, showing question bank, going back, and exiting
      
       add=new JButton("Add");
       add.setBounds(150,380,130,45);
       add.setBackground(Color.WHITE);
       add.setForeground(Color.RED);
       add.addActionListener(this);
       add(add);
       
       next=new JButton("Next");
       next.setBounds(150,430,130,45);
       next.setBackground(Color.WHITE);
       next.setForeground(Color.RED);
       next.addActionListener(this);
       add(next);
       
       bank=new JButton("Question Bank");
       bank.setBounds(150,480,130,45);
       bank.setBackground(Color.WHITE);
       bank.setForeground(Color.RED);
       bank.addActionListener(this);
       add(bank);
       
       back=new JButton("Back");
       back.setBounds(450,430,130,45);
       back.setBackground(Color.WHITE);
       back.setForeground(Color.RED);
       back.addActionListener(this);
       add(back);
       
       exit=new JButton("exit");
       exit.setBounds(450,480,130,45);
       exit.setBackground(Color.WHITE);
       exit.setForeground(Color.RED);
       exit.addActionListener(this);
       add(exit);
       
       

       
       
        setSize(800,650); 
        setLocation(250,70);
        setVisible(true);
    }
    public static void main(String[] args){
        CreateQuiz createQuiz=new CreateQuiz();
        createQuiz.EnterQues();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 // If "Add" button is clicked, write the question and options to a file
       if (e.getSource() == add) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Question.txt", true))) {
        String options = "{" + a.getText() + ", " + b.getText() + ", " + c.getText() + ", " + d.getText() +", " + ans.getText() + "}";
         // Write the question and options to the file
        writer.write(ques.getText() + options);
        writer.newLine();
        JOptionPane.showMessageDialog(null, "Question Added Successfully");
    } catch (IOException ex) {
        // Show error message if an exception occurs while writing to the file
        JOptionPane.showMessageDialog(null, "An error occurred.");
    }
    
}
        else if(e.getSource() == next){
            ques.setText("");a.setText("");b.setText("");c.setText("");d.setText("");ans.setText("");
        }
        else if(e.getSource()==back){
            setVisible(false);
            Courses obj=new Courses();
            obj.courses();
        }
        
        else if(e.getSource()==exit){
            setVisible(false);
        }       
        // If "Question Bank" button is clicked, show the Question Bank page

        else if(e.getSource()==bank) {
            setVisible(false);
            QuesBank quesBank=new QuesBank();
           try {
               quesBank.Selectques();
           } catch (IOException ex) {
               Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, null, ex);
           }
      }
    }
}
