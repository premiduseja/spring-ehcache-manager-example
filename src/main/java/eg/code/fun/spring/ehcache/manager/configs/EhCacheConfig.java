package eg.code.fun.spring.ehcache.manager.configs;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Caching;
import java.time.Duration;

@Configuration
@EnableCaching
public class EhCacheConfig {
    
    @Value ("${cache.ttl.seconds}")
    Long cacheTtl;

    /**
     * Creates cache manager
     * @return org.springframework.cache.CacheManager - Cache manager
     */
    @Bean
    CacheManager ehCacheManager(){
        javax.cache.CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();

        cacheManager.createCache("employeeCache",prepareConfiguration(10000,Duration.ofSeconds(cacheTtl)));

        return new JCacheCacheManager(cacheManager);
    }

    /**
     * Helper method providing ehcache configuration for the cache
     * @return javax.cache.configuration.Configuration<Object, Object>
     */
    @SuppressWarnings({"SameParameterValue"})
    private javax.cache.configuration.Configuration<Object, Object> prepareConfiguration(long heapSize, Duration timeToLive) {
        return Eh107Configuration.fromEhcacheCacheConfiguration(
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(heapSize))
                        .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(timeToLive)));
    }
}
