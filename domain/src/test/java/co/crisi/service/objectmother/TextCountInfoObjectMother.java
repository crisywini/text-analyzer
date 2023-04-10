package co.crisi.service.objectmother;

import co.crisi.data.TextCountInfo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TextCountInfoObjectMother {

    public static TextCountInfo withTextAndTimes(){
        return new TextCountInfo("WORD", 3L);
    }

}
