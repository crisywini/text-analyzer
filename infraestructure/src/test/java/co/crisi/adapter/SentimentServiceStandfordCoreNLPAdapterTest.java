package co.crisi.adapter;

import co.crisi.service.objectmother.TextInfoObjectMother;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SentimentServiceStandfordCoreNLPAdapterTest {

    private final SentimentServiceStandfordCoreNLPAdapter sentimentService = new SentimentServiceStandfordCoreNLPAdapter();

    @Test
    void whenPositive_shouldReturnPositive() {

        val textInfo = TextInfoObjectMother.withTextSentimentPositive();
        val sentiments = sentimentService.getSentiments(textInfo);

        assertThat(sentiments)
                .isNotEmpty()
                .containsEntry("Positive", 3.0);
    }

}