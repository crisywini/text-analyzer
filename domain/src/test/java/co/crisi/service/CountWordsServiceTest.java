package co.crisi.service;

import co.crisi.data.TextInfo;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountWordsServiceTest {

    private final CountWordsService countWordsService = new CountWordsService();

    @Test
    void givenNormalText_shouldReturnCorrectNumberOfWords() {
        val text = "La posada Roca de Guía era suya, y también era suyo el tercer silencio. Así debía ser, pues ese era el mayor de los tres silencios y envolvía a los otros dos.";
        val textInfo = new TextInfo(text);
        val expectedWords = 32L;

        long words = countWordsService.countWords(textInfo);

        assertThat(words)
                .isEqualTo(expectedWords);
    }

}