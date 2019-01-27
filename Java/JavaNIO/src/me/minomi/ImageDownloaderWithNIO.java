package me.minomi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-28.
 */
public class ImageDownloaderWithNIO implements ImageDownloader {

    private static final int BUFFER_CAPACITY = 50 * 1000 * 1000; // 50MB

    @Override
    public void download(URL imageURL, File file) {
        try (ReadableByteChannel fromChannel = Channels.newChannel(imageURL.openStream());
             WritableByteChannel toChannel = new FileOutputStream(file).getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocateDirect(BUFFER_CAPACITY);

            int byteCount;

            while (true) {
                buffer.clear();
                byteCount = fromChannel.read(buffer);
                if (byteCount == -1) break;
                buffer.flip();
                toChannel.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
