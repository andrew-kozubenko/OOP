package org.example;

import static org.example.SubstringSearch.find;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     */
    public static void main(String[] args) {
        String fileName = "input.txt";
        String s = "бра";
        byte[] b = s.getBytes();
        String substring = new String(b, StandardCharsets.UTF_8);

        List<Long> result = find(fileName, substring);
        System.out.println(result);
    }
}
