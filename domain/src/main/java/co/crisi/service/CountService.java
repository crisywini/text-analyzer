package co.crisi.service;

import co.crisi.data.TextInfo;
import co.crisi.port.api.CountServicePort;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.val;

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

}
