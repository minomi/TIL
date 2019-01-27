package me.minomi;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-28.
 */
public class ImageDownloaderFactory {

    public static ImageDownloader getImageDownloader(String downloaderName) {
        if (downloaderName.equals("NIO")) {
            return new ImageDownloaderWithNIO();
        } else if (downloaderName.equals("IO")) {
            return new ImageDownloaderWithIO();
        }
        throw new RuntimeException("해당 다운로더는 없습니다.");
    }
}
