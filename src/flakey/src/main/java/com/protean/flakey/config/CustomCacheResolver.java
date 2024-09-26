package com.protean.flakey.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.Collection;

public class CustomCacheResolver implements CacheResolver {
    public final CacheManager cacheManager;
    public final CacheManager alternateCacheManager;


    public CustomCacheResolver(final CacheManager cacheManager,final CacheManager alternateCacheManager) {
        this.cacheManager = cacheManager;
        this.alternateCacheManager = alternateCacheManager;
    }

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        return null;
    }
}
