package etec.backend.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Permite que el front (Next.js en localhost:3000) llame a la API desde el navegador.
 * Hoy la home pide los datos desde el SERVIDOR de Next (no aplica CORS),
 * pero cuando se hagan fetch desde componentes cliente, esto es obligatorio.
 */
@Configuration
class CorsConfig(
    @Value("\${app.cors.allowed-origins:http://localhost:3000}")
    private val allowedOrigins: Array<String>
) : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/api/**")
            .allowedOrigins(*allowedOrigins)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
    }
}
