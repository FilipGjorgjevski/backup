
# Java Midterm Assignments - March 2025


## Assignment 1: Simple File Logger
**Focus: Files and Directories** 
**Difficulty: Easy** 

### Description
Create a Java application called `FileLogger` that logs messages to a single file via a command-line interface. 

### Requirements
Implement a command-line interface with the following commands:  
1. `log <message>`: Appends the message to a file named `log.txt` in the current directory. Creates the file if it doesn’t exist.  
2. `read`: Displays the entire content of `log.txt`.  
3. `clear`: Deletes `log.txt` if it exists.  

### Additional Requirements
- Use `File` and `FileWriter` (with append mode) for writing, and `BufferedReader` for reading.  
- Handle basic errors:  
  - File not found (for `read`).  
  - Permission issues (print "Error: Cannot write to file").  
- Run in a loop until the user enters `exit`.  
- Provide feedback (e.g., "Message logged" or "File cleared").  

### Sample Interaction
```markdown
Enter command: log First entry
Message logged
Enter command: log Second entry
Message logged
Enter command: read
Content:
First entry
Second entry
Enter command: clear
File cleared
Enter command: exit
```

### Learning Objectives
- Basic file creation and appending.  
- Reading from files.  
- Simple error handling.  

---

## Assignment 2: Parallel File Reader
**Focus: Threads**  
**Difficulty: Moderate**

### Description
Develop a Java application called `ParallelReader` that reads two text files simultaneously using threads and displays their contents.

### Requirements
1. Implement a `FileReaderTask` class that extends `Thread`. Each instance reads a file and prints its contents line-by-line with the filename as a prefix (e.g., "file1.txt: line content").  
2. Create a command-line interface with one command:  
   - `read <file1> <file2>`: Spawns two threads to read the specified files concurrently and display their contents.  
3. Wait for both threads to finish before accepting the next command.  

### Additional Requirements
- Use `File` and `BufferedReader` for reading files.  
- Handle errors:  
  - File not found (print "Error: <filename> not found").  
  - Invalid input (e.g., missing arguments).  
- Run in a loop until `exit` is entered.  
- No need for explicit synchronization—just let threads print independently (interleaving is fine).  

### Sample Interaction
```
Enter command: read notes1.txt notes2.txt
notes1.txt: Hello
notes2.txt: Hi there
notes1.txt: World
notes2.txt: Goodbye
Reading complete
Enter command: exit
```

### Learning Objectives
- Basic thread creation and execution.  
- Reading files in a threaded context.  
- Coordinating thread completion.  

---

## Assignment 3: Hashtag Message Board
**Focus: Sockets**  
**Difficulty: Challenging but Achievable**

### Description
Create a Java application called `MessageBoard` with a server and client. Clients connect to the server to post messages with hashtags or retrieve all messages matching a specific hashtag. The server maintains messages in memory (no files) and handles one client at a time.

### Requirements
#### Server Side (`BoardServer`)
1. Use `ServerSocket` to listen on port 8080.  
2. Accept one client connection at a time and handle three commands:  
   - `post <hashtag> <message>`: Stores the message with its hashtag and timestamp (e.g., "2025-03-10 14:30:45") in memory. Responds with "Message posted".  
   - `read <hashtag>`: Sends all messages with the specified hashtag back to the client, one per line, or "No messages found" if none exist.  
   - `bye`: Closes the connection and waits for a new client.  
3. Store messages in a `List` or `Map` (e.g., `Map<String, List<String>>` mapping hashtags to messages).  
4. Display the client’s IP address when they connect (e.g., "Client connected: 127.0.0.1").  

#### Client Side (`BoardClient`)
5. Use `Socket` to connect to the server (localhost, port 8080).  
6. Provide a command-line interface for:  
   - `post <hashtag> <message>`: Sends the message and hashtag to the server, displays the server’s response.  
   - `read <hashtag>`: Requests messages for the hashtag and displays the server’s response.  
   - `bye`: Ends the connection and exits the client.  
7. Run in a loop until `bye` is entered.  

### Additional Requirements
- Use text-based communication (e.g., newline as message delimiter).  
- Format stored messages as: "[timestamp] <message>" (e.g., "[2025-03-10 14:30:45] Hello world").  
- Handle basic errors:  
  - Server not running (client prints "Error: Server unavailable").  
  - Invalid input (e.g., missing hashtag or message—server responds "Error: Invalid command").  
- Use Java’s `Date` or `LocalDateTime` for timestamps.  

### Sample Interaction
#### Server Console
```
Server started on port 8080
Client connected: 127.0.0.1
Posted: #greeting Hello everyone
Client disconnected
Client connected: 127.0.0.1
Sent messages for #greeting
Client disconnected
```

#### Client 1 Console
```
Connected to server
Enter command: post #greeting Hello everyone
Server response: Message posted
Enter command: bye
Disconnected from server
```

#### Client 2 Console
```
Connected to server
Enter command: read #greeting
Server response:
[2025-03-10 14:30:45] Hello everyone
Enter command: post #greeting Hi there
Server response: Message posted
Enter command: read #greeting
Server response:
[2025-03-10 14:30:45] Hello everyone
[2025-03-10 14:31:00] Hi there
Enter command: bye
Disconnected from server
```

### Learning Objectives
- Client-server communication with sockets.  
- Managing in-memory data over a network.  
- Parsing and responding to commands.  

---

## Grading and Bell Curve
- **Assignment 1:** Expected success rate: 80-90% - Simple file operations form the broad base.  
- **Assignment 2:** Expected success rate: 50-70% - Basic threading shapes the middle.  
- **Assignment 3:** Expected success rate: 20-40% - Sockets with a message board create the challenging tail.
```

---
