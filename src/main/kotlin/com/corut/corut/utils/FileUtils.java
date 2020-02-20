package com.corut.corut.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static com.corut.corut.utils.Utils.MAX_BYTE_SIZE;

public class FileUtils {
    private static final String JAVA_DIR_NAME = "java";

    public static void main(String[] args) throws IOException {
        createFile("exam");
        var text = generateRandomText();
        writeTextToFile(text, "exam");

    }

    public static void createFile(String fileName) {

        new File(JAVA_DIR_NAME).mkdir();

        try {
            var file = new File(JAVA_DIR_NAME + "/" + fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeTextToFile(String text, String fileName)  {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JAVA_DIR_NAME + "/" + fileName + ".txt"))){
            writer.write(text);
        }catch (IOException e){
            System.out.println("writeStringToFile ERROR");
        }
    }

    public static String generateRandomText() {
        byte[] array = new byte[MAX_BYTE_SIZE];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
