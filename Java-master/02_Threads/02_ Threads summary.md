# Thread lifecycle
### new 
A new thread is begins its life cycle in this state & remains here until the program starts the thread. it is also known as a 'born thread'
### Runnable
Once a newly born thread starts, the thread comes under runnable state. A thread stays in this state until it is executing its task.
### Running
In this state a thread starts executing by entering run() method and the yield() method can send them to go back to the runnable state. 
### Waiting 
A thread enters ths state when it is temporarily in inactive state. It is still alive but is not eligible to run. It is can be in waiting, sleeping, or blocked state. 
### Terminated
A runnable thread enters the terminated state when it completes its task, or otherwise terminated.
___

# Create thread in java
## A. Thread class
1. Create a thread class
2. ovverride run() method
3. create object of the class
4. Invoke start() method to execute the custom thread run()

```java
class App extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) 
			System.out.println("@@ Printing "+i);		
	}
}

public class A{
	public static void main(String[] args) {
		
		// Threads always execute in sequence		
		System.out.println("==App started==");
		
		App a = new App();
		a.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("!! Printing "+i);
		}
		
		System.out.println("==App finished==");
	}
}

```
## B. Runnable Interface
##### The reason we use Runnable Interface - in java class can only inherit once. 
1. Create a thread class implementing Runnable interface.
2. ovverride run() method
3. create object of the class
4. Invoke start() method to execute the custom thread run()
```java
class superApp{
	
}

class App extends superApp implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) 
			System.out.println("@@ Printing "+i);		
	}
}

public class A{
	public static void main(String[] args) {
		
		// Threads always execute in sequence		
		System.out.println("==App started==");
		
		Runnable r = new App();
		Thread task = new Thread(r);
		task.start();
			
		for (int i = 0; i < 10; i++) {
			System.out.println("!! Printing "+i);
		}
		
		System.out.println("==App finished==");
	}
}
```

___
## Thread class vs Runnable interface
Thread class | Runnable interface|
---|--|
* Each thread creates its unique object | * Each thread creates its unique object|
* More memory consumption| * More memory consumption|
* A class extending thread class can't extend any other class | * Along with Runnable a class can implement any other interface|
* Enable tight coupling | * Enable tight coupling|


___
## Main thread
* Main thread is the most important thread of java program. 
* it is executed whenever java program starts
* Every program must contain this thread for its execution to take place
* Java main thread is needed because:
    1. From this other "child" threads are spawned
    2. It must be the last thread to finish execution. 
    when the main thread stops - program terminated.

