package co.crisi.config;

import co.crisi.port.api.CountServicePort;
import co.crisi.service.CountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountWordsServiceConfig {


    @Bean
    public CountServicePort countService(){
        return new CountService();
    }

}
