package co.crisi.adapter;

import co.crisi.data.TextInfo;
import co.crisi.port.api.SentimentServicePort;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import lombok.val;
import org.ejml.simple.SimpleMatrix;
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
    public Map<String, Double> getSentiments(TextInfo textInfo) {
        Annotation annotation = pipeline.process(textInfo.text());
        Map<String, Double> sentiments = new HashMap<>();
        for (CoreMap sentence : annotation
                .get(CoreAnnotations.SentencesAnnotation.class)) {
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            double sentiment = RNNCoreAnnotations.getPredictedClass(tree);
            String sentimentType = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            sentiments.put(sentimentType, sentiment);
        }

        return sentiments;
    }

}
