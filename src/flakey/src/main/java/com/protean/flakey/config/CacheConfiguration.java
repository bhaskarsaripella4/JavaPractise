//package com.protean.flakey.config;
//
//
//import com.zaxxer.hikari.util.ConcurrentBag;
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.cache.interceptor.SimpleCacheResolver;
//import org.springframework.cache.interceptor.AbstractCacheResolver;
//
//import java.util.Collections;
//
//@Configuration
//@EnableCaching
//public class CacheConfiguration {
//
//    @Bean
//    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
//        return new ConcurrentCustomizer();
//    }
//
//    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
//
//        @Override
//        public void customize(ConcurrentMapCacheManager cacheManager) {
//            cacheManager.setAllowNullValues(false); // does not save null values in cache
//            cacheManager.setCacheNames(Collections.singleton("tickets"));
//            System.out.println("using cache customizer for "+cacheManager.getCacheNames().toString()+"cache");
//        }
//    }
//
//}
