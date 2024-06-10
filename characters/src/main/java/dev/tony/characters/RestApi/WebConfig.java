package dev.tony.characters.RestApi;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuraciones CORS si son necesarias
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configuraciones de manejadores de recursos si son necesarias
    }

    // Otros métodos de configuración...
}
