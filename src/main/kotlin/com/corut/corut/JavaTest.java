package com.corut.corut;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.atomic.AtomicLong;

public class JavaTest {

	public static void main(String[] args) throws InterruptedException {

		var counter = new AtomicLong();
		AtomicLong currentTimeMillis = new AtomicLong();

		currentTimeMillis.set(System.currentTimeMillis());


		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					var counterForLoadCPU = new AtomicLong();
					for (int i = 0; i < 10_000_000; i++) {
						counterForLoadCPU.incrementAndGet();
					}
					counter.incrementAndGet();
				}
			})
				.start();
		}


		while (counter.get() != 100) {
			Thread.sleep(100);
		}

		System.out.println(System.currentTimeMillis() - currentTimeMillis.get());
	}


	/**
	 * RUN ME FOR TEST REACTOR WEBFLUX
	 * @throws InterruptedException
	 */

}
