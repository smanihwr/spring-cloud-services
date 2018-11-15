package pluralsight.demo;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomSampler {

    @Bean
    public Sampler smartSampler() {
        return span -> {
            System.out.println("custom sampler used");
            return true;
        };
    }
}
