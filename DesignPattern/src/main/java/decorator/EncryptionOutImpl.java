package decorator;

import java.io.IOException;
import java.nio.file.Path;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-05-08.
 */
public class EncryptionOutImpl extends Decorator implements EncryptionOut {

    public EncryptionOutImpl(FileOut delegate) {
        super(delegate);
    }

    @Override
    public byte[] encrypt(byte[] data) {
        System.out.println("절대 암호화 중");
        return data;
    }

    @Override
    public void write(Path path, byte[] data) throws IOException {
        super.write(path, encrypt(data));
    }
}
