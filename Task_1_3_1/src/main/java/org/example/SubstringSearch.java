package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubstringSearch {

    public static List<Integer> find(String fileName, String substring) {
        List<Integer> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                int index = line.indexOf(substring);
                while (index != -1) {
                    result.add(index + lineNumber);
                    index = line.indexOf(substring, index + 1);
                }

                lineNumber += line.length() + 1;
            }
        } catch (IOException error) {
            error.printStackTrace();
        }

        return result;
    }
}
