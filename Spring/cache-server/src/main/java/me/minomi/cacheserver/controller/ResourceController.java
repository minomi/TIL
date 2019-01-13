package me.minomi.cacheserver.controller;

import me.minomi.cacheserver.service.ResourceCacheService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-13.
 */

@RestController
public class ResourceController {

    private ResourceCacheService resourceCacheService;

    public ResourceController(ResourceCacheService resourceCacheService) {
        this.resourceCacheService = resourceCacheService;
    }

    @GetMapping("/rsc")
    public ResponseEntity<Resource> getResource(@RequestParam String url) {
        if (StringUtils.isEmpty(url)) {
            return ResponseEntity.badRequest().build();
        }

        File resource = resourceCacheService.getResource(url);
        Resource fileResource = new FileSystemResource(resource);
        return ResponseEntity.ok(fileResource);
    }
}
