import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientReaderThread implements Runnable {
    ObjectInputStream ois;
    Socket socket;
    public ClientReaderThread(Socket socket) {
        this.socket=socket;
        Thread thread= new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while(true){
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                String msg=(String)ois.readObject();
                System.out.println(msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
