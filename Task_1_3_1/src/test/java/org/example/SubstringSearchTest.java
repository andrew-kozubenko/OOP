package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * SubstringSearchTest.
 */
public class SubstringSearchTest {
    /**
     * testSubstringSearch.
     */
    @Test
    public void testSubstringSearch() {
        List<Long> expectedResult = new ArrayList<>();

        expectedResult.add(1L);
        expectedResult.add(8L);
        expectedResult.add(12L);
        expectedResult.add(19L);
        expectedResult.add(24L);
        expectedResult.add(31L);
        // Создаем временный файл с тестовыми данными
        String fileName = "testFile.txt";
        String content = "abracadabra" +
                "abracadabra\n" +
                "abracadabra";

        TestUtils.createTestFile(fileName, content);

        // Проводим поиск в тестовом файле
        String substring = "bra";
        List<Long> result = SubstringSearch.find(fileName, substring);

        // Проверяем результаты поиска
        assertTrue(result.equals(expectedResult));

        // Удаление временного файла
        TestUtils.deleteTestFile(fileName);
    }

    /**
     * testLargeFile.
     */
    @Test
    public void testLargeFile() {
        List<Long> expectedResult = new ArrayList<>();
        expectedResult.add(20971520L);

        String fileName = "testFile.txt";
        String substring = "myString";

        TestUtils.generateLargeFile(fileName, substring, 20L * 1024 * 1024);

        List<Long> result = SubstringSearch.find(fileName, substring);

        assertTrue(result.equals(expectedResult));

        TestUtils.deleteTestFile(fileName);
    }
}
