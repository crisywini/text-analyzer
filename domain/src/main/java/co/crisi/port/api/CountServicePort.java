package co.crisi.port.api;

import co.crisi.data.TextCountInfo;
import co.crisi.data.TextInfo;

import java.util.List;
import java.util.Map;

public interface CountServicePort {

    long countWords(TextInfo textInfo);

    Map<String, Long> countGroupByWord(TextInfo textInfo);

    List<TextCountInfo> getMostRepeatedWords(TextInfo textInfo);

}
