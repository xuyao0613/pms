package com.pms.thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
	private LinkedList<Object> list = new LinkedList<Object>();

	private AtomicInteger count = new AtomicInteger(0);

	private final int minSize = 0;

	private final int maxSize;

	public MyQueue(int size) {
		this.maxSize = size;
	}

	private final Object lock = new Object();

	public void put(Object obj) {
		synchronized (lock) {
			if (count.get() == this.maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}

			list.add(obj);
			count.incrementAndGet();
			lock.notify();
			System.out.println("新加入的元素为:" + obj);
		}
	}

	public Object take() {
		Object ret = null;
		synchronized (lock) {
			if (count.get() == this.minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}

			ret = list.removeFirst();
			count.decrementAndGet();
			lock.notify();
		}
		return ret;
	}

	public int getSize() {
		return this.count.get();
	}

	public static void main(String[] args) {

		final MyQueue mq = new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");

		System.out.println("当前容器的长度:" + mq.getSize());

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				mq.put("f");
				mq.put("g");
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Object o1 = mq.take();
				System.out.println("移除的元素为:" + o1);
				Object o2 = mq.take();
				System.out.println("移除的元素为:" + o2);
			}
		}, "t2");
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t1.start();
	}
}
