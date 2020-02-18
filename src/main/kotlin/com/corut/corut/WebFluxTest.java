package com.corut.corut;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.atomic.AtomicLong;

public class WebFluxTest {
	public static void main(String[] args) throws InterruptedException {

		var counter = new AtomicLong();
		AtomicLong currentTimeMillis = new AtomicLong();

		currentTimeMillis.set(System.currentTimeMillis());

		Flux.range(1, 100)
			.parallel(4)
			.runOn(Schedulers.newParallel("load-cpu", 4))
			.map(ssss -> {
				var loadCPU = new AtomicLong();

				for (int i = 0; i < 10_000_000; i++) {
					loadCPU.incrementAndGet();
				}
				counter.incrementAndGet();
				return ssss;
			})

			.subscribe();

		while (counter.get() != 100) {
			Thread.sleep(100);
		}

		System.out.println(System.currentTimeMillis() - currentTimeMillis.get());
	}


}
