import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));

        while (true) {
            Socket socket = serverSocket.accept();
            byte[] sendTextBytes = String.format("%200s", "my server is dope").getBytes();
            socket.getOutputStream().write(sendTextBytes);

            byte[] receiveTextBytes = new byte[200];
            socket.getInputStream().read(receiveTextBytes);
            String text = new String(receiveTextBytes).trim();
            System.out.println("Received from client: " + text);

            System.out.println("Sending to client: " + text);
            sendTextBytes = String.format("%200s", text).getBytes();
            socket.getOutputStream().write(sendTextBytes);
        }
    }
}
