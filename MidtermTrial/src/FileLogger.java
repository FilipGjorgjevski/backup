import java.io.*;
import java.util.Scanner;

public class FileLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logFile = "log.txt";

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) break;

            String[] parts = input.split(" ", 2);
            String command = parts[0];

            try {
                switch (command) {
                    case "log":

                        if (parts.length < 2) {
                            System.out.println("Error: Message required");
                            break;
                        }
                        try (FileWriter writer = new FileWriter(logFile, true)) {
                            writer.write(parts[1] + "\n");
                            System.out.println("Message logged");
                        }
                        break;



                    case "read":

                        File file = new File(logFile);
                        if (!file.exists()) {
                            System.out.println("Error: File not found");
                            break;
                        }
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            System.out.println("Content:");
                            String line;
                            while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                            }
                        }
                        break;



                    case "clear":
                        if (new File(logFile).delete()) {
                            System.out.println("File cleared");
                        } else {
                            System.out.println("Error: File not found or already cleared");
                        }
                        break;

                    default:
                        System.out.println("Error: Unknown command");
                }
            } catch (IOException e) {
                System.out.println("Error: Cannot write to file");
            }
        }
        scanner.close();
    }
}