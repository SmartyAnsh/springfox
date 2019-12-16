package com.smart.discover.springfox;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SpringfoxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringfoxApplication.class, args);
    }

    @Bean
    public Docket springfoxAppInfo() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("Springfox-api")
            .select()
            .paths(paths())
            .build()
            .apiInfo(apiInfo());
    }

    private Predicate<String> paths() {
        return regex("/api/.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Springfox API specification",
                "Spring REST APIs",
                "",
                "",
                null,
                "License of API", "API license URL", Collections.emptyList());
    }

}
