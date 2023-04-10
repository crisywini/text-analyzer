package co.crisi.service;

import co.crisi.data.TextCountInfo;
import co.crisi.data.TextInfo;
import co.crisi.port.api.CountServicePort;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.val;
import org.apache.tomcat.util.http.parser.EntityTag;

public class CountService implements CountServicePort {

    @Override
    public long countWords(TextInfo textInfo) {
        val text = CleanTextService.cleanText(textInfo.text());
        return Arrays.stream(text.split("\s"))
                .count();
    }

    @Override
    public Map<String, Long> countGroupByWord(TextInfo textInfo) {
        val text = CleanTextService.cleanText(textInfo.text());
        return Arrays.stream(text.split(" "))
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public List<TextCountInfo> getMostRepeatedWords(TextInfo textInfo) {
        val wordsCount = countGroupByWord(textInfo);
        return wordsCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .map(entry -> new TextCountInfo(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }


}
