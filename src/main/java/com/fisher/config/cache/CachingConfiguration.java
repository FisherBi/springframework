package com.fisher.config.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.*;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fisbii on 16-12-6.
 */
@Configuration
@EnableCaching
@ComponentScan
public class CachingConfiguration implements CachingConfigurer {
    @Autowired
    @Qualifier("ehCacheCacheManager")
    private CacheManager ehCacheCacheManager;

    @Autowired
    @Qualifier("redisCacheManager")
    private CacheManager redisCacheManager;


    @Override
    public CacheManager cacheManager() {
        List<CacheManager> cacheManagers = new ArrayList<>();

        if (this.ehCacheCacheManager != null) {
            cacheManagers.add(this.ehCacheCacheManager);
        }

        if (this.redisCacheManager != null) {
            cacheManagers.add(this.redisCacheManager);
        }

        CompositeCacheManager cacheManager = new CompositeCacheManager();

        cacheManager.setCacheManagers(cacheManagers);
        return cacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}
