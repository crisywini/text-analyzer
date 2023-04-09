package co.crisi.port.api;

import co.crisi.data.TextInfo;

public interface SentimentServicePort {

    String getSentiment(TextInfo textInfo);

}
