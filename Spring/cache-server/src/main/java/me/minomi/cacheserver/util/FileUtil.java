package me.minomi.cacheserver.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */
public class FileUtil {

    public static final Path BASE_PATH = Paths.get("/Users/minho/workspace/TIL/Spring/cache-server/resources");

    public static String getFileName(final String resourceURL) throws IOException  {
        final URL url = new URL(resourceURL);
        final String host = url.getHost().replaceAll("\\.", "/");
        final String resourcePath = url.getPath().replaceFirst("/", "");
        return BASE_PATH.resolve(host).resolve(resourcePath).toString();
    }

    public static File getFile(final String resourceURL) throws IOException {
        final String fileName = getFileName(resourceURL);
        return new File(fileName);
    }

    public static void copyURLToFile(final String resourceURL) throws IOException {
        URL url = new URL(resourceURL);
        FileUtils.copyURLToFile(url, getFile(resourceURL));
    }
}
