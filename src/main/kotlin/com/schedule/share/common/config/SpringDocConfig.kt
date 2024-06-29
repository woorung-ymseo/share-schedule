package com.schedule.share.common.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.SpecVersion
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.format.FormatterRegistry
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Profile("local", "dev")
@Configuration
class SpringDocConfig(

) : WebMvcConfigurer {
    override fun addFormatters(registry: FormatterRegistry) {
        DateTimeFormatterRegistrar().apply {
            setUseIsoFormat(true)
            registerFormatters(registry)
        }
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true)
    }

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .specVersion(SpecVersion.V31)
            .info(
                Info()
                    .title("Share Schedule - Calendar API")
                    .version("1.0"),
            )
//            .servers(listOf(Server().url(contextPath)))
    }

    @Bean
    fun adminApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("Calendar API")
            .displayName("Calendar API")
            .packagesToScan("com.schedule.share")
            .build()
    }
}
