package me.minomi.async_test.service;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-06.
 */

@Service
public class AsyncDownloadService {
    private String BASE = "/Users/minho/workspace/TIL/Spring/async_test/src/main/resources/static";

    @Async
    public void downloadAndSaveImg(URL imgURL,
                                   DeferredResult<ResponseEntity<String>> deferredResult) throws Exception {
        String fileName = this.fileName("" + imgURL.hashCode());
        File file = new File(fileName);
        if (file.exists()) {
            deferredResult.setResult(ResponseEntity.ok(fileName));
            return;
        }
        BufferedImage bufferedImage = ImageIO.read(imgURL);
        ImageIO.write(bufferedImage, "jpg", file);
        deferredResult.setResult(ResponseEntity.ok(fileName));
    }

    private String fileName(String fileKey) {
        return BASE + "/" + fileKey + ".jpg";
    }
}
