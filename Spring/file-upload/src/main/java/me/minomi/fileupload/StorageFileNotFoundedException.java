package me.minomi.fileupload;


import java.net.MalformedURLException;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-14.
 */
public class StorageFileNotFoundedException extends RuntimeException {
    public StorageFileNotFoundedException(String s) {
        super(s);
    }

    public StorageFileNotFoundedException(String s, Exception e) {
        super(s, e);
    }
}
