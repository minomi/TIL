import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 26..
 */
public class Writer implements Runnable {

    private Socket serverSocket;
    private boolean isRunning = true;

    private Scanner scanner = new Scanner(System.in);

    Writer(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try (OutputStream outputStream = serverSocket.getOutputStream()) {
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
            while (isRunning) {
                printWriter.println(scanner.nextLine());
                printWriter.flush();
            }
        } catch (Exception e) { }
    }
}
