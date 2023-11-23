package org.example;

import static org.example.SubstringSearch.find;

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
        String substring = "bra";

        List<Integer> result = find(fileName, substring);
        System.out.println(result);

        String fileName1 = "large_file.txt";
        String substring1 = "targetSubstring";
    }
}
