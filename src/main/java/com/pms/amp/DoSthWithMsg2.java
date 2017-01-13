package com.pms.amp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;

public class DoSthWithMsg2 implements Runnable {

	BlockingQueue<String> blockingQueue;

	public DoSthWithMsg2(BlockingQueue<String> _blockingQueue) {
		this.blockingQueue = _blockingQueue;
	}

	private boolean isRunning = true;

	@Override
	public void run() {
		while (isRunning) {
			try {
				// 2秒内取不到就退出
				String msg = blockingQueue.poll(2, TimeUnit.MILLISECONDS);
				if (StringUtils.isBlank(msg)) {
					TimeUnit.MILLISECONDS.sleep(500);
					continue;
				}
				System.out.println("do sth with msg 2 :" + msg);
				// 休息0.5秒
//				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		this.isRunning = false;
	}

}
