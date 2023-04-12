package co.crisi.service;

import co.crisi.data.TextCountInfo;
import co.crisi.exception.EmptyTextException;
import co.crisi.service.objectmother.TextInfoObjectMother;
import java.util.List;
import java.util.Map;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountServiceTest {

    private final CountService countService = new CountService();


    @Nested
    class CountWords {

        @Test
        void givenNormalText_shouldReturnCorrectNumberOfWords() {
            val textInfo = TextInfoObjectMother.withText();
            val expectedWords = 32L;

            long words = countService.countWords(textInfo);

            assertThat(words)
                    .isEqualTo(expectedWords);
        }

    }


    @Nested
    class CountGroupBy {

        @Test
        void whenNormalText_shouldMapCorrectCounting() {
            val textInfo = TextInfoObjectMother.withTextToGroupBy();

            Map<String, Long> wordCount = countService.countGroupByWord(textInfo);

            assertThat(wordCount)
                    .isNotEmpty()
                    .containsEntry("THE", 2L)
                    .containsEntry("SAME", 1L)
                    .containsEntry("THAT", 2L)
                    .containsEntry("IS", 2L)
                    .containsEntry("AS", 1L)
                    .containsEntry("TIMES", 1L)
                    .containsEntry("TWO", 1L)
                    .containsEntry("ABOUT", 1L)
                    .containsEntry("THING", 1L);
        }

    }

    @Nested
    class GetMostRepeatedWords {

        @Test
        void whenNormalText_shouldRetrieve10MostRepeatedWords() {
            val textInfo = TextInfoObjectMother.withTextToGroupBy();
            val expectedWords = List.of(new TextCountInfo("THAT", 2L),
                    new TextCountInfo("THE", 2L), new TextCountInfo("IS", 2L),
                    new TextCountInfo("SAME", 1L), new TextCountInfo("AS", 1L),
                    new TextCountInfo("TIMES", 1L), new TextCountInfo("THIS", 1L),
                    new TextCountInfo("TWO", 1L), new TextCountInfo("ABOUT", 1L),
                    new TextCountInfo("THING", 1L));
            val mostRepeatedWords = countService.getMostRepeatedWords(textInfo);

            assertThat(mostRepeatedWords)
                    .isNotEmpty()
                    .isEqualTo(expectedWords)
                    .size().isEqualTo(10);
        }

        @Test
        void whenNoText_shouldRetrieveEmpty() {
            val textInfo = TextInfoObjectMother.emptyText();

            val exception = Assertions.assertThrows(EmptyTextException.class,
                    () -> countService.getMostRepeatedWords(textInfo));

            assertThat(exception)
                    .hasMessage("The input is blank! Couldn't do any operation with it!");
        }

    }

}