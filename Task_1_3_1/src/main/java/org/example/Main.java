package org.example;

import java.util.List;

import static org.example.SubstringSearch.find;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     */
    public static void main(String[] args) {
        String fileName = "input.txt";
        String substring = "bra";

        List<Integer> result = find(fileName, substring);
        System.out.println(result);

        String fileName1 = "large_file.txt";
        String substring1 = "targetSubstring";
    }
}
