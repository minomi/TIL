package me.minomi.fileupload;

import java.io.IOException;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-15.
 */
public class StorageException extends RuntimeException {
    public StorageException(String s) {
        super(s);
    }

    public StorageException(String s, IOException e) {
        super(s, e);
    }
}
