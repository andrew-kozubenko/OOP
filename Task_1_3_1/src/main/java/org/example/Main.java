package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.example.SubstringSearch.find;

public class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String substring = "bra";

        List<Integer> result = find(fileName, substring);
        System.out.println(result);
    }
}
//abracadabra
//абракадабра