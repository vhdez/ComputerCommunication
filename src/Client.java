import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Connecting to my server");
        Socket newSocket = new Socket("127.0.0.1",3256);
        OutputStream out = newSocket.getOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject("Hi Mr. Hernandez it's "+ "VICTOR");
        Thread.sleep(10000);
        objOut.writeObject("TWICE");
        objOut.writeObject("THRICE");
    }
}
