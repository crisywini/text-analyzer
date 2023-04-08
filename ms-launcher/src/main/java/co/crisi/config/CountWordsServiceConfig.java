package co.crisi.config;

import co.crisi.port.api.TextServicePort;
import co.crisi.service.CountWordsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountWordsServiceConfig {


    @Bean
    public TextServicePort textService(){
        return new CountWordsService();
    }

}
