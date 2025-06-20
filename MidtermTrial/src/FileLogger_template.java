import java.io.*;
import java.util.Scanner;

/**
 * Assignment 1: Simple File Logger
 * Create a Java application that logs messages to a file via a command-line interface.
 */
public class FileLogger_template {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logFile = "log.txt";

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            // ToDo: Check if the user wants to exit the program
            if (input.equals("exit")) break;

            String[] parts = input.split(" ", 2);
            String command = parts[0];

            // ToDo: Add try-catch block to handle IOException when implementing file operations
            
            switch (command) {
                case "log":
                    // ToDo: Check if a message was provided
                    
                    // ToDo: Implement the log command
                    // - Use FileWriter with append mode to write the message to log.txt
                    // - Print "Message logged" as feedback
                    
                    break;

                case "read":
                    // ToDo: Implement the read command
                    // - Check if the log file exists
                    // - If it exists, read and display its entire content
                    // - If it doesn't exist, print "Error: File not found"
                    
                    break;

                case "clear":
                    // ToDo: Implement the clear command
                    // - Delete the log file if it exists
                    // - Print appropriate feedback message
                    
                    break;

                default:
                    System.out.println("Error: Unknown command");
            }
        }
        scanner.close();
    }
} 