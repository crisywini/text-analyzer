package co.crisi.controller;

import co.crisi.data.TextDto;
import co.crisi.mapper.TextMapper;
import co.crisi.port.api.SentimentServicePort;
import java.util.Map;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentiments")
public class SentimentController {

    @Autowired
    private SentimentServicePort sentimentService;

    private final TextMapper textMapper = Mappers.getMapper(TextMapper.class);

    @PostMapping
    public ResponseEntity<Map<String, Integer>> getSentiments(
            @RequestBody
                    TextDto textDto) {
        return ResponseEntity.ok(sentimentService.getSentiments(textMapper.mapToInfo(textDto)));
    }

}
