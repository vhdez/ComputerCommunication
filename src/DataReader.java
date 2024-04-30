import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class DataReader implements Runnable {
    Socket actualSocket;
    ObjectInputStream objIn;
    MyCoolDataStructure inData;

    public DataReader(Socket actualSocket, MyCoolDataStructure inData) throws Exception {
        this.actualSocket = actualSocket;
        this.inData = inData;
        InputStream in = actualSocket.getInputStream();
        this.objIn = new ObjectInputStream(in);
    }

    public void run()  {
        while (!Thread.currentThread().interrupted()) {
            try {
                Object inMessage1 = objIn.readObject();
                inData.put(inMessage1);
            } catch (IOException ioex) {
                // its ok to get IOException when there is no object to read in from ObjectInputStream
            } catch (Exception ex) {
                System.out.println("Ooops DataReader broke: " + ex);
            }
        }
    }
}
