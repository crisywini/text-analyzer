package co.crisi.adapter;

import co.crisi.SentimentNotFoundException;
import co.crisi.data.TextInfo;
import co.crisi.port.api.SentimentServicePort;
import co.crisi.service.CleanTextService;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentClass;
import java.util.Properties;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
public class SentimentServiceStandfordCoreNLPAdapter implements SentimentServicePort {

    private final StanfordCoreNLP pipeline;

    public SentimentServiceStandfordCoreNLPAdapter() {
        val props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }


    @Override
    public String getSentiment(TextInfo textInfo) {
        val annotation = pipeline.process(CleanTextService.cleanText(textInfo.text()));
        return annotation.get(SentencesAnnotation.class).stream()
                .map(sentence -> sentence.get(SentimentClass.class))
                .findFirst()
                .orElseThrow(() -> new SentimentNotFoundException(textInfo.text()));
    }

}
