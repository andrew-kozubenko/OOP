package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SubstringSearchTest {
    @Test
    public void testSubstringSearch() {
        List<Integer> expectedResult = new ArrayList<>();

        expectedResult.add(1);
        expectedResult.add(8);
        expectedResult.add(12);
        expectedResult.add(19);
        expectedResult.add(24);
        expectedResult.add(31);
        // Создаем временный файл с тестовыми данными
        String fileName = "testFile.txt";
        String content = "abracadabra" + "abracadabra\n" +
                "abracadabra";

        TestUtils.createTestFile(fileName, content);

        // Проводим поиск в тестовом файле
        String substring = "bra";
        List<Integer> result = SubstringSearch.find(fileName, substring);

        // Проверяем результаты поиска
        assertTrue(result.equals(expectedResult));

        // Удаление временного файла
        TestUtils.deleteTestFile(fileName);
    }
}
