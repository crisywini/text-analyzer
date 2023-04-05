package co.crisi.mapper.objectmother;

import co.crisi.data.TextDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TextDtoObjectMother {

    public static TextDto withEmptyText() {
        return TextDto.builder()
                .text("")
                .build();
    }

    public static TextDto withText(){
        return TextDto.builder()
                .text("They stay with Professor Kirke, an eccentric but kind old man, who resides in a house filled with twists, turns, and surprises.")
                .build();
    }

}
