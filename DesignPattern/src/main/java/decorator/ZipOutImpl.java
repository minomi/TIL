package decorator;

import java.io.IOException;
import java.nio.file.Path;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-05-08.
 */
public class ZipOutImpl extends Decorator implements ZipOut  {

    public ZipOutImpl(FileOut delegate) {
        super(delegate);
    }

    @Override
    public byte[] zip(byte[] data) {
        System.out.println("절대 압축 중");
        return data;
    }

    @Override
    public void write(Path path, byte[] data) throws IOException {
        super.write(path, zip(data));
    }
}
