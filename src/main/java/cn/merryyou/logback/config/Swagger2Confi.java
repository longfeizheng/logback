//package cn.merryyou.logback.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * Created on 2017/11/21.
// *
// * @author zlf
// * @since 1.0
// */
//@Configuration
//@EnableSwagger2
//public class Swagger2Confi {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SPRING_WEB)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("cn.merryyou.logback.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    @Bean
//    public ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring Boot中使用Swagger2构建RESTful APIs")
//                .description("Spring Boot Demo")
//                .termsOfServiceUrl("https://longfeizheng@github.com")
//                .contact("longfeizheng")
//                .version("1.0")
//                .build();
//    }
//}
