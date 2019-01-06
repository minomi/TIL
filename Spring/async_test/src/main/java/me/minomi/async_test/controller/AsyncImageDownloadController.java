package me.minomi.async_test.controller;

import me.minomi.async_test.service.AsyncDownloadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.net.URL;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-06.
 */

@RestController
public class AsyncImageDownloadController {

    private AsyncDownloadService asyncDownloadService;

    public AsyncImageDownloadController(AsyncDownloadService asyncDownloadService) {
        this.asyncDownloadService = asyncDownloadService;
    }

    @PostMapping(value = "/image")
    public DeferredResult<ResponseEntity<String>> download(@RequestParam String imgUrlStr) throws Exception{
        URL imgURL = new URL(imgUrlStr);
        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>();
        asyncDownloadService.downloadAndSaveImg(imgURL, deferredResult);
        return deferredResult;
    }
}
