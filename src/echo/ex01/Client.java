package echo.ex01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket(); // 소켓 객체 생성

		System.out.println("<클라이언트 시작>");
		System.out.println("====================================");

		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("110.12.83.8", 10001)); // ip주소와 포트번호를 받고 세팅

		System.out.println("[서버에 연결되었습니다.]");
		
		socket.close();
	}

}
