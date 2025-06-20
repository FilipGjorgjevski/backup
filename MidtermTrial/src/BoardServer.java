import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.*;

public class BoardServer {
    private static Map<String, List<String>> messages = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String clientIP = clientSocket.getInetAddress().getHostAddress();
                    System.out.println("Client connected: " + clientIP);

                    out.println("enter_command");

                    String input;
                    while ((input = in.readLine()) != null) {
                        String[] parts = input.split(" ", 3);
                        String command = parts[0];

                        switch (command) {
                            case "post":

                                if (parts.length < 3) {
                                    out.println("Error: Invalid command");
                                    break;
                                }
                                String hashtag = parts[1];
                                String message = parts[2];
                                String timestamp = LocalDateTime.now().toString();

                                if (!messages.containsKey(hashtag)) {
                                    messages.put(hashtag, new ArrayList<>());
                                }
                                messages.get(hashtag).add("[" + timestamp + "] " + message);

                                System.out.println("Posted: " + hashtag + " " + message);
                                out.println("Message posted");
                                break;

                            case "read":

                                if (parts.length < 2) {
                                    out.println("Error: Invalid command");
                                    break;
                                }
                                hashtag = parts[1];
                                List<String> hashtagMessages = messages.getOrDefault(hashtag, Collections.emptyList());
                                if (hashtagMessages.isEmpty()) {
                                    out.println("No messages found");
                                } else {
                                    for (String msg : hashtagMessages) {
                                        out.println(msg);
                                    }
                                }
                                System.out.println("Sent messages for " + hashtag);
                                break;



                            case "bye":
                                System.out.println("Client disconnected");
                                return;

                            default:
                                out.println("Error: Unknown command");
                        }
                        out.println("enter_command");
                    }
                } catch (IOException e) {
                    System.out.println("Error: Client connection failed");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Server failed to start");
        }
    }
}