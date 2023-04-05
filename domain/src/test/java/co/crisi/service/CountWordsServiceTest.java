package co.crisi.service;

import co.crisi.data.TextInfo;
import co.crisi.service.objectmother.TextInfoObjectMother;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountWordsServiceTest {

    private final CountWordsService countWordsService = new CountWordsService();

    @Test
    void givenNormalText_shouldReturnCorrectNumberOfWords() {
        val textInfo = TextInfoObjectMother.withText();
        val expectedWords = 32L;

        long words = countWordsService.countWords(textInfo);

        assertThat(words)
                .isEqualTo(expectedWords);
    }

}