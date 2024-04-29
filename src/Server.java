import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {


    public static HashMap<Socket,String>clientInfo =new HashMap<>();
    public static void main(String[] args) throws IOException {
        InetAddress localhost= InetAddress.getByName("localhost");
        ServerSocket serverSocket = new ServerSocket(8080,0,localhost );
        System.out.println("Server is started on ip: "+localhost.getHostAddress()+" and port: "+serverSocket.getLocalPort());

        int i=0;
        // now accept client;
        // as its a infinite loop so it will accept all socket connections it receives
        while (true){
            Socket socket = serverSocket.accept();
            //store data
            String name= "Client-"+i;
            clientInfo.put(socket,name);
            System.out.println(name+" joined");
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("You are "+name);
//            String msgToSend = null;
            //now sending message from server
//            new ServerWriteThread(socket,name,msgToSend);
            new ServerReadThread(socket,name);



            i++; //at the last we increment i;
        }

        //
    }
}
