package co.crisi.config;

import co.crisi.adapter.SentimentServiceStandfordCoreNLPAdapter;
import co.crisi.port.api.SentimentServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SentimentServiceConfig {

    @Bean
    public SentimentServicePort sentimentService() {
        return new SentimentServiceStandfordCoreNLPAdapter();
    }

}
