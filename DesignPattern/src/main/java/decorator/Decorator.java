package decorator;

import java.io.IOException;
import java.nio.file.Path;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-05-08.
 */

// 데코레이터 정의, 파일 저장은 delegate 에게 위임한다.
public abstract class Decorator implements FileOut {

    private FileOut delegate;

    public Decorator(FileOut delegate) {
        this.delegate = delegate;
    }

    @Override
    public void write(Path path, byte[] data) throws IOException {
        delegate.write(path, data);
    }

    protected void doDelegate(Path path, byte[] data) throws IOException {
        delegate.write(path, data);
    }
}
