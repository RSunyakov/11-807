package ru.kpfu.itis.textsimilarity;


import java.util.ArrayList;
import java.util.List;

public class CosineSimilarityTextAnalyzer implements TextAnalyzer {
    @Override
    public double analyze(TextProvider te1, TextProvider te2) {
        List<String> list1 = tokenize(te1.getText());
        List<String> list2 = tokenize(te2.getText());
        List<String> UnionWords = UnionTokenize(list1, list2);
        List<Integer>EntriesForList1 = TermFrequensy(list1, UnionWords);
        List<Integer>EntriesForList2 = TermFrequensy(list2, UnionWords);
        return cosAnalyzer(EntriesForList1, EntriesForList2);
    }

    private List<String> tokenize(String text) {
        text = text.replace(",", "");
        String[] words = text.split(" ");
        List<String> Token = new ArrayList<>();
        for (String word : words) {
            word = word.toLowerCase();
            Token.add(word);
        }
        return Token;
    }


    private List<String> UnionTokenize(List<String> l1, List<String> l2) {
        ArrayList<String> UnionWords = new ArrayList<>();
        for (String token : l1) {
            if (!UnionWords.contains(l1)) {
                UnionWords.add(token);
            }
        }
        for (String token : l2) {
            if (!UnionWords.contains(l2)) {
                UnionWords.add(token);
            }
        }
        return UnionWords;
    }

    private List<Integer> TermFrequensy(List<String> l1, List<String> UW) {
        ArrayList<Integer> Entries = new ArrayList<>();
        int CountOfEntries = 0;
        for (int k = 0; k < l1.size(); k++) {
            CountOfEntries = 0;
            for (int i = 0; i < l1.size(); i++) {
                if (UW.contains(l1.get(i))) {
                    CountOfEntries++;
                    Entries.add(k, CountOfEntries);
                }
            }
        }
        return Entries;
    }
    private double cosAnalyzer(List<Integer> l1, List<Integer> l2) {
        double numerator = 0;
        double sum1 = 0;
        double sum2 = 0;
        double denominator = 0;
        int min;
        min = l1.size() < l2.size() ? l1.size() : l2.size();
        for (int i = 0; i < min; i++) {
            numerator += Math.sqrt(l1.get(i) * l1.get(i)) * Math.sqrt(l2.get(i) * l2.get(i));
        }
        for (int i = 0; i < min; i++) {
            sum1 += l1.get(i) * l1.get(i);
            sum2 += l2.get(i) * l2.get(i);
        }
        double sqr1 = Math.sqrt(sum1);
        double sqr2 = Math.sqrt(sum2);
        denominator = sqr1 * sqr2;
        double CosineSimilarity = numerator / denominator;
        return CosineSimilarity;
    }
}