package com.ghca.ceip.social;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.DefaultUserInfoRestTemplateFactory;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.List;

/**
 * Created by gh on 2017/5/12.
 */

@SpringBootApplication
@EnableOAuth2Client
public class CEIPSocialApplication {

    public static final String detect = "https://aip.baidubce.com/rest/2.0/face/v1/detect";
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CEIPSocialApplication.class, args);
        OAuth2RestTemplate bean = run.getBean(OAuth2RestTemplate.class);
        ResponseEntity<String> stringResponseEntity = bean.postForEntity(detect, null, String.class);
        System.out.println(stringResponseEntity);


    }


    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
        return new OAuth2RestTemplate(resource, context);
    }




}
