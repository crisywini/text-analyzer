package co.crisi.mapper;

import co.crisi.data.TextCountDto;
import co.crisi.data.TextCountInfo;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface TextCountMapper {

    TextCountInfo mapToInfo(TextCountDto textCountDto);

    TextCountDto mapToDto(TextCountInfo textCountInfo);

    List<TextCountDto> mapToDtos(List<TextCountInfo> textCountInfos);

}
