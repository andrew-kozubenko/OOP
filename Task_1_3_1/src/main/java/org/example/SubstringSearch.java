package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SubstringSearch {
    public static List<Integer> find(String fileName, String substring) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        List<Integer> result = new ArrayList<>();

        try(InputStream is = classLoader.getResourceAsStream(fileName);
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr)) {
            if (is != null) {

                String line;
                int lineNumber = 0;

                while ((line = br.readLine()) != null) {
                    int index = line.indexOf(substring);
                    System.out.println(line);
                    while (index != -1) {
                        result.add(index + lineNumber);
                        index = line.indexOf(substring, index + 1);
                        System.out.println(index);
                    }
                    lineNumber += line.length() + 1;
                }
            } else {
                System.out.println("Файл не найден: " + fileName);
            }
        }  catch (IOException error) {
            error.printStackTrace();
        }

        return result;
    }
}
