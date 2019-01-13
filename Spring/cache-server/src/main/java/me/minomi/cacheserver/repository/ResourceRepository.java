package me.minomi.cacheserver.repository;

import me.minomi.cacheserver.domain.ResourceCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */
@Repository
public interface ResourceRepository extends CrudRepository<ResourceCache, String> { }
