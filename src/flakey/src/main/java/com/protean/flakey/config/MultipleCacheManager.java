package com.protean.flakey.config;

//import org.springframework.boot.autoconfigure.cache.CacheProperties.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.Collection;
import java.util.concurrent.TimeUnit;


public class MultipleCacheManager extends CachingConfigurerSupport {

    public String[] cacheNames = {"tickets"};// "campaigns","comboPredictions","CustomizedPredictions"

    @Bean
//    @Primary
    public CacheManager cacheManager(){
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(cacheNames);
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(200)
                .maximumSize(500)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .weakKeys()
                .recordStats());

        return cacheManager;

    }

    @Bean
    public CacheManager alternateCacheManager() {
        return new ConcurrentMapCacheManager(cacheNames);
    }

    public CacheManager distributedCacheManager(){
        return null;
    }

    @Bean

    @Override
    public CacheResolver cacheResolver() {
        return new CustomCacheResolver(cacheManager(),alternateCacheManager());
    }
}
