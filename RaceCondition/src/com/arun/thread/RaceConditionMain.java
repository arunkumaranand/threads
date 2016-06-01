package com.arun.thread;

public class RaceConditionMain {

	public static void main(String[] args) throws Exception {
		raceConditionDemo();
		System.out.println("------------");
		raceConditionFixDemo();
	}



	private static void raceConditionDemo() throws Exception {
		System.out.println("Race condition Demo: ");
		// Call wrapper from only one thread
		IntWrapper intW = new IntWrapper(0);

		Runnable tenThousandIncrementer = () -> {
			for (int i = 0; i < 10000; i++) {
				intW.incrementVal();
			}
		};
		
		// Single Thread Test
		Thread singleThreadTest = new Thread(tenThousandIncrementer);
		singleThreadTest.start();
		singleThreadTest.join();
		System.out.println("After Single Thread operation (expected 10,000): "+ intW.getVal());
		
		// 10 Thread test
		intW.setVal(0);
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(tenThousandIncrementer);
			threads[i].start();
		}
		// Wait for each thread to stop
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		System.out.println("After 10 Thread operation: (expected 100,000): "+ intW.getVal());
		
	}
	
	private static void raceConditionFixDemo() throws Exception {
		System.out.println("Race condition FIX Demo: (with Synchronization)");
		// Call wrapper from only one thread
		IntWrapperSafe intW = new IntWrapperSafe(0);

		Runnable tenThousandIncrementer = () -> {
			for (int i = 0; i < 10000; i++) {
				intW.incrementVal();
			}
		};
		
		// Single Thread Test
		Thread singleThreadTest = new Thread(tenThousandIncrementer);
		singleThreadTest.start();
		singleThreadTest.join();
		System.out.println("After Single Thread operation (expected 10,000): "+ intW.getVal());
		
		// 10 Thread test
		intW.setVal(0);
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(tenThousandIncrementer);
			threads[i].start();
		}
		// Wait for each thread to stop
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		System.out.println("After 10 Thread operation: (expected 100,000): "+ intW.getVal());
		
	}

}
