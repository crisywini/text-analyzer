package co.crisi.controller;

import co.crisi.data.TextDto;
import co.crisi.mapper.TextMapper;
import co.crisi.port.api.TextServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/text")
public class TextController {

    @Autowired
    private TextServicePort textServicePort;

    @Autowired
    private TextMapper textMapper;

    @PostMapping
    public ResponseEntity<Long> countWords(
            @RequestBody
                    TextDto textDto) {
        return ResponseEntity.ok(textServicePort.countWords(textMapper.mapToInfo(textDto)));

    }

}
