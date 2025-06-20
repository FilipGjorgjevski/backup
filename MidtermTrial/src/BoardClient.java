import java.io.*;
import java.net.*;
import java.util.Scanner;

public class BoardClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server");
            Scanner scanner = new Scanner(System.in);
            String serverPrompt = in.readLine(); // Read initial prompt

            while (true) {
                System.out.print("> "); // Client prompt
                String input = scanner.nextLine().trim();

                if (input.equals("bye")) {
                    out.println("bye");
                    break;
                }

                out.println(input);
                String response;

                while ((response = in.readLine()) != null && !response.equals("enter_command")) {
                    System.out.println(response);
                }
            }
            System.out.println("Disconnected from server");
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error: Server unavailable");
        }
    }
}