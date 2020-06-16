package com.java.basics;

public class ThreadingClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Runnable run method");
			}
		};
		
		Thread t = new Thread(r, "t1");
		
		Thread t1 = new Thread(() -> System.out.println("Inside runnable method new way"), "t1");
		
		t.start();
		t1.start();
	}
}
