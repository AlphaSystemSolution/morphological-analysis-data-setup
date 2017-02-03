package com.alphasystem.morphologicalanalysis.spring.support;

import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * @author sali
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.alphasystem.morphologicalanalysis.wordbyword.repository",
        "com.alphasystem.morphologicalanalysis.graph.repository",
        "com.alphasystem.morphologicalanalysis.morphology.repository"})
public class MongoConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);
    public static final String MONGO_DB_NAME_PROPERTY = "mongo.db.name";

    @Value("${script.name:SIMPLE_ENHANCED}")
    private String scriptName;

    @Value("${mongodb.host:127.0.0.1}")
    private String mongodbHostUrl;

    @Value("${mongodb.port:27017}")
    private int mongodbPort;

    @Value("${mongodb.database:__DEFAULT__}")
    private String mongodbDatabase;

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient(mongodbHostUrl, mongodbPort);
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        LOGGER.info("Connecting to database: {}", mongodbDatabase);
        return new SimpleMongoDbFactory(this.mongoClient(), mongodbDatabase);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public DbRefResolver dbRefResolver() throws Exception {
        return new DefaultDbRefResolver(mongoDbFactory());
    }

    @Bean
    public MappingContext mappingContext() {
        return new MongoMappingContext();
    }

    @Bean
    public MongoConverter mongoConverter() throws Exception {
        return mongoTemplate().getConverter();
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mongoConverter());
    }

}
