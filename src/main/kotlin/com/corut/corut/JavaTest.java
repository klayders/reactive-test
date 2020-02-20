package com.corut.corut;

import java.util.concurrent.atomic.AtomicLong;

import static com.corut.corut.utils.FileUtils.*;
import static com.corut.corut.utils.Utils.COUNT_THREAD;

public class JavaTest {

	public static void main(String[] args) throws InterruptedException {

		var counterThreadFinishedWork = new AtomicLong();

		var currentTimeMillis = System.currentTimeMillis();


		for (int i = 0; i < COUNT_THREAD; i++) {
			new Thread(() -> {
				var threadName = Thread.currentThread().getName();
				createFile(threadName);
				var text = generateRandomText();
				writeTextToFile(text, threadName);
				counterThreadFinishedWork.incrementAndGet();
			})
				.start();
		}


		while (counterThreadFinishedWork.get() != COUNT_THREAD) {
			Thread.sleep(100);
		}

		System.out.println(System.currentTimeMillis() - currentTimeMillis);
	}

}
