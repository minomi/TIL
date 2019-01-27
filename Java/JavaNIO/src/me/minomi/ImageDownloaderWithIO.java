package me.minomi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-28.
 */
public class ImageDownloaderWithIO implements ImageDownloader {

    private static final int BUFFER_CAPACITY = 50 * 1000 * 1000; // 50MB

    @Override
    public void download(URL imageURL, File file) {
        try (BufferedInputStream in = new BufferedInputStream(imageURL.openStream());
             FileOutputStream fileOutputStream  = new FileOutputStream(file)) {

            byte[] dataBuffer = new byte[BUFFER_CAPACITY];

            int bytesRead;

            while ((bytesRead = in.read(dataBuffer, 0, BUFFER_CAPACITY)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
