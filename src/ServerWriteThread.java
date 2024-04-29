import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerWriteThread implements Runnable {
    ObjectOutputStream oos;
    Socket socket;
    String name;
    String msg;
    public ServerWriteThread(Socket socket, String  name,String msg){
        this.msg = msg;
        this.name=name;
        this.socket=socket;
        Thread thread= new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
