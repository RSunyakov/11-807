package ru.kpfu.itis.textsimilarity;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class СosSimTest {
    CosineSimilarityTextAnalyzer cos;
    TextProvider te1;
    TextProvider te2;

    @Before
    public void setup() {
        cos = new CosineSimilarityTextAnalyzer();
        te1 = new SimpleTextProvider("Мама мыла раму не");
        te2 = new SimpleTextProvider("Мама ничего не делал раму");
    }

    /*@Test
    public void testTokenize() {
        List<String> expected = new ArrayList<>();
        List<String> actual = cos.tokenize("Мама мыла раму");
        expected.add("мама");
        expected.add("мыла");
        expected.add("раму");
        assertEquals(expected, actual);
    }*/ //так как Tokenize приватный

    @Test
    public void testAnalyze() {
        double expected = 0.9;
        double actual = cos.analyze(te1, te2);
        assertEquals(expected, actual, 0.1);
    }
}
