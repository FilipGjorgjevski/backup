# Java Threads Exercises and Solutions

## Exercise 1: Print thread properties

For Each Thread:
– Print the
• Name
• Priority
• Check if thread the is “alive”
• Thread Declaration (Name, Priority & Group)
– Change the priority of each previously created
thread (meaning, increase its priority by 1, i.e. its
count in the FOR cycle)

## Exercise 2: Create TickTack class
That has name and rate attributes and implement Runnable interface where Tick/Tack will be after the rate period example: rate 500 : Tick , sleep period 500ms, Tack, sleep period 500ms, Tick....
Create a constructor of TickTack that will obtain a value for a name and the clock’s ticking rate
– E.g. Seiko, 600
Create 2 clocks with different names and ticking rates and run them

## Exercise 3: Synchronize Access to a Shared Variable
Create a program where two threads increment the same int variable 1000 times each. Use synchronization to ensure that the final value of the variable is 2000.

## Exercise 4: Utilize a Thread Pool
Write a program that uses a thread pool to execute multiple tasks concurrently. Use Executors.newFixedThreadPool to create a pool and submit a few simple tasks that print out messages to the console.
Example:

pool-1-thread-3 (Start) message = 2 <br>
pool-1-thread-1 (Start) message = 0 <br>
pool-1-thread-4 (Start) message = 3 <br>
pool-1-thread-5 (Start) message = 4 <br>
pool-1-thread-2 (Start) message = 1 <br>
pool-1-thread-2 (End) <br>
pool-1-thread-1 (End) <br>
pool-1-thread-4 (End) <br>
pool-1-thread-5 (End) <br>
pool-1-thread-5 (Start) message = 8 <br>
pool-1-thread-3 (End) <br>
pool-1-thread-3 (Start) message = 9 <br>
pool-1-thread-1 (Start) message = 6 <br>
pool-1-thread-2 (Start) message = 5 <br>
pool-1-thread-4 (Start) message = 7 <br>
pool-1-thread-2 (End) <br>
pool-1-thread-1 (End) <br>
pool-1-thread-4 (End) <br>
pool-1-thread-3 (End) <br>
pool-1-thread-5 (End) <br>
Finished all threads