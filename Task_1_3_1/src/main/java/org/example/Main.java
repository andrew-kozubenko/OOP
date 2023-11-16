package org.example;

import java.nio.charset.Charset;
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
//    blockBuilder.delete(0, blockBuilder.length() - substring.length());
//    blockBuilder.append(block, Math.max(0, bytesRead - substring.length()), bytesRead);
}

//abracadabra
//абракадабра
