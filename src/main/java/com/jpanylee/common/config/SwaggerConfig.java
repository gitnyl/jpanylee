package com.jpanylee.common.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // http://localhost:8080/swagger-ui.html
    private String basePackage = "com.jpanylee.api.jpanylee.controller";
    private String version = "1.0.0";
    private String title;
    private String pathUri;
    List<ResponseMessage> commonResponse = setCommonResponse();

    private List<ResponseMessage> setCommonResponse() {
        List<ResponseMessage> list = new ArrayList<>();
        list.add(new ResponseMessageBuilder().code(404).message("Not Found").responseModel(new ModelRef("ResponseEntity")).build());
        list.add(new ResponseMessageBuilder().code(500).message("Internal Error").responseModel(new ModelRef("ResponseEntity")).build());
        return list;
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket apiTest() {
        TypeResolver typeResolver = new TypeResolver();
        title = "테스트 " + version;
        pathUri = "/api/test/**";

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(title)
                .apiInfo(apiInfo(version, title))
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.ant(pathUri))
                .build()
                .useDefaultResponseMessages(false)  //swagger에서 제공해주는 응답코드 (200,401,403,404)에 대한 기본 메시지 사용 여부
                .globalResponseMessage(RequestMethod.POST, commonResponse)
                .globalResponseMessage(RequestMethod.GET, commonResponse)
                .globalResponseMessage(RequestMethod.DELETE, commonResponse)
                .globalResponseMessage(RequestMethod.PUT, commonResponse)
                .additionalModels(typeResolver.resolve(ResponseEntity.class))
                ;
    }
    @Bean
    public Docket apiAdmin() {
        title = "관리자 " + version;
        pathUri = "/api/admin/**";

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, commonResponse)
                .globalResponseMessage(RequestMethod.GET, commonResponse)
                .globalResponseMessage(RequestMethod.DELETE, commonResponse)
                .globalResponseMessage(RequestMethod.PUT, commonResponse)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.ant(pathUri))
                .build()
                .apiInfo(apiInfo(version, title))
                .groupName(title)
                ;
    }
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "API Docs",
                version,
                "www.nayeonglee.kr",
                new Contact("Contact Info", "www.nayeonglee.kr", "nylee226@gmail.com"),
                "Licenses", "www.nayeonglee.kr",
                new ArrayList<>());
    }


}
