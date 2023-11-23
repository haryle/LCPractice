package Chapter1.Question5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @ParameterizedTest
    @CsvSource(value = {
            "aabcccccaaa,a2b1c5a3",
            "aa,aa",
            "aaa,a3",
            "aaabbbc,a3b3c1",
            "aaaab,a4b1",
            "accccbb,a1c4b2",
            "acccc,a1c4",
            "a,a"
    }, delimiter = ',')
    void testCompress(String inputStr, String expectedStr) {
        String outputStr = Solution.compress(inputStr);
        assertEquals(expectedStr, outputStr);
    }
}