package echo.ex01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket();  // 1번 ServerSocket 생성
		
		// bind(new InetSocketAddress)를 통해 ip주소와 포트 번호를 넣어야 한다.
		serverSocket.bind(new InetSocketAddress("110.12.83.8", 10001));  // 2번 연결 요청을 기다리고 있다.
		
		System.out.println("<서버 시작>");
		System.out.println("====================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		Socket socket = serverSocket.accept();  // 5번 연결 요청이 오면 작동한다.
		// 6번 accept()을 이용해서 Socket socket을 만든다.
		
		System.out.println("[클라이언트가 연결되었습니다.]");
		
		
		socket.close();
		
		serverSocket.close();
		
		
		
		
		
		
		
		
		
		
		
	}

}
