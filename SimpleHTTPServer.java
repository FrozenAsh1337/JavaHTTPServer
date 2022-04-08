import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class SimpleHTTPServer
{
    public static void main(String[] args) throws Exception
    {
	ServerSocket server=new ServerSocket(8080);
	System.out.println("Listening on port 8080...");
	while(true)
	    {
		Socket clientSocket=server.accept();
		InputStreamReader isr=new InputStreamReader(clientSocket.getInputStream());
		BufferedReader reader=new BufferedReader(isr);
		String line=reader.readLine();
		while(!line.isEmpty())
		    {
			System.out.println(line);
			line=reader.readLine();
			
		    }
		try(Socket socket=server.accept())
		    {
			Date today=new Date();
			String httpRespone="HTTP/1.1 200 OK\r\n\r\n"+today;
			socket.getOutputStream().write(httpRespone.getBytes("UTF-8"));
		    }
	    }
	
    }
}
