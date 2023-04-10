package co.crisi.controller;

import co.crisi.data.TextCountDto;
import co.crisi.data.TextDto;
import co.crisi.mapper.TextCountMapper;
import co.crisi.mapper.TextMapper;
import co.crisi.port.api.CountServicePort;
import java.util.List;
import java.util.Map;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/texts")
public class CountController {

    @Autowired
    private CountServicePort countService;

    private final TextMapper textMapper = Mappers.getMapper(TextMapper.class);

    private final TextCountMapper textCountMapper = Mappers.getMapper(TextCountMapper.class);

    @PostMapping("/words")
    public ResponseEntity<Long> countWords(
            @RequestBody
                    TextDto textDto) {
        return ResponseEntity.ok(countService.countWords(textMapper.mapToInfo(textDto)));
    }

    @PostMapping("/group/words")
    public ResponseEntity<Map<String, Long>> countGroupByWord(
            @RequestBody
                    TextDto textDto) {
        return ResponseEntity.ok(countService.countGroupByWord(textMapper.mapToInfo(textDto)));
    }

    @PostMapping("/most-repeated/words")
    public ResponseEntity<List<TextCountDto>> getMostRepeatedWords(
            @RequestBody
                    TextDto textDto) {
        return ResponseEntity.ok(
                textCountMapper.mapToDtos(countService.getMostRepeatedWords(textMapper.mapToInfo(textDto))));
    }

}
