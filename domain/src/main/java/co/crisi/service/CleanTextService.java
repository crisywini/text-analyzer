package co.crisi.service;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CleanTextService {


    public static String cleanText(String text) {
        return removePunctuation(removeBlankSpaces(text));
    }

    private static String removeBlankSpaces(String text) {
        return text
                .replaceAll("\\s+", " ");
    }

    private static String removePunctuation(String text) {
        return text
                .replaceAll("\\p{Punct}", "");
    }

}
