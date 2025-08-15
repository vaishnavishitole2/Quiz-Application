package com.quizapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a single quiz question with options and a correct answer.
 */
class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;

    /**
     * Constructs a new Question.
     * @param questionText The text of the question.
     * @param options A list of possible answers.
     * @param correctAnswerIndex The 0-based index of the correct answer in the options list.
     */
    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getter for the question text
    public String getQuestionText() {
        return questionText;
    }

    // Getter for the options
    public List<String> getOptions() {
        return options;
    }

    // Getter for the correct answer index
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    /**
     * Displays the question and its options to the console.
     */
    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}

/**
 * The main class for the Online Quiz Application.
 * This class handles the quiz logic, including loading questions,
 * presenting them to the user, and scoring the results.
 */
public class Quiz {

    private List<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
        initializeQuestions();
    }

    /**
     * Initializes the list of questions for the quiz.
     */
    private void initializeQuestions() {
        // Question 1
        List<String> q1Options = new ArrayList<>();
        q1Options.add("Statements that allow controlling the flow of execution in a program.");
        q1Options.add("A way to store multiple values in a single variable.");
        q1Options.add("A method for printing output to the console.");
        q1Options.add("A data type for storing text.");
        questions.add(new Question("1. What are Java loops?", q1Options, 0));

        // Question 2
        List<String> q2Options = new ArrayList<>();
        q2Options.add("A loop that is guaranteed to execute at least once.");
        q2Options.add("A simplified loop for iterating over arrays or collections.");
        q2Options.add("A loop that runs indefinitely.");
        q2Options.add("A loop used for mathematical calculations.");
        questions.add(new Question("2. What is an enhanced for-loop (for-each loop)?", q2Options, 1));

        // Question 3
        List<String> q3Options = new ArrayList<>();
        q3Options.add("Using the System.out.println() method.");
        q3Options.add("Using a single variable to store all inputs.");
        q3Options.add("Using the Scanner class within a loop.");
        q3Options.add("Java cannot handle multiple user inputs.");
        questions.add(new Question("3. How do you handle multiple user inputs in a console application?", q3Options, 2));

        // Question 4
        List<String> q4Options = new ArrayList<>();
        q4Options.add("There is no difference.");
        q4Options.add("if-else is for loops, switch-case is for methods.");
        q4Options.add("switch-case compares one variable against multiple values; if-else handles complex logical conditions.");
        q4Options.add("switch-case is faster but less readable.");
        questions.add(new Question("4. How is a switch-case different from if-else?", q4Options, 2));

        // Question 5
        List<String> q5Options = new ArrayList<>();
        q5Options.add("A framework that provides an architecture to store and manipulate a group of objects.");
        q5Options.add("A special type of class in Java.");
        q5Options.add("A way to organize code into packages.");
        q5Options.add("A tool for debugging Java code.");
        questions.add(new Question("5. What are collections in Java?", q5Options, 0));

        // Question 6
        List<String> q6Options = new ArrayList<>();
        q6Options.add("A fixed-size array.");
        q6Options.add("A resizable array implementation of the List interface.");
        q6Options.add("An interface for creating lists.");
        q6Options.add("A collection that does not allow duplicate elements.");
        questions.add(new Question("6. What is an ArrayList?", q6Options, 1));

        // Question 7
        List<String> q7Options = new ArrayList<>();
        q7Options.add("Using a for loop with an index.");
        q7Options.add("Using the hasNext() and next() methods of an Iterator object.");
        q7Options.add("Using a while loop with a counter.");
        q7Options.add("You cannot use iterators to iterate.");
        questions.add(new Question("7. How do you iterate through a collection using an Iterator?", q7Options, 1));

        // Question 8
        List<String> q8Options = new ArrayList<>();
        q8Options.add("A collection that stores elements in a sequential order.");
        q8Options.add("An object that maps keys to values, with no duplicate keys.");
        q8Options.add("A collection that only stores unique elements.");
        q8Options.add("A type of loop in Java.");
        questions.add(new Question("8. What is a Map?", q8Options, 1));

        // Question 9
        List<String> q9Options = new ArrayList<>();
        q9Options.add("list.sort();");
        q9Options.add("Arrays.sort(list);");
        q9Options.add("Collections.sort(list);");
        q9Options.add("Lists cannot be sorted.");
        questions.add(new Question("9. How do you sort an ArrayList of strings called 'list'?", q9Options, 2));

        // Question 10
        List<String> q10Options = new ArrayList<>();
        q10Options.add("Collections.shuffle(list);");
        q10Options.add("list.randomize();");
        q10Options.add("Arrays.shuffle(list);");
        q10Options.add("There is no built-in way to shuffle a list.");
        questions.add(new Question("10. How do you randomly shuffle the elements of an ArrayList called 'list'?", q10Options, 0));
    }

    /**
     * Starts the quiz, presents questions, and calculates the final score.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        // Shuffle the questions to make the quiz different each time
        Collections.shuffle(questions);

        for (Question currentQuestion : questions) {
            System.out.println("\n------------------------------------");
            currentQuestion.displayQuestion();
            System.out.print("Your answer (1-" + currentQuestion.getOptions().size() + "): ");
            
            int userAnswer = -1;
            try {
                userAnswer = scanner.nextInt();
                // Convert 1-based answer to 0-based index
                if (userAnswer - 1 == currentQuestion.getCorrectAnswerIndex()) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer was: " + (currentQuestion.getCorrectAnswerIndex() + 1));
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number. Skipping question.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        displayResults();
        scanner.close();
    }

    /**
     * Displays the final score to the user.
     */
    public void displayResults() {
        System.out.println("\n====================================");
        System.out.println("Quiz Over!");
        System.out.println("Your final score is: " + score + " out of " + questions.size());
        System.out.println("====================================");
    }

    /**
     * The main method to run the quiz application.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Java Developer Internship Quiz!");
        Quiz quiz = new Quiz();
        quiz.start();
    }
}
