package co.crisi.service.objectmother;

import co.crisi.data.TextInfo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TextInfoObjectMother {

    public static TextInfo emptyText() {
        return new TextInfo("");
    }

    public static TextInfo withText() {
        return new TextInfo(
                "La posada Roca de Guía era suya, y también era suyo el tercer silencio. Así debía ser, pues ese era el mayor de los tres silencios y envolvía a los otros dos.");
    }

    public static TextInfo withTextToGroupBy() {
        return new TextInfo(
                "The thing about this, is that the is two times same as that");
    }

    public static TextInfo withTextSentimentPositive() {
        return new TextInfo("The thing is that this project looks amazing dude, I am really happy for you,congrats!");
    }

}
