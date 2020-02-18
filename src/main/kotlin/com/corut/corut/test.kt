package com.corut.corut

import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

class test {
}

fun main() {

    val currentTimeMillis = System.currentTimeMillis()
    val counter = AtomicLong()

    for (i in 1..100) {
        thread(start = true) {

            val c = AtomicLong()

            for (i in 1..10_000_000L) {
                c.incrementAndGet()
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



//fun main() {
//
//    val currentTimeMillis = System.currentTimeMillis()
//
//    val counter = AtomicLong()
//
//
//    for (i in 1..100) {
//        thread(start = true) {
//
//            val c = AtomicLong()
//
//            for (i in 1..10_000_000L) {
//                c.incrementAndGet()
//            }
//            counter.incrementAndGet();
//        }
//    }
//
//    while (counter.get() != 100L) {
//        sleep(100)
//    }
//    println("i`m here")
//
//    println(counter.get())
//
//    println(System.currentTimeMillis() - currentTimeMillis)
//
//
//}
