package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SubstringSearch {
    public static List<Integer> find(String fileName, String substring) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        List<Integer> result = new ArrayList<>();

        try(InputStream is = classLoader.getResourceAsStream(fileName);
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr)) {
            if (is != null) {
                int blockSize = 1024;
                char[] buffer = new char[blockSize];
                int bytesRead;

                int lineNumber = 0;
                StringBuilder blockBuilder = new StringBuilder();

                int take = 0;
                while ((bytesRead = br.read(buffer, 0, blockSize)) != -1) {
                    String block = new String(buffer, 0, bytesRead);
                    blockBuilder.append(block);

                    int index = blockBuilder.indexOf(substring);
                    while (index != -1) {
                        result.add(index + lineNumber - take);
                        index = blockBuilder.indexOf(substring, index + 1);
                    }

                    take = substring.length() - 1;
                    blockBuilder.delete(0, blockBuilder.length() - take);

                    lineNumber += bytesRead;
                }
            } else {
                System.out.println("File not found: " + fileName);
            }
        }  catch (IOException error) {
            error.printStackTrace();
        }

        return result;
    }
}