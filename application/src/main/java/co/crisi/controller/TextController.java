package co.crisi.controller;

import co.crisi.data.TextDto;
import co.crisi.mapper.TextMapper;
import co.crisi.port.api.TextServicePort;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/texts")
public class TextController {

    @Autowired
    private TextServicePort textService;

    private final TextMapper textMapper = Mappers.getMapper(TextMapper.class);

    @PostMapping
    public ResponseEntity<Long> countWords(
            @RequestBody
                    TextDto textDto) {
        return ResponseEntity.ok(textService.countWords(textMapper.mapToInfo(textDto)));

    }

}
