import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",8080);
        System.out.println("Connected");
        // now this will be infinite loop
//        while(true) {
            new ClientReaderThread(socket);
            new ClientWriterThread(socket);
//        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

//        }
    }
}
