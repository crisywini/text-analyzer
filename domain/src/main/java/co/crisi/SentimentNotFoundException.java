package co.crisi;

public class SentimentNotFoundException extends RuntimeException{

    public static final String SENTIMENT_NOT_FOUND_MESSAGE = "The sentiment of the sentence: %s was not found!";

    public SentimentNotFoundException(String sentence){
        super(String.format(SENTIMENT_NOT_FOUND_MESSAGE, sentence));
    }
}
