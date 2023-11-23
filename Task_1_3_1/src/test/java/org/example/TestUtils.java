package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

/**
 * TestUtils.
 */
public class TestUtils {
    /**
     * createTestFile.
     */
    public static void createTestFile(String fileName, String content) {
        // Получаем URL ресурса
        URL resourceUrl = TestUtils.class.getClassLoader().getResource("");

        if (resourceUrl != null) {
            // Получаем путь к ресурсам
            String resourcesPath = new File(resourceUrl.getFile()).getPath();
            System.out.println(resourcesPath);

            // Создаем файл в директории resources
            File file = new File(resourcesPath, fileName);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Unable to get the resources directory.");
        }
    }

    /**
     * generateLargeFile.
     */
    public static void generateLargeFile(String fileName, String substring, int fileSizeInBytes) {
        URL resourceUrl = TestUtils.class.getClassLoader().getResource("");

        if (resourceUrl != null) {
            String resourcesPath = new File(resourceUrl.getFile()).getPath();
            System.out.println(resourcesPath);

            File file = new File(resourcesPath, fileName);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < fileSizeInBytes; i++) {
                    sb.append("a");
                }
                sb.append(substring);

                writer.write(sb.toString());
            }  catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Unable to get the resources directory.");
        }
    }

    /**
     * deleteTestFile.
     */
    public static void deleteTestFile(String fileName) {
        // Получаем URL ресурса
        URL resourceUrl = TestUtils.class.getClassLoader().getResource("");

        if (resourceUrl != null) {
            // Получаем путь к ресурсам
            String resourcesPath = new File(resourceUrl.getFile()).getPath();

            // Удаляем файл из директории resources
            File file = new File(resourcesPath, fileName);
            if (file.exists()) {
                if (!file.delete()) {
                    System.err.println("Unable to delete the test file.");
                }
            }
        } else {
            System.err.println("Unable to get the resources directory.");
        }
    }
}