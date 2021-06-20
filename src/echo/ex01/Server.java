package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(); // 1번 ServerSocket 생성

		// bind(new InetSocketAddress)를 통해 ip주소와 포트 번호를 넣어야 한다.
		serverSocket.bind(new InetSocketAddress("211.177.56.195", 10001)); // 2번 연결 요청을 기다리고 있다.

		System.out.println("<서버 시작>");
		System.out.println("====================================");
		System.out.println("[연결을 기다리고 있습니다.]");

		// 5번(accept) 2번에서 연결 요청 확인이 되면 작동한다.
		Socket socket = serverSocket.accept();
		// 6번(Socket) accept()을 이용해서 Socket socket을 만든다.

		System.out.println("[클라이언트가 연결되었습니다.]");

		// 메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// 메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 1:1 채팅 메신저처럼 메세지 받기(반복문 사용)
		while (true) {
			// 키보드 입력 값 받기
			String msg = br.readLine();

			// 클라이언트에서 /q가 입력되면 null 값이 오며 종료
			if (msg == null) {
				System.out.println("[클라이언트 접속 종료]");
				break;
			}

			// 입력 받은 값 출력
			System.out.println("받은 메세지: " + msg);

			// 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}

		System.out.println("====================================");
		System.out.println("<서버 종료>");

		bw.close();
		br.close();
		socket.close();
		serverSocket.close();

	}

}
