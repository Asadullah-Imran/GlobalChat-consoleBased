import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriterThread implements Runnable {

    ObjectOutputStream oos;
    Socket socket;
    public ClientWriterThread(Socket socket) throws InterruptedException {
        this.socket=socket;
        Thread thread= new Thread(this);
        thread.start();
//        thread.join();
    }
    @Override
    public void run() {
        while(true){
            Scanner scanner= new Scanner(System.in);
            String msg=scanner.nextLine();
            try {
                oos= new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
