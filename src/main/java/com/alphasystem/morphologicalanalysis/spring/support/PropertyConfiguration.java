package com.alphasystem.morphologicalanalysis.spring.support;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author sali
 */
@Configuration
public class PropertyConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        String activeProfile = System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        Resource[] locations = new Resource[0];
        locations = ArrayUtils.add(locations, new ClassPathResource(String.format("config-%s.properties", activeProfile)));
        propertySourcesPlaceholderConfigurer.setLocations(locations);
        return propertySourcesPlaceholderConfigurer;
    }
}
