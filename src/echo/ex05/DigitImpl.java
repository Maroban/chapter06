package echo.ex05;

public class DigitImpl implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			System.out.println(i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
