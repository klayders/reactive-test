package com.corut.corut;

import java.util.concurrent.atomic.AtomicLong;

import static com.corut.corut.Utils.COUNT_THREAD;

public class JavaTest {

	public static void main(String[] args) throws InterruptedException {

		var counter = new AtomicLong();
		AtomicLong currentTimeMillis = new AtomicLong();

		currentTimeMillis.set(System.currentTimeMillis());


		for (int i = 0; i < COUNT_THREAD; i++) {
			new Thread(() -> {
				var counterForLoadCPU = new AtomicLong();
				for (int i1 = 0; i1 < 10_000_000; i1++) {
					counterForLoadCPU.incrementAndGet();
				}
				counter.incrementAndGet();
			})
				.start();
		}


		while (counter.get() != 100) {
			Thread.sleep(100);
		}

		System.out.println(System.currentTimeMillis() - currentTimeMillis.get());
	}

}
