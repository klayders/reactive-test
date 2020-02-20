package com.corut.corut.utils

import com.corut.corut.utils.Utils.MAX_BYTE_SIZE
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.*

object KotlinFileUtils {
    private const val KOTLIN_DIR_NAME = "kotlin"


    fun createFile(fileName: String) {
        File(KOTLIN_DIR_NAME).mkdir()
        try {
            val file = File("$KOTLIN_DIR_NAME/$fileName.txt")
            if (file.createNewFile()) {
                println("File created: " + file.name)
            } else {
                println("File already exists.")
            }
        } catch (e: IOException) {
            println("An error occurred.")
            e.printStackTrace()
        }
    }

    fun writeTextToFile(text: String?, fileName: String) {
        try {
            BufferedWriter(FileWriter("$KOTLIN_DIR_NAME/$fileName.txt")).use { writer -> writer.write(text) }
        } catch (e: IOException) {
            println("writeStringToFile ERROR")
        }
    }

    fun generateRandomText(): String {
        val array = ByteArray(MAX_BYTE_SIZE)
        Random().nextBytes(array)
        return String(array, StandardCharsets.UTF_8)
    }
}