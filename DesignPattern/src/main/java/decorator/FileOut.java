package decorator;

import java.io.IOException;
import java.nio.file.Path;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-05-08.
 */
public interface FileOut {
    void write(Path path, byte[] data) throws IOException;
}
