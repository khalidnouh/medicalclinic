package com.stc.caa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringFoxConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.stc.caa"))
                    .paths(PathSelectors.any())
                    .build();

        }
    @Bean
    public ApiInfo apiInfo() {
        List<VendorExtension> vedor = new ArrayList<>();
        Contact contact = new Contact("STC", "https://www.stc.com.sa/content/stc/sa/ar/personal/home.html", "khalidnou7.94@gmail.com");
        return new ApiInfo("Backend developer candidate’s assignment APIS Documentaion ", "THAT IS THE  RESTFUL APIS DOCUMENTATION",
                "1.0", "", contact, "", "", vedor);

    }
}