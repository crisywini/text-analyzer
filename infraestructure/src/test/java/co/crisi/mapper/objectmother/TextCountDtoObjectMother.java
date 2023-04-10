package co.crisi.mapper.objectmother;

import co.crisi.data.TextCountDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TextCountDtoObjectMother {

    public static TextCountDto withTextAndTimes(){
        return new TextCountDto("DTO", 5L);
    }

}
