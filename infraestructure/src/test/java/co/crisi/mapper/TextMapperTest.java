package co.crisi.mapper;

import co.crisi.data.TextDto;
import co.crisi.data.TextInfo;
import co.crisi.mapper.objectmother.TextDtoObjectMother;
import co.crisi.service.objectmother.TextInfoObjectMother;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;


class TextMapperTest {

    private final TextMapper textMapper = Mappers.getMapper(TextMapper.class);

    @Test
    void mapToDto() {

        val textInfo = TextInfoObjectMother.withText();

        val textDto = textMapper.mapToDto(textInfo);

        assertThat(textDto)
                .isNotNull()
                .extracting(TextDto::getText)
                .isEqualTo(textInfo.text());
    }

    @Test
    void mapToInfo() {

        val textDto = TextDtoObjectMother.withText();

        val textInfo = textMapper.mapToInfo(textDto);

        assertThat(textInfo)
                .isNotNull()
                .extracting(TextInfo::text)
                .isEqualTo(textDto.getText());
    }

}