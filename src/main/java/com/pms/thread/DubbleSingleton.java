package com.pms.thread;

public class DubbleSingleton {
	
	public DubbleSingleton(){
		try {
			// 模拟初始化对象的准备时间...
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//使用volatile修饰，避免延迟后加载有可能造成ds没有完全初始化就去判断的情况
	private volatile static DubbleSingleton ds;

	public static DubbleSingleton getDs() {
		if (ds == null) {
			synchronized (DubbleSingleton.class) {
				if (ds == null) {
					ds = new DubbleSingleton();//此处有风险，双重检查锁定有可能遇到先分配空间完成才对ds指向内存的地址，必须用volatile修饰，避免此现象
				}
			}
		}
		return ds;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		}, "t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		}, "t3");

		t1.start();
		t2.start();
		t3.start();
	}
}
