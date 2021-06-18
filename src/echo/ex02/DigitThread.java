package echo.ex02;

public class DigitThread extends Thread  {
	
	// 필드
	
	
	// 생성자
	
	
	// 메소드 - GS
	
	
	// 메소드 일반	
	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
