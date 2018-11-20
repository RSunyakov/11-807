package ru.kpfu.itis.textsimilarity;

import java.util.List;

public class SearchEngineImpl implements SearchEngine {
    private TextAnalyzer analyzer;

    public SearchEngineImpl(TextAnalyzer analyzer) {
        this.analyzer = analyzer;
    }
    @Override
    public List<TextProvider> getSortedByRelevanceList(TextProvider target, List<TextProvider> sources) {
        for (int i = sources.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (analyzer.analyze(target, sources.get(j)) > analyzer.analyze(target, sources.get(j + 1))) {
                    TextProvider tmp = sources.get(j);
                    sources.set(j, sources.get(j + 1));
                    sources.set(j + 1, tmp);
                }
            }
        }
        for (int i = 0; i < sources.size() / 2; i++) {
            TextProvider tmp = sources.get(i);
            sources.set(i, sources.get(sources.size() - i - 1));
            sources.set(sources.size() - i - 1, tmp);
        }
        return sources;
    }
}
