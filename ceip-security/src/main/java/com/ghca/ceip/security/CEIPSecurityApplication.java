package com.ghca.ceip.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by gh on 2017/4/11.
 */

@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing
@EnableAuthorizationServer
public class CEIPSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CEIPSecurityApplication.class);
    }



    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("CEIP权限控制模块")
                        .description("用户角色权限管理")
                        .termsOfServiceUrl("http://blog.didispace.com/")
                        .contact(new Contact("ZHANG Yi", "", "278912113@qq.com"))
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ghca.ceip.security"))
                .paths(PathSelectors.any())
                .build();
    }

}
