package com.java.interview;

public class ThreadDemo {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				throw new RuntimeException("Thread excepion thrown");
			}
		});
		t1.start();

		while(true) {
			System.out.println("ThreadDemo.main()");
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("Interrupted Exception Thrown");
			}
		}
	}
}	

