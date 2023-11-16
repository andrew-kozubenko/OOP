package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.example.SubstringSearch.find;

public class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String substring = "бра";

        List<Integer> result = find(fileName, substring);
        System.out.println(result);
    }
}
//abracadabra
//абракадабра