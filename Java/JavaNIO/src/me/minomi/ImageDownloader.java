package me.minomi;

import java.io.File;
import java.net.URL;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-28.
 */
public interface ImageDownloader {
    void download(URL imageURL, File file);
}
