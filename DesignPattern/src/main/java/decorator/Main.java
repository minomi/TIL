package decorator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-05-08.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path testPath = Paths.get("/Users/minho/workspace/TIL/DesignPattern/test.txt");
        FileOut fileOut = new FileOutImpl();
        byte[] data = new byte[] {1, 2, 3, 4, 5};

        // 그냥 파일에 쓰고 싶다
        System.out.println("그냥 파일에 쓴다");
        fileOut.write(testPath, data);
        System.out.println("\n");

        // 압축해서 파일에 쓰고 싶다.
        System.out.println("압축해서 파일에 쓴다");
        FileOut zipFileOut = new ZipOutImpl(fileOut);
        zipFileOut.write(testPath, data);
        System.out.println("\n");

        // 암호화해서 파일에 쓰고 싶다.
        System.out.println("암호화해서 파일에 쓴다");
        FileOut encryptionFileOut = new EncryptionOutImpl(fileOut);
        encryptionFileOut.write(testPath, data);
        System.out.println("\n");

        // 압축해서 암호화 해서 파일에 쓰고 싶다.
        System.out.println("압축하고 암호화해서 파일에 쓴다");
        FileOut zipAndEncFileOut = new ZipOutImpl(encryptionFileOut);
        zipAndEncFileOut.write(testPath, data);
        System.out.println("\n");

        // 암호화 하고 압축하고 파일에 쓰고 싶다.
        System.out.println("암호화하고 압축해서 파일에 쓴다");
        FileOut encAndZipFileOut = new EncryptionOutImpl(zipFileOut);
        encAndZipFileOut.write(testPath, data);
        System.out.println("\n");
    }
}
