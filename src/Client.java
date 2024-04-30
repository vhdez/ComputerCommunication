import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to my server");
        Socket newSocket = new Socket("127.0.0.1",3256);
        OutputStream out = newSocket.getOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject("FIRST from Mr. H");
        objOut.writeObject("SECOND from Mr. H");
        objOut.writeObject("THIRD from Mr. H");
        System.out.println("Done sending messages");
    }
}
