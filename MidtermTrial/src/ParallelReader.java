import java.io.*;
import java.util.Scanner;

public class ParallelReader {
    static class FileReaderTask extends Thread {
        private String filename;

        public FileReaderTask(String filename) {
            this.filename = filename;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(filename + ": " + line);
                }
            } catch (IOException e) {
                System.out.println("Error: " + filename + " not found");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) break;


            String[] parts = input.split(" ");
            if (!parts[0].equals("read") || parts.length != 3) {
                System.out.println("Error: Use 'read <file1> <file2>'");
                continue;
            }

            String file1 = parts[1];
            String file2 = parts[2];

            Thread thread1 = new FileReaderTask(file1);
            Thread thread2 = new FileReaderTask(file2);

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
                System.out.println("Reading complete");
            } catch (InterruptedException e) {
                System.out.println("Error: Thread interrupted");
            }
        }
        scanner.close();
    }
}