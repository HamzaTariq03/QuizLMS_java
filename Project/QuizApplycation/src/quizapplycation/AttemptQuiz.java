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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class AttemptQuiz extends JFrame implements ActionListener {

    ArrayList<ButtonGroup> optionGroups;
    int totalQuestions;
    int correctAnswers;
    JButton submitButton;
    Timer timer;
    JLabel timerLabel;
    int timeRemaining;

    AttemptQuiz() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        optionGroups = new ArrayList<>();
        totalQuestions = 0;
        correctAnswers = 0;

        JLabel heading = new JLabel("Quiz Application");
        heading.setBounds(300, 20, 500, 45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        try (BufferedReader reader = new BufferedReader(new FileReader("SelectedQuestions.txt"));
             FileWriter writer = new FileWriter("AnswerFile.txt")) {
            String line;
            int yPos = 50;
            while ((line = reader.readLine()) != null) {
                if (line.contains("{")) {
                    String[] questionParts = line.split("\\{");
                    String questionText = questionParts[0];
                    String[] options = questionParts[1].replace("}", "").split(",");
                    JLabel questionLabel = new JLabel(questionText);
                    questionLabel.setBounds(30, yPos, 800, 25);
                    add(questionLabel);
                    yPos += 30;

                    ButtonGroup optionGroup = new ButtonGroup();

                    // Add radio buttons for options
                    int optionIndex = 0;
                    for (String option : options) {
                        if (optionIndex < options.length - 1) {
                            JRadioButton optionRadioButton = new JRadioButton(option.trim());
                            optionRadioButton.setBounds(60, yPos, 800, 25);
                            optionGroup.add(optionRadioButton);
                            add(optionRadioButton);
                            yPos += 30;
                        }

                        // Check if it's the last option
                        if (optionIndex == options.length - 1) {
                            // Write the last option to the answer file
                            writer.write(option.trim() + System.lineSeparator());
                        }
                        optionIndex++;
                    }

                    optionGroups.add(optionGroup);
                    totalQuestions++;
                } else {
                    JLabel label = new JLabel(line);
                    label.setBounds(30, yPos, 800, 25);
                    add(label);
                    yPos += 30;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file.");
        }

        submitButton = new JButton("Submit");
        submitButton.setBounds(350, 550, 100, 30);
        submitButton.setBackground(Color.RED);
        submitButton.setForeground(Color.BLUE);
        submitButton.addActionListener(this);
        add(submitButton);

        timerLabel = new JLabel();
        timerLabel.setBounds(650, 30, 100, 45);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(timerLabel);

        timeRemaining = 1 * 60; // number of minutes in seconds
        timer = new Timer(1000, (ActionEvent e) -> {
        updateTimer();
        });
        timer.start();

        setSize(800, 650);
        setLocation(250, 70);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AttemptQuiz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            timer.stop(); // Stop the timer when the Submit button is clicked
            checkAnswers();
            displayScore();
            submitButton.setEnabled(false); // Disable the submit button after it has been clicked
        }
    }

    private void checkAnswers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("AnswerFile.txt"))) {
            int questionIndex = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                ButtonGroup optionGroup = optionGroups.get(questionIndex);
                Enumeration<AbstractButton> buttons = optionGroup.getElements();
                String selectedOption = null;

                while (buttons.hasMoreElements()) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        selectedOption = button.getText();
                        break;
                    }
                }

                if (selectedOption != null && line.trim().equalsIgnoreCase(selectedOption.trim())) {
                    correctAnswers++;
                }

                questionIndex++;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file.");
        }
    }

    private void displayScore() {
        int score = correctAnswers;
        String message = "Your Score is: " + score;
        JOptionPane.showMessageDialog(null, message);

        try (FileWriter scoreWriter = new FileWriter("QuizMarks.txt")) {
            scoreWriter.write(String.valueOf(score));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while writing the score.");
        }
    }

    private void updateTimer() {
        if (timeRemaining > 0) {
            int minutes = timeRemaining / 60;
            int seconds = timeRemaining % 60;
            timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
            timeRemaining--;
        } else {
            timer.stop();
            checkAnswers();
            displayScore();
            submitButton.setEnabled(false);
        }
    }
}

*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class AttemptQuiz extends JFrame implements ActionListener {
 
         // ArrayList to store ButtonGroups for each question
    ArrayList<ButtonGroup> optionGroups;
        // Variables to keep track of the total number of questions and correct answers

    int totalQuestions;
    int correctAnswers;
    JButton submitButton;
    Timer timer;
    JLabel timerLabel;
    int timeRemaining;

    void Quiz() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        optionGroups = new ArrayList<>();
        totalQuestions = 0;
        correctAnswers = 0;

                // Create a label for the heading of the quiz application
        JLabel heading = new JLabel("Quiz Application");
        heading.setBounds(300, 20, 500, 45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        try (BufferedReader reader = new BufferedReader(new FileReader("SelectedQuestions.txt"));
             FileWriter writer = new FileWriter("AnswerFile.txt")) {
            String line;
            int yPos = 50;
                        // Loop through each line in the SelectedQuestions.txt file
            while ((line = reader.readLine()) != null) {
                if (line.contains("{"))// If the line contains a question
                {
                    String[] questionParts = line.split("\\{");
                    String questionText = questionParts[0];
                    String[] options = questionParts[1].replace("}", "").split(",");
                    
                    // Create a label for the question and add it to the frame
                    JLabel questionLabel = new JLabel(questionText);
                    questionLabel.setBounds(30, yPos, 800, 25);
                    add(questionLabel);
                    yPos += 30;

                    ButtonGroup optionGroup = new ButtonGroup();

                    // Add radio buttons for options
                    int optionIndex = 0;
                    for (String option : options) {
                        if (optionIndex < options.length - 1) {
                            JRadioButton optionRadioButton = new JRadioButton(option.trim());
                            optionRadioButton.setBounds(60, yPos, 800, 25);
                            optionGroup.add(optionRadioButton);
                            add(optionRadioButton);
                            yPos += 30;
                        }

                        // Check if it's the last option
                        if (optionIndex == options.length - 1) {
                            // Write the last option to the answer file
                            writer.write(option.trim() + System.lineSeparator());
                        }
                        optionIndex++;
                    }

                    optionGroups.add(optionGroup);
                    totalQuestions++;
                }
                else {
                    JLabel label = new JLabel(line);
                    label.setBounds(30, yPos, 800, 25);
                    add(label);
                    yPos += 30;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file.");
        }

        submitButton = new JButton("Submit");
        submitButton.setBounds(350, 550, 100, 30);
        submitButton.setBackground(Color.RED);
        submitButton.setForeground(Color.BLUE);
        submitButton.addActionListener(this);
        add(submitButton);

        timerLabel = new JLabel();
        timerLabel.setBounds(650, 30, 100, 45);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(timerLabel);

        int timerValue = 1; // Default value if file reading fails
    try (BufferedReader reader = new BufferedReader(new FileReader("TimerValue.txt"))) {
        String line = reader.readLine();
        if (line != null && !line.isEmpty()) {
            timerValue = Integer.parseInt(line);
        }
    } 
    catch (IOException | NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "An error occurred w");
    }

    timeRemaining = timerValue * 60; // Convert minutes to seconds

    // Start the timer
    timer = new Timer(1000, (ActionEvent e) -> {
        updateTimer();
    });
    timer.start();

        setSize(800, 650);
        setLocation(250, 70);
        setVisible(true);
    }

    public static void main(String[] args) {
        AttemptQuiz attemptQuiz=new AttemptQuiz();
        attemptQuiz.Quiz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
             timer.stop(); // Stop the timer when the Submit button is clicked
            checkAnswers(); // Check the selected answers against the correct answers
            displayScore();
            submitButton.setEnabled(false); // Disable the submit button after it has been clicked
        }
    }

    private void checkAnswers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("AnswerFile.txt"))) {
            int questionIndex = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                ButtonGroup optionGroup = optionGroups.get(questionIndex);
                Enumeration<AbstractButton> buttons = optionGroup.getElements();
                String selectedOption = null;

                // Check which option was selected by the user
                while (buttons.hasMoreElements()) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        selectedOption = button.getText();
                        break;
                    }
                }

                 // If the selected option matches the correct answer, increment the correctAnswers count
                if (selectedOption != null && line.trim().equalsIgnoreCase(selectedOption.trim())) {
                    correctAnswers++;
                }

                questionIndex++;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file.");
        }
    }

    private void displayScore() {
        int score = correctAnswers;
        String message = "Your Score is: " + score;
        JOptionPane.showMessageDialog(null, message);

        try (FileWriter scoreWriter = new FileWriter("QuizMarks.txt")) {
            scoreWriter.write(String.valueOf(score));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while writing the score.");
        }
    }

    private void updateTimer() {
        if (timeRemaining > 0) {
            int minutes = timeRemaining / 60;
            int seconds = timeRemaining % 60;
            timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
            timeRemaining--;
        } else {
              // If the timer reaches 0, stop the timer, check answers, display the score, and disable the submit button
            timer.stop();
            checkAnswers();
            displayScore();
            submitButton.setEnabled(false);
        }
    }
}

