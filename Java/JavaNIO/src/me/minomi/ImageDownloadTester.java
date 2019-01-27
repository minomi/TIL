package me.minomi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-26.
 */
public class ImageDownloadTester {

    private static final List<String> IMAGE_URLS = List.of(
            "https://pixabay.com/get/eb35b90c2cfd033ecd0b4404e44c469eeb76ffd41cb5194795f0c67ba0.jpg",
            "https://pixabay.com/get/e837b90a2ef7053ecd0b4404e44c469eeb76ffd41cb5194795f0c67ba0.png",
            "https://pixabay.com/get/e830b1072ef5023ecd0b4404e44c469eeb76ffd41cb5194795f0c67ba0.jpg",
            "https://pixabay.com/get/ef3cb5082bf41c3e815b4407e64c4e9ee26ae3d01db9174195f7c37e.jpg",
            "https://pixabay.com/get/e834b50820f61c3e815b4407e64c4e9ee26ae3d01db9174195f7c37e.jpg",
            "https://pixabay.com/get/ea37b20d2ef61c3e815b4407e64c4e9ee26ae3d01db9174195f7c37e.jpg",
            "https://pixabay.com/get/ec30b00a2df01c3e815b4407e64c4e9ee26ae3d01db9174195f7c37e.jpg",
            "https://pixabay.com/get/e835b50a2ffc033ecd0b4404e44c469eeb76ffd41cb5194795f0c67ba0.jpg",
            "https://pixabay.com/get/eb3cb5072cf4053ecd0b4404e44c469eeb76ffd41cb5194795f0c67ba0.jpg",
            "https://pixabay.com/get/ee36b7072ff31c3e815b4407e64c4e9ee26ae3d01db9174195f7c37e.jpg",
            "https://pixabay.com/get/ee32b90c29f11c3e815b4407e64c4e9ee26ae3d01db9174195f7c57e.jpg",
            "https://pixabay.com/get/eb36b30f20f5083ecd0b4404e44c469eeb76ffd41cb5194795f0c67da0.jpg",
            "https://pixabay.com/get/ea35b1072ff3083ecd0b4404e44c469eeb76ffd41cb5194795f0c67da0.jpg",
            "https://pixabay.com/get/e834b80d28f6073ecd0b4404e44c469eeb76ffd41cb5194795f0c67da0.jpg"
    );

    public static void main(String[] args) {
        String count = args[0];
        String NIO = "NIO";
        String IO = "IO";
        for (int i = 0 ; i < Integer.parseInt(count) ; i++) {
            test(IO, new ImageDownloaderWithIO());
            test(NIO, new ImageDownloaderWithNIO());
        }
    }

    private static void test(String IO_OR_NIO, ImageDownloader imageDownloader) {
        ConcurrentMap<String, Boolean> completeDownloadMap = new ConcurrentHashMap<>();
        System.out.println(IO_OR_NIO + " 다운로드 시작");
        long downloadStartTimeStamp = System.currentTimeMillis();

        IMAGE_URLS.parallelStream().forEach(imageURLStr -> {
            completeDownloadMap.put(imageURLStr, false);
            try {
                URI imageURI = new URI(imageURLStr);
                Path imagePath = Paths.get(imageURI.getHost() + imageURI.getPath());
                Path dir = Paths.get("/Users/minho/workspace/TIL/Java/JavaNIO/images");
                Path absolutePath = dir.resolve(imagePath);

                File imageFile = absolutePath.toFile();
                imageFile.getParentFile().mkdirs();
                new FileWriter(imageFile);

                imageDownloader.download(imageURI.toURL(), imageFile);
                completeDownloadMap.put(imageURLStr, true);
//                System.out.println(imageURLStr + " 다운로드 완료");

                boolean allDownloadComplete = completeDownloadMap.values()
                        .stream()
                        .allMatch(completeDownload -> completeDownload);

                if (allDownloadComplete) {
                    long allEndSec = System.currentTimeMillis();
                    System.out.println(IO_OR_NIO + " 다운로드 끝 " + (allEndSec - downloadStartTimeStamp) / 1000 + " 초 걸림");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
