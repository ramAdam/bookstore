package com.mog.momongo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

/**
 * BookDataConfiguration
 */
@Configuration
public class BookDataConfiguration {

    @Autowired
    BookData data;

    @Bean("bookData")
    public BookData bookData(){
        data.populateBooks();
        return data;
    }

    // @Bean
    // public Jackson2RepositoryPopulatorFactoryBean getRepositoryPopulator(){
    //     Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
    //     factory.setResources(new Resource[] {new ClassPathResource("data.json")});
    //     return factory;
    // }
    
}