package co.crisi.port.api;

import co.crisi.data.TextInfo;
import java.util.Map;

public interface CountServicePort {

    long countWords(TextInfo textInfo);

    Map<String, Long> countGroupByWord(TextInfo textInfo);

}
