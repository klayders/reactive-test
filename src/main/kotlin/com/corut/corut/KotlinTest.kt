package com.corut.corut

import com.corut.corut.Utils.COUNT_THREAD
import com.corut.corut.Utils.CYCLE_LOAD_OPERATION
import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

class KotlinTest {
}

fun main() {

    val currentTimeMillis = System.currentTimeMillis()
    val counter = AtomicLong()

	for (i in 1..COUNT_THREAD) {
        thread(start = true) {

            val loadCPU = AtomicLong()

			for (i in 1..CYCLE_LOAD_OPERATION) {
                loadCPU.incrementAndGet()
            }
            counter.incrementAndGet();
        }
    }

    while (counter.get() != 100L) {
        sleep(100)
    }

    println("i`m here, finish")
    println(counter.get())
    println(System.currentTimeMillis() - currentTimeMillis)
}

