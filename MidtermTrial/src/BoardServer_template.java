import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Assignment 3: Hashtag Message Board - Server Side
 * Create a server that maintains a message board where clients can post messages with hashtags
 * and retrieve messages matching specific hashtags.
 */
public class BoardServer_template {
    // ToDo: Create a data structure to store messages by hashtag
    // - Use a Map with hashtag as key and a List of messages as value
    
    public static void main(String[] args) {
        // ToDo: Implement the server functionality
        // 1. Create a ServerSocket to listen on port 8080
        // 2. Handle IOException if the server fails to start
        
        System.out.println("Server started on port 8080");

        // ToDo: Implement an infinite loop to accept client connections
        while (true) {
            // ToDo: Accept a client connection
            // 1. Accept a client connection using serverSocket.accept()
            // 2. Create PrintWriter and BufferedReader for communication with the client
            // 3. Get and display the client's IP address
            // 4. Send initial prompt to the client ("Enter command:")
            // 5. Handle IOException if the client connection fails
            
            // ToDo: Process client commands in a loop
            // 1. Read input from the client
            // 2. Parse the command and its arguments (split by space)
            // 3. Handle the following commands:
            //    * post <hashtag> <message>: Store the message with its hashtag and timestamp
            //    * read <hashtag>: Send all messages with the specified hashtag to the client
            //    * bye: Close the connection
            // 4. Send "Enter command:" after processing each command
        }
    }
    
    // ToDo: Consider adding helper methods for handling commands
    // - A method to handle the post command
    // - A method to handle the read command
} 