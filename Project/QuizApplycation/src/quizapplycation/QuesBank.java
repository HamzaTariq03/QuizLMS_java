/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizapplycation;


/**
 *
 * @author Hamza
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuesBank extends JFrame implements ActionListener {

    ArrayList<JCheckBox> checkBoxes;
    JButton addButton, back;
    JTextField timerBox, dateBox;

   void Selectques() throws IOException {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Create a heading label
        JLabel heading = new JLabel("Question Bank");
        heading.setBounds(300, 20, 500, 45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        checkBoxes = new ArrayList<>();
// Read questions from the "Question.txt" file and create checkboxes for each question
        try (BufferedReader reader = new BufferedReader(new FileReader("Question.txt"))) {
            String line;
            int yPos = 50;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    JCheckBox checkBox = new JCheckBox(line);
                    checkBox.setBounds(30, yPos, 800, 25);
                    checkBoxes.add(checkBox); // Add the checkbox to the list
                    add(checkBox); // Add the checkbox to the frame
                    yPos += 30;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file.");
        }
 // Create the "Create" button
        addButton = new JButton("Create");
        addButton.setBounds(100, 550, 80, 50);
        addButton.addActionListener(e -> saveSelectedQuestions());
        addButton.setBackground(Color.RED);
        addButton.setForeground(Color.BLUE);
        add(addButton);

          // Create the "Back" button
        back = new JButton("Back");
        back.setBounds(400, 550, 80, 50);
        back.setBackground(Color.RED);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        add(back);
        
  // Create labels and text fields for entering timer value and date
        JLabel timerLabel = new JLabel("Timer:");
        timerLabel.setBounds(25, 500, 50, 25);
        timerLabel.setForeground(Color.RED);
        add(timerLabel);

        timerBox = new JTextField();
        timerBox.setBounds(65, 500, 100, 25);
        add(timerBox);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(30, 520, 50, 25);
        dateLabel.setForeground(Color.RED);
        add(dateLabel);

        dateBox = new JTextField();
        dateBox.setBounds(65, 520, 100, 25);
        add(dateBox);

        setSize(800, 650);
        setLocation(250, 70);
        setVisible(true);
    }

     // Method to save selected questions to a file
    private void saveSelectedQuestions() {
        ArrayList<String> selectedQuestions = getSelectedQuestions();
        
        String timerValue = timerBox.getText();
// Write the selected questions to the "SelectedQuestions.txt" file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("SelectedQuestions.txt"))) {
            for (String question : selectedQuestions) {
                writer.write(question);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Questions added.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred.");
        }
            saveTimerValueToFile(timerValue);

    }
    
    // Method to save the timer value to a file
    private void saveTimerValueToFile(String timerValue) {
        // Write the timer value to the "TimerValue.txt" file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("TimerValue.txt"))) {
        writer.write(timerValue);
        JOptionPane.showMessageDialog(null, "Timer value added to file.");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "An error occurred while writing the timer value to the file.");
    }
}

    // Method to get the selected questions from the checkboxes

    private ArrayList<String> getSelectedQuestions() {
        ArrayList<String> selectedQuestions = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedQuestions.add(checkBox.getText());
            }
        }
        return selectedQuestions;
    }

    public static void main(String[] args) throws IOException {
       QuesBank quesBank=new QuesBank();
       quesBank.Selectques();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
              CreateQuiz createQuiz=new CreateQuiz();
              createQuiz.EnterQues();
        }
    }
    
    
}


