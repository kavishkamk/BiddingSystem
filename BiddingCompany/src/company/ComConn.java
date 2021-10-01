package company;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//get and close socket

public class ComConn {
	
	private String sIP; //Server IP
	private int port;//server port
	private Socket cs;
	
	//constructor for create company socket
	public ComConn(String sip, int cPort){
			
		sIP  = sip;
		port =cPort;
			
		try {
			cs = new Socket(sIP, port);
		}
		catch(IOException e) {
			System.out.printf("%s : Cannot connect [IP - %s, Port - %d\n", time(), sIP, port);
		}
	}
	
	//to close socket
	public void tcpClose() {
			
		try {
			cs.close();
			System.out.printf("%s : Port is closed\n", time());
		}
		catch(IOException e){
			System.err.println(e);
		}
		
	}
	
	//return socket
	public Socket getSocket() {
		return cs;
	}

	// get current time
	public String time() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}	
}
