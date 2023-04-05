package co.crisi.service;

import co.crisi.data.TextInfo;
import co.crisi.port.api.TextServicePort;
import java.util.Arrays;
import lombok.val;

public class CountWordsService implements TextServicePort {

    @Override
    public long countWords(TextInfo textInfo) {
        val text = textInfo.text()
                .replaceAll("\\s+", " ")
                .replaceAll("\\p{Punct}", "");
        return Arrays.stream(text.split("\s"))
                .count();
    }

}
