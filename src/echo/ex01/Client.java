package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket(); // 소켓 객체 생성

		System.out.println("<클라이언트 시작>");
		System.out.println("====================================");

		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.0.126", 10001)); // ip주소와 포트번호를 받고 세팅

		System.out.println("[서버에 연결되었습니다.]");
		
		
		Scanner sc = new Scanner(System.in);
		
		
		// Scanner 만들기 (원리 이해)
		InputStream in = System.in; // System 클래스 안의 in이라는 메소드 사용
		InputStreamReader sisr = new InputStreamReader(in);
		BufferedReader sbr = new BufferedReader(sisr);
		
		
		// println() 만들기 (원리 이해)
		OutputStream out = System.out;  // System 클래스 안의 out이라는 메소드 사용
		OutputStreamWriter sosw = new OutputStreamWriter(out);
		BufferedWriter sbw = new BufferedWriter(sosw);
		
				
		// 메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// 메세지 보내기
		String str = "안녕";

		// 보내기
		bw.write(str);
		bw.newLine();
		bw.flush();

		// 1:1 채팅 메신저처럼 메세지 보내기(반복문 사용)
		while (true) {

			// 키보드 입력
			String msg = sc.nextLine();
			// String msg = sbr.readLine(); => 직접 만든 Scanner 사용

			// /q 가 입력되면 종료.
			if ("/q".equals(msg)) {
				System.out.println("[접속이 종료되었습니다.]");
				break;
			}

			// 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();

			// 메세지 출력
			String reMsg = br.readLine();
			System.out.println("[Server: " + reMsg + "]");
		}

		System.out.println("====================================");
		System.out.println("<클라이언트 종료>");
		/*
		sbw.write("<클라이언트 종료>"); => 직접 만든 println() 사용
		sbw.newLine();
		*/
		
		sbw.close();
		sbr.close();
		sc.close();
		br.close();
		bw.close();
		socket.close();
	}

}
