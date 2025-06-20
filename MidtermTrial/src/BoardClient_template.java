import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Assignment 3: Hashtag Message Board - Client Side
 * Create a client that connects to the message board server to post and read messages with hashtags.
 */
public class BoardClient_template {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ToDo: Implement the client-server communication
        // 1. Create a Socket to connect to the server (localhost, port 8080)
        // 2. Create PrintWriter for sending messages to the server
        // 3. Create BufferedReader for receiving messages from the server
        // 4. Handle IOException if the server is unavailable
        
        System.out.println("Connected to server");
        
        // ToDo: Read the initial prompt from the server
        
        boolean running = true;
        while (running) {
            System.out.print("> "); // Client prompt
            String input = scanner.nextLine().trim();

            // ToDo: Check if the user wants to disconnect from the server
            // - If the input is "bye", send "bye" to the server and set running to false
            
            // ToDo: Send the user's input to the server
            
            // ToDo: Read and display the server's response
            // - Read lines from the server until you receive "Enter command:"
            // - Print each response line to the console
        }
        
        System.out.println("Disconnected from server");
        scanner.close();
        
        // ToDo: Close all resources (socket, PrintWriter, BufferedReader)
    }
} 