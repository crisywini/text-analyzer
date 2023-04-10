package co.crisi.mapper;

import co.crisi.data.TextCountDto;
import co.crisi.data.TextCountInfo;
import co.crisi.mapper.objectmother.TextCountDtoObjectMother;
import co.crisi.service.objectmother.TextCountInfoObjectMother;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class TextCountMapperTest {

    private final TextCountMapper textCountMapper = Mappers.getMapper(TextCountMapper.class);


    @Test
    void mapToDto() {
        val textCountInfo = TextCountInfoObjectMother.withTextAndTimes();

        val textCountDto = textCountMapper.mapToDto(textCountInfo);

        assertThat(textCountDto)
                .isNotNull()
                .extracting(TextCountDto::getWord, TextCountDto::getTimes)
                .contains("WORD", 3L);
    }

    @Test
    void mapToInfo() {
        val textCountDto = TextCountDtoObjectMother.withTextAndTimes();

        val textCountInfo = textCountMapper.mapToInfo(textCountDto);

        assertThat(textCountInfo)
                .isNotNull()
                .extracting(TextCountInfo::word, TextCountInfo::times)
                .contains("DTO", 5L);
    }

}