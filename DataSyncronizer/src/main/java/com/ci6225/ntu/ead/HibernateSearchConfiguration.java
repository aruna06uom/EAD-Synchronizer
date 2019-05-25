package com.ci6225.ntu.ead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ci6225.ntu.ead.service.HibernateSearchService;

import javax.persistence.EntityManager;

@EnableAutoConfiguration
@Configuration
public class HibernateSearchConfiguration {

    @Autowired
    private EntityManager bentityManager;

    @Bean
    HibernateSearchService hibernateSearchService() {
        HibernateSearchService hibernateSearchService = new HibernateSearchService(bentityManager);
        hibernateSearchService.initializeHibernateSearch();
        return hibernateSearchService;
    }
}