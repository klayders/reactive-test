package com.corut.corut

import com.corut.corut.utils.KotlinFileUtils
import com.corut.corut.utils.Utils.COUNT_THREAD
import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

class KotlinTest {
}

fun main() {

    val currentTimeMillis = System.currentTimeMillis()
    val counterCoroutinesFinishedWork = AtomicInteger()

	for (i in 1..COUNT_THREAD) {
        thread(start = true) {
            KotlinFileUtils.createFile("exam$i")
            val text = KotlinFileUtils.generateRandomText()
            KotlinFileUtils.writeTextToFile(text, "exam$i")
            counterCoroutinesFinishedWork.incrementAndGet();
        }
    }

    while (counterCoroutinesFinishedWork.get() != COUNT_THREAD) {
        sleep(100)
    }

    println("i`m here, finish")
    println(counterCoroutinesFinishedWork.get())
    println(System.currentTimeMillis() - currentTimeMillis)
}

