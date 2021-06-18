package echo.ex02;

public class MultiThreadApp {

	public static void main(String[] args) throws Exception {

		DigitThread thread = new DigitThread();
		thread.start();
		
		
		for(char ch = 'A'; ch<='Z'; ch++) {
			System.out.println(ch);
			Thread.sleep(1000);
		}
		
		
	}

}
