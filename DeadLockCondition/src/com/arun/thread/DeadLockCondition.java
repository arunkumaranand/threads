package com.arun.thread;

public class DeadLockCondition {

	public static void main(String[] args) throws Exception{
		Object key1 = new Object();
		Object key2 = new Object();
		
		Runnable r1 = () -> {
			String name = Thread.currentThread().getName();
			synchronized (key1) {
				System.out.println("I am ["+ name + "], got Key 1, waiting for Key 2");
				synchronized (key2) {
					System.out.println("I am ["+ name + "], got Key 2 as well!");
				}
				
			}
		};
		
		Runnable r2 = () -> {
			String name = Thread.currentThread().getName();
			synchronized (key2) {
				System.out.println("I am ["+ name + "], got Key 2, waiting for Key 1");
				synchronized (key1) {
					System.out.println("I am ["+ name + "], got Key 1 as well!");
				}
				
			}
		};
		
		Thread t1 = new Thread(r1, "FirstThread");
		Thread t2 = new Thread(r2, "SecondThread");
		
		t1.start();
		//Thread.sleep(100);
		t2.start();
		

	}

}
