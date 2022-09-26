import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClient {
	//8080 PORT
	
	/*
	 Once the connection between your server and your client is established the client should do the following:

		Allow the user to type a single line string on the console.
		Read in the string from the user and print it out preceded by 
			the text “Client says:”
		Send the string over the socket to the server.
		Wait for a response from the server.
		When the server responds print “Server says:” followed by the single line string received from the server.
		Go to 1. 
	 */

	public static void main(String[] args) throws IOException {

		while (true) {
			Socket socket = new Socket(args[1], Integer.parseInt(args[0]));
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(System.in));
			String clientInput = reader.readLine();
		System.out.println("Client says: " + clientInput);
		socket.getOutputStream().write(clientInput.getBytes());
		byte[] b = new byte[200];
		socket.getInputStream().read(b);
			String text = new String(b).trim();
			System.out.println("Server says: " + text);
		}
	}
	
}
