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

}
