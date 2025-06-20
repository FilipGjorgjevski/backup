import java.io.*;
import java.util.Scanner;

/**
 * Assignment 2: Parallel File Reader
 * Develop a Java application that reads two text files simultaneously using threads.
 */
public class ParallelReader_template {
    /**
     * ToDo: Implement the FileReaderTask class that extends Thread
     * - It should read a file and print its contents line-by-line
     * - Each line should be prefixed with the filename
     * - Handle file not found errors appropriately
     */
    static class FileReaderTask extends Thread {
        private String filename;

        public FileReaderTask(String filename) {
            // ToDo: Initialize the filename field
            
        }

        @Override
        public void run() {
            // ToDo: Implement the run method
            // - Use BufferedReader to read the file line by line
            // - Print each line with the filename as prefix
            // - Handle IOException if the file is not found
            
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            // ToDo: Check if the user wants to exit the program
            if (input.equals("exit")) break;
            
            String[] parts = input.split(" ");
            
            // ToDo: Validate the command format
            // - Check if the command is "read"
            // - Check if there are exactly two filenames provided
            // - Print error message if the format is invalid
            

            // ToDo: Extract the two filenames from the command
            

            // ToDo: Create and start two threads to read the files
            // - Create two FileReaderTask instances
            // - Start both threads
            // - Wait for both threads to complete using join()
            // - Print "Reading complete" when both threads are done
            // - Handle InterruptedException
            
        }
        scanner.close();
    }
} 