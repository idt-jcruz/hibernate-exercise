package com.mstar.training.config;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.SpringHandlerInstantiator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;

@Configuration
public class RepositoryConfig {
	
	private Resource[] autoPopulationResources = {
			new ClassPathResource( "jails.json" ),
			new ClassPathResource( "inmates.json" ),
			new ClassPathResource( "officers.json" )
    		
    };
	
	@Bean
    public Jackson2RepositoryPopulatorFactoryBean respositoryPopulator(ObjectMapper mapper) {
        
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setResources( autoPopulationResources );
        factory.setMapper( mapper );
        
        return factory;
    }
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder(ApplicationContext context) {
		
		HandlerInstantiator handler = new SpringHandlerInstantiator( context.getAutowireCapableBeanFactory() );
		
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.handlerInstantiator( handler );
	    
	    return builder;
	}
	
}
