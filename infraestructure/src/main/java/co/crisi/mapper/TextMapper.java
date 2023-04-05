package co.crisi.mapper;

import co.crisi.data.TextDto;
import co.crisi.data.TextInfo;
import org.mapstruct.Mapper;

@Mapper
public interface TextMapper {

    TextInfo mapToInfo(TextDto textDto);

    TextDto mapToDto(TextInfo textInfo);

}
