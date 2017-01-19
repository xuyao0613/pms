package com.pms.thread;

public class MultiThread {
	private static int num;

	public static synchronized void printNum(String arg) throws InterruptedException {
		if (arg.equals("a")) {
			num = 100;
			System.out.println("tag a, set num over!");
		} else {
			num = 200;
			System.out.println("tag b, set num over!");
		}
		System.out.println("tag " + arg + ", num = " + num);
	}

	public static void main(String[] args) {
		final MultiThread m1 = new MultiThread();
		final MultiThread m2 = new MultiThread();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					m1.printNum("a");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					m2.printNum("b");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}
}
