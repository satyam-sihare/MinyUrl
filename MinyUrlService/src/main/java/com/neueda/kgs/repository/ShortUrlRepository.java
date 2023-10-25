package com.neueda.kgs.repository;

import com.neueda.kgs.config.CacheConfig;
import com.neueda.kgs.model.ShortUrl;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends MongoRepository<ShortUrl, String> {
    @Cacheable(value = CacheConfig.CACHE_MINYLY)
    ShortUrl findByKeyCode(Long key);

    ShortUrl findByLongUrl(String url);

    @CachePut(value = CacheConfig.CACHE_MINYLY, key = "#shortUrl.keyCode")
    ShortUrl save(ShortUrl shortUrl);
}
