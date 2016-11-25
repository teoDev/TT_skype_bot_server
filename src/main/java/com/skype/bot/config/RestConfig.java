package com.skype.bot.config;

import com.skype.bot.model.Answer;
import com.skype.bot.model.AnswerContent;
import com.skype.bot.model.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by surmab on 25.11.2016.
 */
@Configuration
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class RestConfig  extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Tag.class);
    }
    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


    @Bean
    public ResourceProcessor<Resource<Answer>> answerProcessor() {
            return new ResourceProcessor<Resource<Answer>>() {

                @Override
                public Resource<Answer> process(Resource<Answer> resource) {
                    Answer content = resource.getContent();
                    if (content.getContent().getType() != AnswerContent.ContentType.TEXT){
                        resource.add(new Link("http://localhost:8080/answer-content/download/"+content.getContent().getText()+"&type="+content.getContent().getType(), "download-link"));
                    }
                    return resource;
                }
            };
        }

}