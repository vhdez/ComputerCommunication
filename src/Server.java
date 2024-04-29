import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        String outMessage = "Hi!";
        System.out.println("Creating a socket for communication");
        ServerSocket mySocket = new ServerSocket(3256);
        Socket actualSocket = mySocket.accept();

        MyCoolDataStructure queue = new MyCoolDataStructure();
        DataReader myDataReader = new DataReader(actualSocket, queue);
        ProgramLogicDoer myProgramLogicDoer = new ProgramLogicDoer(queue);

        Thread dataReadThread = new Thread(myDataReader);
        Thread programLogicThread = new Thread(myProgramLogicDoer);

        dataReadThread.start();
        programLogicThread.start();
    }
}