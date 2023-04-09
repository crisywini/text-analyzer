package co.crisi.adapter;

import co.crisi.data.TextInfo;
import co.crisi.port.api.SentimentServicePort;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import lombok.val;
import org.apache.commons.lang3.tuple.Pair;
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
    public Map<String, Integer> getSentiments(TextInfo textInfo) {
        val annotation = pipeline.process(textInfo.text());
        return annotation.get(CoreAnnotations.SentencesAnnotation.class).stream()
                .map(sentence -> {
                    val tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                    val score = RNNCoreAnnotations.getPredictedClass(tree);
                    val sentimentType = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
                    return Pair.of(sentimentType, score);
                })
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }

}
