import java.io.IOException;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",8080);
        System.out.println("Connected");
            new ClientReaderThread(socket);
            new ClientWriterThread(socket);
    }
}
