package finalmission.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    private final RandommerProperties randommerProperties;

    public ClientConfig(final RandommerProperties randommerProperties) {
        this.randommerProperties = randommerProperties;
    }

    
}
