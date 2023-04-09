package co.crisi.port.api;

import co.crisi.data.TextInfo;
import java.util.Map;

public interface SentimentServicePort {

    Map<String, Double> getSentiments(TextInfo textInfo);

}
