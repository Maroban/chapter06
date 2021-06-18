package echo.ex05;

public class Multithread {

	public static void main(String[] args) {

		Thread thread01 = new Thread(new DigitImpl());
		Thread thread02 = new Thread(new LowerImpl());
		Thread thread03 = new Thread(new UpperImpl());

		thread01.start();
		thread02.start();
		thread03.start();

	}

}
