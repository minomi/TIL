package decorator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-05-08.
 */
public class FileOutImpl implements FileOut {
    @Override
    public void write(Path path, byte[] data) throws IOException {
        System.out.println("파일에 겁나 쓰는 중");
        Files.write(path, data, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
